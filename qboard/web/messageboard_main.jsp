<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>留言版</title>
<script language="JavaScript" type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script language="JavaScript" type="text/javascript" src="js/jquery.timer.js"></script>
<script type="text/JavaScript">

function limitChars(limit){

	var text = $('#message').val(); 
	var textlength = text.length;

	$('#count').html(textlength);

	if(textlength > limit){
		return false;
	}else{
		return true;
	}

}

function postData(){

	var name = $('#name').val();
	var email = $('#email').val();
	var website = $('#website').val();
	var message = $('#message').val();
	var captcha_code = $('#captcha_code').val();

 	var dataString = 
 		'name='+ name + 
 		'&email=' + email + 
 		'&website=' + website + 
 		'&message=' + message + 
 		'&captcha_code=' + captcha_code;  
 	
 		$("#error").html("Processing...");
 		$.ajax({  
   			type: "POST",  
   			url: "post.php",  
   			data: dataString,  
   		error: function(){
     				//alert('Error loading document');
	 			return false; 
   				},
   		success: function() {
     			//place something here
   				}
 		});
 		
	return true;
}

function loadMessages(offset){
	$("#messages").html("Loading...").hide().fadeIn("slow");
	$('#messages').load('messages.php?offset='+offset).hide().fadeIn("slow");
	return false;
}

$(document).ready(function(){

  loadMessages(0);
  $("#cap").html("<img id=captcha src=captcha/securimage_show.php alt=CAPTCHA Image />");
//$("#cap").html("<img src=CaptchaSecurityImages.php?width=100&amp;height=26&amp;characters=5>");


  $("#message").keyup(function() {
     limitChars(20);
  });
  
  $(".refresh").click(function() {
  loadMessages(0);
  //alert('refresh!');
  return false;
  });
  
  //$("form").submit(function() {
  $(".button").click(function() {
  
var sec_code = $.ajax({
  url: "get_session.php",
  async: false
 }).responseText;

  
     if($('#message').val()==''||$('#name').val()==''){
        $('#error').html("Name and Message cannot be empty").addClass('error').hide().fadeIn("slow");
        return false; 
	 };	 
	 if($('#email').val()!=''){
	   if(isValidEmail($('#email').val())==false){
	   $('#error').html("Invalid email address").addClass('error').hide().fadeIn("slow");
	   return false; 
	   };
	 };
	 if($('#website').val()!='' && $('#website').val()!='http://'){
	   if(isValidURL($('#website').val())==false){
	   $('#error').html("Invalid URL").addClass('error').hide().fadeIn("slow");
	   return false; 
	   };
	 };
	 if($('#message').val().length>300){
	 $('#error').html("Message must not exceed 300 characters.").addClass('error').hide().fadeIn("slow");
	 return false; 
	 };
	 if(sec_code!=$('#captcha_code').val()){
	 $('#error').html("Invalid security code.").addClass('error').hide().fadeIn("slow");
	 refreshCaptcha();
	 return false; 
	 }
	 if(postData()){
	 $('#error').html("Processing.....").removeClass('error').hide().fadeIn("slow");
	 $.timer(3000,function(){
	 $('#error').html("Message inserted!").addClass('success').hide().fadeIn("slow");
	 loadMessages(0);
	 refreshCaptcha();
	 //$('input[@type="text"]').val("");
	 $('#name').val("");
	 $('#email').val("");
	 $('#website').val("");
	 $('#message').val("");
	 $('#captcha_code').val("");
	 });
	 }else{
	 $('#error').html("Database Error.").fadeIn("slow");
	 return false; 
	 }
	 return false;

  });
  
});

</script>
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<div id="stylized" class="myform">
<form id="form" name="form" action="#" method="post">
<h1>請留言：</h1>
<p id="error">&nbsp;&nbsp;&nbsp;</p>
<label>會員：${user.uname}</label>
<input name="name" type="text" id="name" />
<label>訊息：《字數: <span id="count">0</span>》</label>
<textarea name="message" id="message" rows="6">
</textarea>
<button type="submit" class="button">Submit</button>
<div class="spacer"></div>
</form>
</div>

<!--<input type="button" name="button" class="refresh" id="button" value="Refresh Messages" style="margin-bottom: 10px"/>-->

<div style="float:left">
<div id="messages" class="messages">
<!-- posted messages display here -->
</div>
</div>
</body>
</html>