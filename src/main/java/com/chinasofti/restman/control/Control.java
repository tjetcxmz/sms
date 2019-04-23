package com.chinasofti.restman.control;

import java.util.List;

import com.chinasofti.restman.dmain.Administration;
import com.chinasofti.restman.dmain.Customer;
import com.chinasofti.restman.dmain.Discount;
import com.chinasofti.restman.dmain.Orderterm;
import com.chinasofti.restman.dmain.Staff;
import com.chinasofti.restman.util.UserInput;
import com.chinasofti.restman.view.View;

public class Control {
	private View v;
	private UserInput ui;
	private static final String ip = "10.10.49.163";
	private static final int port = 9999;
	private SMSservice service;
	private boolean flag;
	private Customer cus;	//声明一个顾客
	private Staff sta;		//声明一个员工
	private Administration adm;	//声明一个经理
	private Discount dis;	
	List<Orderterm> lort;	
	
	public Control() {
		this.v = new View();
		this.ui = new UserInput();
		this.flag=true;
		this.lort=null;
		this.dis=new Discount();
		//创建代理对象 
		service = ProxyClient.getClient(SMSservice.class, ip, port);
	}
	// 自定义方法-项目流程方法
	public void start() {
		while (true) {
			this.v.welcome();
			int select = this.ui.getInt("请选择");
			if (select == 0) {
				this.v.println("系统终止");
				System.exit(0);
			} else if (select == 1) {
				while(true){
					this.cuslogin();
					if(flag){
						this.v.godView();
						select = this.ui.getInt("请选择");
						switch(select){ 
							case 1:{
								this.diancai();			//点菜
								break;
							}
							case 2:{
								int id=this.ui.getInt("请输入您的卡号");
								if(this.service.selectCustomerByCuid(id)==null){
									v.println("您输入的账户还未注册嗷");
									break;
								}
								v.println(this.service.selectCusRecordBycuid(id));
								break;
							}
							default: {
								v.println("输的不对，从输");
							}
						}
					}
				}
			} else if (select == 2) {
				while(true){
					/*System.out.println(">>>我们是耶稣");
					System.out.println("--------------------");
					System.out.println("1:上帝想要这些东西");				//处理订单
					System.out.println("2:找上帝算账");					//结账
					System.out.println("3:做一个新的上帝");				//新建账户
					System.out.println("4:上帝丢了");					//挂失
					System.out.println("5:上帝也需要钱");				//充值
					System.out.println("6:告诉上帝他要的太贵了");			//打印发票
*/					this.stalogin();
					if(flag){
						this.v.jesusView();
						select = this.ui.getInt("请选择");
						switch(select){
							case 1:{
								this.chuliOrder();
								break;
							} 
							case 2:{
								this.jiezhang();
								break;
							} 
							case 3:{
								String cuname=this.ui.getString("请输入客户的姓名:");
								String memtype=this.ui.getString("请输入客户的会员类型");
								this.cus=this.service.insertCustomer(cuname,memtype);
								v.println("客户信息是"+cus.toString());          		//返回值应显示客户的信息包括余额，客户号
								break;
							} 
							case 4:{
								this.guahsi();
								break;
							} 
							case 5:{
								this.chongzhi();
								break;
							} 
							case 6:{
								break;
							}
							default:{
								v.println("输的不对，从输");
							}
						}
						break;
					}
				}
			} else if(select ==3){
				while(true){
					this.admlogin();
					if(flag){
						this.v.admView();
						select = this.ui.getInt("请选择");
						switch(select){
						
						}
						break;
					}
				}
			} else {
				this.v.println("指令有误");
			}
		}
	}
	//验证顾客登录的方法
	private void cuslogin(){
		this.flag=true;
		int id=this.ui.getInt("请输入您的账号");
		this.cus = this.service.cuslogin(id);
		if(cus==null){
			v.println("您还莫得注册过嗷,快去找咱家的员工注册享受美食吧");		//如果顾客没有注册过，提醒顾客去找员工注册并登录
			this.flag=false;
		}
	}
	//验证员工登录的方法
	private void stalogin(){
		this.flag=true;
		int id=this.ui.getInt("请输入你的工号");
		String pass=this.ui.getString("请输入你的密码");
		this.sta = this.service.stalogin(id, pass);
		if(sta==null){
			v.println("帖子你输入的账号或者密码不对嗷");
			this.flag=false;
		}
	}
	//验证管理员登录的方法
	private void admlogin(){
		this.flag=true;
		int id=this.ui.getInt("要是经理的话你的号码是多少啊");
		String pass=this.ui.getString("请输入你的密码");
		this.adm=this.service.admlogin(id, pass);
		if(pass==null){
			v.println("你是谁！你不是经理");
			this.flag=false;
		}
	}
	//添加点菜的方法
	private void diancai(){
		this.v.showArray(this.service.selectDishes());
		lort = this.service.insertOrder();
		this.v.showArray(lort);
		while(true){
			if("y".equals(this.ui.getString("是否需要修改订单捏 (y/n),选n后就会提交"))){
				int id=0;
				while(true){
					id=this.ui.getInt("请输入你想删除的菜");
					for (Orderterm ord : lort) {				//查找订单集合看有没有想要删除的菜
						if(ord.getDiid()==id){
							id=0;
						}
					}
					if(id==0){
						this.v.println("您都没点怎么删啊");
					}else{
						break;
					}
				}	
				this.service.deleteOrderByDiid(id);
			}
		}
	}
	//处理订单的方法
	private void chuliOrder(){
		this.v.println("客户的订单信息如下");										//显示客户订单
		if(lort==null){
			v.println("还没有客户点菜呢");
			return;
		}
		this.v.showArray(lort);												
		v.println("可以交给后厨了，铁子");
	}
	//结账的方法 
	private void jiezhang(){
		double sum=0;
		int memtype=0;
		double money=0;
		double xj=0;
		this.cus=null;
		this.cus=this.service.selectCustomerByCuid(this.ui.getInt("请输入客户id"));
		if(lort==null){
			v.println("单子都没有呢结啥账");
			return;
		}
		if(this.cus==null){
			v.println("输错了吧，这个账户还没注册嗷");
			return;
		}
		for (Orderterm orderterm : lort) {
			sum+=(orderterm.getPrice())*(orderterm.getDinum());
		}
		if(this.cus.getMemtype().equals("普通会员")){
			memtype=1;
		}else if(this.cus.getMemtype().equals("超级会员")){
			memtype=2;
		}
		money=sum*this.dis.show(memtype);
		v.println("您需要付款的金额为:"+money);
		this.v.jieZhangView();								//结账方式界面
		int i=this.ui.getInt("请选择");
		if(i==2){
			while(this.cus.getCubal()<money){
				v.println("你卡里钱不够了捏");
				int select=this.ui.getInt("请选择: 1/充值   2/现金");
				if(select==2){
					xj=this.ui.getDouble("请输入收款额");
					if(money<xj){
						v.println("找零为"+(xj-money));
					}
					return;
				}else if(select==1){
					chongzhi_injiezhang();
				}
			}
			this.service.settleAccounts(this.cus.getCuid(), this.cus.getCubal()-money);
		}else{
			xj=this.ui.getDouble("请输入收款额");
			if(money<xj){
				v.println("找零为"+(xj-money));
			}
		}
		this.v.println("结账成功!!!");
	}
	//挂失的方法
	private void guahsi(){
		this.cus=null;
		int id=this.ui.getInt("请输入想要的挂失的账号");
		if(this.service.selectCustomerByCuid(id)==null){		//查询想要挂失的账号存不存在
			this.v.println("该账户不存在嗷");
			return;
		}
		this.service.deleteCustomerByCuid(id);
		this.v.println("挂失成功!");
	}
	//在结账方法中充值的方法
	private void chongzhi_injiezhang(){
		double d=this.ui.getDouble("请输入上帝要充值的数目");
		int id=this.cus.getCuid();								//定义变量存储当前顾客的id
		if(d>3000){
			this.service.updateMemtype(id, "超级会员");
		}else if(d>1000&&!this.cus.getMemtype().equals("超级会员")){
			this.service.updateMemtype(id, "普通会员");
		}
		this.service.topUp(id, this.cus.getCubal()+d);
	}
	//在员工操作界面充值的方法
	private void chongzhi(){
		this.cus=null;
		int id=this.ui.getInt("请输入上帝的id");
		this.cus=this.service.selectCustomerByCuid(id);
		if(this.cus==null){
			this.v.println("这个上帝没有在咱家嗷,重新输入吧");
			return;
		}
		double money=this.ui.getDouble("请输入要充值的金额");
		if(money>3000){
			this.service.updateMemtype(id, "超级会员");
		}else if(money>1000&&!this.cus.getMemtype().equals("超级会员")){
			this.service.updateMemtype(id, "普通会员");
		}
		this.service.topUp(id, this.cus.getCubal()+money);
	}
	//打印发票的方法
	private void printFaPiao(){
		
	}
}
