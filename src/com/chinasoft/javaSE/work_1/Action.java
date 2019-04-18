package com.chinasoft.javaSE.work_1;

import com.chinasoft.javaSE.work_1.Studnet;

import java.io.PrintWriter;
import java.util.*;

public class Action {
	
	Scanner sc=new Scanner(System.in);
	private static  int stuNum=0;
	Studnet[] S=new Studnet[Menu.NUM];
	
	public Action() {
		
	}
	
	public void creatStudent(){
		
		S[stuNum]=new Studnet();
		System.out.print("学号：");			
		S[stuNum].setId(sc.nextInt());
		System.out.print("姓名：");
		S[stuNum].setName(sc.next());
		System.out.print("成绩");
		S[stuNum].setScore(sc.nextDouble());
		
		stuNum++;
		
		if(stuNum==Menu.NUM){
			System.out.println("学生信息已达上限");
			return;
		}
		System.out.println("是否继续录入y（是）/n或其他键（否）");
		if("y".equals(sc.next())){
			creatStudent();
		}																
	}
	
	public void showStuScore(){
		for (int i=0;i<stuNum;i++) {
			System.out.println(S[i].getId()+"\t"+S[i].getName()+"\t"+S[i].getScore());
		}
	}
	
	public void sortStuScore(){
		if(sc.hasNextInt()){
			if(sc.nextInt()==1){
				Studnet T;
				for (int i = 0; i < stuNum; i++) {
					for (int j = 0; j <stuNum-i-1; j++) {
						if(S[j].getScore()>S[j+1].getScore()){
							T=S[j];
							S[j]=S[j+1];
							S[j+1]=T;
						}
					}
				}
				showStuScore();
			}
			else{
				Studnet T;
				for (int i = 0; i < stuNum; i++) {
					for (int j = 0; j < stuNum-i-1; j++) {
						if(S[j].getScore()<S[j+1].getScore()){
							T=S[j];
							S[j]=S[j+1];
							S[j-1]=T;
						}
					}
				}
				showStuScore();
			}
		}
		else{
			sortStuScore();
		}
	}
	
	public void deleteStu(){
		
		int x=sc.nextInt();
		boolean flag=false;
		
		for (int i = 0; i <stuNum; i++) {
			if(S[i].getId()==x){
				flag=true;
				for (int j = i+1; j<stuNum; j++) {
					S[j-1]=S[j];
				}
				S[stuNum-1]=null;
				stuNum--;
				System.out.println("删除完成");
			}
		}
		if(flag==false){
			System.out.println("没有此学号的学生");
		}
	}
}
