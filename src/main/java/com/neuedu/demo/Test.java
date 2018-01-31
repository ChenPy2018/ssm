package com.neuedu.demo;

import java.lang.reflect.Proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
//		IFactory factory = new Factory();
//		Agent agent = new Agent(factory);
//		IFactory proxyfactory = (IFactory)Proxy.newProxyInstance(factory.getClass().getClassLoader(), factory.getClass().getInterfaces(), agent);
//		proxyfactory.ProductA();
		
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//		IFactory factory = (IFactory) applicationContext.getBean("proxyFactory");
//		factory.ProductA();
		
		Factory factory = new Factory();
		CglibAgent cilib = new CglibAgent();
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(factory.getClass());
		enhancer.setCallback(cilib);
		Factory proxy = (Factory) enhancer.create();
		proxy.ProductB();
	}
}
