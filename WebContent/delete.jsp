<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete</title>
</head>
<body>
	<form action="<c:url value="/sales.delete.controller" />" method="post">
		supply_id:<input type="text" name="supply_id"><br />
		<input type="submit" name="submit" value="submit"> 
	</form>
</body>
</html>