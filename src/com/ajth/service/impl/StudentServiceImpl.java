package com.ajth.service.impl;


import java.sql.SQLException;
import java.util.List;

import com.ajth.dao.StudentDao;
import com.ajth.dao.impl.StudentDaoImpl;
import com.ajth.domain.PageBean;
import com.ajth.domain.Student;
import com.ajth.service.StudentService;


/*
 * 学生管理业务层接口实现类
 */
public class StudentServiceImpl implements StudentService {

	//查询所有
	@Override
	public List<Student> findAll() throws SQLException  {
		//调用dao层
		StudentDao studentDao = new StudentDaoImpl();
		return studentDao.findAll();
	}

	//根据id查询
	@Override
	public Student findStudentById(int id) throws SQLException{
		StudentDao studentDao = new StudentDaoImpl();
		return studentDao.findStudentById(id);
	}

	//修改
	@Override
	public void update(Student student) throws SQLException{
		StudentDao studentDao = new StudentDaoImpl();
		studentDao.update(student);
		
	}

	//删除
	@Override
	public void deleteStudent(int id) throws SQLException {
		StudentDao studentDao = new StudentDaoImpl();
		studentDao.deleteStudent(id);
		
	}

	//添加
	@Override
	public void addStudent(Student student) throws SQLException {
		StudentDao studentDao = new StudentDaoImpl();
		studentDao.addStudent(student);
		
	}

	//查询
	@Override
	public List<Student> searchStudent(String name, String gender) throws SQLException {
		StudentDao studentDao = new StudentDaoImpl();
		return studentDao.searchStudent(name, gender);
	}
	
	
	//分页
	
	@Override
	public PageBean findStudentPage(int currentPage)throws SQLException {
		
		//封装分页数据
		PageBean<Student> pageBean = new PageBean<>();
		//每页显示条数
		int pageCount = StudentDao.PAGE_SIZE;
		pageBean.setCurrentPage(currentPage); //当前页
		pageBean.setPageCount(pageCount); //每页显示条数
		
		StudentDao studentDao = new StudentDaoImpl();
		List<Student> list = studentDao.findStudentPage(currentPage);
		pageBean.setList(list);//设置这一页的数据
		
		int count = studentDao.findCount();
		pageBean.setTotalCount(count); //总记录条数
		
		Double totalPage = Math.ceil(count / pageCount);
		pageBean.setTotalPage(totalPage.intValue());//总页数totalPage
		
		return pageBean;
	}

}
