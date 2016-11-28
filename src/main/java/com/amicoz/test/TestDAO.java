package com.amicoz.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author iamkarandikar
 *
 */
@Repository
public class TestDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Transactional
	public void showData() {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from TestEntity");
		List<TestEntity> list = query.list();
		for(TestEntity test : list) {
			System.out.println("["+test.getId1() + ", " + test.getId2() + "]");
		}
		
	}
	
	
}
