package com.ajth.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajth.service.StudentService;
import com.ajth.service.impl.StudentServiceImpl;

/**
 * 删除
 */
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		try {
			//接收地址栏传递过来要修改的参数
			int id = Integer.parseInt(request.getParameter("id"));
			//调用service层
			StudentService studentService = new StudentServiceImpl();
			studentService.deleteStudent(id);
			
			//跳转页面
			//request.getRequestDispatcher("studentList").forward(request, response);
			response.sendRedirect("studentList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
