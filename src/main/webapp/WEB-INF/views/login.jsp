<html>
<script src="js/jquery-1.11.1.min.js"></script>


<head>
<title>Yahoo!!</title>
</head>
<body>
    <label id="message"><font color="red" ></font></label><hr>
    <form action="/trial" method="POST">
        Name : <input id="emailId" name="emailId" type="text" value=${user} >  </input> 
        Password : <input name="password" type="text" value=${pass} >
        </input> <input type="button" id="login" onclick=""/>
    </form>
</body>

<script type="text/javascript" >


$(document).ready(function() {
	
	  $("#login").click(function(e) {
		    e.preventDefault()
		    if (username =='' || loginpass=='') {
		        $('#message').html("Please fill out all the blank.");
		      }
		      else if (validateEmail(username) == false){
		        $('#message').html("Please enter a valid username.");
		      } else{
			
			      // Returns successful data submission message when the entered information is stored in database.
			      $.post({
			    	url:"/validate", 
			    	dataType: "JSON", 
			    	data: {
			        EMAIL: $("#emailId").val()
			      },
			      success: function(data) {
			    	  console.log(data);
			    	  if(data == "1") {
			    		  //$('#message').html("Changes saved successfully");
			    		  
			    		  //$('#message').show();//.delay(2000).hide();
						  
						  $('#message').html("success");
			    		  
			    	  }else {
			    		  $('#message').html("Error");
			    	  }
	
			    	  }});
		      }
		  });
})


</script>

</html>