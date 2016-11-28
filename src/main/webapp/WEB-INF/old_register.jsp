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
<body class="login">
  <div id="header">
    <div id="logo" class="loginreg">Amicoz</div>
  </div>
  <div id="formbox">
  <div id="userInput">
	<form action="/register2" method="POST">
	<div id="userInput1">
	<input type="text" name="firstname" placeholder="First name"><br>
	</div>
	<div id="userInput2">
	<input type="text" name="lastname" placeholder="Last name"><br>
	</div>
	<div id="userInput4">
	<input type="text" name="email" placeholder="Email"><br>
	</div>
	<div id="userInput5">
	<input type="password" name="password" placeholder="Password"><br>
	</div>
	<div id="userInput6">
	<input type="submit" value="Next >>">
	<!-- <a href="/register2"><input type="button" value="Next >>"></a> -->
	
	<br>
	</div>
	<div id="join" style="margin-top: 20px;">
	Already have an account? 
	<a href="/login_amicoz">Login</a>
	</div>
	</form>
  </div>
  </div>
</body>
</html>