package com.chinasofti.restman.control;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.chinasofti.restman.dmain.Administration;
import com.chinasofti.restman.dmain.Customer;
import com.chinasofti.restman.dmain.Discount;
import com.chinasofti.restman.dmain.Order;
import com.chinasofti.restman.dmain.Dishes;
import com.chinasofti.restman.dmain.Orderterm;
import com.chinasofti.restman.dmain.Staff;
import com.chinasofti.restman.util.DateUtil;
import com.chinasofti.restman.util.UserInput;
import com.chinasofti.restman.view.View;

public class Control {
	private View v;
	private UserInput ui;
	private static final String ip = "10.10.49.163";
	private static final int port = 9999;
	private SMSservice service;
	private boolean flag;
	private Customer cus; // 声明一个顾客
	private Staff sta; // 声明一个员工
	private Administration adm; // 声明一个经理
	private Discount dis;
	private List<Orderterm> lort;
	private Order ord;
	private List<Dishes> ldis; // 菜单
	private double money;

	public Control() {
		this.v = new View();
		this.ui = new UserInput();
		this.flag = true;
		this.lort = new ArrayList<Orderterm>();
		this.dis = new Discount();
		// 创建代理对象
		this.service = ProxyClient.getClient(SMSservice.class, ip, port);
	}

	// 自定义方法-项目流程方法
	public void start() {
		while (true) {
			this.v.welcome();
			int select = this.ui.getInt("请选择:");
			if (select == 0) {
				this.v.println("系统终止");
				System.exit(0);
			} else if (select == 1) {
				this.cuslogin();
				while (true) {
					if (flag) {
						this.v.godView();
						select = this.ui.getInt("请选择:");
						if (select == 0) {
							break;
						}
						switch (select) {
							case 1: {
								this.diancai(); // 点菜
								break;
							}
							case 2: {
								int id = this.ui.getInt("请输入您的卡号");
								if (this.service.selectCustomerByCuid(id) == null) {
									v.println("您输入的账户还未注册嗷");
									break;
								}
								this.cus = this.service.selectCustomerByCuid(id);
								this.v.showArray(this.service.returnCCROrderterm(id));
								break;
							}
							default: {
								v.println("输的不对，从输");
							}
						}
					}else{
						break;
					}
				}
			} else if (select == 2) {
				this.stalogin();
				while (true) {
					/*
					 * System.out.println(">>>我们是耶稣");
					 * System.out.println("--------------------");
					 * System.out.println("1:上帝想要这些东西"); //处理订单
					 * System.out.println("2:找上帝算账"); //结账
					 * System.out.println("3:做一个新的上帝"); //新建账户
					 * System.out.println("4:上帝丢了"); //挂失
					 * System.out.println("5:上帝也需要钱"); //充值
					 * System.out.println("6:告诉上帝他要的太贵了"); //打印发票
					 */ 
					if (flag) {
						this.v.jesusView();
						select = this.ui.getInt("请选择:");
						if (select == 0) {
							break;
						}
						switch (select) {
							case 1: {
								this.chuliOrder();
								break;
							}
							case 2: {
								this.jiezhang();
								break;
							}
							case 3: {
								String cuname = this.ui.getString("请输入客户的姓名:");
								String memtype = this.ui.getString("请输入客户的会员类型");
								this.cus = this.service.insertCustomer(cuname, memtype);
								v.println("客户信息是" + cus.toString()); // 返回值应显示客户的信息包括余额，客户号
								break;
							}
							case 4: {
								this.guahsi();
								break;
							}
							case 5: {
								this.chongzhi();
								break;
							}
							case 6: {
								this.printFaPiao();								//打印发票的方法

								this.lort =new ArrayList<Orderterm>();			// 清空购物车
								this.ord = new Order(); 						// 清空购物车
								
								this.service.PrintOrder(); 						// 清空数据库购物车表
								break;
							}
							default: {
								v.println("输的不对，从输");
							}
						}
					}else{
						break;
					}
				}
			} else if (select == 3) {
				this.admlogin();
				while (true) {
					/*
					 * System.out.println("1:我能操作耶稣"); //员工管理
					 * System.out.println("2:上帝丢了在我这里能补"); //补卡
					 * System.out.println("3:我还能把上帝变没了"); //冻结账户
					 * System.out.println("4:上帝看到什么也归我管"); //菜品管理
					 * System.out.println("5:我还会让上帝少花钱"); //设置会员优惠额度
					 * System.out.println("6:我得算算上帝每月喜欢啥");
					 */
					if (flag) {
						this.v.admView();
						select = this.ui.getInt("请选择:");
						if (select == 0) {
							break;
						}
						switch (select) {
						case 1: {
							this.updateStaff(); // 员工管理的方法
							break;
						}
						case 2: {
							this.buka();
							break;
						}
						case 3: {
							this.dongjie();
							break;
						}
						case 4: {
							this.updateDishes();
							break;
						}
						case 5: {
							this.updateEdu();
							break;
						}
						case 6: {
							this.showLikeDishes();
							break;
						}
						default: {
							v.println("输的不对，从输");
						}
						}
					}else{
						break;
					}
				}
			} else {
				this.v.println("指令有误");
			}
		}
	}

	// 验证顾客登录的方法
	private void cuslogin() {
		this.flag = true;
		int id = this.ui.getInt("请输入您的账号");
		this.cus = this.service.cuslogin(id);
		if (cus == null) {
			v.println("您还莫得注册过嗷,快去找咱家的员工注册享受美食吧    或者是你被咱家冻结了咧"); // 如果顾客没有注册过，提醒顾客去找员工注册并登录
			System.out.println();
			this.flag = false;
			return;
		}
		this.v.println("欢迎	(*^▽^*) " + this.service.selectCustomerByCuid(id).getCuname() + "  (*^▽^*)光临本店");
	}

	// 验证员工登录的方法
	private void stalogin() {
		this.flag = true;
		int id = this.ui.getInt("请输入你的工号");
		String pass = this.ui.getString("请输入你的密码");
		this.sta = this.service.stalogin(id, pass);
		if (sta == null) {
			v.println("帖子你输入的账号或者密码不对嗷");
			this.flag = false;
			return;
		}
		this.v.println("(*^▽^*) 欢迎" + this.service.selectStaffById(id).getStName() + "登录系统   (*^▽^*) ");
	}

	// 验证管理员登录的方法
	private void admlogin() {
		this.flag = true;
		int id = this.ui.getInt("要是经理的话你的号码是多少啊");
		String pass = this.ui.getString("请输入你的密码");
		this.adm = this.service.admlogin(id, pass);
		if (adm == null) {
			v.println("你是谁！你不是经理");
			this.flag = false;
			return;
		}
		this.v.println("欢迎经理先生");
	}

	// 添加点菜的方法
	private void diancai() {
		this.ldis = this.service.selectDishes(); // 实例化菜单集合
		this.showDishes(ldis); // 显示菜单
		int select = 1;
		int num = 0;
		int Dimonsv=0;
		this.flag = false;

		while (true) { // 实例化订单信息
			select = this.ui.getInt("请选择 :  (按0退出)");

			if (select == 0) { // 按0退出
				break;
			}

			for (Dishes dis : ldis) {
				if (dis.getDiid() == select) {
					this.flag = true;
				}
			}
			if (this.flag == false) {
				this.v.println("您输入的菜品号不对嗷,请重新输入");
				return;
			}
			num = this.ui.getInt("请选择数量");
			for (Dishes dis : ldis) {
				if (dis.getDiid() == select) {
					dis.setDimonsv(dis.getDimonsv() + num); 							// 更新月销量
					Dimonsv=dis.getDimonsv();
					this.lort.add(new Orderterm(select, num, dis.getDiprice()));
				}
			}
			if ("y".equals(this.ui.getString("是否需要修改订单捏 (y/n)"))) {
				this.v.showArray(this.lort);
				int id = 0;
				while (true) {
					id = this.ui.getInt("请输入你想删除的菜");
					Iterator<Orderterm> it = lort.iterator(); 					// 利用迭代器查找有没有要删除的
					while (it.hasNext()) {
						if (it.next().getDiid() == id) {
							it.remove();
							this.flag = true;
						}
					}
					if (this.flag == false) {
						this.v.println("您都没点怎么删啊");
						return;
					} else {
						break;
					}
				}
				for (Dishes dis : ldis) {
					if (dis.getDiid() == select) {
						dis.setDimonsv(dis.getDimonsv() - num); // 更新月销量
						Dimonsv=dis.getDimonsv();
						// this.service.deleteOrderByDiid(id);
					}
				}
				//this.ldis.get(select).setDimonsv(dis.getDimonsv() - num); // 更新月销量
				this.service.deleteOrderByDiid(id);
			}
			this.service.updateDishes(select,Dimonsv);
		}
		this.service.insertOrder(new Order(DateUtil.getCurrentDate(),this.cus.getCuid())); 		// 将订单小计保存至服务器
		this.service.insertOrderterm(lort); // 订单集合保存至服务器
	}

	// 处理订单的方法
	private void chuliOrder() {
		this.lort=this.service.returnOrderterm();
		this.v.println("客户的订单信息如下	"); // 显示客户订单
		System.out.println("╭──────────────────────────────────────╮");
		if (this.lort.size() == 0) {
			v.println("还没有客户点菜呢");
			return;
		}
		this.v.showArray(this.lort);
		System.out.println("╰──────────────────────────────────────╯");
		v.println("可以交给后厨了，铁子");
	}

	// 结账的方法
	private void jiezhang() {
		double sum = 0;
		int memtype = 0;
		double xj = 0;
		this.money=0;
		this.cus = null;
		this.cus = this.service.selectCustomerByCuid(this.ui.getInt("请输入客户id:"));
		this.lort = this.service.returnOrderterm(); 					// 将数据库中的内容更新至集合中
		this.ldis = this.service.selectDishes();
		if (lort.size()== 0) {
			System.out.println();
			v.println("单子都没有呢结啥账");
			System.out.println();
			return;
		}
		if (this.cus == null) {
			v.println("输错了吧，这个账户还没注册嗷");
			return;
		}
		for (Orderterm orderterm : lort) {
			double price = (orderterm.getPrice()) * (orderterm.getDinum());
			for (Dishes dishes : ldis) {
				if (dishes.getIscheap() == 1 && dishes.getDiid() == orderterm.getDiid()) {
					price *= 0.5; // 如果是特价菜的话所有价格减半
				}
			}
			sum += price; // 用sum存储订单里所有菜品的总价
		}
		if (this.cus.getMemtype().equals("普通会员")) {
			this.v.println("您是普通会员，将享受"+this.dis.getCommonEdu()+"折服务");
			memtype = 1;
		} else if (this.cus.getMemtype().equals("超级会员")) {
			this.v.println("您是普通会员，将享受"+this.dis.getSuperEdu()+"折服务");
			memtype = 2;
		}
		this.money = sum * this.dis.show(memtype);
		v.println("您需要付款的金额为:" + this.money);
		this.v.jieZhangView(); 											// 结账方式界面
		int i = this.ui.getInt("请选择:");
		if (i == 2) {
			while (this.cus.getCubal() < this.money) {
				v.println("你卡里钱不够了捏");
				int select = this.ui.getInt("请选择: 1/充值   2/现金");
				if (select == 2) {
					xj = this.ui.getDouble("请输入收款额:");
					if (this.money < xj) {
						v.println("找零为" + (xj - this.money));
					}
					return;
				} else if (select == 1) {
					chongzhi_injiezhang();
				}
			}
			this.service.settleAccounts(this.cus.getCuid(), this.cus.getCubal() - this.money);
		} else {
			xj = this.ui.getDouble("请输入收款额:");
			if (this.money < xj) {
				v.println("找零为" + (xj - this.money));
			}
		}
		this.v.println("结账成功!!!");
		this.ord = this.service.returnOrder();							//更新订单记录
		this.service.updateCustomerConsumptionRecords(this.lort, this.ord.getOrdate(), this.ord.getCuid(), this.money);// 更新客户类型表
		this.service.updateOrderStId(this.sta.getStId());				//更新订单属性员工号
	}

	// 挂失的方法
	private void guahsi() {
		this.cus = null;
		int id = this.ui.getInt("请输入想要的挂失的账号:");
		if (this.service.selectCustomerByCuid(id) == null) { 			// 查询想要挂失的账号存不存在
			this.v.println("该账户不存在嗷");
			return;
		}
		this.service.deleteCustomerByCuid(id);
		this.v.println("挂失成功!");
	}

	// 在结账方法中充值的方法
	private void chongzhi_injiezhang() {
		double d = this.ui.getDouble("请输入上帝要充值的数目:");
		int id = this.cus.getCuid(); // 定义变量存储当前顾客的id
		if (d > 3000) {
			try {
				this.service.updateMemtype(id, "超级会员");
				this.service.topUp(id, this.cus.getCubal() + d);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("修改成功");
			}
			this.v.println("尊敬的超级会员，您好");
		} else if (d > 1000 && !this.cus.getMemtype().equals("超级会员")) {
			try {
				this.service.updateMemtype(id, "普通会员");
				this.service.topUp(id, this.cus.getCubal() + d);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("修改成功");
			}
			this.v.println("可爱的普通会员，您好");
		}
	}

	// 在员工操作界面充值的方法
	private void chongzhi() {
		this.cus = null;
		int id = this.ui.getInt("请输入上帝的id:");
		this.cus = this.service.selectCustomerByCuid(id);
		if (this.cus == null) {
			this.v.println("这个上帝没有在咱家嗷,重新输入吧");
			return;
		}
		double money = this.ui.getDouble("请输入要充值的金额:");
		if (money > 3000) {
			try {
				this.service.updateMemtype(id, "超级会员");
				this.service.topUp(id, this.cus.getCubal() + money);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("修改成功");
			}
			this.v.println("尊敬的超级会员，您好");
		} else if (money > 1000 && !this.cus.getMemtype().equals("超级会员")) {
			try {
				this.service.updateMemtype(id, "普通会员");
				this.service.topUp(id, this.cus.getCubal() + money);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("修改成功");
			}
			this.v.println("可爱的普通会员，您好");
		}
	}

	// 打印发票的方法
	private void printFaPiao() {
		this.lort = this.service.returnOrderterm();
		this.service.insertOrdStIf(this.sta.getStId());
		if(this.lort==null){
			System.out.println("这里面是空的哎");
			return;
		}
		System.out.println(this.service.returnOrder());
		for (Orderterm ord : lort) {
			System.out.println(ord);
		}
	}

	// 修改员工的界面及方法
	private void updateStaff() {
		/*
		 * System.out.println("1:我要查询所有的小弟"); //查询员工
		 * System.out.println("2:我要新建一个小弟"); //创建员工
		 * System.out.println("3:我要修改一个小弟"); //修改员工
		 * System.out.println("4:我要做掉一个小弟"); //删除员工
		 * systeam.out.println("0:退出");
		 */
		while (true) {
			this.v.updateStaffView();
			int select = this.ui.getInt("请选择:");
			if (select == 0) {
				break;
			}
			switch (select) {
			case 1: {
				this.v.showArray(this.service.selectStaff());
				break;
			}
			case 2: {
				String stname = this.ui.getString("请输入员工的姓名:");
				String stpass = this.ui.getString("请输入员工的密码:");
				this.service.insertStaff(stname, stpass);
				break;
			}
			case 3: {
				int stid = this.ui.getInt("请输入想要修改的员工号:");
				this.sta = this.service.selectStaffById(stid);
				if (sta == null) {
					this.v.println("你输入的员工号不存在嗷");
				}
				String stname = this.ui.getString("请输入修改后的员工的姓名:");
				String stpass = this.ui.getString("请输入修改后的员工的密码:");
				this.service.updateStaffById(stid, stname, stpass);
				break;
			}
			case 4: {
				int stid = this.ui.getInt("请输入想要删除的员工号:");
				this.sta = this.service.selectStaffById(stid);
				if (sta == null) {
					this.v.println("你输入的员工号不存在嗷");
				}
				this.service.deleteStaffById(stid);
				this.v.println("删除成功");
				break;
			}
			default: {
				v.println("您输的不对嗷");
				break;
			}
			}
		}
	}

	// 补卡的方法
	private void buka() {
		int id = this.ui.getInt("请输入想要补卡的卡id:");
		this.cus = this.service.selectAllCusByCuid(id);
		if (this.cus == null) {
			this.v.println("该卡不存在嗷");
			return;
		}
		if (this.cus.getFrozen() == 0) {
			this.cus.setFrozen(1);
			this.service.thaw(id);
		} else {
			this.v.println("该卡信息如下，请根据一下信息办卡");
			System.out.println(this.cus);
		}
	}

	// 冻结的方法
	private void dongjie() {
		int id = this.ui.getInt("请输入想要冻结的客户id:");
		this.cus = this.service.selectCustomerByCuid(id);
		if (this.cus == null && this.cus.getFrozen() == 0) { // 用户不存在或者已经被冻结时不执行冻结操作
			this.v.println("该卡不存在嗷或者该卡已经被冻结了嗷");
			return;
		}
		this.cus.setFrozen(0);
		this.service.deleteCustomerByCuid(id); // 冻结操作
	}

	// 菜品管理的方法
	private void updateDishes() {
		while (true) {
			/*
			 * System.out.println("1:这个菜挺好吃的，加进来吧"); //加入菜品
			 * System.out.println("2:这个菜不好吃，我要删了它"); //删除菜品
			 * System.out.println("3:这个菜不合适，改改吧"); //修改菜品
			 * System.out.println("4:我看看我都有啥菜"); //查询菜品
			 * System.out.println("5:今日特价菜"); //设置每日菜品
			 */
			this.v.dishesView();
			int select = this.ui.getInt("请选择:");
			if (select == 0) {
				this.v.println("退出成功!");
				break;
			}
			switch (select) {
			case 1: {
				String diname = this.ui.getString("请输入菜品名称:");
				double diprice = this.ui.getDouble("请输入菜品价格:");
				int dtid = this.ui.getInt("请输入菜品类型:");
				try {
					this.service.insertDishes(diname, diprice, dtid);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("添加成功!");
				}
				break;
			}
			case 2: {
				this.flag = false;
				this.ldis = this.service.selectDishes();
				this.showDishes(ldis);
				int id = this.ui.getInt("请输入想要删除的菜品id:");
				Iterator<Dishes> it = this.ldis.iterator();
				while (it.hasNext()) { // 更新菜单集合并且判断删除的菜品是否存在
					if (it.next().getDiid() == id) {
						it.remove();
						this.flag = true;
					}
				}
				if (this.flag == false) {
					System.out.println("你想删除的不存在哎");
					return;
				}
				this.service.deleteDishesById(id); // 删除
				break;
			}
			case 3: {
				this.flag = false;
				this.ldis = this.service.selectDishes(); // 更新菜单
				this.showDishes(ldis);
				int id = this.ui.getInt("请输入想要修改的菜品id:");
				Iterator<Dishes> it = this.ldis.iterator();
				while (it.hasNext()) { // 更新菜单集合并且判断删除的菜品是否存在
					if (it.next().getDiid() == id) {
						String name = this.ui.getString("请输入你想要修改的菜品的新名称:");
						double price = this.ui.getDouble("请输入你想要修改的菜品的新价格:");
						int dtid = this.ui.getInt("请输入你想要修改的菜品类型号:");
						this.service.updateDishes(id, name, price, dtid);
						this.flag = true;
						// 每次更新菜品
					}
				}
				if (this.flag == false) {
					System.out.println("你想删除的不存在哎");
					return;
				}
				break;
			}
			case 4: {
				this.ldis = this.service.selectDishes();
				this.showDishes(ldis);
				break;
			}
			case 5: {
				this.ldis = this.service.selectDishes();
				this.showDishes(ldis);
				int id = this.ui.getInt("请输入想要设置的特价菜id:");
				Iterator<Dishes> it = this.ldis.iterator();
				while (it.hasNext()) {
					if (it.next().getDiid() == id) {
						int x = this.ui.getInt("请输入您是想要还原还是设置	(0还原/1设置)");
						this.service.setIscheap(id, x);
						this.flag = true;
						System.out.println("设置成功");
					}
				}
				if (this.flag == false) {
					System.out.println("菜品id输错了嗷");
					return;
				}
				break;
			}
			default: {
				v.println("没输对呀");
				break;
			}
			}
		}
	}

	// 设置会员优惠额度的方法
	private void updateEdu() {
		double x = this.ui.getDouble("请输入普通会员的额度:");
		double y = this.ui.getDouble("请输入超级会员的额度:");
		this.dis.setCommonEdu(x);
		this.dis.setSuperEdu(y);
		System.out.println("	修改成功!");
	}

	// 展示菜单的方法
	public void showDishes(List<Dishes> list) {
		if (list == null) {
			System.out.println("菜单里啥都没有呢看啥啊");
			return;
		}
		System.out.println(">>>	  本店的口号是:  香甜可口，童叟无欺  。		(๑°艸°๑)/你怀了我的猴子？		");
		System.out.println();
		System.out.println();
		System.out.println("菜品号是:\t菜品名是:\t菜品价格是\t菜品类型是:\t月销量是:\t");
		for (Dishes dis : list) {
			
			System.out.println("---------------------->");
			System.out.println(dis.getDiid()+"\t"+ dis.getDiname()+"\t¥:" + dis.getDiprice()+"\t"
					+ this.service.selectDtnameByDtid(dis.getDtid())+"\t"+ dis.getDimonsv());
			if (dis.getIscheap() == 1) {
				System.out.println("  ヽ(￣▽￣)ﾉ       这个今天是特价菜嗷");
			}
		}
	}
	//展示最喜欢菜的方法
	private void showLikeDishes() {
		this.ldis=this.service.selectDishes();
		double money=0;
		for (int i = 1; i < ldis.size(); i++) {
			if(ldis.get(i).getDimonsv()>ldis.get(i-1).getDimonsv()){
				money=ldis.get(i).getDimonsv();
			}
		}
		for (Dishes dishes : ldis) {
			if(dishes.getDimonsv()==money){
				System.out.println(dishes);
			}
		}
	}
}
