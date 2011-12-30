<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<sql:query var="rs" dataSource="jdbc/qbdb">
	SELECT activityid,activityname FROM activity
</sql:query>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>demo db</title>
</head>
<body>
	<h2>Results</h2>
	<c:forEach var="row" items="${rs.rows}">
    ID ${row.activityid} &nbsp;|&nbsp;
    NAME ${row.activityname}<br />
	</c:forEach>
</body>
</html>