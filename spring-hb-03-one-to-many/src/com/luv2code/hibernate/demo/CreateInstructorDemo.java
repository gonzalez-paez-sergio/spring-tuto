package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] string) {

		SessionFactory sessionFactory 
				= new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(Instructor.class)
					.addAnnotatedClass(InstructorDetail.class)
					.addAnnotatedClass(Course.class)
					.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
 
			Instructor instructor = new Instructor(
					"Hrinish", 
					"Patalay", 
					"hrinish@luv2code.com");

			// associate the objects
			InstructorDetail instructorDetail 
				= new InstructorDetail(
						"http://www.youtube.com", 
						"Talk");
			
			instructor.setInstructorDetail(instructorDetail);

			// start a transaction
			session.beginTransaction();

			// save the instructor
			session.save(instructor);

			session.getTransaction().commit();

			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 sessionFactory.close();
		}
	}

}
