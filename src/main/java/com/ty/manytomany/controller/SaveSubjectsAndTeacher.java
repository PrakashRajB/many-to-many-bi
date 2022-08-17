package com.ty.manytomany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.manytomany.dto.Subject;
import com.ty.manytomany.dto.Teacher;

public class SaveSubjectsAndTeacher {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Subject subject = entityManager.find(Subject.class, 2);
//		subject.setName("C++");
//		subject.setDays(100);

		List<Teacher> teachers = new ArrayList<Teacher>();

		Teacher teacher1 = entityManager.find(Teacher.class, 1);
//		teacher1.setName("Navin");
//		teacher1.setAge(32);
		teachers.add(teacher1);

//		Teacher teacher2 = new Teacher();
		Teacher teacher2 = entityManager.find(Teacher.class, 2);
//		teacher2.setName("Mouri");
//		teacher2.setAge(25);
		teachers.add(teacher2);

//		Teacher teacher3 = new Teacher();
		Teacher teacher3 = entityManager.find(Teacher.class, 3);
//		teacher3.setName("Naresh reddy");
//		teacher3.setAge(28);
		teachers.add(teacher3);

		subject.setTeachers(teachers);

		entityTransaction.begin();
		entityManager.persist(teacher1);
		entityManager.persist(teacher2);
		entityManager.persist(teacher3);
		entityManager.persist(subject);
		entityTransaction.commit();

	}

}
