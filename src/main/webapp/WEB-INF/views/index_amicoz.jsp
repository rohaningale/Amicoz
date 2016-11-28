<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Amicoz</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/main.css">
	<script src="js/jquery-1.11.1.min.js"></script>
  	<script src="js/dropdown.js"></script>
  	<script src="js/form.js"></script>
<!--   	<script src="js/index_1.js"></script> -->
	<link href='https://fonts.googleapis.com/css?family=PT+Sans' rel='stylesheet' type='text/css'>
</head>

<body>
  <div id="header">
    <a href="/index"><div id="logo">Amicoz</div></a>
    <div id="user">
      <div id="img"></div>
      <div class="dropdown">
        <a href="javascript:void(0)" class="dropbtn" onclick="dropLink()">
          <img src="${s_imgsrc}" class="userpic" />
          ${s_fullname}</a>
        <div class="dropdown-content" id="profiledrop">
          <a href="profile.html">My Profile</a>
          <a href="settings.html">Settings</a>
          <a href="#logout" class="logout">Logout</a>
        </div>
      </div>
    </div>
    <div id="search">
      <input type="text" class="searchbox" placeholder="Search.. ( Name, City, Emailid ) ex. John Smith"></input>
    </div>
  </div>
  <div id="wrapper">
    <div id="left">
      <div id="box">
        <div class="title">Groups <a href="groupcreate.html" class="create">Create your own!</a></div>
        <ul>
          <li><a href="#">B465 Group</a></li>
          <li><a href="#">Computer Science is awesome!</a></li>
          <li><a href="#">Java tutorials</a></li>
          <li><a href="#">Indiana University</a></li>
          <li><a href="#">Best Tech Gadgets</a></li>
          <li><a href="#">Tesla</a></li>
          <li><a href="#">Web Developers Unite</a></li>
        </ul>
      </div>
      <div id="box">
        <div class="title">Friend Suggestions</div>
        <ul class="friends">
          <li><a href="#"><img src="imgs/profilepic.jpg" class="userpic" />Elon Musk</a><a href="#"><div class="add">Add Friend</div></a></li>
          <li><a href="#"><img src="imgs/profilepic.jpg" class="userpic" />Bill Gates</a><a href="#"><div class="add">Add Friend</div></a></li>
          <li><a href="#"><img src="imgs/profilepic.jpg" class="userpic" />Tim Cook</a><a href="#"><div class="add">Add Friend</div></a></li>
          <li><a href="#"><img src="imgs/profilepic.jpg" class="userpic" />Mark Zuckerberg</a><a href="#"><div class="add">Add Friend</div></a></li>
          <li><a href="#"><img src="imgs/profilepic.jpg" class="userpic" />Jack Dorsey</a><a href="#"><div class="add">Add Friend</div></a></li>
        </ul>
      </div>
    </div>
    <div id="right">
      <div id="box">
        <div class="title">My Friends <b>|</b> Chat</div>
        <ul class="friends">
          <li><a href="#"><img src="imgs/profilepic.jpg" class="userpic" />Anand Karandikar</a></li>
          <li><a href="#"><img src="imgs/profilepic.jpg" class="userpic" />Girish Gabra</a></li>
          <li><a href="#"><img src="imgs/profilepic.jpg" class="userpic" />Rohan Ingle</a></li>
          <li><a href="#"><img src="imgs/profilepic.jpg" class="userpic" />Yueyang Wu</a></li>
        </ul>
      </div>
    </div>
    <div id="center">
      <div id="box">
        <div class="title">Update Status</div>
        <textarea class="statusbox" id="posttext" placeholder="What's on your mind?"></textarea>
        <button type="submit" id="statussubmit" class="statusbutton">Post</button>
      </div>
      <div id="box">
        <div class="title" style="margin-bottom: 5px;">Timeline</div>
				<ul class="timelineposts">
					<li id="1">
						<div class="userinfo">
							<img src="imgs/profilepic.jpg" class="profilepic" /> <span class="username"><a href="#profilelink">Munir Safi</a></span><br/><span class="datetime">April 12, 2016</span><br/><span class="datetime">7:35PM</span>
						</div>
						<div class="post">
							Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla nunc libero, euismod eget nibh et, elementum efficitur libero. Fusce egestas imperdiet arcu, nec maximus turpis ornare at. Morbi porttitor nulla nisi, eu pretium elit ullamcorper pretium. <p>Aenean quis risus a turpis sagittis euismod sed quis mauris. Sed et faucibus quam. Sed eget risus turpis. Nullam sit amet neque gravida libero feugiat sagittis eu congue est. Donec a mauris rutrum, gravida ante non, egestas lacus. Nam lorem ex, pulvinar nec eros a, placerat ullamcorper diam.</p>
						</div>
						<div class="likebar">
							<a href="" class="likes">10 likes <img src="imgs/like.png"/ class="like"></a>
							<a href="" class="dislikes">2 dislikes <img src="imgs/dislike.png"/ class="like"></a>
						</div>
						<ul class="comments">
							<li>
								<img src="imgs/profilepic.jpg" class="friendcommentpic" />
								<div class="usercomment">Etiam aliquam ligula pharetra ligula luctus, nec consectetur turpis ornare. Morbi at leo ornare, luctus odio eget, eleifend lorem. Mauris auctor vestibulum varius. Quisque commodo sollicitudin purus pulvinar interdum.</div>
							</li>
						</ul>
						<img src="imgs/profilepic.jpg" class="mycommentpic" /><textarea class="commentbox" placeholder="Say something!"></textarea>
					</li>
					<li>
						<div class="userinfo">
							<img src="imgs/profilepic.jpg" class="profilepic" /> <span class="username"><a href="#profilelink">Munir Safi</a></span><br/><span class="datetime">April 12, 2016</span><br/><span class="datetime">7:35PM</span>
						</div>
						<div class="post">
							Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla nunc libero, euismod eget nibh et, elementum efficitur libero. Fusce egestas imperdiet arcu, nec maximus turpis ornare at. Morbi porttitor nulla nisi, eu pretium elit ullamcorper pretium. <p>Aenean quis risus a turpis sagittis euismod sed quis mauris. Sed et faucibus quam. Sed eget risus turpis. Nullam sit amet neque gravida libero feugiat sagittis eu congue est. Donec a mauris rutrum, gravida ante non, egestas lacus. Nam lorem ex, pulvinar nec eros a, placerat ullamcorper diam.</p>
						</div>
						<div class="likebar">
							<a href="" class="likes">10 likes <img src="imgs/like.png"/ class="like"></a>
							<a href="" class="dislikes">2 dislikes <img src="imgs/dislike.png"/ class="like"></a>
						</div>
						<ul class="comments">
							<li>
								<img src="imgs/profilepic.jpg" class="friendcommentpic" />
								<div class="usercomment">Etiam aliquam ligula pharetra ligula luctus, nec consectetur turpis ornare. Morbi at leo ornare, luctus odio eget, eleifend lorem. Mauris auctor vestibulum varius. Quisque commodo sollicitudin purus pulvinar interdum.</div>
							</li>
						</ul>
						<img src="imgs/profilepic.jpg" class="mycommentpic" /><textarea class="commentbox" placeholder="Say something!"></textarea>
					</li>
					<li>
						<div class="userinfo">
							<img src="imgs/profilepic.jpg" class="profilepic" /> <span class="username"><a href="#profilelink">Munir Safi</a></span><br/><span class="datetime">April 12, 2016</span><br/><span class="datetime">7:35PM</span>
						</div>
						<div class="post">
							Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla nunc libero, euismod eget nibh et, elementum efficitur libero. Fusce egestas imperdiet arcu, nec maximus turpis ornare at. Morbi porttitor nulla nisi, eu pretium elit ullamcorper pretium. <p>Aenean quis risus a turpis sagittis euismod sed quis mauris. Sed et faucibus quam. Sed eget risus turpis. Nullam sit amet neque gravida libero feugiat sagittis eu congue est. Donec a mauris rutrum, gravida ante non, egestas lacus. Nam lorem ex, pulvinar nec eros a, placerat ullamcorper diam.</p>
						</div>
						<div class="likebar">
							<a href="" class="likes">10 likes <img src="imgs/like.png"/ class="like"></a>
							<a href="" class="dislikes">2 dislikes <img src="imgs/dislike.png"/ class="like"></a>
						</div>
						<ul class="comments">
							<li>
								<img src="imgs/profilepic.jpg" class="friendcommentpic" />
								<div class="usercomment">Etiam aliquam ligula pharetra ligula luctus, nec consectetur turpis ornare. Morbi at leo ornare, luctus odio eget, eleifend lorem. Mauris auctor vestibulum varius. Quisque commodo sollicitudin purus pulvinar interdum.</div>
							</li>
						</ul>
						<img src="imgs/profilepic.jpg" class="mycommentpic" /><textarea class="commentbox" placeholder="Say something!"></textarea>
					</li>
				</ul>
      </div>
    </div>
  </div>
</body>


<script type="text/javascript">
$(document).ready(function(){
	console.log("This is the script.")
	var list = JSON.parse('${groups}');
	//console.log("listobject: "+ list);
	
	$.each(list, function(index, data){
		console.log('inside function');
		console.log(data.groupId);
		$("#glist").append("<li><a href='groupInfo?groupid="+data.groupId+"' >"+ data.groupName+ "</a></li>");
	});
});


</script>