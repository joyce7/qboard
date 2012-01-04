<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="StyleSheet" href="${pageContext.request.contextPath}/css/bubble.css" />
<link type="text/css" rel="StyleSheet" href="${pageContext.request.contextPath}/css/onecol.css" />
<title>留言版</title>
<style type="text/css">
		#formDiv{
			padding-top:12px;
			color:Indigo;
		}
 	</style>
</head>
<body>
	   <!-- Begin Wrapper -->
   <div id="wrapper" style="width:600px; margin: auto;">
	
	<div class="header">
	<div id="formDiv">
		<form method="post" id="messageForm" action="${pageContext.request.contextPath}/MessageBoard" >	
			<div> 我要發言：</div>
			<div align="left">
			<textarea name="body" cols="40" rows="3" id="body">
			</textarea>
			</div>
			<!-- 
			<input type="button" id="msgBtn" value="送出" onClick="sendMsg()"/>
			 -->
			 <div align="left">--&nbsp;by ${user.membername}&nbsp;&nbsp;
			     <input type="submit" id="msgBtn" value="送出" />
			 </div>
			 <input type="hidden"  name="cmd" value="add" />
			 <input type="hidden"  name="author" value="${user.memberid}" />&nbsp;
		</form>
	</div>
	</div>
	<div class="content" style="background-color: white;" >
	  <c:forEach var="msg" items="${messages}">
			<div class="sbl2"><div class="sbr2"><div class="stl2"><div class="str2">
					${msg.body}
					</div></div></div></div>
			<div class="sb2"><img class="character" src="images/330.gif" alt="" />
			&nbsp;&nbsp;${msg.author}&nbsp;於&nbsp;${msg.created_at}
			<c:if test="${msg.author == user.memberid}">
			    &nbsp;&nbsp;<a href="MessageBoard?cmd=del&msgid=${msg.id}" style="text-decoration:none" >
			    <img border="0" src="images/trash.gif" alt="刪除這則留言" 
			    onmouseover="this.src='images/trash_r.gif'" 
			    onmouseout="this.src='images/trash.gif'"></a> 
			</c:if>
			</div>
	  </c:forEach>
	</div>
		<div class="footer">&nbsp;</div>
	</div>

</body>
</html>