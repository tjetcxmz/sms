package com.chinasofti.swstwo.biz;

import java.util.List;

import com.chinasofti.smstwo.dmain.Student;

public interface StudentBiz {

	public Student findById(int id);
	
	public String addStudent(int id, String name, double score);

	public List<Student> findAll();

	public List<Student> sort(boolean b);

	public String removeStudent(int  id);
}
