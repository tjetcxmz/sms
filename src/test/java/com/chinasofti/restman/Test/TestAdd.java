package com.chinasofti.restman.Test;

import static org.junit.Assert.fail;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.chinasofti.restman.control.Control;
import com.chinasofti.restman.control.SMSservice;
import com.chinasofti.restman.dmain.Dishes;

public class TestAdd {
	private SMSservice service;
	@Test
	public void test(){
		System.out.println(this.service.insertDishes("大虫子", 7, 1));
	}
}
