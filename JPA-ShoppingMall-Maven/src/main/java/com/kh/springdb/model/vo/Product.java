package com.kh.springdb.model.vo;
import jakarta.persistence.*;
import lombok.*;

@Entity

@Getter @Setter
@Table(name="Product")
public class Product {
	
	@Id
	@Column(name="product_id")
	@GeneratedValue(strategy= GenerationType.SEQUENCE,generator="productId_Seq")
	@SequenceGenerator(name = "productId_Seq", sequenceName = "productId_Seq",allocationSize = 1)
	private Long id;
	private String product_name;
	private String category;
	private String price;
	private String stock_quantity;
	private String description;
	
}