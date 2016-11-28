<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Amicoz</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/main.css">
<script src="js/dropdown.js"></script>
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/settingsform.js"></script>
<script src="js/searchbox.js"></script>
<link href='https://fonts.googleapis.com/css?family=PT+Sans'
	rel='stylesheet' type='text/css'>
</head>

<body>
	<div id="header">
<!-- 		<a href="/index"><div id="logo">Amicoz</div></a> -->
		<a href="/frontPage"><div id="logo">Amicoz</div></a>
		<div id="user">
			<div id="img"></div>
			<div class="dropdown">
				<a href="javascript:void(0)" class="dropbtn" onclick="dropLink()">
					<img src="${s_imgsrc}" class="userpic" /> ${s_fullname}
				</a>
				<div class="dropdown-content" id="profiledrop">
					<a href="/profile?userid=${s_userid}">My Profile</a> <a
						href="/profile_settings">Settings</a> <a href="/logout"
						class="logout">Logout</a>
				</div>
			</div>
		</div>
		<div id="search">
			<input type="text" class="searchbox"
				placeholder="Search.. ( [firstname] [lastname] ) ex. John Smith"
				maxlength="32"></input>
		</div>
	</div>
	<div id="wrapper">
		<div id="userbar">
			<div id="profilepicture">
				<img src="${profile_picture}" class="profilepic" />
			</div>
			<div id="userinformation">
				<h1>${fullname}</h1>
				<%-- 				<div class="birthday">${dob}</div> --%>
				<%-- 				<div class="livesin" name="livesin"><b>${lives_in}</b></div> --%>

				<div id="profileInfo">
					<h1 id = "profilename"></h1>
				</div>


				<div ${hidden_friend_button}>
					<input type=submit value='${friend_status}' class='add'
						style='background-color: #4CAF50; color: white; font-size: 20px; display: inline-block; cursor: pointer;'
						id='friendButton' onclick="manageFriend(${to_userid})" /> <input
						type=submit value=Block id="blockButton"
						style='background-color: #4CAF50; color: white; font-size: 20px; display: inline-block; cursor: pointer;' />

				</div>
			</div>
		</div>
		<div id="box" class="profileposts">
			<div class="title" style="margin-bottom: 5px;">Timeline</div>
			<ul class="timelineposts" id="timelineposts">
				<%-- 				<li>
					<div class="userinfo">
						<img src="${s_imgsrc}" class="profilepic" /> <span
							class="username"><a href="#profilelink">${fullname}</a></span><br />
						<span class="datetime">April 12, 2016</span><br /> <span
							class="datetime">7:35PM</span>
					</div>
					<div class="post">
						Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla
						nunc libero, euismod eget nibh et, elementum efficitur libero.
						Fusce egestas imperdiet arcu, nec maximus turpis ornare at. Morbi
						porttitor nulla nisi, eu pretium elit ullamcorper pretium.
						<p>Aenean quis risus a turpis sagittis euismod sed quis
							mauris. Sed et faucibus quam. Sed eget risus turpis. Nullam sit
							amet neque gravida libero feugiat sagittis eu congue est. Donec a
							mauris rutrum, gravida ante non, egestas lacus. Nam lorem ex,
							pulvinar nec eros a, placerat ullamcorper diam.</p>
					</div>
					<div class="likebar">
						<a href="#likes">10 likes <img src="imgs/like.png"
							class="like"></a> <a href="#dislikes">2 dislikes <img
							src="imgs/dislike.png" class="like"></a>
					</div>
					<ul class="comments">
						<li><img src="imgs/profilepic.jpg" class="friendcommentpic" />
							<div class="usercomment">Etiam aliquam ligula pharetra
								ligula luctus, nec consectetur turpis ornare. Morbi at leo
								ornare, luctus odio eget, eleifend lorem. Mauris auctor
								vestibulum varius. Quisque commodo sollicitudin purus pulvinar
								interdum.</div></li>
					</ul> <img src="${s_imgsrc}" class="mycommentpic" /> <textarea
						class="commentbox" placeholder="Say something!"></textarea>
				</li> --%>
			</ul>
		</div>
	</div>
</body>
</html>

<script>
var count =0;
var name;
var profile_info = ${profile_information};
$('#profileInfo').append('<p id="profile_information">');
$.each(profile_info, function(index, data) {
	if(count ==0){
		name = data;
		console.log(name);
		count=count+1;
	}else if(count==1){
		name+= " "+data;
		console.log(name);
		count=count+1;
	}else{
		var info = data;		
		if(info!="")
		$('#profileInfo').append(info+'<br>');
	}

});
$('#profileInfo').append('</p>');
$('#profilename').append(name);


$(document).ready(function(){
	
	
	var friendStatusValue = '${friend_status}';

	if(friendStatusValue != 'Remove Friend'){
		$('#blockButton').hide();
	}
	
	$('#blockButton').click(function(){
		var user = ${profileUserId};
		alert(user);
		var value = $(this).attr('value');
		var flag = 'X';
		var newVal="";
		if(value == 'Block'){
			//alert(value);
			flag = 'Y';
		newVal = 'Unblock';
		}else{
			flag='N';
			newVal = 'Block';
		}
		
		$.ajax({
			type: 'POST',
			url: 'updateBlocked',
			data: {user: user, flag: flag},
			success: function(data){
				$('#blockButton').prop('value',newVal);
			}
		 });
	});
});

function manageFriend(user){
	
	//alert("inside manageFriend");
	//alert("data: "+user);
	//alert("list id"+ liId);
	var buttonValue = document.getElementById("friendButton").value;
	alert(buttonValue);
	console.log('inside addFriend');
	//alert("inside addFriend");
	if(buttonValue == 'Add Friend'){
		$.ajax({
			type: 'POST',
			url: 'addFriend',
			data: {user: user},
			success: function(data1){
				if(data1 != "-1"){
					console.log('inside if success');
					$('#friendButton').prop('value','Cancel Request');
					$('#blockButton').hide();
				}
			}
		});
		
	}
	
	if(buttonValue == 'Confirm Friend'){
		$.ajax({
			type: 'POST',
			url: 'confirmFriend',
			data: {user: user},
			success: function(data){
				 
				 console.log(data);
				//alert("success");
				if(data != "-1"){
					console.log('inside if success');
					$('#friendButton').prop('value','Remove Friend');
					$('#blockButton').show();			
					
				}
			}
		});
	}
	
	if(buttonValue == 'Cancel Request'){
		$.ajax({
			type: 'POST',
			url: 'cancelRequest',
			data: {user: user},
			success: function(data){
				 
				 //console.log(data1);
				//alert("success");
				if(data != "-1"){
					console.log('inside if success');
					$('#friendButton').prop('value','Add Friend');
					$('#blockButton').hide();
				}
			}
		});
	}
	
	if(buttonValue == 'Remove Friend'){
		$.ajax({
			type: 'POST',
			url: 'removeFriend',
			data: {user: user},
			success: function(data1){
				 
				 //console.log(data1);
				//alert("success");
				if(data1 != "-1"){
					console.log('inside if success');
					$('#friendButton').prop('value','Add Friend');
					$('#blockButton').hide();
				}
			}
		});
	}
	
	return true; 
	
	
	
}

</script>

<script>
var posts = ${groupPosts};
console.log("posts: " + posts);
console.log(posts);
$.each(posts,function(index,data){
	var pid = data.postID;
	var userInfo = '<div class="userinfo"><img src="'+data.profilePicUrl+'" class="profilepic" /> <span class="username"><a href="profile?userid='+data.userID+'">'+data.userName+'</a></span><br/><span class="datetime">'+data.time+'</span><br/></div>';
	
	var postContent = '<div class="post">'+data.postText+'</div>';
	console.log(postContent);
	var likesDislikes = '<div class="likebar" hidden><a href="#likes">'+data.likeCount+'<img src="imgs/like.png"/ class="like"></a><a href="#dislikes">'+data.dislikeCount+'<img src="imgs/dislike.png"/ class="like"></a></div>';
	
	console.log("posts id" + data.postID);
	console.log("posts by: "+data.userName);
	console.log("post time: "+data.time);
 	var commentsList = "<ul id='comments"+data.postID+"' class='comments'>";
	if(typeof data.comments !== 'undefined') {
		var comments = data.comments;
		
		$.each(comments,function(index2,data2){
			commentsList += '<li><img src="'+data2.profilePicUrl+'" class="friendcommentpic" /> <span class="username"><a href="profile?userid='+data.userID+'">'+data.userName+'</a></span><div class="usercomment">'+data2.comment+'</div></li>';
			console.log("comment id"+data2.commentId);
			console.log("comment"+data2.comment);
			console.log("timestamp"+data2.timeStamp);
			console.log("username"+data2.userName);
	});
	}
	
	
	commentsList += "</ul>";
	commentsList += '<img src="https://www.accrinet.com/clientuploads/authorship_profile.jpg" class="mycommentpic" /><textarea id="commentbox" class="commentbox" placeholder="Say something!"></textarea>';
 	$("#timelineposts").append(userInfo+postContent+likesDislikes+commentsList);
 	console.log("info.....");
 			console.log(userInfo);
 			console.log(likesDislikes);
 					//$("#timelineposts").append(userInfo+postContent+likesDislikes);
					$('.commentbox').keypress(function (e) {
						var comment = $(this).val();
						  
						console.log("keypress");
					    if (e.which == 13) {
					      if (comment.length < 1) {
					        alert("Your comment must have at least 1 character in order to be valid!");
					      } else if (comment.length > 250) {
					        alert("Your comment cannot exceed 250 characters!");
					      } else {
					    	   comment = $(this).val();
							   console.log(comment);
							   
					    	  $.ajax({
					    	  	
					 			type: "POST",
						        url:"/commentSave",
						        dataType: "json", 	
						        data : {
						        	"userId" :  uid,
						        	"comment" : comment,
						        	"postId" : pid
						        },	
								success: function(data3){
									console.log("commentSave returns :"+data3);
									//window.location.href = "/group.jsp";
									//alert(data);
									//$("#success_message").html("");
									if(data3==1){
										$("#comments"+data.postID).append('<li><img src="" class="friendcommentpic" /> <span class="username"><a href="profile?userid='+data.userID+'">'+data.userName+'</a></span><div class="usercomment">' + comment + '</div></li>');
									}else{
										console.log("in else");
										
									}
								}
							  });
				    	 
				       
				        //alert($(this).parent().parent().get(0).tagName + " " + $(this).parent().parent().attr('class'));
				        // Returns successful data submission message when the entered information is stored in database.
				        console.log("In comment enter");
				    	   
				      }
				      return false;    //<---- Add this line
				    }
				  });
			});

</script>
