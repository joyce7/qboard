<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="JavaScript">

function alertMsg(msg) {
   if( msg != null && msg != "" && msg != "NOT_LOGIN")
	    alert(msg);
}

</script>

<link type="text/css" rel="StyleSheet" href="${pageContext.request.contextPath}/css/login.css" />
<title>請登入</title>
</head>
<body onload="alertMsg('${msg}');">
	<form method="post" action="${pageContext.request.contextPath}/UserSession">
		<fieldset>
		<legend>請登入系統</legend>
		<label for="userid">帳號</label> <input type="text" id="userid" name="userid" /><br>
		<label for="passwd">密碼</label> <input type="password" id="password" name="password" /><br>
		<input type="submit"  class="submitbtn" value="登入" />
		</fieldset>
		<input type="hidden" class="cmd" name="cmd" value="login"/>
	</form>
</body>
</html>