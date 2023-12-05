package com.kh.oracleDB.mallBoard.vo;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderitem_seq")
	@SequenceGenerator(name = "orderitem_seq", sequenceName = "orderitem_seq", allocationSize = 1)
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id")
	private Order order;
	
	//구매자
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;
	
	//상품 주문번호
	private int itemId;
	
	//주문상품 이름
	private String itemName;
	
	//주문상품 가격
	private int itemPrice;
	
	//주문상품 수량
	private int itemCount;
	
	//가격 * 수량 = 총 가격
	private int itemTotalPrice;
	
	//주문상품에 매핑되는 판매상품
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "saleItem_id")
	private SaleItem saleItem;
	
	//주문 취소여부 1 : 주문취소 0 : 주문완료
	private int isCancel;
	
	//장바구니 상품 하나씩 개별 주문
	public static OrderItem createOrderItem(int itemId, User user, Item item, int count, Order order, SaleItem saleItem) {
		OrderItem orderItem = new OrderItem();
		orderItem.setItemId(itemId);
		orderItem.setUser(user);
		orderItem.setOrder(order);
		orderItem.setItemName(item.getName());
		orderItem.setItemPrice(item.getPrice());
		orderItem.setItemCount(count); //어떤 제품을 몇 개 살 것이고 최종적으로 몇 개를 구매할 것인지에 대한 카운트가 필요
		orderItem.setItemTotalPrice(item.getPrice() * count);
		orderItem.setSaleItem(saleItem);
		return orderItem;
	}
	
	//장바구니 전체 주문
	public static OrderItem createOrderItem(int itemId, User user, CartItem cartItem, SaleItem saleItem) {
		OrderItem orderItem = new OrderItem();
		orderItem.setItemId(itemId);
		orderItem.setUser(user);
		orderItem.setItemName(cartItem.getItem().getName());
		orderItem.setItemPrice(cartItem.getItem().getPrice());
		orderItem.setItemCount(cartItem.getCartCount());
		orderItem.setItemTotalPrice(cartItem.getItem().getPrice() * cartItem.getCartCount());
		orderItem.setSaleItem(saleItem);
		return orderItem;
	}
}
