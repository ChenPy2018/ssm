package com.neuedu.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neuedu.dao.StudentDao;
import com.neuedu.pojo.Student;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Resource
	private StudentDao studentdao;
	@Override
	public List<Student> getStudents(Student student) {
		return studentdao.getStudents(student);
	}

}
