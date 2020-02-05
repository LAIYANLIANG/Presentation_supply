<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>
	<form action="<c:url value="/sales.update.controller" />" method="post">
		supply_id:<input type="text" name="supply_id"><br />
		commodity_name:<input type="text" name="commodity_name"><br />
		commodity_originalprice:<input type="text" name="commodity_originalprice"><br /> 
		commodity_price:<input type="text" name="commodity_price"><br /> 
		Vegan:<input type="text" name="Vegan"><br /> 
		<input type="submit" name="submit" value="submit"> 
	</form>
</body>
</html>