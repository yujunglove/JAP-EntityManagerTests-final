package com.greedy.section02.product;
import java.util.Date;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="section02_product")
@Table(name="TBL_PRODUCT")

@SequenceGenerator( name="PRODUCT_SEQUENCE_GENERATOR",
sequenceName="SEQ_PRODUCT_NO", allocationSize=1 )
public class Product {
	
	@Id
	@Column(name="PRODUCT_NO", nullable=false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PRODUCT_SEQUENCE_GENERATOR")
	private int productNo;
	
	@Column(name="PRODUCT_NAME", nullable=false)
	private String productName;
	
	@Column(name="PRODUCT_PRICE", nullable=false)
	private int productPrice;
	
	@Column(name="PRODUCT_DATE", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date productDate;
	
	@Column(name="CATEGORY", nullable=false)
	@Enumerated(EnumType.STRING)
	private ProductEnum product;
	
	public Product() {}

	public Product(int productNo, String productName, int productPrice, Date productDate, ProductEnum product) {
		super();
		this.productNo = productNo;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDate = productDate;
		this.product = product;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	@Access(AccessType.PROPERTY)
	public String getProductName() {
		System.out.println("getProductName()를 이용한 access 확인...");
		return productName + " Delious!";
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public Date getProductDate() {
		return productDate;
	}

	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}

	public ProductEnum getCategory() {
		return product;
	}

	public void setCategory(ProductEnum product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Product [productNo=" + productNo + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productDate=" + productDate + ", category=" + product + "]";
	}
	
	

	
	

	
	
}
