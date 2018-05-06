package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteInstuctorDetailDemo {

	public static void main(String[] string) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")

				.addAnnotatedClass(Instructor.class)

				.addAnnotatedClass(InstructorDetail.class)

				.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// get the instructor detail object
			int id = 3;

			// print the instructor detail
			InstructorDetail instructorDetail
						= session.get(InstructorDetail.class, id);

			System.out.println("instructorDetail:" + instructorDetail);

			System.out.println("instructor :" + instructorDetail.getInstructor());

			// delete the instructor detail

			session.delete(instructorDetail);

			session.getTransaction().commit();

			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
