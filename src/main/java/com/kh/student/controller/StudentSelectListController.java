package com.kh.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.AbstractController;
import com.kh.student.model.service.IStudentService;

public class StudentSelectListController extends AbstractController {

	private IStudentService studentService;
	
	public StudentSelectListController(IStudentService studentService) {
		super();
		this.studentService = studentService;
		System.out.println("[스튜던트셀렉트리스트컨트롤러] studentService = " + studentService);
	}
	

	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		return "student/selectList";
	}

	
}
