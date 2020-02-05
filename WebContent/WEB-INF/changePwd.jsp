<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>

<form action="<c:url value="/changePwdAction_controller" />" method="post">
帳號：<span>${supply_acc}</span>
</div>


<div>
請輸入原密碼：<input type="password" name="changePwd_org" > ${msg }
</div>


<div>
更新密碼：<input type="password" name="changePwd" > ${msg }
</div>

<div>
在次輸入更新密碼：<input type="password" name="changePwd_doublecheck" > ${msg }
</div>

<input type="submit" value="確認修改密碼">
</form>

</body>
</html>