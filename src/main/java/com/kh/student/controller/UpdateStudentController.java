package com.kh.student.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.common.AbstractController;
import com.kh.student.model.service.IStudentService;
import com.kh.student.model.vo.Student;

public class UpdateStudentController extends AbstractController {

	private IStudentService studentService;

	public UpdateStudentController(IStudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@Override
	public String doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int no = Integer.valueOf(request.getParameter("no"));
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		Student student = new Student(no, name, tel, null);
		System.out.println("[업데이트스튜던트] student = " + student);
		
		int result = studentService.updateStudent(student);
		
		response.setContentType("application/json; charset=utf-8");
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "회원정보수정성공");
		new Gson().toJson(map, response.getWriter());
		
		return null;
	}
	
	
}











