package com.chinasofti.restman.control;

import java.lang.reflect.Proxy;

public class ProxyClient {
	public static <T> T getClient(Class<T> clazz,String ip,int port){
		//1、当前对象的类加载器  2、客户端中介  3、实际代理接口
		return (T) Proxy.newProxyInstance(ProxyClient.class.getClassLoader(), new Class[]{clazz}, new ClientHandler(ip, port));	
	}
}
