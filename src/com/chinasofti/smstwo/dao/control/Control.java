package com.chinasofti.smstwo.dao.control;

import java.util.List;

import com.chinasofti.smstwo.biz.impl.StudentBizImpl;
import com.chinasofti.smstwo.dao.view.View;
import com.chinasofti.smstwo.dmain.Student;
import com.chinasofti.smstwo.util.UserInput;
import com.chinasofti.swstwo.biz.StudentBiz;

public class Control {
	//属性
	private View v;
	private UserInput ui;
	//创建业务层对象
	private StudentBiz stuBiz;
	//构造方法
	public Control(){
		this.v=new View();
		this.ui=new UserInput();
		this.stuBiz=new StudentBizImpl();
	}
	//get|set
	
	//自定义方法-项目流程方法
	public void start(){
		while(true){
			this.v.welcome();
			int select=this.ui.getInt("请选择");
			if(select==0){
				this.v.println("系统终止");
				System.exit(0);
			}else if(select==1){
				String info=this.addStudent();
				this.v.println(info);
			}else if(select==2){
				this.showStudent();
			}else if(select==3){
				v.sortView();
				this.sortView();
			}else if(select==4){
				this.deleteStudent();
			}else{
				this.v.println("指令有误");
			}
		}
	}
	
	//删除学生的方法
	private void deleteStudent() {
		v.println(">>>学生信息删除");
/*		int id=this.ui.getInt("请输入想要删除学生的学号 ：");
		Student stu=this.stuBiz.findById(id);*/
		Student stu=this.stuBiz.findById(this.ui.getInt("请输入想要删除学生的学号 ："));
		if(stu==null){
			this.v.println("学生不存在");
			return;
		}
		this.v.println("学生信息如下");
		this.v.println(stu.toString());
		//询问是否删除
		if(!"y".equals(this.ui.getString("是否确认删除(y/n)"))){
			this.v.println("删除终止");
			return;
		}
		String s=this.stuBiz.removeStudent(stu.getStuId());
		this.v.println(s);
	}

	//学生排序的方法
	private void sortView() {
		//准备list集合存放数据
/*		List<Student>list;
		int select =ui.getInt("请选择");
		if(select==1){
			list=this.stuBiz.sort(true);
		}else{
			list=this.stuBiz.sort(false);
		}*/
		v.showArray(this.stuBiz.sort(ui.getInt("请选择:")==1));
	}

	//显示学生成绩的办法
	private void showStudent() {
		v.println(">>>学生成绩输出：");
/*		v.showArray(list.getStus());
		//调用biz查询所有学生的方法
		List<Student> list=this.stuBiz.findAll();
		v.showArray(list);*/
		v.showArray(this.stuBiz.findAll());
	}
	
	//添加学生的方法
	private String addStudent() {
		this.v.println(">>学生信息录入");
		this.v.println("请输入学生信息");
		int id=this.ui.getInt("请输入学生学号:");
		//调用biz查询学生的方法判断学生是否存在
		Student stu=this.stuBiz.findById(id);
		if(stu!=null){
			return "学号重复录入失败";
		}
		String name=ui.getString("请输入学生姓名");
		double score=ui.getDouble("请输入学生的成绩");
		//调用biz添加学生的方法
		/*String s=this.stuBiz.addStudent(id,name,score);
		return s;*/
		return this.stuBiz.addStudent(id,name,score);
	}
	
}
