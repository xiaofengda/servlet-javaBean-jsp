package com.ajth.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.ajth.dao.StudentDao;
import com.ajth.domain.Student;
import com.ajth.utils.JDBCUtil02;
import com.ajth.utils.TextUtils;

/*
 * 学生管理dao层接口实现类
 */
public class StudentDaoImpl implements StudentDao {

	//查询所有
	@Override
	public List<Student> findAll() throws SQLException {
		
		
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		
		
		return runner.query("select * from student", new BeanListHandler<Student>(Student.class));
	}

	//根据id查询
	@Override
	public Student findStudentById(int id) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		return runner.query("select * from student where id = ?", new BeanHandler<Student>(Student.class), id);
	}

	//修改
	@Override
	public void update(Student student) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		runner.update("update student set name=?, gender=?, phone=?, birthday=?, hobby=?, abst=? where id=?",
				student.getName(),
				student.getGender(),
				student.getPhone(),
				student.getBirthday(),
				student.getHobby(),
				student.getAbst(),
				student.getId());
	}

	//删除
	@Override
	public void deleteStudent(int id) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		runner.update("delete from student where id=?",id);
		
	}

	@Override
	public void addStudent(Student student) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		runner.update("insert into student values (null, ?, ?, ?, ?, ?, ?)",
				student.getName(),
				student.getGender(),
				student.getPhone(),
				student.getBirthday(),
				student.getHobby(),
				student.getAbst()
		);
		
	}

	@Override
	public List<Student> searchStudent(String name, String gender) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		
		//String sql = select * from student where name=? or gender=?
		/*
		 * 分析如果只有姓名
		 * select * from student where name like ? ;
		 * 分析如果只有性别
		 * select * from student where gender = ? ;
		 * 如果姓名性别都有
		 * select * from student where name like ? and gender = ?;
		 * 如果两个都没有查询所有
		 */
		String sql = "select * from student where 1=1";
		List<String> list = new ArrayList<String>();
		//判断有没有姓名，如果有就拼接到sql语句里
		if(!TextUtils.isEmpty(name)) {
			sql = sql + " and name like ?";
			list.add("%"+name+"%");
		}
		//判断有没有性别，如果有拼接到sql语句里
		if(!TextUtils.isEmpty(gender)) {
			sql = sql + " and gender = ?";
			list.add(gender);
		}
		return runner.query(sql, new BeanListHandler<Student>(Student.class), list.toArray());
		
	}

	@Override
	public List<Student> findStudentPage(int currentPage) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		
		return runner.query("select * from student limit ? offset ?", 
				new BeanListHandler<Student>(Student.class) , PAGE_SIZE , (currentPage-1)*PAGE_SIZE);
	}

	//总记录条数
	@Override
	public int findCount() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		Long result = (Long) runner.query("select count(*) from student", new ScalarHandler());
		return result.intValue();
	}



}
