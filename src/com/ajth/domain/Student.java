package com.ajth.domain;

import java.util.Date;

/*
 *
 * CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生编号',
  `name` varchar(255) NOT NULL COMMENT '学生姓名',
  `gender` varchar(255) DEFAULT NULL COMMENT '学生性别',
  `phone` varchar(255) DEFAULT NULL COMMENT '学生电话',
  `birthday` date DEFAULT NULL COMMENT '学生生日',
  `hobby` varchar(255) DEFAULT NULL COMMENT '学生爱好',
  `abstract` varchar(255) COMMENT '学生简介',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
 */
public class Student {
	private Integer id;
	private String name;
	private String gender;
	private String phone;
	private Date birthday;
	private String hobby;
	private String abst;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getAbst() {
		return abst;
	}
	public void setAbst(String abst) {
		this.abst = abst;
	}
	public Student(Integer id, String name, String gender, String phone, Date birthday, String hobby, String abst) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.birthday = birthday;
		this.hobby = hobby;
		this.abst = abst;
	}
	
	
	public Student(String name, String gender, String phone, Date birthday, String hobby, String abst) {
		super();
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.birthday = birthday;
		this.hobby = hobby;
		this.abst = abst;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gender=" + gender + ", phone=" + phone + ", birthday="
				+ birthday + ", hobby=" + hobby + ", abst=" + abst + "]";
	}
	
	
	
	

}
