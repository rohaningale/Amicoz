<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Amicoz</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/main.css">
  <script src="js/dropdown.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
  <script src="js/jquery-1.11.1.min.js"></script>
  <script src="js/form.js"></script>
	<link href='https://fonts.googleapis.com/css?family=PT+Sans' rel='stylesheet' type='text/css'>
</head>

<body>
  <div id="header">
<!--     <a href="/index"><div id="logo">Amicoz</div></a> -->
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
		<input type="text" class="searchbox"
			placeholder="Search.. ( [firstname] [lastname] ) ex. John Smith"
			maxlength="32"></input>
	</div>
  </div>
  
  <div id="wrapper">
		<div id="groupbar">
			<div id="groupinformation">
				<h1>${groupName}</h1>
				<div class="bio">${groupDescription}</div>
				<p id="admin"></p>
				
			</div>
		</div>
		<div id="box" class="profileposts">
			<div class="title">Group Members</div>
			<ul id="members" class="friends">
<!--				<li><a href="#"><img src="imgs/profilepic.jpg" class="userpic" />Anand Karandikar</a></li>-->
<!--				<li><a href="#"><img src="imgs/profilepic.jpg" class="userpic" />Girish Gabra</a></li>-->
<!--				<li><a href="#"><img src="imgs/profilepic.jpg" class="userpic" />Rohan Ingle</a></li>-->
<!--				<li><a href="#"><img src="imgs/profilepic.jpg" class="userpic" />Yueyang Wu</a></li>-->
			</ul>
		</div>
		<div id="box" class="profileposts">
			<div class="title">Write a post</div>
			<textarea class="statusbox" id="grouppostbox" placeholder="Post something on the group page!"></textarea>
			<button type="submit" class="statusbutton" id="grouppostbutton">Post</button>
		</div>
		<div id="box" class="profileposts">
			<div class="title" style="margin-bottom: 5px;">Group Timeline</div>
			<ul id="timelineposts" class="timelineposts">
<!--				<li>-->
<!--					<div class="userinfo">-->
<!--						<img src="imgs/profilepic.jpg" class="profilepic" /> <span class="username"><a href="#profilelink">Munir Safi</a></span><br/><span class="datetime">April 12, 2016</span><br/><span class="datetime">7:35PM</span>-->
<!--					</div>-->
<!--					<div class="post">-->
<!--						Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla nunc libero, euismod eget nibh et, elementum efficitur libero. Fusce egestas imperdiet arcu, nec maximus turpis ornare at. Morbi porttitor nulla nisi, eu pretium elit ullamcorper pretium. <p>Aenean quis risus a turpis sagittis euismod sed quis mauris. Sed et faucibus quam. Sed eget risus turpis. Nullam sit amet neque gravida libero feugiat sagittis eu congue est. Donec a mauris rutrum, gravida ante non, egestas lacus. Nam lorem ex, pulvinar nec eros a, placerat ullamcorper diam.</p>-->
<!--					</div>-->
<!--					<div class="likebar">-->
<!--						<a href="#likes">10 likes <img src="imgs/like.png"/ class="like"></a>-->
<!--						<a href="#dislikes">2 dislikes <img src="imgs/dislike.png"/ class="like"></a>-->
<!--					</div>-->
<!--					<ul class="comments">-->
<!--						<li>-->
<!--							<img src="imgs/profilepic.jpg" class="friendcommentpic" />-->
<!--							<div class="usercomment">Etiam aliquam ligula pharetra ligula luctus, nec consectetur turpis ornare. Morbi at leo ornare, luctus odio eget, eleifend lorem. Mauris auctor vestibulum varius. Quisque commodo sollicitudin purus pulvinar interdum.</div>-->
<!--						</li>-->
<!--					</ul>-->
<!--					<img src="imgs/profilepic.jpg" class="mycommentpic" /><textarea class="commentbox" placeholder="Say something!"></textarea>-->
<!--				</li>-->
			</ul>
		</div>
	</div>
	<script>
			var uid = 1; //${s_userId};
			
			var gid = 1; //${s_groupid};
			var admin = JSON.parse('${groupAdmin}');
			console.log(admin.userId);
			console.log(admin.firstName);
			$("#admin").append(admin.firstName);
			var members = ${groupMembers};
			console.log("members: " + members);
			$.each(members,function(index,data){
				var fullName = data.firstName + " " + data.lastName;
				$("#members").append("<li><a href='profile?userid="+data.userId+"'> <img src="+data.profilePicUrl+" class='userpic' />" + fullName + "</a></li>");
				console.log("member ka user id" + data.userId);
				console.log(data.firstName);
				console.log(data.lastName);
				}
			);	
			console.log("admin: " + admin);
			
			var posts = ${groupPosts};
			console.log("posts: " + posts);
			$.each(posts,function(index,data){
				var pid = data.postID;
				
				var userInfo = '<div class="userinfo"><img src="'+data.profilePicUrl+'" class="profilepic" /> <span class="username"><a href="profile?userid='+data.userID+'">'+data.userName+'</a></span><br/><span class="datetime">'+data.time+'</span><br/></div>';
				
				var postContent = '<div class="post">'+data.postText+'</div>';
				
				var likesDislikes = '<div class="likebar" hidden><a href="#likes">'+data.likeCount+'<img src="imgs/like.png"/ class="like"></a><a href="#dislikes">'+data.dislikeCount+'<img src="imgs/dislike.png"/ class="like"></a></div>';
				
				console.log("posts id" + data.postID);
				console.log("posts by: "+data.userName);
				console.log("post time: "+data.time);
				var comments = data.comments;
				
				var commentsList = "<ul id='comments"+data.postID+"' class='comments'>";
				$.each(comments,function(index2,data2){
					commentsList += '<li><img src="'+data2.profilePicUrl+'" class="friendcommentpic" /> <span class="username"><a href="profile/'+data.userId+'">'+data.userName+'</a></span><div class="usercomment">'+data2.comment+'</div></li>';
					console.log("comment id"+data2.commentId);
					console.log("comment"+data2.comment);
					console.log("timestamp"+data2.timeStamp);
					console.log("username"+data2.userName);
				});
				commentsList += "</ul>";
				commentsList += '<img src="https://www.accrinet.com/clientuploads/authorship_profile.jpg" class="mycommentpic" /><textarea id="commentbox" class="commentbox" placeholder="Say something!"></textarea>';
				
								$("#timelineposts").append(userInfo+postContent+likesDislikes+commentsList);
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
												console.log("data.userid"+data.userID);
												if(data3==1){
													$("#comments"+data.postID).append('<li><img src="" class="friendcommentpic" /> <span class="username"><a href="profile?userid='+data.userId+'">'+data.userName+'</a></span><div class="usercomment">' + comment + '</div></li>');
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
			
			$("#grouppostbutton").click(function(e) {
			    e.preventDefault()
			    var grouppost = $("#grouppostbox").val();
			    if (grouppost == '') {
			      alert("Your post must have at least 1 character in order to be valid!");
			    } else {
			      // Returns successful data submission message when the entered information is stored in database.
			    	$.ajax({
			    	  	
			 			type: "POST",
				        url:"postSave",
				        dataType: "json", 	
				        data : {
				        	"userID" :  uid,
				        	"postText" : grouppost
				        	//"groupId" : ${s_groupid}
				        	
				        },	
						success: function(data){
							console.log("postSave returns :"+data);
							//window.location.href = "/group.jsp";
							//alert(data);
							//$("#success_message").html("");
							if(data == 1){
								location.reload();
							}
							else{
								console.log("failed saving the post");
							}
						}
					});
			      }
			  });
			
			
		</script>
	
</body>
</html>
