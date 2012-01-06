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
   <div id="wrapper" style="width:480px; margin: auto;">
	
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
	<div style="position: relative; height: 300px; width: 472px;">
	  <!-- 
	  <div style="overflow: auto; height: 100%; width: 100%;" >
	   -->
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
	  <!-- 
	  </div>
	   -->
	</div>
	</div>
		<div class="footer">&nbsp;</div>
	</div>
<div id="staticbuttons" style="position:absolute;">
<a href="javascript:" onmouseover="myspeed=-thespeed" onmouseout="myspeed=0"><img
src="${pageContext.request.contextPath}/images/arrow_up.png" border="0"></a><br />
<a href="javascript:" onmouseover="myspeed=thespeed" onmouseout="myspeed=0"><img
src="${pageContext.request.contextPath}/images/arrow_dn.png" border="0"></a>
</div>

<script>

//Page Scroller (aka custom scrollbar)- By Dynamic Drive
//For full source code and more DHTML scripts, visit http://www.dynamicdrive.com
//This credit MUST stay intact for use

var Hoffset=50; //Enter buttons' offset from right edge of window (adjust depending on images width)
var Voffset=70; //Enter buttons' offset from bottom edge of window (adjust depending on images height)
var thespeed=3; //Enter scroll speed in integer (Advised: 1-3)

var ieNOTopera=document.all&&navigator.userAgent.indexOf("Opera")==-1;
var myspeed=0;

var ieHoffset_extra=document.all? 15 : 0;
var cross_obj=document.all? document.all.staticbuttons : document.getElementById? document.getElementById("staticbuttons") : document.staticbuttons;

function iecompattest(){
return (document.compatMode && document.compatMode!="BackCompat")? document.documentElement : document.body;
}

function positionit(){
var dsocleft=document.all? iecompattest().scrollLeft : pageXOffset;
var dsoctop=document.all? iecompattest().scrollTop : pageYOffset;
var window_width=ieNOTopera? iecompattest().clientWidth+ieHoffset_extra : window.innerWidth+ieHoffset_extra;
var window_height=ieNOTopera? iecompattest().clientHeight : window.innerHeight;

if (document.all||document.getElementById){
cross_obj.style.left=parseInt(dsocleft)+parseInt(window_width)-Hoffset+"px";
cross_obj.style.top=dsoctop+parseInt(window_height)-Voffset+"px";
}
else if (document.layers){
cross_obj.left=dsocleft+window_width-Hoffset;
cross_obj.top=dsoctop+window_height-Voffset;
}
}

function scrollwindow(){
window.scrollBy(0,myspeed);
}

function initializeIT(){
positionit();
if (myspeed!=0){
scrollwindow();
}
}

if (document.all||document.getElementById||document.layers)
setInterval("initializeIT()",20);

</script>
</body>
</html>