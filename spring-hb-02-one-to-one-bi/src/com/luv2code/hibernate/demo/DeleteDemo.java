package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] string) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			int id = 552;
			Instructor instructor = session.get(Instructor.class, id);
			System.out.println("the instructor:" + instructor);

			if (instructor != null) {
				session.delete(instructor);
			}

			session.getTransaction().commit();

//			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//session.close();
//			sessionFactory.close();
		}
	}

}
