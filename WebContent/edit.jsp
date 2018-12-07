<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改学生页面</title>
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

<form method="post" action="updateStudent">
	<input type="hidden" name="id" value="${student.id }">
  <table border="1" width="600">
  <tr>
	<td>姓名</td>
	<td><input type="text" name="name" value="${student.name }"></td>
  </tr>
  <tr>
	<td>性别</td>
	<td>
		<!-- 如果性别是男的，  可以在男的性别 input标签里面， 出现checked ,
		如果性别是女的，  可以在女的性别 input标签里面，出现checked
		<input type="radio" name="gender" value="男" <c:if test="${stu.gender == '男'}">checked</c:if>>男
		 -->
		<input type="radio" name="gender" value="男" <c:if test='${student.gender == "男"}'>checked</c:if>>男
		<input type="radio" name="gender" value="女" <c:if test='${student.gender == "女"}'>checked</c:if>>女
	</td>
  </tr>
  <tr>
	<td>电话</td>
	<td><input type="text" name="phone" value="${student.phone }"></td>
  </tr>
  <tr>
	<td>生日</td>
	<td><input type="text" name="birthday" id="birthday" value="${student.birthday }"></td>
  </tr>
  <tr>
	<td>爱好</td>
	<td>
		<!-- 爱好： 篮球 ， 足球 ， 看书 
		因为爱好有很多个，  里面存在包含的关系 -->
		<input type="checkbox" name="hobby" value="游泳" <c:if test="${fn:contains(student.hobby,'游泳') }">checked</c:if>>游泳
		<input type="checkbox" name="hobby" value="篮球" <c:if test="${fn:contains(student.hobby,'篮球') }">checked</c:if>>篮球
		<input type="checkbox" name="hobby" value="足球" <c:if test="${fn:contains(student.hobby,'足球') }">checked</c:if>>足球
		<input type="checkbox" name="hobby" value="看书" <c:if test="${fn:contains(student.hobby,'看书') }">checked</c:if>>看书
		<input type="checkbox" name="hobby" value="写字" <c:if test="${fn:contains(student.hobby,'写字') }">checked</c:if>>写字
	
	</td>
  </tr>
  <tr>
	<td>简介</td>
	<td><textarea name="abst" rows="3" cols="20">${student.abst}</textarea></td>
  </tr>
  <tr>
	<td colspan="2"> <input type="submit" value="更新"> </td>
  </tr>
  </table>
   </form>
</body>
</html>