<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Amicoz</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/main.css">
	<script src="js/jquery-1.11.1.min.js"></script>
  	<script src="js/dropdown.js"></script>
  	<script src="js/searchbox.js"></script>
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
          <img src=${s_imgsrc } class="userpic" />
          ${s_fullname }</a>
        <div class="dropdown-content" id="profiledrop">
          <a href="/profile?userid=${s_userid}">My Profile</a>
          <a href="/profile_settings">Settings</a>
          <a href="/logout" class="logout">Logout</a>
        </div>
      </div>
    </div>
      <div id="search">
      <input type="text" class="searchbox" placeholder="Search.. ( [firstname] [lastname] ) ex. John Smith"></input>
    </div>
  </div>
  <div id="wrapper">
  <div id="center">
      <div id="box">
      <ul class="search" id="searchresults">
          <!-- <li><a href="#"><img style="width:50px;height: 50px;" src="imgs/profilepic.jpg" class="userpic" />Elon Musk</a><a href="#"><div class="add" style="padding:3px;">View Profile</div></a></li>
          <li><a href="#"><img style="width:50px;height: 50px;" src="imgs/profilepic.jpg" class="userpic" />Bill Gates</a><a href="#"><div class="add" style="padding:3px;">View Profile</div></a></li>
          <li><a href="#"><img style="width:50px;height: 50px;" src="imgs/profilepic.jpg" class="userpic" />Tim Cook</a><a href="#"><div class="add" style="padding:3px;">View Profile</div></a></li>
          <li><a href="#"><img style="width:50px;height: 50px;" src="imgs/profilepic.jpg" class="userpic" />Mark Zuckerberg</a><a href="#"><div class="add" style="padding:3px;">View Profile</div></a></li>
          <li><a href="#"><img style="width:50px;height: 50px;" src="imgs/profilepic.jpg" class="userpic" />Jack Dorsey</a><a href="#"><div class="add" style="padding:3px;">View Profile</div></a></li> -->
      </ul>
      </div>
  </div>
  </div>
 </body>
 </html>
 
 
 
 <script>
 $(document).ready(function(){
		console.log("this is the script.");

		var searchList = JSON.parse('${searches}');
		console.log(searchList)
		$.each(searchList,function(index,data){
			console.log(data.userId);
			$("#searchresults").append("<li><a href='profile?userid="+data.userId+"'><img src="+data.profilePicUrl+" class='userpic' />"+ data.fullname+"</a> <i>"+data.city+"</i></li>");
		});
		
		});
 
 </script>