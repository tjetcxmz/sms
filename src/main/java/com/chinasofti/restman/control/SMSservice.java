package com.chinasofti.restman.control;

import java.sql.Date;
import java.util.List;

import com.chinasofti.restman.dmain.Administration;
import com.chinasofti.restman.dmain.Customer;
import com.chinasofti.restman.dmain.CustomerConsumptionRecords;
import com.chinasofti.restman.dmain.Dishes;
import com.chinasofti.restman.dmain.Order;
import com.chinasofti.restman.dmain.Orderterm;
import com.chinasofti.restman.dmain.Staff;

public interface SMSservice {
	//customer
	//查询会员信息（查询）
	public List<Customer> selectCustomer();
	//添加会员信息（开卡）
	public Customer insertCustomer(String cuname,String memtype);
	//查询消费记录
	public CustomerConsumptionRecords selectCusRecordBycuid(int id);
	//按照客户号查询会员信息  不包括冻结
	public Customer selectCustomerByCuid(int id);
	//按照客户号查询会员信息   包括冻结的
	public Customer selectAllCusByCuid(int id);
	//删除会员信息（冻结）
	public String deleteCustomerByCuid(int id);
	//更新会员属性
	public String updateCustomer(Customer cus);	//待议
	//解除冻结状态
	public String thaw(int id);			//传递过去之后把对应的id客户冻结状态修改为1								
	//staff
	//点餐/加餐（购物车添加）
	public boolean insertOrderterm(List<Orderterm> list);								
	//返回订单内容
	public List<Orderterm> returnOrderterm();											
	//返回订单小计
	public Order returnOrder();												
	//添加订单小计
	public String insertOrder(Order ord);
	//更新订单表的员工属性
	public boolean updateOrderStId(int stid);
	//修改购物车（购物车根据菜品号删除）
	public boolean deleteOrderByDiid(int id);
	//打印小票,小票打印完后 Order变清空									
	public boolean PrintOrder();									
	//充值的方法
	public boolean topUp(int cuid,double money);
	//修改会员类型的方法
	public String updateMemtype(int cuid,String memtype);
	//结账功能
	public String settleAccounts(int cuid,double money);
	//将订餐详细信息保存到客户消费记录表中的方法
	public String updateCustomerConsumptionRecords(List<Orderterm> lort,Date date,int cuid,double totalprice);
	//返回客户消费记录表中的信息中的list部分
	public List<CustomerConsumptionRecords> returnCCROrderterm(int cuid);
	//更新订单表根据员工号
	public String insertOrdStIf(int stid);
	//administration
	//员工查询（全体查询）
	public List<Staff> selectStaff();
	//员工添加
	public Staff insertStaff(String stname,String stpass);
	//员工删除
	public String deleteStaffById(int stid);
	//员工修改
	public boolean updateStaffById(int stid,String stname,String stpass);					//加
	//经理信息修改												
	public String updateAdministration(String name,String password);
	//根据员工号查询
	public Staff selectStaffById(int stid);													//改
	//根据菜品id查询菜品
	public Dishes selectDishesById(int id);
	//菜品查询
	public List<Dishes> selectDishes();
	//菜品添加
	public String insertDishes(String diname,double diprice,int dtid); 
	//菜品删除
	public String deleteDishesById(int diid);
	//菜品修改
	public boolean updateDishes(int diid,String name,double price,int dtid);
	//更新菜品月销量的方法
	public boolean updateDishes(int diid,int dimonsv);
	//根据菜品id返回菜品名称
	public String selectDtnameByDtid(int id);
	//设置特价菜的方法
	public String setIscheap(int id,int ischeap);
	
	//客户登录cuslogin
	public Customer cuslogin(int code);
	//员工登录stalogin
	public Staff stalogin(int id,String password);
	//经理登录
	public Administration admlogin(int id,String password);
}
