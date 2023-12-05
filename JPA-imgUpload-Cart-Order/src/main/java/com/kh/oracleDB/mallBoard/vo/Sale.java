package com.kh.oracleDB.mallBoard.vo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Sale {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sale_seq")
	@SequenceGenerator(name = "sale_seq", sequenceName = "sale_seq", allocationSize = 1)
	private int id;
	
	//판매자
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "seller_id")
	private User seller;
	
	@OneToMany(mappedBy = "sale")
	private List<SaleItem> saleItems = new ArrayList<>();
	
	//총 판매 개수
	private int totalCount;
	
	//판매 정보를 새로 생성하는 메서드
	public static Sale createSale(User seller) {
		Sale sale = new Sale();
		sale.setSeller(seller);
		sale.setTotalCount(0);
		return sale;
	}
}
/*
	Sale 과 SaleItem 으로 나뉘어진 이유
	Sale : 판매 정보를 나타내는 객체. 판매자와 총 판매 개수와 같은 속성을 가짐.
	SaleItem : 판매 정보에 속해 있는 각 상품에 대한 정보를 나타냄.
*/