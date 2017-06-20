package com.navig;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import com.navig.Students;
import common.HiberFactorySessionUtil;
public class FirstHibernate {
	  @Test
	public void SaveStudents(){
		try{Session session = HiberFactorySessionUtil.OpenSession();
		Students s = new Students();
		s.setName("xiangege");
		s.setAge(19);
		s.setGrade("研究生大神");
		s.setPhone("18633857262");
		System.out.println(s.getGrade());
		System.out.println(s.getAge());
		System.out.println("aa");
		Transaction tx = session.beginTransaction();
		session.save(s);
		tx.commit();}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	 
	
}
