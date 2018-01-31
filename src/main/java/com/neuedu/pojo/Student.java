package com.neuedu.pojo;

import lombok.Data;

@Data
public class Student extends PageBean{

	private Integer sno;
	private String sname;
	private Integer sage;
	private String ssex;
	private String dept;
	
	
}
