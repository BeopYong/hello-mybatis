package com.kh.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.common.AbstractController;
import com.kh.student.model.service.IStudentService;
import com.kh.student.model.vo.Student;

public class StudentEnrollController extends AbstractController {

	private IStudentService studentService;
	
	public StudentEnrollController(IStudentService studentService) {
		this.studentService = studentService;
		System.out.println("[스튜던트인롤컨트롤러] studentService = " + studentService);
	}
	
	/**
	 * GET 학생등록폼 요청
	 */
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		return "student/studentEnroll"; // forwarding
	}

	/**
	 * POST 학생 DB등록 요청
	 */
	@Override
	public String doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 1. 사용자입력값처리
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		Student student = new Student(0, name, tel, null);
		System.out.println("[스튜던트인롤컨트롤러] student = " + student);
		
		
		// 2. 업무로직 요청
		int result = studentService.insertStudent(student); // service는 인터페이스 타입
		String msg = result > 0 ? "학생등록성공" : "학생등록실패";
		
		
		// 3. 사용자 피드백(redirect) 
		HttpSession session = request.getSession();
		session.setAttribute("msg", msg);
		
		return "redirect:/student/studentEnroll.do";
	}

	
}

















