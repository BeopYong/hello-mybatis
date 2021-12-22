package com.kh.student.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.student.model.vo.Student;

public class StudentDao implements IStudentDao {

	@Override
	public int insertStudent(SqlSession session, Student student) {
		// namespace.tagId
		return session.insert("student.insertStudent", student); // 변경된 행의 수 리턴 받음.
	}

	@Override
	public int insertStudent(SqlSession session, Map<String, Object> studentMap) {
		
		return session.insert("student.insertStudentMap", studentMap);
	}

	@Override
	public int selectStudentTotalCount(SqlSession session) {
		
		return session.selectOne("student.selectStudentTotalCount");
	}

	@Override
	public Student selectOneStudent(SqlSession session, int no) {
		
		return session.selectOne("student.selectOneStudent", no);
	}

	@Override
	public int updateStudent(SqlSession session, Student student) {
		
		return session.update("student.updateStudent", student);
	}

	@Override
	public int deleteStudent(SqlSession session, int no) {
		
		return session.delete("student.deleteStudent", no);
	}

	@Override
	public Map<String, Object> selectOneStudentMap(SqlSession session, int no) {
		
		return session.selectOne("student.selectOneStudentMap", no);
	}

	@Override
	public List<Student> selectListStudent(SqlSession session) {
		
		return session.selectList("student.selectListStudent");
	}

	@Override
	public List<Map<String, Object>> selectStudentMapList(SqlSession session) {
		
		return session.selectList("student.selectStudentMapList");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
