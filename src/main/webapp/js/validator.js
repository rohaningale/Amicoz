$(document).ready(function() {
  function validateEmail(email)  {
    var re = /\S+@\S+\.\S+/;
    return re.test(email);
  }

  function validatePassword(password){
	var minChars = 8;
	var maxChars = 32;
	var regex =  /^[a-zA-Z0-9!@#$%^&*]{6,16}$/;
	if(password.length < minChars || password.length > maxChars) {
		return false;
	}
    return true;

  }

  $("#loginSubmit").click(function(e) {
    
	e.preventDefault()
	
    var username = $("#username").val();
    var loginpass = $("#password").val();
    $('#message').html = "" 
    console.log(username);
    console.log(loginpass);
    if ($.trim(username) =='' || $.trim(loginpass)=='') {
      $('#message').html("Please fill out all the blank.");
    }
    else if (validateEmail(username) == false){
      $('#message').html("Please enter a valid username.");
    }
    else{
    	console.log("Validated");
      $.post("/login_amicoz", {
        "username": username,
        "password": loginpass
      }, function(data) {
    	  
    	  if(data == "1")
    		  window.location.href = "/frontPage";
    	  else
    		  $('#message').html("Invalid credentials");
/*        window.setTimeout(function() {
          window.location.href = '/login/';
        }, 10000);
        $('#formbox').hide();*/
    	  
    	  //window.location.href = '/login_amicoz'
      });
    }
  });
  $("#findPass").click(function(e) {
    e.preventDefault()
    var email = $("#femail").val();
    var answer = $("#answer").val();
    if (email == '' || answer == ''){
      $('#message').html("Please fill out all the blank.");
    }
    else if(validateEmail(email) == false){
      $('#message').html("Please enter a valid email address.");
    }
    else{
      $.post("/forgot_password_2", {
        email: email,
        answer: answer,
      }, function(data) {
/*        window.setTimeout(function() {
          //window.location.href = '/forgotPassword/';
        }, 10000);
        $('#formbox').hide();*/
      });
    }
  });
  $("#registerSubmit").click(function(e) {
    e.preventDefault()
    var fname = $("#fname").val();
    var lname = $("#lname").val();
    var email1 = $("#email1").val();
    var password = $("#password").val();
    var answer = $("#answer").val();
    var email2 = $("#email2").val();
    if (fname == '' || lname == '' || email1 == ''|| password == '' || answer == ''){
      $('#message').html("Please fill out the blanks.");
    }
    else if (validateEmail(email1) == false || validateEmail(email2) == false){
      $('#message').html("Please enter a valid email address.");
    }
    else if(validatePassword(password) == false){
      $('#message').html("Password should at least have 8 letters.");
    }
    else{
      $.post("/includes/register.inc.php", {
        fname: fname,
        lname: lname,
        email1: email1,
        password: password,
        answer: answer,
        email2: email2,
      }, function(data) {
        window.setTimeout(function() {
          window.location.href = '/register/';
        }, 10000);
        $('#formbox').hide();
      });
    }
  });
  $("#findUsername1").click(function(e) {
    e.preventDefault()
    var email = $("#email2").val();
    if (email == ''){
      $('#message').html("Please fill out the blank.");
    }
    else if(validateEmail(email) == false){
      $('#message').html("Please enter a valid email address.");
    }
    else{
      $.post("/includes/forgotUsername1.inc.php", {
        email: email,
      }, function(data) {
          window.location.href = 'forgotUsername2.html';
      });
    }
  });
  $("#findUsername2").click(function(e) {
    e.preventDefault()
    var answer = $("#answer").val();
    if (answer == ''){
      $('#message').html("Please fill out the blank.");
    }
    else{
      $.post("/includes/forgotUsername2.inc.php", {
        answer: answer,
      }, function(data) {
        window.setTimeout(function() {
          window.location.href = '/forgotUsername2/';
        }, 10000);
        $('#formbox').hide();
      });
    }
  });
});
