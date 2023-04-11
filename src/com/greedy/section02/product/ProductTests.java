package com.greedy.section02.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductTests {

	private static EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	
	@BeforeAll
	public static void initFactory() {
		entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
	}
	
	@BeforeEach
	public void initManager() {
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	@AfterAll
	public static void closeFactory() {
		entityManagerFactory.close();
	}
	
	@AfterEach
	public void closeManager() {
		entityManager.close();
	}
	
	@Test
	public void Product_food_Tests() {
		
		//given
		Product product = new Product();
		product.setProductName("당근케익");
		product.setProductPrice(6000);
		product.setProductDate(new Date());
		product.setCategory(ProductEnum.Cake);
		
		
		Product product2 = new Product();
		product2.setProductName("흑임자 마카롱");
		product2.setProductPrice(3000);
		product2.setProductDate(new Date());
		product2.setCategory(ProductEnum.Macaron);
		
		Product product3 = new Product();
		product2.setProductName("당근 마카롱");
		product2.setProductPrice(3500);
		product2.setProductDate(new Date());
		product2.setCategory(ProductEnum.Macaron);
		
		
		
		//when
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(product);
		entityManager.persist(product2);
		entityManager.persist(product3);
		entityTransaction.commit();
	}
}
