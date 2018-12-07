package com.ajth.servlet;

import java.io.IOException;
import java.sql.SQLException;

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
public class EditStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			//接收地址栏传递过来要修改的参数
			int id = Integer.parseInt(request.getParameter("id"));
			
			//调用service层
			StudentService studentService = new StudentServiceImpl();
			//调用service层中的findStudentById()方法，根据id查询出学生的信息
			Student student = studentService.findStudentById(id);
			
			//回显数据
			//向域对象保存数据
			request.setAttribute("student", student);
			
			//页面跳转
			request.getRequestDispatcher("edit.jsp").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
