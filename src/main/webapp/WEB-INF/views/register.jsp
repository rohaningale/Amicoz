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
	<form action="register" method="POST">
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
	<div id="userInput7">
		<select name="questions">
			<option value="pet">What was your first pet's name? </option>
			<option value="mother">What is your mother'€™s maiden name? </option>
			<option value="street">What was the first street you lived on as a child?</option>
		</select>
		</div>
	<div id="userInput8">
		<input type="text" name="password" placeholder="Answer"><br>
	</div>
	<div id="userInput10">
		<p style="text-align:left; margin-left:25px;">Alternate email (*optional)</p>
		<input type="text" name="password" placeholder="email"><br>
	</div>
	<div id="userInput6">
	<a href="#"><input type="button" id="registersubmit" value="Submit"></a><br>
	</div>
	<div id="join" style="margin-top: 20px;">
	Already have an account?
	<a href="/login">Login</a>
	</div>
	</form>
  </div>
  </div>
</body>
</html>
