package com.ajth.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajth.domain.Student;
import com.ajth.service.StudentService;
import com.ajth.service.impl.StudentServiceImpl;

/**
 * 修改
 */
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置获取字符集编码
		request.setCharacterEncoding("UTF-8");
		
		try {
			//获取客户端提交过来的信息
			int id = Integer.parseInt(request.getParameter("id"));	//id
			String name = request.getParameter("name");				//姓名
			String gender = request.getParameter("gender");			//性别
			String phone = request.getParameter("phone");			//电话
			String birthday = request.getParameter("birthday");		//生日
			String[] h = request.getParameterValues("hobby");		//爱好，多条数据可以使用数组接收
			String abst = request.getParameter("abst");				//简介
			
			String hobby = Arrays.toString(h);
			hobby = hobby.substring(1, hobby.length()-1);
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			
			//把获取到的信息封装到一个Student类型的student对象中
			Student student = new Student(id, name, gender, phone, date, hobby, abst);
			//调用service层
			StudentService studentService = new StudentServiceImpl();
			//调用sevice层中的update方法执行修改
			studentService.update(student);
			
			//跳转页面
			request.getRequestDispatcher("studentList").forward(request, response);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
