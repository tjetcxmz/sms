package com.chinasofti.restman.control;

import java.util.List;

import com.chinasofti.restman.dmain.Administration;
import com.chinasofti.restman.dmain.Customer;
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
	public String selectCusRecordBycuid(int id);
	//按照客户号查询会员信息（补卡）
	public Customer selectCustomerByCuid(int id);
	//删除会员信息（冻结）
	public String deleteCustomerByCuid(int id);
	//staff
	//点餐/加餐（购物车添加）
	public List<Orderterm> insertOrder();
	//修改购物车（购物车根据菜品号删除）
	public String deleteOrderByDiid(int id);
	//打印小票
	public Order PrintOrder();
	//充值的方法
	public boolean topUp(int cuid,double money);
	//修改会员类型的方法
	public String updateMemtype(int cuid,String memtype);
	//结账功能
	public String settleAccounts(int cuid,double money);
	//administration
	//员工查询（全体查询）
	public List<Staff> selectStaff();
	//员工添加
	public Staff insertStaff(String stname,String stpass);
	//员工删除
	public String deleteStaffById(int stid);
	//经理信息修改
	public String updateAdministration(String name,String password);
	//根据员工号查询
	public Customer selectStaffById(int stid);
	//根据菜品id查询菜品
	public Dishes selectDishesById(int id);
	//菜品查询
	public List<Dishes> selectDishes();
	//菜品添加
	public String insertDishes(String diname,int diprice,int dtid); 
	//菜品删除
	public String deleteDishesById(int diid);
	//修改会员优惠额度
	public String updateQuota(double memberDis,double superDis);
	
	//客户登录cuslogin
	public Customer cuslogin(int code);
	//员工登录stalogin
	public Staff stalogin(int id,String password);
	//经理登录
	public Administration admlogin(int id,String password);
}
