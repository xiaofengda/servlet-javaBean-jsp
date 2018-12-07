package com.ajth.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajth.domain.PageBean;
import com.ajth.service.StudentService;
import com.ajth.service.impl.StudentServiceImpl;

/**
 * 带分页
 */
public class PageStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			
			String currPage = request.getParameter("currentPage");
			if(currPage == null || "".equals(currPage.trim())) {
				currPage = "1";
			}
			int currentPage = Integer.parseInt(currPage);
			
			StudentService studentService = new StudentServiceImpl();
			@SuppressWarnings("rawtypes")
			PageBean pageBean = studentService.findStudentPage(currentPage);
			
			request.setAttribute("pageBean", pageBean);
			
			request.getRequestDispatcher("list_page.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
