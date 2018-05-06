package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

	public static void main(String[] string) {

		SessionFactory sessionFactory 
				= new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(Instructor.class)
					.addAnnotatedClass(InstructorDetail.class)
					.addAnnotatedClass(Course.class)
					.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			// save the instructor
			int id = 1;
	 		Instructor instructor = session.get(Instructor.class, id);
	 
			// associate the objects
			Course c1 = new Course("TOPOLOGY");
			instructor.add(c1);
	 		
			id = 2;
			instructor = session.get(Instructor.class, id);

			Course c2 = new Course("LINEAR ALGEBRA");
			instructor.add(c2);
		
			Course c3 = new Course("CALCULUS");
			instructor.add(c3);
	

			session.save(c1);
			session.save(c2);
			session.save(c3);
	
			session.getTransaction().commit();

			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 sessionFactory.close();
		}
	}

}
