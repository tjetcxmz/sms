package com.chinasofti.smstwo.util;

import java.util.*;

public class UserInput {

	//接受用户输入的内容String
	public String getString(String msg) {
		System.out.println(msg);
		Scanner sc=new Scanner(System.in);
		return sc.next();
	}

	//接受整数
	public int getInt(String msg) {
		while(true){
			try {
				System.out.println(msg);
				Scanner sc=new Scanner(System.in);
				return sc.nextInt();
			} catch (Exception e) {
				System.out.println("输入内容格式不正确，请输入整数格式！");
			}
		}
	}
	//接受浮点数
	public double getDouble(String msg) {
		while(true){
			try {
				System.out.println(msg);
				Scanner sc=new Scanner(System.in);
				return sc.nextDouble();
			} catch (Exception e) {
				System.out.println("输入内容格式不正确，请输入小数格式！");
			}
		}
	}

}
