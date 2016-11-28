<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Amicoz</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/main.css">
	<link rel="stylesheet" href="css/jquery-ui.min.css">
  	<script src="js/dropdown.js"></script>
  	<script src="js/jquery-1.11.1.min.js"></script>
  	<script src="js/jquery-ui.min.js"></script>
  	<script src="js/settingsform.js"></script>
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
		<h1 class="center">My Settings</h1>
		<div id="settings">
			<!--  <form action="/gen_settings" method="POST"> -->
			<h3>General Settings</h3>
			<input type="text" placeholder="First Name" id="fname" name="fname" class="normal inputleft"  value=${fname}></input>
			<input type="text" placeholder="Last Name"  id="lname" name="lname" class="normal inputright" value=${lname}></input>
			<input type="text" placeholder="Email id"  id="sec_email" name="email" class="normal" value=${sec_email}></input>
			<input type="text" placeholder="01/01/1990"   id="dob" name="dob" class="normal" style="width: 32.5%;" value=${dob}></input>
			<input type='tel' pattern='[\(]\d{3}[\)]\d{3}[\-]\d{4}' placeholder="812-123-4567"  id="phonenum" name="phonenum" class="normal" style="width: 32.5%;" value=${phonenum}></input>
			<select name="gender" class="normal" id="gender" style="width:32.5%" >
				<option value="male" id="male" ${male}>Male</option>
				<option value="female" id="female" ${female}>Female</option>
			</select>
			<input type="text" placeholder="City"  id="city" name="city" class="normal" style="width: 32.5%;" value=${city}></input>
			<input type="text" placeholder="State" id="state" name="state" class="normal" style="width: 32.5%;" value=${state}></input>
			<input type="text" placeholder="Country"  id="country" name="country" class="normal" style="width: 32.5%;" value=${country}></input> <br>
			School
<!-- 			<input type="text" placeholder="School" value=${school} id="school" name="school" class="normal"></input> -->
			<textarea class="normal"  name="school" id="school" 
			placeholder="Your School!"
			style="resize: vertical; min-height: 80px; width: 99%">${school}</textarea>
			Bio
			<textarea class="normal"  name="bio" id="bio" 
			placeholder="This is where you type in your bio!" maxlength="200" 
			style="resize: vertical; min-height: 80px; width: 99%">${bio}</textarea>
			<button type="submit" id="generalsubmit" class="button">Update</button>
		 	<p id="message"></p>
			<!-- </form> -->
			<hr/>
			
			
			
			<h3>Privacy Settings ${Settings}</h3>
			<select id="privacy" name="privacy" class="normal" id="privacytype" style="width:32.5%">
				<option value="public" id="public" ${pub}>Public</option>
				<option value="friends" id="friends" ${fri}>Friends</option>
				<option value="private" id="private" ${pri}>Private</option>
			</select>
			<button type="submit" id="privacysubmit" class="button">Update</button>
			<p id="privacy_message"></p>
			<hr/>
			
			<div id="reset_pass">
			<h3>Password Reset</h3>
			<input type="password" placeholder="Current Password" id="currentpass" class="normal"></input>
			<input type="password" placeholder="New Password" id="newpass" class="normal"></input>
			<input type="password" placeholder="Confirm Password" id="confpass" class="normal"></input>
			<button type="submit" id="passwordsubmit" class="button">Update</button>
			<p id="reset_message"></p>
			<hr/>
			</div>
			
		
			<form action="http://localhost:3003/kk/upload.php?id=${s_userid}" method="post" enctype="multipart/form-data">
			<h3>Profile Picture</h3>
			<img src=${s_imgsrc} class="preview"/><br/>
			  <input type="file" name="file" id="file" accept="image/jpeg, image/jpg"><br /><br/>
			  <input type="submit" id="profilepicsubmit" class="button"></input>
			</form>
		
		
		
		</div>
	</div>
</body>
</html>
