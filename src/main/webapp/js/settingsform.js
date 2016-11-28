$(document).ready(function() {
	
	
  function validateEmail(email)  {
    //var re = /\S+@\S+\.\S+/;
	  var re = /^\b[A-Z0-9._%-]+@[A-Z0-9.-]+\.[A-Z]{2,4}\b$/i;

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
    
    var email = $("#sec_email").val();
    var fname = $("#fname").val();
    var lname = $("#lname").val();
    var dob = $("#dob").val();
    var phonenum = $("#phonenum").val();
    var gender = $("#gender").val();
    var bio = $.trim($("#bio").val());
    var city= $('#city').val();
    var state= $('#state').val();
    var country= $('#country').val();
    var school= $.trim($('#school').val());
    
    if (email == '' || validateEmail(email) == false) {
      alert("Your secondary email address was left blank or written in an invalid format. Please fix the error and try again.");
    } else if (fname == '') {
      alert("You can't leave your first name blank!!!");
    } else if (validatePhone(phonenum) == false) {
        alert("Please make sure your phone number is 10 digits in the following format: 123-456-7890 (Make sure there are no spaces)");
    } else {
      // Returns successful data submission message when the entered information is stored in database.
      $.post("/gen_settings", {
        sec_email: email,
        fname: fname,
        lname: lname,
        dob: dob,
        phonenum: phonenum,
        gender: gender,
        bio: bio,
        city: city,
        state: state,
        country: country,
        school: school
      }, function(data) {
    	  console.log(data);
    	  if(data == "1") {
    		  $('#message').html("Changes saved successfully.");
    		  
    		  //$('#message').show();//.delay(2000).hide();
    		  
    	  }else {
    		  $('#message').html("Error in saving changes.");
    	  }
    	  $('#message').delay(5000).fadeOut(300);
    	  
        //$('h1').empty().html('Settings Successfully Updated!<br/><br/>');
//        window.setTimeout(function() {
//          //window.location.href = '/settings/';
//        }, 2000);
//        //$('#settings').hide();
    	  });
      
    }
  });
  $("#privacysubmit").click(function(e) {
    e.preventDefault()
    var privacy = $("#privacy").val();
    if (privacy == '') {
      alert("If you're seeing this, you somehow broke the page! Please refresh and try again.");
    } else {
      // Returns successful data submission message when the entered information is stored in database.
      
    	$.ajax({
 			type: "POST",
	        url:"/privacy_settings",
	        dataType: "json", 	
	        data : {
	        	"privacy": privacy
	        },	
			success: function(data){
				
		    	console.log(data);
		    	if(data == "1") {
		    		$('#privacy_message').html("Changes saved successfully.");
		    	}else {
		    		$('#privacy_message').html("Error in saving changes.");
		    	}
		    	$('#privacy_message').delay(5000).fadeOut(300);
				
			}
		
		});
    }
  });

  $("#passwordsubmit").click(function(e) {
	  
	  e.preventDefault()
	    var currentPassword = $("#currentpass").val();
	    var newPassword = $("#newpass").val();
	    var confirmPassword = $("#confpass").val();
	    if (newPassword != confirmPassword|| newPassword == '' || confirmPassword == '' || currentPassword == '') {
	      alert("Your current password is incorrect or your new passwords don't match! Please try again.");
	    } else {
		  
		  
		  $.post("/password_settings", {
			 currentPassword : currentPassword,
		     newPassword : newPassword,
		     confirmPassword : confirmPassword
	      }, function(data) {
	    	  console.log(data);
	    	  if(data == "1") {
	    		  $('#reset_message').html("Changes saved successfully.");  		  
	    	  }else {
	    		  $('#reset_message').html("Error in saving changes.");
	    	  }
	    	  $('#message').delay(5000).fadeOut(300);
	    	  });
	      
	    }
  });
  /*$("#profilepicsubmit").click(function(e) {
    e.preventDefault()
    var profilepic = $("#newprofilepic").val();
    if (profilepic == '') {
      alert("You need to select an image and then try again!");
    } else {
      // Returns successful data submission message when the entered information is stored in database.
      $.post("/profile_pic_settings", {
        profilepic: profilepic,
      }, function(data) {
    	  console.log(data);
    	  if(data == "1") {
    		  $('#profile_pic_message').html("Changes saved successfully");
    		  
    		  //$('#message').show();//.delay(2000).hide();
    		  
    	  }else {
    		  $('#profile_pic_message').html("Error in saving changes");
    	  }
    	  $('#profile_pic_message').delay(5000).fadeOut(300);
        //$('h1').empty().html('Settings Successfully Updated!<br/><br/>');
        //window.setTimeout(function() {
          //window.location.href = '/profile_settings/';
        //}, 10000);
        //$('#settings').hide();
      });
    }
  });
*/
});
