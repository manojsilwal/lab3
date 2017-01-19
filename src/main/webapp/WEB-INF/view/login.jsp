<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="login" method="post">
			UserName : <input type="text" name="name"
			value="${cookie.username.value}" />
			PassWord : <input type="password" name="pass">
			Remember Me <input type="checkbox" name="remember" 
			<c:if test="${cookie.containsKey('username')}">checked</c:if> />
			<input type="submit" value="submit" />
		</form>
		<p>${error}</p>
	</div>
</body>
</html>