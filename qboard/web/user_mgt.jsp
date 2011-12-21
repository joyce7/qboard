<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>會員管理</title>
</head>
<body>
	
	List Members:
	<table>
	<thead>
		<tr>
			<th scope="col" field="id" dataType="String">ID</th>
			<th scope="col" field="name" dataType="String">名稱</th>								
			<th scope="col" field="remark" dataType="String">手機</th>					
		</tr>
	</thead>
	<tbody>
		<c:forEach var="user" items="${users}">
	    <tr>
			<td>${user.uid}</td>
			<td>${user.uname}</td>			
			<td>${user.mobile}</td>
		</tr>
		</c:forEach>
    </tbody>
	</table>	
	
</body>
</html>