package com.session;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		SessionFactory sessionfactory = configuration.buildSessionFactory();
		Session session = sessionfactory.openSession();
		/*
		 * Transaction transection = session.beginTransaction();
		 * 
		 * Student student = new Student(); student.setFirstName("sh");
		 * student.setLastName("tap"); student.setCity("jal");
		 * student.setPhoneNumber("3456789"); session.save(student);
		 * transection.commit();
		 * 
		 * 
		 * System.out.println("record insert successfully");
		 */

		/*
		 * Student s1 = (Student) session.get(Student.class, 1);
		 * System.out.println("STudent id : "+s1.getId());
		 * System.out.println("Student FirstName :" + s1.getFirstName());
		 * System.out.println("Student Lastname : "+ s1.getLastName());
		 * System.out.println("Student city : " + s1.getCity());
		 * System.out.println("Student phoneNumber : "+ s1.getPhoneNumber());
		 * 
		 * Student s2 = (Student) session.get(Student.class, 2);
		 * System.out.println("STudent id : "+s2.getId());
		 * System.out.println("Student FirstName :" + s2.getFirstName());
		 * System.out.println("Student Lastname : "+ s2.getLastName());
		 * System.out.println("Student city : " + s2.getCity());
		 * System.out.println("Student phoneNumber : "+ s2.getPhoneNumber());
		 */

		System.out.println("first query>>");
		Query query = session.createQuery("from Student");
		query.setCacheable(true);
		List<Student> students = query.list();
		for (Student student : students) {
			System.out.println("id : " + student.getId());
			System.out.println("firstName : " + student.getFirstName());
			System.out.println("lastName :" + student.getLastName());
			System.out.println("city : " + student.getCity());
			System.out.println("phoneNumber :" + student.getPhoneNumber());
		}

		session.close();
		sessionfactory.close();
		System.out.println("Record retrieved successfully.");

	}

}
