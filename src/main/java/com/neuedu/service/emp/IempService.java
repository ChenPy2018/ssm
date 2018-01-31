package com.neuedu.service.emp;

import java.util.List;

import com.neuedu.pojo.emp;

public interface IempService {
	public List<emp> getemps(emp emp);
	public int add(emp emp);
	public int update(emp emp);
	public int del(int id);
	public emp getempById(emp emp);
}
