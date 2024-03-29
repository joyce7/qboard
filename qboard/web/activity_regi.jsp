<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="StyleSheet"
	href="${pageContext.request.contextPath}/css/onecol.css" />
<link type="text/css" rel="StyleSheet"
	href="${pageContext.request.contextPath}/css/shadowbox.css" />
<link type="text/css" rel="StyleSheet"
	href="${pageContext.request.contextPath}/css/notabform.css" />
<title>線上報名</title>

<script>

function fillUserInfo() {
    if (document.getElementById("sameasmember").checked) {
		document.getElementById("membername").value = "${user.membername}";
    	document.getElementById("emailaddress").value = "${user.memberemail}";
    	document.getElementById("phonenum").value = "${user.cellphone}";
    	document.getElementById("address").value = "${user.memberaddr}";

		document.getElementById("membername").disabled = true;
    	document.getElementById("emailaddress").disabled = true;
    	document.getElementById("phonenum").disabled = true;
    	document.getElementById("address").disabled = true;    	
    } else {
		document.getElementById("membername").disabled = false;
    	document.getElementById("emailaddress").disabled = false;
    	document.getElementById("phonenum").disabled = false;
    	document.getElementById("address").disabled = false;    	    	
    }
};

function alertMsg(msg) {
	   if( msg != null && msg != "" )
		    alert(msg);
	}
	
function checkDateWithin() {
    
    b = Date.parse("${activity.applicationbegindate}");
    e = Date.parse("${activity.applicationenddate}");
    c = new Date();
    if( (c <= e) && (c >= b) ) { 
    } else { // not within days
    	document.getElementById("inpsubmit").disabled=true;    
    	document.getElementById("errmsg").style.visibility = 'visible'; 
    }
    
    if ( "${pcount.applicationadult}" >= "${activity.adultnum}"  && 
    	 "${pcount.applicationchildren}" >= "${activity.childrennum}") {
    	document.getElementById("inpsubmit").disabled=true;    
    	document.getElementById("errmsg2").style.visibility = 'visible';     	
    } 
	
}


</script>
</head>
<body onload="alertMsg('${msg}');checkDateWithin();">
	<div class="wrapper">
		<div class="header">
			<div id="banner">
				<div class="shiftcontainer">
					<div class="shadowcontainer">
						<div class="innerdiv">
							<b>${activity.activityname}</b> 
							<br /> 活動日期：${activity.activitydate}
							<br /> 活動地點：${activity.activityaddr}
							<br /> 報名期間：${activity.applicationbegindate}～${activity.applicationenddate}
							<br /> 活動費用：${activity.attendancefee}
							<br /> 人數限制：${activity.adultnum}(大人)&nbsp;|&nbsp;${activity.childrennum}(小孩)		
							<br /> 累計人數：${pcount.applicationadult}(大人)&nbsp;|&nbsp;${pcount.applicationchildren}(小孩)						
						</div>
					</div>
				</div>
				<br />
			</div>
		</div>
		<div class="content">
			<form name="frmcontact" id="contactform" class="cssform" 
			      method="post"  action="${pageContext.request.contextPath}/Activity"
			      onsubmit="submitform();">
				<p>
					<label for="sameasmember">同會員資訊？</label>
					<input type="checkbox" id="sameasmember" class="boxes"  onclick="fillUserInfo();"  />
				</p>
			
				<p>
					<label for="membername">姓名</label> 
					<input name="membername" type="text" id="membername" value="" />
				</p>
				<p>
					<label for="emailaddress">Email：</label> 
					<input type="text" id="emailaddress" name="emailaddress" value="" />
				</p>
				<p>
					<label for="phonenum">聯絡電話：</label> 
					<input type="text" name="phonenum" id="phonenum" value="" />（ 行動或市話）
				</p>
				<p>
					<label for="address">通訊地址：</label>
					<input type="text" name="address" id="address" value="" />
				</p>
				<p>
					<label for="adultnum">大人人數：</label> 
					<input type="text"	name="adultnum" id="adultnum" value="" />
				</p>
				<p>
					<label for="kidnum">12歲以下人數：</label> 
					<input type="text" name="kidnum" id="kidnum" value="" />
				</p>
				<div style="margin-left: 150px;">
					<input id="inpsubmit" type="submit" value="送出" />&nbsp;<a href="Activity?cmd=list"><button>取消</button></a>
				</div>
				<input name="actid" value="${activity.activityid}" type="hidden" />
				<input name="cmd" value="add_registr" type="hidden" />
			</form>

		</div>
		<div class="footer">
			<div id="errmsg" style="color: red;visibility: hidden; text-align: center;" >不在報名日期範圍。</div>
			<div id="errmsg2" style="color: red;visibility: hidden; text-align: center;" >報名額滿。</div>
		</div>
	</div>
</body>
</html>