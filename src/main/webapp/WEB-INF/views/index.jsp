<!doctype html>
<html lang="en">


<head>
<meta charset="UTF-8">
<title>Amicoz</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/main.css">
<script src="js/jquery-1.11.1.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="js/dropdown.js"></script>
<script src="js/searchbox.js"></script>
<!-- <script src="js/tooltip.js"></script> -->
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
		<div id="left">
			<div id="box">
				<div class="title">
					Groups<input type="submit" class='add' onclick="createGroup() "
						value="Create new." />
				</div>
				<ul id="glist">
					<!--           <li><a href="#">B465 Group</a></li>
          <li><a href="#">Computer Science is awesome!</a></li>
          <li><a href="#">Java tutorials</a></li>
          <li><a href="#">Indiana University</a></li>
          <li><a href="#">Best Tech Gadgets</a></li>
          <li><a href="#">Tesla</a></li>
          <li><a href="#">Web Developers Unite</a></li> -->
				</ul>
			</div>
			<div id="box">
				<div class="title">Friend Suggestions</div>
				<ul class="friends" id="friendSuggestionsList">
					<%--           <li><a href="#"><img src="${s_imgsrc}" class="userpic" />Elon Musk</a><a href="#"><div class="add">Add Friend</div></a></li>
          <li><a href="#"><img src="${s_imgsrc}" class="userpic" />Bill Gates</a><a href="#"><div class="add">Add Friend</div></a></li>
          <li><a href="#"><img src="${s_imgsrc}" class="userpic" />Tim Cook</a><a href="#"><div class="add">Add Friend</div></a></li>
          <li><a href="#"><img src="${s_imgsrc}" class="userpic" />Mark Zuckerberg</a><a href="#"><div class="add">Add Friend</div></a></li>
          <li><a href="#"><img src="${s_imgsrc}" class="userpic" />Jack Dorsey</a><a href="#"><div class="add">Add Friend</div></a></li> --%>
				</ul>
			</div>
		</div>
		<div id="right">
			<div id="box">
				<div class="title">
					My Friends <b>|</b> Chat
				</div>
				<ul class="friends" id="friendsList">
					<%--           <li><a href="#"><img src="${s_imgsrc}" class="userpic" />Anand Karandikar</a></li>
          <li><a href="#"><img src="${s_imgsrc}" class="userpic" />Girish Gabra</a></li>
          <li><a href="/chat"><img src="${s_imgsrc}" class="userpic" />Rohan Ingle</a></li>
          <li><a href="#"><img src="${s_imgsrc}" class="userpic" />Yueyang Wu</a></li> --%>
				</ul>
			</div>
			<div id="box">
				<div class="title">Pending Requests</div>
				<ul class="friends" id="pendingReqFromFriendsList">
					<!--  <li ><a href="#"><img src='<c:url value='/resources/images/profilepic.jpg'/>' class='userpic' />Elon Musk1</a><a href="#"><div class="add">Add Friend</div></a></li>-->
					<!--  <li ><a href="#"><img src='<c:url value='/resources/images/profilepic.jpg'/>' class='userpic' />Elon Musk2</a><a href="#"><div class="add">Add Friend</div></a></li> -->
					<!-- <li><a href="#"><img src="<c:url value="/resources/images/profilepic.jpg"/>" class="userpic" />Bill Gates</a><a href="#"><div class="add">Add Friend</div></a></li>
          <li><a href="#"><img src="<c:url value="/resources/images/profilepic.jpg"/>" class="userpic" />Tim Cook</a><a href="#"><div class="add">Add Friend</div></a></li>
          <li><a href="#"><img src="<c:url value="/resources/images/profilepic.jpg"/>" class="userpic" />Mark Zuckerberg</a><a href="#"><div class="add">Add Friend</div></a></li>
          <li><a href="#"><img src="<c:url value="/resources/images/profilepic.jpg"/>" class="userpic" />Jack Dorsey</a><a href="#"><div class="add">Add Friend</div></a></li> -->
				</ul>
			</div>
		</div>
		<div id="center">
			<div id="box">
				<div class="title">Update Status</div>
				<textarea class="statusbox" placeholder="What's on your mind?" id="postText"></textarea>
				<button type="submit" class="statusbutton" id="statusSubmit">Post</button>
			</div>
			<div id="box">
				<div class="title" style="margin-bottom: 5px;">Timeline</div>
				<ul class="timelineposts" id="timelineposts">
					<%-- 					<li>
						<div class="userinfo">
							<img src="${s_imgsrc}" class="profilepic" /> <span
								class="username"><a href="#profilelink">Munir Safi</a></span><br />
							<span class="datetime">April 12, 2016</span><br />
							<span class="datetime">7:35PM</span>
						</div>
						<div class="post">
							Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla
							nunc libero, euismod eget nibh et, elementum efficitur libero.
							Fusce egestas imperdiet arcu, nec maximus turpis ornare at. Morbi
							porttitor nulla nisi, eu pretium elit ullamcorper pretium.
							<p>Aenean quis risus a turpis sagittis euismod sed quis
								mauris. Sed et faucibus quam. Sed eget risus turpis. Nullam sit
								amet neque gravida libero feugiat sagittis eu congue est. Donec
								a mauris rutrum, gravida ante non, egestas lacus. Nam lorem ex,
								pulvinar nec eros a, placerat ullamcorper diam.</p>
						</div>
						<div class="likebar">
							<a href="#likes">10 likes <img src="imgs/like.png"
								/ class="like"></a> <a href="#dislikes">2 dislikes <img
								src="imgs/dislike.png" / class="like"></a>
						</div>
						<ul class="comments">
							<li><img src="${s_imgsrc}" class="friendcommentpic" />
								<div class="usercomment">Etiam aliquam ligula pharetra
									ligula luctus, nec consectetur turpis ornare. Morbi at leo
									ornare, luctus odio eget, eleifend lorem. Mauris auctor
									vestibulum varius. Quisque commodo sollicitudin purus pulvinar
									interdum.</div></li>
						</ul> <img src="${s_imgsrc}" class="mycommentpic" />
					<textarea class="commentbox" placeholder="Say something!"></textarea>
					</li> --%>
				</ul>
			</div>
		</div>
	</div>
</body>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						console.log("this is the script.");
						var list = JSON.parse('${groups}');
						//console.log("listobject: "+ list);

						$.each(list, function(index, data) {
							console.log('inside function');
							console.log(data.groupId);
							$("#glist").append(
									"<li><a href='group?groupid="
											+ data.groupId + "' >"
											+ data.groupName + "</a></li>");
						});
						//console.log(listarr[0] +" "+ listarr[1] +" "+ listarr[2]);
						var fglist = JSON.parse('${friendSuggestion}');
						//console.log("end");
						//"'><img src="+"'<c:url value='/resources/images/profilepic.jpg"+"'/>' class='userpic' />"
						$
								.each(
										fglist,
										function(index, data) {
											console.log("these are suggestions "+data.userId);
											//console.log(data.userId);
											$("#friendSuggestionsList")
													.append(
															"<li><a href='profile?userid="
																	+ data.userId
																	+ "'><img src="+data.profilePicUrl+" class='userpic' />"
																	+ data.firstName
																	+ " "
																	+ data.lastName
																	+ "</a>"
																	+ " "
																	+ "<input type = submit value='Add Friend' class='add' style = 'cursor:pointer;' id = 'friendButton' onclick = 'manageFriend("
																	+ data.userId
																	+ ","
																	+ index
																	+ ")'>"
																	+ "</li>");
										});

						var pendingList = JSON
								.parse('${pendingReqFromFriends}');
						$
								.each(
										pendingList,
										function(index, data) {
											console.log(data.userId);
											$("#pendingReqFromFriendsList")
													.append(
															"<li><a href='profile?userid="
																	+ data.userId
																	+ "'><img src="+data.profilePicUrl+" class='userpic' />"
																	+ data.firstName
																	+ " "
																	+ data.lastName
																	+ "</a>"
																	+ " "
																	+ "<input type = submit value='Confirm Friend' class='add' style = 'margin-top:5px; cursor:pointer;' id = 'friendButton' onclick = 'manageFriend("
																	+ data.userId
																	+ ","
																	+ index
																	+ ")'>"
																	+ "</li>");
										});

						var friendsList = JSON.parse('${friends}');
						$
								.each(
										friendsList,
										function(index, data) {
											console.log(data.userId);
											$("#friendsList")
													.append(
															"<li><a href='profile?userid="
																	+ data.userId
																	+ "'><img src="+data.profilePicUrl+" class='userpic' />"
																	+ data.firstName
																	+ " "
																	+ data.lastName
																	+ "</a><a href='chat?withid="
																	+ data.userId
																	+ "&withname="
																	+ data.firstName
																	+ "'>[Chat]</a></li>");
										});

					});

	function manageFriend(user, liId) {

		//alert("inside manageFriend");
		//alert("data: "+user);
		//alert("list id"+ liId);
		var buttonValue = document.getElementById("friendButton").value;
		//alert(buttonValue);
		console.log('inside addFriend');
		console.log(buttonValue);
		//alert("inside addFriend");
		if (buttonValue == 'Add Friend') {
			$.ajax({
				type : 'POST',
				url : 'addFriend',
				data : {
					user : user
				},
				success : function(data1) {
					if (data1 != "-1") {
						console.log('inside if success');
						$('#friendButton').prop('value',
								'Cancel Friend Request');
						// $('#blockButton').hide();
						console.log("remove list with id:" + liId);
						$(
								"#friendSuggestionsList li:nth-child("
										+ (liId + 1) + ")").remove();
					} else {

						//$("#friendSuggestionsList li:nth-child("+ (liId + 1) + ")").remove();
					}
				}
			});

		}

		if (buttonValue == 'Confirm Friend') {
			
			$.ajax({
				type : 'POST',
				url : '/confirmFriend',
				data : {
					user : user
				},
				success : function(data) {

					console.log(data);
					//alert("success");
					if (data != "-1") {
						console.log('inside if success');
						$('#friendButton').prop('value', 'Friends');
						// $('#blockButton').show();			
						$(
								'#pendingReqFromFriendsList li:nth-child('
										+ (liId + 1) + ')').remove();
					}
				}
			});
		}
	}
	function createGroup() {
		console.log('inside create group');
		var user = '1'
		$.ajax({
			type : 'POST',
			url : 'groupcreate',
			data : {
				"User" : user
			},
			success : function(data) {
				if (data == 1) {
					console.log('in success');
					window.location.href = 'groupcreate';
				}
			}
		});
	}
</script>
<script> 

	$("#statusSubmit")
			.click(
					function(e) {
						e.preventDefault()
						var posttext = $("#postText").val();
						if (posttext.length < 1) {
							alert("Please make sure your post is at least 1 characters.");
						} else if (posttext.length > 500) {
							alert("Your post cannot exceed 500 characters!");
						} else {
							alert(posttext)
							console.log(posttext);
							$
									.ajax({
										type : "POST",
										url : "postSave",
										dataType : "json",
										data : {
											"postText" : posttext
										},
										success : function(data) {
											console
													.log("Post successfully saved!!! :");
											$(".statusbox").val('');
											$(
													"<p>Your comment was successfully added to your profile!</p>")
													.insertAfter(
															"button#statussubmit")
													.delay(5000)
													.fadeOut('slow');
											;

											//window.location.href = "/group.jsp";
											//alert(data);
											//$("#success_message").html("");
											//location.reload();
										}
									});
							// Returns successful data submission message when the entered information is stored in database.
							/*$.post("/includes/passwordreset.inc.php", {
							  postText: posttext,
							}, function(data) {
							  $('h1').empty().html('Settings Successfully Updated!<br/><br/>');
							  window.setTimeout(function() {
							    window.location.href = '/settings/';
							  }, 10000);
							  $('#settings').hide();
							});*/
						}
					});

	
	
	
	$('#likeButton').click(function() {

		var postid = 1;
		var liketype = 'L';
		alert(postid);
		$.ajax({
			type : 'POST',
			url : 'updateLike',
			data : {
				"postID" : postid,
				"Liketype" : liketype
			},
			success : function(data1) {

				//console.log(data1);
				//alert("success");
				if (data1 != "-1") {
					console.log('inside if success');
					//$('#friendButton').prop('value','Add Friend');
				}
			}
		});

	});
	$('#disLikeButton').click(function() {

		var postid = 1;
		var liketype = 'D';
		alert(postid);
		$.ajax({
			type : 'POST',
			url : 'updateLike',
			data : {
				"postID" : postid,
				"Liketype" : liketype
			},
			success : function(data1) {

				//console.log(data1);
				//alert("success");
				if (data1 != "-1") {
					console.log('inside if success');
					///$('#friendButton').prop('value','Add Friend');
				}
			}
		});

	});
	
	var posts = ${friendsPosts}
/* 	if(posts.length == 0)
		return 
	else */
		$.each(posts, function(index, data) {
						var pid = data.postID;

						var userInfo = '<div class="userinfo"><img src="'+data.profilePicUrl+'" class="profilepic" /> <span class="username"><a href="profile?userid='+data.userID+'">'
								+ data.userName
								+ '</a></span><br/><span class="datetime">'
								+ data.time + '</span><br/></div>';

						var postContent = '<div class="post">' + data.postText
								+ '</div>';

						var likesDislikes = '<div class="likebar" hidden><input id = "likeButton" type = "image" src="imgs/like.png"><a href="#dislikes">'
								+ data.dislikeCount
								+ '<img src="imgs/dislike.png"/ class="like"></a></div>';

						console.log("posts id" + data.postID);
						console.log("posts by: " + data.userName);
						console.log("post time: " + data.time);
						var commentsList = "<ul id='comments"+data.postID+"' class='comments'>";
						if(typeof data.comments !== 'undefined') {
						
							var comments = data.comments;

							
							$
									.each(
											comments,
											function(index2, data2) {
												commentsList += '<li><img src="'+data2.profilePicURL+'" class="friendcommentpic" /> <span class="username"><a href="profile/'+data.userId+'">'
														+ data.userName
														+ '</a></span><div class="usercomment">'
														+ data2.comment
														+ '</div></li>';
												console.log("comment id"
														+ data2.commentId);
												console.log("comment"
														+ data2.comment);
												console.log("timestamp"
														+ data2.timeStamp);
												console.log("username"
														+ data2.userName);
											});

						}
						commentsList += "</ul>";
						commentsList += '<img src="https://www.accrinet.com/clientuploads/authorship_profile.jpg" class="mycommentpic" /><textarea id="commentbox" class="commentbox" placeholder="Say something!"></textarea>';
						console.log("user info------"+userInfo);
						console.log("Post content----"+postContent);
						console.log("Likes----"+likesDislikes);
						console.log("comments-----"+commentsList);
						$("#timelineposts").append(
								userInfo + postContent + likesDislikes
										+ commentsList);
						$('.commentbox')
								.keypress(
										function(e) {
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

													$
															.ajax({

																type : "POST",
																url : "/commentSave",
																dataType : "json",
																data : {
																	"userId" : uid,
																	"comment" : comment,
																	"postId" : pid
																},
																success : function(
																		data3) {
																	console
																			.log("commentSave returns :"
																					+ data3);
																	//window.location.href = "/group.jsp";
																	//alert(data);
																	//$("#success_message").html("");
																	if (data3 == 1) {
																		$(
																				"#comments"
																						+ data.postID)
																				.append(
																						'<li><img src="" class="friendcommentpic" /> <span class="username"><a href="profile/'+data.userId+'">'
																								+ data.userName
																								+ '</a></span><div class="usercomment">'
																								+ comment
																								+ '</div></li>');
																	} else {
																		console
																				.log("in else");

																	}
																}
															});

													//alert($(this).parent().parent().get(0).tagName + " " + $(this).parent().parent().attr('class'));
													// Returns successful data submission message when the entered information is stored in database.
													console
															.log("In comment enter");

												}
												return false; //<---- Add this line
											}
										});

					});
</script>