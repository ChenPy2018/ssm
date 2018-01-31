package com.neuedu.controller;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.neuedu.pojo.Student;
import com.neuedu.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Resource
	private StudentService studentservice;
	@RequestMapping("/list.do")
	public String getlist(Student student,ModelMap modelmap){
		if(StringUtils.isBlank(student.getSname())){
			student.setSname(null);
		}
//		student.setWithPage(0);
//		System.out.println(student.getSname());
		modelmap.addAttribute("student", studentservice.getStudents(student));
		modelmap.addAttribute("name", student.getSname());
//		System.out.println(studentservice.getStudents());
		return "student/index";
	}
}
