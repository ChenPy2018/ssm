package com.neuedu.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class T {

	@Resource
	private StudentService studentservice;
	@Test
	public void a(){
//		System.out.println(studentservice.getStudents());
	}
}
