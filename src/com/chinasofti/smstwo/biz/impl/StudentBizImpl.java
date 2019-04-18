package com.chinasofti.smstwo.biz.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.chinasofti.smstwo.dao.StudentDao;
import com.chinasofti.smstwo.dao.impl.StudentDaoImpl;
import com.chinasofti.smstwo.dmain.Student;
import com.chinasofti.smstwo.util.MySort;
import com.chinasofti.swstwo.biz.StudentBiz;

public class StudentBizImpl implements StudentBiz {
	//创建Dao对象
	private StudentDao stuDao;
	
	@Override
	public Student findById(int id) {
		// TODO Auto-generated method stub
		return this.stuDao.selectById(id);	
	}

	public StudentBizImpl() {
		super();
		this.stuDao = new StudentDaoImpl();
	}

	public StudentDao getStuDao() {
		return stuDao;
	}

	public void setStuDao(StudentDao stuDao) {
		this.stuDao = stuDao;
	}

	@Override
	public String addStudent(int id, String name, double score) {
		/*boolean b=this.stuDao.intertStudent(new Student(id,name,score));
		return b?"添加成功！":"添加失败！";*/
		return this.stuDao.intertStudent(new Student(id,name,score))?"添加成功！":"添加失败！";
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return this.stuDao.selectAllStudent();
	}

	@Override
	public List<Student> sort(boolean b) {
		//查询所有学生
		List<Student> list=this.stuDao.selectAllStudent();
		//进行排序
		Collections.sort(list,new MySort(b));
		return list;
	}

	@Override
	public String removeStudent(int id) {
		/*boolean b=this.stuDao.deleteById(id);
		return b?"添加成功！":"添加失败！";*/
		return this.stuDao.deleteById(id)?"删除成功！":"删除失败！";
	}

}
