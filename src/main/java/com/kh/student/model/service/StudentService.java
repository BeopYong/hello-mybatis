package com.kh.student.model.service;

import static com.kh.common.SqlSessionTemplate.*;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.student.model.dao.IStudentDao;
import com.kh.student.model.vo.Student;

public class StudentService implements IStudentService {

	private IStudentDao studentDao;

	public StudentService(IStudentDao studentDao) {
		super();
		this.studentDao = studentDao;
	}

	@Override
	public int insertStudent(Student student) {
		int result = 0;
//		Connection conn = null; // mybatis를 통해 jdbc관리. SqlSession으로 대체
		SqlSession session = getSqlSession();
		try {
//			conn = getConnection();
			result = studentDao.insertStudent(session, student);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public int insertStudent(Map<String, Object> studentMap) {
		int result = 0;
		SqlSession session = null;
		
		try {
			session = getSqlSession();
			result = studentDao.insertStudent(session, studentMap);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public int selectStudentTotalCount() {
		SqlSession session = getSqlSession();
		int totalCount = studentDao.selectStudentTotalCount(session);
		session.close();
		return totalCount;
	}

	@Override
	public Student selectOneStudent(int no) {
		SqlSession session = getSqlSession();
		Student student = studentDao.selectOneStudent(session, no);
		session.close();
		return student;
	}

	@Override
	public int updateStudent(Student student) {
		SqlSession session = null;
		int result = 0;
		try {
			session = getSqlSession();
			result = studentDao.updateStudent(session, student);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public int deleteStudent(int no) {
		SqlSession session = null;
		int result = 0;
		try {
			session = getSqlSession();
			result = studentDao.deleteStudent(session, no);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public Map<String, Object> selectOneStudentMap(int no) {
		SqlSession session = getSqlSession();
		Map<String, Object> studentMap = studentDao.selectOneStudentMap(session, no);
		session.close();
		return studentMap;
	}

	@Override
	public List<Student> selectListStudent() {
		SqlSession session = getSqlSession();
		List<Student> list = studentDao.selectListStudent(session);
		session.close();
		return list;
	}

	@Override
	public List<Map<String, Object>> selectStudentMapList() {
		SqlSession session = getSqlSession();
		List<Map<String, Object>> mapList = studentDao.selectStudentMapList(session);
		session.close();
		return mapList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}









