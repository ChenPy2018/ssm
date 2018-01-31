package com.neuedu.newdemo;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class Throw implements ThrowsAdvice{

	public void afterThrowing(Method method, Object[] args, Object target, Exception ex){
		System.out.println("�쳣֪ͨ");
		System.out.println(ex.getMessage());
	}
}
