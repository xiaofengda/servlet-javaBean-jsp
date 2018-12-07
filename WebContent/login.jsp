<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<script type="text/javascript">
	function check(){
		var username = document.getElementById("username").value;
		var password = document.getElementById("password").value;
		if(username == null || password == ''){
			alert("账号密码不能为空");
			return false;
		}
		return true;
		
	}

</script>
</head>
<body>
	<form action="" method="post" onsubmit="check()">
		账号：<input type="text" id="username" name="username"><br />
		密码：<input type="password" id="password" name="password"><br />
		<input type="submit" value="登录">
	</form>

</body>
</html>