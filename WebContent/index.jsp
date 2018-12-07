<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<script type="text/javascript">
	function toFindAll(){
		window.location = "studentList";
	}
	
	function toFindAllcheck(){
		window.location = "PageStudentServlet"
	}

</script>
</head>
<body>
	<h1>点击按钮跳转学生列表页</h1>
	<input type="button" value="普通页面" onclick="toFindAll()">
	<!-- <input type="button" value="带分页面" onclick="toFindAllcheck()"> -->

</body>
</html>