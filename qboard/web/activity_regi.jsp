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
</head>
<body>
	<div class="wrapper">
		<div class="header">
			<div id="banner">
				<div class="shiftcontainer">
					<div class="shadowcontainer">
						<div class="innerdiv">
							<b>${activity.activityname}</b> 
							<br /> 活動日期：${activity.activitydate}
							<br /> 活動地點：${activity.activityaddr}
							<br /> 報名期間：${activity.applicationbegindate}-${activity.applicationenddate}
							<br /> 活動費用：${activity.attendancefee}							
						</div>
					</div>
				</div>
				<br />
			</div>
		</div>
		<div class="content">
			<form id="myform" class="cssform" action="">
				<p>
					<label for="sameasmember">聯絡資訊同會員？</label>
					<input type="checkbox" id="sameasmember" class="boxes" />
				</p>
			
				<p>
					<label for="user">姓名</label> <input type="text" id="user"
						value="" />
				</p>
				<p>
					<label for="emailaddress">Email：</label> 
					<input type="text" id="emailaddress" value="" />
				</p>
				<p>
					<label for="phonenum">聯絡電話：</label> 
					<input type="text" id="phonenum" value="" />（ 行動或市話）
				</p>
				<p>
					<label for="address">通訊地址：</label>
					<textarea id="address" rows="2" cols="32">
					  aaa
					</textarea>
				</p>
				<p>
					<label for="adultnum">大人人數：</label> 
					<input type="text"	id="adultnum" value="" />
				</p>
				<p>
					<label for="kidnum">12歲以下人數：</label> 
					<input type="text" id="kidnum" value="" />
				</p>
				<div style="margin-left: 150px;">
					<input type="submit" value="送出" /> <input type="reset"
						value="取消" />
				</div>
			</form>

		</div>
		<div class="footer">footer</div>
	</div>
</body>
</html>