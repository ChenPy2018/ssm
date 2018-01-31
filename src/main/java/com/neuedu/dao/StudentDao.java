package com.neuedu.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.neuedu.pojo.Student;

@Repository
public interface StudentDao {

	public List<Student> getStudents(Student student);
}
