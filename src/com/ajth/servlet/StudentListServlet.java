package com.ajth.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajth.domain.Student;
import com.ajth.service.StudentService;
import com.ajth.service.impl.StudentServiceImpl;

/**
 * 学生列表展示
 */
public class StudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			//调用service层
			StudentService studentService = new StudentServiceImpl();
			//调用service层中的findAll()方法，返回一个Student类型的list集合
			List<Student> list = studentService.findAll();
			
			//向域对象中保存数据
			request.setAttribute("list", list);
			
			//跳转列表展示页面
			request.getRequestDispatcher("list.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
