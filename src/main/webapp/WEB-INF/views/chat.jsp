<!doctype html>

<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Amicoz</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
 	<meta http-equiv="refresh" content="20" />
	<link rel="stylesheet" href="css/main.css">
	<link rel="stylesheet" href="css/jquery-ui.min.css">
	<link rel = "stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	  <script src="js/dropdown.js"></script>
	  <script src="js/jquery-1.11.1.min.js"></script>
	  <script src="js/jquery-ui.min.js"></script>
	  <script src="js/form.js"></script>
	  <script src="js/croppic.min.js"></script>
	  <script src="js/searchbox.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<link href='https://fonts.googleapis.com/css?family=PT+Sans' rel='stylesheet' type='text/css'>
</head>

<body>
  <div id="header">
<!--     <a href="index.html"><div id="logo">Amicoz</div></a> -->
<a href="/frontPage"><div id="logo">Amicoz</div></a>
    <div id="user">
      <div id="img"></div>
      <div class="dropdown">
        <a href="javascript:void(0)" class="dropbtn" onclick="dropLink()">
          <img src=${s_imgsrc} class="userpic" />
          ${s_fullname}</a>
        <div class="dropdown-content" id="profiledrop">
          <a href="/profile?userid=${s_userid}">My Profile</a>
          <a href="/profile_settings">Settings</a>
          <a href="/logout" class="logout">Logout</a>
        </div>
      </div>
    </div>
    <div id="search">
      <input type="text" class="searchbox" placeholder="Search.. ( [firstname] [lastname] ) ex. John Smith" maxlength="32" ></input>
    </div>
  </div>
  <div id="wrapper">
		<h1 class="center">My Chats</h1>
<!-- 		<p hidden value=${fromid}></p> -->
<!-- 		<div id="box" class="chat_friends">
			<div class="title">Select a chat:</div>
			<ul class="friends">
				<li><a href="#"><img src="imgs/profilepic.jpg" class="userpic" />Anand Karandikar</a></li>
				<li><a href="#"><img src="imgs/profilepic.jpg" class="userpic" />Girish Gabra</a></li>
				<li><a href="#"><img src="imgs/profilepic.jpg" class="userpic" />Rohan Ingle</a></li>
				<li><a href="#"><img src="imgs/profilepic.jpg" class="userpic" />Yueyang Wu</a></li>
			</ul>
		</div>
 -->		
 		<div id="box" class="chat_chat">
 		
			<div class="title">Chat With: <%= request.getParameter("withname") %></div>
			<script>
				var session = ${s_userid};
				console.log("This is logged in user id "+${s_userid});
				//var id2 = 2;
				
				//console.log("withname" +withname);
					$.ajax({
				
					  //The URL to process the request
					    'url' : 'http://localhost:1234/conversations/'+${s_userid}+'/'+<%= request.getParameter("withid") %>,
					  //The type of request, also known as the "method" in HTML forms
					  //Can be 'GET' or 'POST'
					    'type' : 'GET',
					  //Any post-data/get-data parameters
					  //This is optional
					    // 'data' : {
					    //   'id1' : 1,
					    //   'id2' : 5
					    // },
					  //The response from the server
					    'success' : function(data) {
					    //You can use any jQuery/JavaScript here!!!
					      // if (data == "success") {
					      //   alert('request sent!');
					      // }
					      console.log(data);
					      console.log("received");
					      var items = [];
					      
						  $.each( data, function(index) {
						//	  console.log(withname );
								if(data[index].fromid == session) {
									items.push( "<li style='text-align: right; margin-right: 10px;' title=" + data[index].timestamp + ">" + '${s_fullname}' + ":<br/>" + data[index].message + "</li>" );
								} else {
						    	items.push( "<li title=" + data[index].timestamp + "><br/>" + data[index].message + "</li>" );
								}
						  });

						  $( "<ul/>", {
						    "class": "chatmessages",
						    html: items.join( "" )
						  }).appendTo( ".chat_chat" );

					      //for (var i = 0, len = data.length; i < len; i++) {
					        //console.log(data[i]);
					        //var o = data[i];
					       // $("#conversation").append(o.fromid+" :" +o.message+" at " + o.timestamp + "<br>");
					      //}
					      //console.log(d);
					      //console.log(JSON.parse(data));
					    }
					  	});
// 				$.getJSON( "chats.json", function( data ) {
// 				  var items = [];
// 				  $.each( data, function(index) {
// 						if(data[index].fromid == session) {
// 							items.push( "<li style='text-align: right; margin-right: 10px;' title=" + data[index].timestamp + ">" + data[index].fromid + ":<br/>" + data[index].message + "</li>" );
// 						} else {
// 				    	items.push( "<li title=" + data[index].timestamp + ">" + data[index].fromid + ":<br/>" + data[index].message + "</li>" );
// 						}
// 				  });

// 				  $( "<ul/>", {
// 				    "class": "chatmessages",
// 				    html: items.join( "" )
// 				  }).appendTo( ".chat_chat" );
// 				});
			</script>
			
		</div>

		<div class="input-group">
                        <input id="msgtxt" type="text" class="form-control input-sm" placeholder="Type your message here..." />
                        <span class="input-group-btn">
                            <button class="btn btn-warning btn-sm" id="send">
                                Send</button>
                        </span>
         </div>
         
				<script>
				
		$("#send").click( function()
		{
		           //  alert('button clicked');
		             console.log("msg - "+$("#msgtxt").val());
			   		  var msg = $("#msgtxt").val();
		            $.ajax({
		   			  //The URL to process the request
		   			  //$("")
		   			  //console.log($("#msgtxt").val());
		   			    'url' : 'http://localhost:1234/send',
		   			  //The type of request, also known as the "method" in HTML forms
		   			  //Can be 'GET' or 'POST'
		   			    'type' : 'POST',
		   			  //Any post-data/get-data parameters
		   			  //This is optional
		   			    'data' : {
		   			      'u1' : ${s_userid},
		   			      'u2' : <%= request.getParameter("withid") %>,
		   			      'message' : msg
		   			     },
		   			  //The response from the server
		   			    'success' : function(data) {
		   			    	console.log("sent");
		   			    	location.reload();
		   			    	}
		   			    });
		   		});
		 </script>         
	</div>
</body>
</html>
