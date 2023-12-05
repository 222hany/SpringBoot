package com.kh.shop.vo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="ProductList")
@Getter @Setter
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