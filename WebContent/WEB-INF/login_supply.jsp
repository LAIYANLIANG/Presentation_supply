<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員登入</title>
</head>
<body>
	<form action="<c:url value="/login_supply_controller" />" method="post">
		<table>
		<br />
		${msgError.supply_allerror}<br />
		${msg }<br />
		<br />
			供應商帳號：
			<input type="text" name="supply_acc">${msgError.supply_acc}<br />
			<hr>
			供應商密碼：
			<input type="text" name="supply_pwd">${msgError.supply_pwd}<br />
			<hr>
			<!-- 
消費者<input type="radio" name="aaaa" value="customer"><br />
廠商<input type="radio" name="aaaa" value="supply">
<hr>
 -->
 <hr>
			<input type="submit" name="submit" value="submit">
<hr>
			<input type="button" value="供應商註冊新帳號"
				onclick="location.href='<c:url value="/registered" />';">
		</table>
	</form>
</body>
</html>