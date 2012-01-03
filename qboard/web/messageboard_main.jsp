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
 		label {
			float: left;
			text-align: right;
			margin-right: 15px;
			width: 100px;
		}
		#messageTableHead {
			font-weight: 900;
			color:navy;
		}
		body {
			/*color:MidnightBlue;
			background-color:#66839A; */ 
			margin:20px;
			padding:0px;
			font:11px verdana, arial, helvetica, sans-serif;
		}
		.pageTitle {
			margin:0px 0px 15px 0px;
			padding:0px;
			font-size:28px;
			font-weight:900;
			color:#aaa;
		}
		#formDiv{
			padding-top:12px;
			color:Indigo;
		}
 	</style>
</head>
<body>
	   <!-- Begin Wrapper -->
   <div id="wrapper">
	
	<div class="header" style="background-color:#66839A;width:600px">
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
	<div class="content" style="background-color:#66839A;width:600px">
	  <c:forEach var="msg" items="${messages}">
			<div class="sbl"><div class="sbr"><div class="stl"><div class="str">
					${msg.body}
					</div></div></div></div>
			<div class="sb">${msg.author}&nbsp;於&nbsp;${msg.created_at}
			<c:if test="${msg.author == user.memberid}">
			    &nbsp;&nbsp;<a href="MessageBoard?cmd=del&msgid=${msg.id}">[X]</a> 
			</c:if>
			</div>
	  </c:forEach>
	</div>
		<div class="footer" style="background-color:#66839A;width:600px">&nbsp;</div>
	</div>

</body>
</html>