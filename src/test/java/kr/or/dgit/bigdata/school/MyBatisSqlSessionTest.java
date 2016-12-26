package kr.or.dgit.bigdata.school;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.bigdata.school.util.MybatisSqlSessionFactory;

public class MyBatisSqlSessionTest {
	private static SqlSessionFactory SqlSessionFactory;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		SqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		SqlSessionFactory = null;
	}

	@Test
	public void testSqlSession() {
		SqlSession session = SqlSessionFactory.openSession();
		assertNotNull(session);
	}

}
