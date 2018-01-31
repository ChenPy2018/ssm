package com.neuedu.demo;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibAgent implements MethodInterceptor{

	//object Ŀ�����ʵ����method Ŀ�귽���ķ������ ��args Ŀ�귽���Ĳ�����methodProxy �������ʵ��
	@Override
	public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		Object result=null;
		System.out.println("����");
		methodProxy.invokeSuper(object, args);
		System.out.println("����");
		return result;
	}

	
	
}
