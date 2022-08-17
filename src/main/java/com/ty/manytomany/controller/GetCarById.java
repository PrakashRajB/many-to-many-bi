package com.ty.manytomany.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.manytomany.dto.Car;
import com.ty.manytomany.dto.Feature;

public class GetCarById {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Car car = entityManager.find(Car.class, 2);
		List<Feature> features = car.getFeatures();
		if (car != null) {
			System.out.println(car);
			for (Feature f : features) {
				System.out.println(f);
			}
		}

	}

}
