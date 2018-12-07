package com.ajth.service;

import java.sql.SQLException;
import java.util.List;

import com.ajth.domain.PageBean;
import com.ajth.domain.Student;

/*
 * 学生管理业务层接口
 */
public interface StudentService {
	
	//查询所有
	public List<Student> findAll()throws SQLException;

	//根据id查询
	public Student findStudentById(int id)throws SQLException;

	//修改
	public void update(Student student)throws SQLException;

	//删除
	public void deleteStudent(int id)throws SQLException;

	//添加
	public void addStudent(Student student)throws SQLException;

	public List<Student> searchStudent(String name, String gender)throws SQLException;

	public PageBean<Student> findStudentPage(int currentPage)throws SQLException;
	
}
