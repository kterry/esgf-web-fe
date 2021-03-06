function editUser(openId){
  var oid = openId;
    
  $("div .edit_field").show();
  $("div .error").hide();
  $("div .success").hide();
    
  //empty table first then fill
  var Parent = document.getElementById('edit_table');
  for(var i = Parent.rows.length - 1; i > 0; i--){
    Parent.deleteRow(i);
  }

  var jsonObj = new Object;
  jsonObj.openId = oid;
			
  var jsonStr = JSON.stringify(jsonObj);
  var userinfo_url = '/esgf-web-fe/getusersinfoproxy';
  $.ajax({
	  type: "POST",
	  url: userinfo_url,
		async: true,
		cache: false,
	  data: {query:jsonStr},
	  dataType: 'json',
    success: function(data) {
      if (data.EditOutput.status == "success") { 
        var users = data.EditOutput.comment;
        var rows = users.split(",");
        $('.editTable').append('<tr><td>openId</td><td>' + rows[9] + '</td></tr>' +
                                     '<tr><td>username</td><td>' + rows[0] + '</td></tr>' +
                                     '<tr><td>Last Name:</td><td><input alt="" type="text" class="text" id="lastName" value="' + rows[1] + '"/></td></tr>' +
                                     '<tr><td>Middle Name:</td><td><input alt="" type="text" class="text" id="middleName" value="' + rows[2] + '"/></td></tr>' +
                                     '<tr><td>First Name:</td><td><input alt="" type="text" class="text" id="firstName" value="' + rows[3] + '"/></td></tr>' +
                                     '<tr><td>Email:</td><td><input alt="" type="text" class="text" id="email" value="' + rows[4] + '"/></td></tr>' +
                                     '<tr><td>Organization:</td><td><input alt="" type="text" class="text" id="organization" value="' + rows[5] + '"/></td></tr>' +
                                     '<tr><td>City:</td><td><input alt="" type="text" class="text" id="city" value="' + rows[6] + '"/></td></tr>' +
                                     '<tr><td>State:</td><td><input alt="" type="text" class="text" id="state" value="' + rows[7] + '"/></td></tr>' +
                                     '<tr><td>Country:</td><td><input alt="" type="text" class="text" id="country" value="' + rows[8] + '"/></td></tr>' +
                                     '<tr><td></td><td><div class="submit"><input alt="" id="userUpdate" type="submit" value="Submit" class="button" onclick="javascript:submitUserInfo(\'' + rows[0] + '\')"/>' +
                                     '<input alt="" id="cancelUpdate" type="submit" value="Cancel" class="button" onclick="javascript:cancelUserInfo()"/>' +
                                     '<input alt="" id="userDelete" type="submit" value="Delete" class="button" onclick="javascript:areYouSure()"/></div>' +
                                     '<div class="doubleCheck" style="display: none"><font color="red"><strong>Are you sure you want to delete this user?</strong></font> ' +
                                     '<input alt="" id="canceldelete" type="submit" value="Cancel" class="button" onclick="javascript:cancelDelete()"/>' +
                                     '<input alt="" id="delete" type="submit" value="Delete" class="button" onclick="javascript:deleteUserInfo(\'' + rows[0] + '\')"/></div>' +
                                     '</td></tr>');
      }
      else{
   		  $("div .error").html("Deleting this account has failed! " + data.EditOutput.comment);
   		  $("div .error").show();
      }
    },
    error: function(request, status, error) { 
   		$("div .error").html("internal Error: " + request + " " + status + " " + error);
   	  $("div .error").show();
    }
  });
}
