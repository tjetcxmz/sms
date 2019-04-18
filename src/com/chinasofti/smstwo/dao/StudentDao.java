package com.chinasofti.smstwo.dao;

import java.util.List;

import com.chinasofti.smstwo.dmain.Student;

public interface StudentDao {
	//创建一个添加学生的办法
	public boolean intertStudent(Student stu);
	//创建一个查询所有学生的办法
	public List<Student> selectAllStudent();
	//创建一个查询学生的办法通过id查询
	public Student selectById(int id);
	//创建一个删除学生的办法
	public boolean deleteById(int id);
}
