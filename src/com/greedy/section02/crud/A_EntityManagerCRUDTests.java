package com.greedy.section02.crud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class A_EntityManagerCRUDTests {
	
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
	public void 새로운_메뉴_추가_테스트() {
		
		Category category = new Category();
		category.setCategoryCode(13);
		category.setCategoryName("과일");
		category.setRefCategoryCode(4);
		
		//when
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		try {
			entityManager.persist(category);
			entityTransaction.commit();
		} catch (Exception e) {
			entityTransaction.rollback();
			e.printStackTrace();
		}
		
		//then
		assertTrue(entityManager.contains(category));
		
	}
	
	@Test
	public void 메뉴_이름_수정_테스트() {
		
		//given
		Category category = entityManager.find(Category.class, 13);
		System.out.println("Category = " + category);
		
		String categoryNameToChange = "유제품";
		
		//when
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		try {
			category.setCategoryName(categoryNameToChange);
			entityTransaction.commit();
		} catch (Exception e) {
			entityTransaction.rollback();
			e.printStackTrace();
		}
		
		//then
		assertEquals(categoryNameToChange, entityManager.find(Category.class, 13).getCategoryName());
		
	}
	
	@Test
	public void 메뉴_삭제하기_테스트() {
		
		//given
		Category categoryToRemove = entityManager.find(Category.class, 13);
		
		//when
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		try {
			entityManager.remove(categoryToRemove);
			entityTransaction.commit();
		} catch (Exception e) {
			entityTransaction.rollback();
			e.printStackTrace();
		}
		
		//then
		Category removedCategory = entityManager.find(Category.class, 13);
		assertEquals(null, categoryToRemove);
	}

}
