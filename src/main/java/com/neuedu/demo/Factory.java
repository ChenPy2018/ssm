package com.neuedu.demo;

public class Factory implements IFactory{

	public void ProductA(){
		System.out.println("生产A");
	}
	public void ProductB(){
		System.out.println("生产B");
	}
	public void ProductC(){
		System.out.println("生产C");
	}
}
