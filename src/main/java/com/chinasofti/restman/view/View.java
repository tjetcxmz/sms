package com.chinasofti.restman.view;

import java.util.List;

public class View {

	public void welcome() {
		System.out.println("\t餐厅管理系统");
		System.out.println("--------------------");
		System.out.println("1、我是上帝");
		System.out.println("2、我是耶稣");
		System.out.println("0、退出系统");
		System.out.println("--------------------");
	}

	public void println(String msg) {
		System.out.println(msg);
	}
	
	public void godView() {
		System.out.println(">>>上帝能做什么");
		System.out.println("--------------------");
		System.out.println("1:点餐");
		System.out.println("2:查询消费记录");
		System.out.println("--------------------");
	}
	
	public void jesusView(){
		System.out.println(">>>我们是耶稣");
		System.out.println("--------------------");
		System.out.println("1:上帝想要这些东西");				//处理订单
		System.out.println("2:找上帝算账");					//结账
		System.out.println("3:做一个新的上帝");				//新建账户
		System.out.println("4:上帝丢了");					//挂失
		System.out.println("5:上帝也需要钱");				//充值
		System.out.println("6:告诉上帝他要的太贵了");			//打印发票
		System.out.println("--------------------");
	}
	public void admView(){
		System.out.println(">>>耶稣和上帝都归我管");
		System.out.println("--------------------");
		System.out.println("1:我能操作耶稣");				//员工管理
		System.out.println("2:上帝丢了在我这里能补");			//补卡
		System.out.println("3:我还能把上帝变没了");			//冻结账户
		System.out.println("4:上帝看到什么也归我管");			//菜品管理
		System.out.println("5:我还会让上帝少花钱");			//设置会员优惠额度
		System.out.println("6:我得算算上帝每月喜欢啥");		//统计月销量，客户最喜欢的菜品是啥
		System.out.println("--------------------");
	}
	//结账界面
	public void jieZhangView(){
		System.out.println(">>>这谁顶得住啊");
		System.out.println("--------------------");
		System.out.println("1:他想用现金结账");				//用现金结账
		System.out.println("2:他想刷卡");					//刷卡结账
		System.out.println("--------------------");
	}
	//员工管理界面
	public void updateStaffView(){
		System.out.println(">>>请开始你的表演");
		System.out.println("--------------------");
		System.out.println("1:我要查询所有的小弟");			//查询员工
		System.out.println("2:我要新建一个小弟");				//创建员工
		System.out.println("3:我要修改一个小弟");				//修改员工
		System.out.println("4:我要做掉一个小弟");				//删除员工
		System.out.println("--------------------");
	}
	//菜品管理界面
	public void dishesView(){
		System.out.println(">>>吃啥呀");
		System.out.println("--------------------");
		System.out.println("1:这个菜挺好吃的，加进来吧");		//加入菜品
		System.out.println("2:这个菜不好吃，我要删了它");		//删除菜品
		System.out.println("3:这个菜不合适，改改吧");			//修改菜品
		System.out.println("4:我看看我都有啥菜");				//查询菜品
		System.out.println("5:今日特价菜");					//设置每日菜品
		System.out.println("--------------------");
	}
	//显示数组信息的方法
	public void showArray(List list) {
		System.out.println("学号\t姓名\t成绩");
		for (Object object : list) {
			System.out.println();
		}
	}
}
