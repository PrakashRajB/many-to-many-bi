package com.ty.manytomany.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.manytomany.dto.Car;
import com.ty.manytomany.dto.Feature;

public class GetFeatureById {
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Feature feature=entityManager.find(Feature.class, 6);
		if(feature!=null) {
			List<Car> cars =feature.getCars();
			System.out.println(feature);
			System.out.println("Cars Which is having the feature");
			System.out.println("-----------------------------------------");
			for(Car c: cars) {
				System.out.println(c);
			}
			
		}
	}

}
