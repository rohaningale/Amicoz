<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Amicoz</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/style.css">
	<script src="js/jquery-1.11.1.min.js"></script>
	<link href="libs/bootstrap-3.3-2.4-dist/css/bootstrap.min.css" rel="stylesheet">
	<link href='https://fonts.googleapis.com/css?family=PT+Sans' rel='stylesheet' type='text/css'>
	<script src="js/validator.js"></script>
</head>
<body>

  <div id="header">
    <div id="logo" class="loginreg">Amicoz</div>
  </div>

  <div id="formbox">
  <div id="userInput">
	<form action="/frontPage" method="POST">
	<div id="userInput1">
	<input type="text" id="username" name="username" placeholder="Username (your email id)"><br>
	</div>
	<div id="userInput2">
	<input type="password" id="password" name="password" placeholder="Password"><br>
	<label id="message"><font color="red" >${errorMessage}</font></label><hr>
	</div>
	<div id="userInput3">
	<input type="submit" id= "loginSubmit" value="Login" ><br>
	</div>
	<p>
	<a href="/forgot_username_1" style="">Forgot your username?</a>
	<a href="/forgot_password_1"  style="">Forgot your password?</a>
	</p>
	<div id="join" style="margin-top: 20px;">
	Do not have an account? 
	<a href="/register">Join now</a>
	</div>
	</form>
  </div>
  </div>

</body>
</html>
