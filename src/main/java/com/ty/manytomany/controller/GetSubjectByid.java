package com.ty.manytomany.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.manytomany.dto.Subject;
import com.ty.manytomany.dto.Teacher;

public class GetSubjectByid {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Subject subject = entityManager.find(Subject.class, 1);
		System.out.println("Subject Id - " + subject.getId());
		System.out.println("Subject Name - " + subject.getName());
		System.out.println("Subject Completion days - " + subject.getDays());
		System.out.println("------------------------------------------");

		List<Teacher> teachers = subject.getTeachers();

		System.out.println(teachers);
	}

}
