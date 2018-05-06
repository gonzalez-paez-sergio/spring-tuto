package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class GetInstructorCoursesDemo {

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

			 int id = 1;
			 
			 Instructor instructor = session.get(Instructor.class, id);
			 
			 List<Course> list = instructor.getCourses();
	
			 System.out.println(list);
			 
			session.getTransaction().commit();

			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			 sessionFactory.close();
		}
	}

}
