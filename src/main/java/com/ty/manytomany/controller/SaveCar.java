package com.ty.manytomany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.manytomany.dto.Car;
import com.ty.manytomany.dto.Feature;

public class SaveCar {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Car car = new Car();
		car.setBrand("AUDI");
		car.setCost(2300000);

		List<Feature> features = new ArrayList<Feature>();

		Feature feature1 = entityManager.find(Feature.class, 4);
//		feature1.setType("Power window");
//		feature1.setCost(10000);
		features.add(feature1);

		Feature feature2 = entityManager.find(Feature.class, 5);
//		feature2.setType("Auto pilot");
//		feature2.setCost(40000);
		features.add(feature2);

		Feature feature3 = entityManager.find(Feature.class, 6);
//		feature3.setType("Sun roof");
//		feature3.setCost(12000);
		features.add(feature3);

		Feature feature4 = new Feature();
		feature4.setType("Air Bag");
		feature4.setCost(30000);
		features.add(feature4);

		car.setFeatures(features);

		entityTransaction.begin();
		entityManager.persist(car);
		entityManager.persist(feature4);
		entityTransaction.commit();
	}

}
