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
 * 查询
 */
public class SearchStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置页面获取请求字符集编码
		request.setCharacterEncoding("UTF-8");
		try {
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			
			//调用service
			StudentService studentService = new StudentServiceImpl();
			List<Student> list = studentService.searchStudent(name, gender);
			
			/*for (Student student : list) {
				System.out.print(student);
			}*/
			
			request.setAttribute("list", list);
			
			//页面跳转
			request.getRequestDispatcher("list.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
