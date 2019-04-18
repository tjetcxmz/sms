package com.chinasofti.smstwo.dao.view;

import java.util.List;

import com.chinasofti.smstwo.dmain.Student;

public class View {

	public void welcome() {
		System.out.println("\t简易学生成绩处理系统");
		System.out.println("--------------------");
		System.out.println("1、录入学生信息");
		System.out.println("2、查询学生信息");
		System.out.println("3、学生信息排序");
		System.out.println("4、删除学生信息");
		System.out.println("0、退出系统");
		System.out.println("--------------------");
	}

	public void println(String msg) {
		System.out.println(msg);
	}

	public void sortView() {
		System.out.println(">>>学生信息排序");
		System.out.println("学生成绩排序");
		System.out.println("--------------------");
		System.out.println("1:升序");
		System.out.println("2:降序");
		System.out.println("--------------------");
	}
	//显示数组信息的方法
	public void showArray(List<Student> list) {
		System.out.println("学号\t姓名\t成绩");
		for (Student student : list) {
			System.out.println(student);
		}
	}

}
