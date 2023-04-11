package com.greedy.section03;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmployeeTests {
	


public class AccociationAndJPQLTests {
	
	private static EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	
	@BeforeAll
	public static void initFactory() {
		entityManagerFactory = Persistence.createEntityManagerFactory("jpatestproject2");
	}
	
	@BeforeEach
	public void initEntityManager() {
		
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	@AfterEach
	public void closeEntityManager() {
		entityManager.close();
	}
	
	@AfterAll
	public static void closeEntityManagerFactory() {
		entityManagerFactory.close();
	}
	
	
	@Test
	public void 아이디_기준_사원_조회하기() {
		
		//given
		String employeeIdParameter = "301";
		
		String jpql = "SELECT e FROM section03_employee e WHERE e.empId = :empName";
		
		//when
		List<Employee> employeeList = entityManager.createQuery(jpql, Employee.class)
				.setParameter("empName", employeeIdParameter)
				.getResultList();
		
		//then
		assertNotNull(employeeList);
		employeeList.forEach(System.out::println);
				
		
	}
	
	@Test
	public void like_연산자를_활용한_조회_테스트() {
		/* 하가 들어가는  */
		
        //when
        String jpql = "SELECT e FROM section03_employee e WHERE e.empName LIKE '하%'";
        List<Employee> employeeList = entityManager.createQuery(jpql, Employee.class).getResultList();
		
        //then
		assertNotNull(employeeList);
		employeeList.forEach(System.out::println);
	}

	@Test
	public void 사원_insert_테스트() {
		
		//given
		Employee employee = new Employee();
		employee.setEmpId("99");
		employee.setEmpName("김유정");
		employee.setEmpNo("55555-55555");
		employee.setEmail("hong123@greedy.com");
		employee.setPhone("01012345678");
		employee.setSalary(3000000);
		employee.setBonus(10.0);
		employee.setManagerId("100");
		employee.setHireDate(new Date());	
		employee.setEntYn("Y");
		
		Department department = new Department();
		department.setDeptId("YuYu");
		department.setDeptTitle("영업부");
		department.setLocationId("go");
		employee.setDeptCode(department);
		
		//when
		entityManager.persist(employee);
		
		
	}
	
	
	@Test
	public void 전체사원_조회_테스() {
		
	
		//when
		String jpql = "SELECT e FROM section03_employee e";
		List<Employee> employeeList = entityManager.createQuery(jpql, Employee.class).getResultList();
			
		
		//then
		assertNotNull(employeeList);
		employeeList.forEach(System.out::println);
		
		
	}
}

}
