package com.ajth.dao;

import java.sql.SQLException;
import java.util.List;

import com.ajth.domain.Student;

/*
 * 学生管理dao层接口
 */
public interface StudentDao {
	
	int PAGE_SIZE = 5; //每页显示5条数据
	
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

	//查询
	public List<Student> searchStudent(String name, String gender)throws SQLException;

	
	public List<Student> findStudentPage(int currentPage)throws SQLException;

	//统计条数
	public int findCount()throws SQLException;


}
