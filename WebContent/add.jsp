<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加学生页面</title>
<!-- 日期插件 -->
<script type="text/javascript" src="${pageContext.request.contextPath }/jquery/jquery-1.4.2.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/jquery/jquery.datepick.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath }/jquery/jquery.datepick.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/jquery/jquery.datepick-zh-CN.js"></script>
<script type="text/javascript">
	$(function(){
		$('#birthday').datepick({dateFormat: 'yy-mm-dd'});
	});

</script>
</head>


<body>

<h3>更新学生页面</h3>

<form method="post" action="addStudent">
	<input type="hidden" name="id">
  <table border="1" width="600">
  <tr>
	<td>姓名</td>
	<td><input type="text" name="name" id="name"></td>
  </tr>
  <tr>
	<td>性别</td>
	<td>
		<input type="radio" name="gender"  value="男">男
		<input type="radio" name="gender" value="女">女
	</td>
  </tr>
  <tr>
	<td>电话</td>
	<td><input type="text" name="phone" id="phone"></td>
  </tr>
  <tr>
	<td>生日</td>
	<td><input type="text" name="birthday" id="birthday"></td>
  </tr>
  <tr>
	<td>爱好</td>
	<td>
		<input type="checkbox" name="hobby" value="游泳">游泳
		<input type="checkbox" name="hobby" value="篮球">篮球
		<input type="checkbox" name="hobby" value="足球">足球
		<input type="checkbox" name="hobby" value="看书">看书
		<input type="checkbox" name="hobby" value="写字">写字
	
	</td>
  </tr>
  <tr>
	<td>简介</td>
	<td><textarea name="abst" id="abst" rows="3" cols="20"></textarea></td>
  </tr>
  <tr>
	<td colspan="2"> <input type="submit" value="添加"> </td>
  </tr>
  </table>
   </form>
</body>
</html>