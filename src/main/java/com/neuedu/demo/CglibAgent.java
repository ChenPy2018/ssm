package com.neuedu.demo;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibAgent implements MethodInterceptor{

	//object 目标类的实例，method 目标方法的反射对象 ，args 目标方法的参数，methodProxy 代理类的实例
	@Override
	public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		Object result=null;
		System.out.println("宣传");
		methodProxy.invokeSuper(object, args);
		System.out.println("销售");
		return result;
	}

	
	
}
