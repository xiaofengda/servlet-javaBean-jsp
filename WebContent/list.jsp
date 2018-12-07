<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生列表页</title>
<style type="text/css">
a{
	text-decoration: none;

}
table.imagetable {
	font-family: verdana, arial, sans-serif;
	font-size: 12px;
	color: #333333;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
	width: 800px;
	
}

table.imagetable th {
	background: #b5cfd2;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #999999;
}

table.imagetable td {
	background: #dcddc0;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #999999;
}
</style>

<script type="text/javascript">
	//deleteStudent
	function doDelete(id){
		var flag = confirm("是否确定删除");
		if(flag){
			location.href="deleteStudent?id"+id;
		}
	}
</script>
</head>
<body>
	<form action="searchStudent" method="post">
		<table class="imagetable">
			<tr>
				<th colspan="8">
					按姓名查询:<input type="text" name="name"> 
					按姓名查询:
					<select name="gender">
						<option value="">--请选择--</option>
						<option value="男">男</option>
						<option value="女">女</option>
					</select>
					<input type="submit" value="查询"> |
					<a href="add.jsp">添加</a>
					
				</th>
			</tr>
			
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>电话</th>
				<th>生日</th>
				<th>爱好</th>
				<th>简介</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${list}" var="stu">
				<tr>
					<td>${stu.id}</td>
					<td>${stu.name}</td>
					<td>${stu.gender}</td>
					<td>${stu.phone}</td>
					<td>${stu.birthday}</td>
					<td>${stu.hobby}</td>
					<td>${stu.abst}</td>
					<td><a href="editStudent?id=${stu.id}">修改</a> | <a href=""
						onclick="doDelete(${stu.id})">删除</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>

</body>
</html>