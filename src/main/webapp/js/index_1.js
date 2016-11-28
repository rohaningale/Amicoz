
$(document).ready(function(){
	console.log("this is the script.");
	var list = JSON.parse('${groups}');
	//console.log("listobject: "+ list);
	
	$.each(list, function(index, data){
		console.log('inside function');
		console.log(data.groupId);
		$("#glist").append("<li><a href='groupInfo?groupid="+data.groupId+"' >"+ data.groupName+ "</a></li>");
	});
	//console.log(listarr[0] +" "+ listarr[1] +" "+ listarr[2]);
	var fglist = JSON.parse('${friendSuggestion}');
	//console.log("end");
	
	$.each(fglist,function(index,data){
		//console.log(data.userId);
		$("#friendSuggestionsList").append("<li><a href='profile?userid="+data.userId+"'><img src="+"'<c:url value='/resources/images/profilepic.jpg"+"'/>' class='userpic' />"+ data.firstName+" "+data.lastName+"</a>"+" "+"<input type = submit value='Add Friend' class='add' style = 'cursor:pointer;' id = 'friendButton' onclick = 'manageFriend("+data.userId+","+index+")'>"+"</li>");
	});                                                                   
	
	var pendingList = JSON.parse('${pendingReqFromFriends}');
	$.each(pendingList,function(index,data){
		console.log(data.userId);
		$("#pendingReqFromFriendsList").append("<li><a href='"+data.userId+"'><img src="+"'<c:url value='/resources/images/profilepic.jpg"+"'/>' class='userpic' />"+ data.firstName+" "+data.lastName+"</a>"+" "+"<input type = submit value='Confirm Friend' class='add' style = 'margin-top:5px; cursor:pointer;' id = 'friendButton' onclick = 'manageFriend("+data.userId+","+index+")'>"+"</li>");
	});
	
	var friendsList = JSON.parse('${friends}');
	$.each(friendsList,function(index,data){
		console.log(data.userId);
		$("#friendsList").append("<li><a href='"+data.userId+"'><img src="+"'<c:url value='/resources/images/profilepic.jpg"+"'/>' class='userpic' />"+ data.firstName+" "+data.lastName+"</li>");
	});
	
	});

function manageFriend(user,liId){
	
	//alert("inside manageFriend");
	//alert("data: "+user);
	//alert("list id"+ liId);
	var buttonValue = document.getElementById("friendButton").value;
	//alert(buttonValue);
	console.log('inside addFriend');
	//alert("inside addFriend");
	if(buttonValue == 'Add Friend'){
		$.ajax({
			type: 'POST',
			url: 'addFriend',
			data: {user: user},
			success: function(data1){
				if(data1 != "-1"){
					console.log('inside if success');
					$('#friendButton').prop('value','Cancel Friend Request');
					// $('#blockButton').hide();
					console.log("remove list with id:"+ liId);
					$( "#friendSuggestionsList li:nth-child("+(liId+1)+")" ).remove();
				}
			}
		});
		
	}
	
	if(buttonValue == 'Confirm Friend'){
		$.ajax({
			type: 'POST',
			url: 'confirmFriend',
			data: {user: user},
			success: function(data){
				 
				 console.log(data);
				//alert("success");
				if(data != "-1"){
					console.log('inside if success');
					$('#friendButton').prop('value','Friends');
					// $('#blockButton').show();			
					$('#pendingReqFromFriendsList li:nth-child('+(liId+1)+')').remove();
				}
			}
		});
	}
}