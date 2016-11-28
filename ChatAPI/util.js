var mysql      = require('mysql');
var connection = mysql.createConnection({
  host     : 'localhost',
  user     : 'root',
  //password : 'root123',
  password : 'infa@123',
  database : 'db_amicoz'
});

 connection.connect(function(err){
 if(!err) {
     console.log("Database is connected ... \n\n");  
 } else {
     console.log("Error connecting database ... \n\n");  
 }
 });


exports.sendMessage = function(req, res, next) {

  console.log("sending..");
	console.log(req.body);
	
  var user1 = parseInt(req.body.u1);
	var user2 = parseInt(req.body.u2);
  var message = req.body.message;

  var post  = {fromid: user1, toid: user2, message:message };

	console.log("U1: "+user1+" U2: "+user2 +" Message: "+message);
	
  connection.query("INSERT INTO messages SET ?", post, function(err, result) {
		console.log(err)
	});

  res.end("Message Posted");
    
}

exports.getConversation = function(req, res, next) {
    
    console.log("Get Conversation..");
    console.log("Sender: "+ req.params.id1);
    console.log("Receiver: "+ req.params.id2);
    
    var a = parseInt(req.params.id1);
    var b = parseInt(req.params.id2);

    var make = 'SELECT * FROM messages WHERE fromid = '+a+' AND toid ='+b+' OR + fromid = '+b+' AND toid ='+a;
    connection.query(make, function(err, results) {
	    if (err) throw err;
	 	res.send(results);
	    for (var i in results) {
        console.log('Message: ', results[i]);
	    }
	});
};

exports.creategroup = function(req, res, next) {
	var members = req.body.members;
	var name = req.body.name;
	
  console.log("Initiating group "+ name);
  console.log("Members are "+members);
  membersArr = members.split(",");
    
  for(var k in membersArr){
    console.log(membersArr[k]);
  }
  
  var group = {gname: name};
  
  connection.query("INSERT INTO groups SET ?", group, function(err, result) {
  	gid = result.insertId;
    console.log("last inserted group id: "+gid);

		for(var k in membersArr){
  		var post = {gid:gid, uid: parseInt(membersArr[k])};
  		console.log(post);
  		connection.query("INSERT INTO groups_users_mapper SET ?", post, function(err, result) {
				console.log(err);
			});
		}
  	res.end("Group Created");
  });  
};

exports.sendGroupMessage = function(req, res, next) {

  console.log("sending message in group");
	console.log(req.body);
	
  var gid = parseInt(req.body.gid);
	var uid = parseInt(req.body.uid);
  var message = req.body.message;

  var post  = { gid: gid, uid: uid, message:message };

  connection.query("INSERT INTO group_messages SET ?", post, function(err, result) {
  	console.log(err)
  });

  res.end(" Group Message Posted");
};

exports.getGroupConversation = function(req, res, next) {
  console.log("Geting Group Conversations..");
  console.log("Group: "+ req.params.gid);
  
  var gid = parseInt(req.params.gid);

  var make = 'SELECT * FROM group_messages WHERE gid = '+gid;
  connection.query(make, function(err, results) {
    if (err) throw err;
 	res.send(results);
    for (var i in results) {
      console.log('Message: ', results[i]);
    }
	});
};