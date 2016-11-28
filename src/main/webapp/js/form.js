$(document).ready(function() {
  function validateEmail(email)  {
    var re = /\S+@\S+\.\S+/;
    return re.test(email);
  }
  function validatePhone(phone)  {
    if (phone == '') {
      return true;
    } else {
      var re = /[1-9]\d{2}-\d{3}-\d{4}/;
      return re.test(phone);
    }
  }
  $(function() {
    $( "#dob" ).datepicker({
      dateFormat: "yy-mm-dd",
      changeYear: true,
      yearRange: "1900:2016",
      changeMonth: true
    });
  });
  $("#generalsubmit").click(function(e) {
    e.preventDefault()
    var email = $("#email").val();
    var fname = $("#fname").val();
    var lname = $("#lname").val();
    var dob = $("#dob").val();
    var phonenum = $("#phonenum").val();
    var gender = $("#gender").val();
    var bio = $("#bio").val();
    if (email == '' || validateEmail(email) == false) {
      alert("Your secondary email address was left blank or written in an invalid format. Please fix the error and try again.");
    } else if (fname == '') {
      alert("You can't leave your first name blank!!!");
    } else if (validatePhone(phonenum) == false) {
      alert("Please make sure your phone number is 10 digits in the following format: 123-456-7890 (Make sure there are no spaces)")
    } else {
      // Returns successful data submission message when the entered information is stored in database.
      $.post("/includes/passwordreset.inc.php", {
        email: email,
        firstname: fname,
        lname: lname,
        dob: dob,
        phonenum: phonenum,
        gender: gender,
        bio: bio,
      }, function(data) {
        $('h1').empty().html('Settings Successfully Updated!<br/><br/>');
        window.setTimeout(function() {
          window.location.href = '/settings.html';
        }, 10000);
        $('#settings').hide();
      });
    }
  });
  $("#registersubmit").click(function(e) {
    e.preventDefault()
    var email = $("#email").val();
    var fname = $("#fname").val();
    var lname = $("#lname").val();
    var dob = $("#dob").val();
    var phonenum = $("#phonenum").val();
    var gender = $("#gender").val();
    var bio = $("#bio").val();
    if (email == '' || validateEmail(email) == false) {
      alert("Your secondary email address was left blank or written in an invalid format. Please fix the error and try again.");
    } else if (fname == '') {
      alert("You can't leave your first name blank!!!");
    } else {
      // Returns successful data submission message when the entered information is stored in database.
      $.post("/includes/passwordreset.inc.php", {
        email: email,
        fname: fname,
        lname: lname,
        dob: dob,
        phonenum: phonenum,
        gender: gender,
        bio: bio,
      }, function(data) {
        $('h1').empty().html('Settings Successfully Updated!<br/><br/>');
        window.setTimeout(function() {
          window.location.href = '/login.html';
        }, 10000);
        $('#settings').hide();
      });
    }
  });
  $("#privacysubmit").click(function(e) {
    e.preventDefault()
    var privacytype = $("#privacytype").val();
    if (privacytype == '') {
      alert("If you're seeing this, you somehow broke the page! Please refresh and try again.");
    } else {
      // Returns successful data submission message when the entered information is stored in database.
      $.post("/includes/passwordreset.inc.php", {
        privacy: privacytype,
      }, function(data) {
        $('h1').empty().html('Settings Successfully Updated!<br/><br/>');
        window.setTimeout(function() {
          window.location.href = '/settings/';
        }, 10000);
        $('#settings').hide();
      });
    }
  });
  $("#passwordsubmit").click(function(e) {
    e.preventDefault()
    var password = $("#currentpass").val();
    var newpass = $("#newpass").val();
    var confpass = $("#confpass").val();
    if (newpass != confpass|| newpass == '' || confpass == '' || currentpass == '') {
      alert("Your current password is incorrect or your new passwords don't match! Please try again.");
    } else {
      // Returns successful data submission message when the entered information is stored in database.
      $.post("/includes/passwordreset.inc.php", {
        password: currentpass,
        newpass: newpass,
        confpass: confpass,
      }, function(data) {
        $('h1').empty().html('Settings Successfully Updated!<br/><br/>');
        window.setTimeout(function() {
          window.location.href = '/settings/';
        }, 10000);
        $('#settings').hide();
      });
    }
  });
  $("#profilepicsubmit").click(function(e) {
    e.preventDefault()
    var profilepic = $("#newprofilepic").val();
    if (profilepic == '') {
      alert("You need to select an image and then try again!");
    } else {
      // Returns successful data submission message when the entered information is stored in database.
      $.post("/includes/passwordreset.inc.php", {
        profilepic: profilepic,
      }, function(data) {
        $('h1').empty().html('Settings Successfully Updated!<br/><br/>');
        window.setTimeout(function() {
          window.location.href = '/settings/';
        }, 10000);
        $('#settings').hide();
      });
    }
  });
  $("#statussubmit").click(function(e) {
    e.preventDefault()
    var posttext = $("#posttext").val();
    if (posttext.length == '') {
      alert("Please make sure your post is at least 1 characters.");
    } else if (posttext.length > 500) {
      alert("Your post cannot exceed 500 characters!");
    } else {
      $("#box .timelineposts").prepend("<li><div class='userinfo'><img src='imgs/profilepic.jpg' class='profilepic' /> <span class='username'><a href='#profilelink'>Munir Safi</a></span><br/><span class='datetime'>April 12, 2016</span><br/><span class='datetime'>7:35PM</span></div><div class='post'>"+ posttext + "</div><div class='likebar'><a href='' class='likes'>0 likes <img src='imgs/like.png' class='like'></a><a href='' class='dislikes'>0 dislikes <img src='imgs/dislike.png' class='like'></a></div><ul class='comments'><li></li></ul><img src='imgs/profilepic.jpg' class='mycommentpic' /><textarea class='commentbox' placeholder='Say something!''></textarea></li>");
      // Returns successful data submission message when the entered information is stored in database.
      /*$.post("/includes/passwordreset.inc.php", {
        postText: posttext,
      }, function(data) {
        $('h1').empty().html('Settings Successfully Updated!<br/><br/>');
        window.setTimeout(function() {
          window.location.href = '/settings/';
        }, 10000);
        $('#settings').hide();
      });*/
    }
  });
  $("#createsubmit").click(function(e) {
    e.preventDefault()
    var groupname = $("#groupname").val();
    if (groupname == '') {
      alert("You cannot leave the group name blank!");
    } else if (groupname.length < 3) {
      alert("Please ensure that the group name is more than 3 characters.");
    } else if ($('#members ul li').length < 1) {
      alert("Please be sure to add at least one other member to this group before creating it.")
    } else {
      // Returns successful data submission message when the entered information is stored in database.
      $.post("/includes/passwordreset.inc.php", {
        groupName: groupname,
      }, function(data) {
        $('h1').empty().html('Settings Successfully Updated!<br/><br/>');
        window.setTimeout(function() {
          window.location.href = '/settings/';
        }, 10000);
        $('#settings').hide();
      });
    }
  });
  $("#grouppostbutton").click(function(e) {
    e.preventDefault()
    var grouppost = $("#grouppostbox").val();
    if (grouppost == '') {
      alert("Your post must have at least 1 character in order to be valid!");
    } else {
      // Returns successful data submission message when the entered information is stored in database.
      $.post("", {
        goupPost: grouppost,
      }, function(data) {
        $('#box').empty().html('Your post was successfully submitted!<br/><br/>');
        $('#box').load();
      });
    }
  });
  $(".likes").one('click', function(e) {
    e.preventDefault()
    var likecount = $(this).text().match(/\d+/);
    $(this).html(likecount*1 + 1 + " likes <img src='imgs/like.png' class='like'>");
  });
  $(".dislikes").one('click', function(e) {
    e.preventDefault()
    var dislikecount = $(this).text().match(/\d+/);
    $(this).html(dislikecount*1 - 1 + " dislikes <img src='imgs/dislike.png' class='like'>");
  });
  $(".dislikes").on('click', function(e) {
    e.preventDefault()
  });
  $(".likes").on('click', function(e) {
    e.preventDefault()
  });
  
  $("#registersubmit").click(function(e) {
	    e.preventDefault()
	    var email = $("#email").val();
	    var fname = $("#fname").val();
	    var lname = $("#lname").val();
	    var pass = $('#password').val();
	    if (email == '' || validateEmail(email) == false) {
	        alert("Your email address was left blank or written in an invalid format. Please fix the error and try again.");
	      } else if (fname == '' || lname == '') {
	        alert("You can't leave your first or last name blank!!!");
	      } else if(validatePassword(pass) == false){
	    	alert("Your password should be in range [8-32] chars and should include special characters.");
	      } else {
	    	document.getElementById("registerForm").submit();
	      }
  
	      
  });
  
  
  
  
});
