<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<c:url value="/member/supply.update.controller" />" method="post">
		supply_id(int):<input type="text" name="supply_id"><br />
		supply_acc(nvarchar(50)):<input type="text" name="supply_acc"><br />
		supply_pwd(nvarchar(50)):<input type="text" name="supply_pwd"><br /> 
		supply_name(nvarchar(50)):<input type="text" name="supply_name"><br /> 
		supply_ph(nvarchar(10)):<input type="text" name="supply_ph"><br /> 
		supply_conumber(nvarchar(8)):<input type="text" name="supply_conumber"><br /> 
		supply_address(nvarchar(50)):<input type="text" name="supply_address"><br /> 
		supply_bankaccount(nvarchar(50)):<input type="text" name="supply_bankaccount"><br /> 
		supply_contactphnum(nvarchar(10)):<input type="text" name="supply_contactphnum"><br /> 
		supply_contact(nvarchar(50)):<input type="text" name="supply_contact"><br /> 
		supply_email(nvarchar(50)):<input type="text" name="supply_email"><br /> 
		supply_invoice(nvarchar(50)):<input type="text" name="supply_invoice"><br /> 
		supply_vip(nvarchar(10)):<input type="text" name="supply_vip"><br /> 
		supply_limit(int):<input type="text" name="supply_limit"><br /> 
		<input type="submit" name="submit" value="submit"> 
	</form>

</body>
</html>