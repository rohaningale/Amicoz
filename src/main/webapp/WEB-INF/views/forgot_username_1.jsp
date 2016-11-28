<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Amicoz</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/style.css">
	<link href="libs/bootstrap-3.3-2.4-dist/css/bootstrap.min.css" rel="stylesheet">
	<link href='https://fonts.googleapis.com/css?family=PT+Sans' rel='stylesheet' type='text/css'>
</head>
<body>

  <div id="header">
    <div id="logo" class="loginreg">Amicoz</div>
  </div>

  <div id="formbox">
  <div id="userInput">
	<form id="forgot_username_form" action="/forgot_username_1" method="POST">
<!-- 	<p>Please provide your email to find the password.</p> -->
    <p>Provide your alternate email id?</p>
	<div id="userInput2">
	<input type="text" name="emailId" placeholder="Email address"> 
	<p id="message"><font color=${color}>${message}</font></p> <br>
	<a onclick="document.getElementById('forgot_username_form').submit();"><input type="submit" value="Next >>"></a><br>
<!-- 	href="/forgot_password_1" -->
	</div>
	</div>
	</form>
  </div>
  </div>
</body>
</html>