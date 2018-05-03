<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Score Info</title>
</head>
<body>
		<p>姓名：${userInfo.uname}</p>
		
        <c:forEach items="${scoreInfo}" var="items">
        	<p>科目：${items.cname} 成绩：${items.score}</p>
        </c:forEach>
</body>
</html>