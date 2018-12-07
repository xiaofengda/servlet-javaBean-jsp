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
 * 添加
 */
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置获取页面请求的字符集编码
		request.setCharacterEncoding("UTF-8");
		
		try {
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			String phone = request.getParameter("phone");
			
			String birthday = request.getParameter("birthday");
			//多条数据可以使用数组[]接收
			String[] h = request.getParameterValues("hobby");
			
			String abst = request.getParameter("abst");
			
			//String--Date
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			String hobby = Arrays.toString(h);
			hobby = hobby.substring(1, hobby.length()-1);
			
			//把获取到的数据封装到一个对象里
			Student student = new Student(name, gender, phone, date, hobby, abst);
			
			//调service层
			StudentService studentService = new StudentServiceImpl();
			studentService.addStudent(student);
			
			//页面跳转
			request.getRequestDispatcher("studentList").forward(request, response);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
