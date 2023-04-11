package com.greedy.section02.crud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="SECTION02_CATEGORY")	//엔티티 객체로 만들기 위한 어노테이션. 다른 패키지에 동일 이름의 클래스가 존재하면 name 지정 필요.
@Table(name="TBL_CATEGORY")			//데이터베이스에 매핑 될 테이블 이름 설정.
public class Category {
	
	@Id									//PK에 해당하는 속성에 지정
	@Column(name="CATEGORY_CODE")			//데이터베이스에 대응되는 컬럼명 지정
	private int categoryCode;
	
	@Column(name="CATEGORY_NAME")
	private String categoryName;
	@Column(name="REF_CATEGORY_CODE")
	private int refCategoryCode;
	
	public Category() {
	}

	public Category(int categoryCode, String categoryName, int refCategoryCode) {
		super();
		this.categoryCode = categoryCode;
		this.categoryName = categoryName;
		this.refCategoryCode = refCategoryCode;
	}

	public int getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getRefCategoryCode() {
		return refCategoryCode;
	}

	public void setRefCategoryCode(int refCategoryCode) {
		this.refCategoryCode = refCategoryCode;
	}

	@Override
	public String toString() {
		return "Menu [categoryCode=" + categoryCode + ", categoryName=" + categoryName + ", refCategoryCode="
				+ refCategoryCode + "]";
	}

	
	
	

}
