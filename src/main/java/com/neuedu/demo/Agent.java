package com.neuedu.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Agent implements InvocationHandler{
	private Object obj;

	public Agent(Object obj) {
		super();
		this.obj = obj;
	}


	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Ðû´«");
		Object result = method.invoke(this.obj, args);
		System.out.println("ÏúÊÛ");
		return result;
	}

	
	
}
