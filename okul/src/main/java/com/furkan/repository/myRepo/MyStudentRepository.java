package com.furkan.repository.myRepo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.furkan.entity.Student;
import com.furkan.util.HibernateUtils;

public class MyStudentRepository extends MyCrud<Student> {
	
	public List<Student> findAllFirst(){
		List <Student> a = new ArrayList<>();
		Session session = HibernateUtils.getSessionFactory().openSession();
		String queryy = "From Student";
		TypedQuery<Student> st = session.createQuery(queryy);
		a= st.getResultList();
		
		return a;
	}

}
