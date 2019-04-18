package com.chinasoft.javaSE.work_1;

import java.util.*;

public class Menu {
	
	public static int NUM=3;
	
	Scanner sc=new Scanner(System.in);
	Action at=new Action();
	
	public void Menu(){
		System.out.println("简易学生成绩处理");
		System.out.println("-----------------------------------");
		System.out.println("1.  录入学生成绩");
		System.out.println("2.  显示学生信息");
		System.out.println("3.  学生信息排序");
		System.out.println("4.  删除学生信息");
		System.out.println("0.  退出系统");
		System.out.println("-----------------------------------");
		System.out.print("请选择：");
		
		switch(sc.nextInt()){
			case 1:{
				menu_creatStu();
				break;
			}
			case 2:{
				menu_showStu();
				break;
			}
			case 3:{
				menu_sortStu();
				break;
			}
			case 4:{
				menu_deleteStu();
				break;
			}
			case 0:{
				System.out.println("退出程序成功！");
				System.exit(0);
			}
		}
	}
	
	public void menu_creatStu(){
		System.out.println(">>>>>学生信息输入");
		System.out.println("请输入学生信息：");
		at.creatStudent();
	}
	
	public void menu_showStu(){
		System.out.println(">>>>>学生信息输出");
		System.out.println("-----------------------------------");
		System.out.println("学号\t姓名\t成绩");
		System.out.println("-----------------------------------");
		at.showStuScore();
	}
	
	public void menu_sortStu(){
		System.out.println(">>>>>学生信息排序");
		System.out.println("-----------------------------------");
		System.out.println("1.升序   2.降序");
		System.out.println("-----------------------------------");
		System.out.println("请选择：");
		at.sortStuScore();
		System.out.println("排序完成");
	}
	
	public void menu_deleteStu(){
		System.out.println(">>>>>学生信息删除");
		System.out.println("-----------------------------------");
		System.out.println("请输入想要删除学生的学号");
		System.out.println("-----------------------------------");
		at.deleteStu();
	}
}
