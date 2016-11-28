$(document).ready(function() {
  $('.searchbox').keydown(function(e) {
	
	if($.trim($('.searchbox').val())!='') {
	    if (e.which === 13) {
	    	e.preventDefault();
//			/alert("you pressed enter");
			/* call the search function */
	    	
	    	var query = $(".searchbox").val();
	    	//alert("You entered "+query);
	    	$.post("/search", 
	    			{ searchQuery : query}, 
	    			
	    			function(data) {
	        	  		console.log(data);
	        	  		if(data == "1") {
	        	  			window.location.replace("/search?searchQuery="+query);
	        	  		} else {
	        	  			alert("sorry")
	        	  		}
	        	  	});
	    }
	}
  });
});