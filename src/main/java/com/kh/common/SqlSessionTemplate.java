package com.kh.common;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {

	/**
	 * SqlSessionFactoryBuilder(mybatis-config.xml) - SqlSessionFactory - SqlSession
	 * 
	 * @return
	 */
	public static SqlSession getSqlSession() {
		SqlSession session = null;
		String configLocation = "/mybatis-config.xml";
		
		try {
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			SqlSessionFactory factory = builder.build(Resources.getResourceAsStream(configLocation));
			session = factory.openSession(false); // 기본값은 true. autoCommit 안함. transaction은 직접 관리.
		} catch (IOException e) {
			e.printStackTrace();
		}
		return session;
	}
}
















