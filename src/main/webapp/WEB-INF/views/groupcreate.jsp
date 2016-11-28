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
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <!-- <script src="js/form.js"></script> -->
	<link href='https://fonts.googleapis.com/css?family=PT+Sans' rel='stylesheet' type='text/css'>
	<script type = "text/javascript" language = "javascript">
		console.log("group create jsp");
		var array = "${friends[1].firstName}"
	 	console.log(array);
	 	$(document).ready(function() {
	 		$("#group_created").hide();
		var array = "${friends[1].firstName}"
		console.log(array);
		    <c:forEach items= "${friends}" var="friendsVar">
		    	$("#friendlist ul").append("<li id= '${friendsVar.userId}'>${friendsVar.firstName} ${friendsVar.lastName}</li>")
		    	var temp = $("#1").val();
		    	console.log(temp);
		    </c:forEach>
			$("#friendlist ul").delegate("li", "click", function() {
    		$("#members ul").append(this);
			});
			$("#members ul").delegate("li", "click", function() {
    		$("#friendlist ul").append(this);
			});
		});
	 	
	 	function onClickSubmit(){
	 		console.log("In sumbmit");
	 		//jsonObj = [];
	 		var friendsList = $("#friendsList li")
	 		var members="";
	 		friendsList.each(function(idx, li){
	 			//friendData = {}
	 			var friend = $(li);
	 			//var fullname = friend.text().split(" ");
	 			//friendData['firstName'] = fullname[0];
	 			//friendData['lastName'] = fullname[1];
	 			//friendData['userId'] = friend.attr('id');
	 			//console.log(friendData['lastName']);
	 			//console.log(friendData['u	serId']);
	 			//jsonObj.push(friendData);
	 			members=members+friend.attr('id')+", ";
	 		
	 		});
	 		console.log($("#groupname").val());
	 		console.log($("#bio").val());
	 		//console.log(JSON.stringify(jsonObj));
	 		//var tk = JSON.stringify(jsonObj);
	 		$.ajax({
	 			type: "POST",
		        url:"savegroup",
		        dataType: "json", 	
		        data : {
		        	"groupName" : $("#groupname").val(),
		        	"groupDescription" : $("#bio").val(),
		        	"groupAdminId" : ${s_userid},
		        	"userDetails" : members
		        },	
				success: function(data){
					console.log("Login returns :"+data);
					//window.location.href = "/group.jsp";
					//alert(data);
					//$("#success_message").html("");
					$('#group_created').show()
					
				}
			
			});
	 		
	 	}
	</script>
</head>

<body>
  <div id="header">
<!--     <a href="index.html"><div id="logo">Amicoz</div></a> -->
<a href="/frontPage"><div id="logo">Amicoz</div></a>
    <div id="user">
      <div id="img"></div>
      <div class="dropdown">
        <a href="javascript:void(0)" class="dropbtn" onclick="dropLink()">
          <img src="${s_imgsrc}" class="userpic" />
          ${s_fullname}</a>
        <div class="dropdown-content" id="profiledrop">
          <a href="/profile??userid=${s_userid}">My Profile</a>
          <a href="/profile_settings">Settings</a>
          <a href="/logout" class="logout">Logout</a>
        </div>
      </div>
    </div>
    <div id="search">
      <input type="text" class="searchbox" placeholder="Search.."></input>
    </div>
  </div>
  <div id="wrapper">
		<h1 class="center">Create a group!</h1>
		<div id="settings">
			<h3>Group information</h3>
			<input type="text" placeholder="My Amicoz Group" id="groupname" class="normal"></input>
			<textarea class="normal" id="bio" placeholder="This is where you type in your group description!" maxlength="200" style="resize: vertical; min-height: 80px; width: 99%"></textarea>
			Choose members:
			<div id="friendlist">
				<ul>
					
				</ul>
			</div>
			Added members:
			<div id="members">
				<ul id="friendsList">
				</ul>
			</div>
			<button type="submit" id="createsubmit" class="button" onclick = onClickSubmit()>Submit</button>
			
			
				<p id = "group_created">Group Created Successfully!!</p></a>
			
		</div>
	</div>
</body>
</html>
