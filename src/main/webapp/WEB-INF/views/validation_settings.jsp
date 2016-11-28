<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Amicoz</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/main.css">
  <script src="js/dropdown.js"></script>
  <script src="js/jquery-1.11.1.min.js"></script>
  <script src="js/form.js"></script>
	<link href='https://fonts.googleapis.com/css?family=PT+Sans' rel='stylesheet' type='text/css'>
</head>

<body>
  <div id="header">
    <a href="index"><div id="logo">Amicoz</div></a>
    <div id="user">
      <div id="img"></div>
      <div class="dropdown">
        <a href="javascript:void(0)" class="dropbtn" onclick="dropLink()">
          <img src="imgs/profilepic.jpg" class="userpic" />
          ${s_fullname}</a>
        <div class="dropdown-content" id="profiledrop">
          <a href="profile">My Profile</a>
          <a href="profile_settings">Settings</a>
          <a href="logout" class="logout">Logout</a>
        </div>
      </div>
    </div>
    <div id="search">
      <input type="text" class="searchbox" placeholder="Search.."></input>
    </div>
  </div>
  <div id="wrapper">
		<h1 class="center">My Settings</h1>
		<div id="settings">
		
		
			<h3>General Settings</h3>
			<input type="text" placeholder="First Name" value=${fname} id="fname" class="normal inputleft"></input>
			<input type="text" placeholder="Last Name" id="lname" value=${lname} class="normal inputright"></input>
			<input type="text" placeholder="email@email.com" id="email" value=${sec_email} class="normal"></input>
			<input type="text" placeholder="01/01/1990" id="dob" class="normal" value=${dob} style="width: 32.5%;"></input>
			<input type="text" placeholder="812-123-4567" id="phonenum" value=${phonenum} class="normal" style="width: 32.5%;"></input>
			<select name="gender" class="normal" id="gender" style="width:32.5%">
				<option value="male" ${male}>Male</option>
				<option value="female" ${female}>Female</option>
			</select>
			<textarea class="normal" id="bio" placeholder="This is where you type in your bio!" maxlength="200" style="resize: vertical; min-height: 80px; width: 99%">
			${bio}
			</textarea>
			<button type="submit" id="generalsubmit" class="button">Update</button>
			<hr/>
			
			
			<h3>Privacy Settings</h3>
			<select name="privacy" class="normal" id="privacytype" style="width:32.5%">
				<option value="public" ${"pub"}>Public</option>
				<option value="private" ${"pri"}>Private</option>
			</select>
			<button type="submit" id="privacysubmit" class="button">Update</button>
			<hr/>
			<h3>Password Reset</h3>
			<input type="password" placeholder="Current Password" id="currentpass" class="normal"></input>
			<input type="password" placeholder="New Password" id="newpass" class="normal"></input>
			<input type="password" placeholder="Confirm Password" id="confpass" class="normal"></input>
			<button type="submit" id="passwordsubmit" class="button">Update</button>
			<hr/>
			<h3>Profile Picture</h3>
			<img src="${img_src}" class="preview"/><br/>
			<input type="file" id="new profilepic" accept="image/*"><br/><br/>
			<button type="submit" id="profilepicsubmit" class="button">Upload</button>
		</div>
	</div>
</body>
</html>
