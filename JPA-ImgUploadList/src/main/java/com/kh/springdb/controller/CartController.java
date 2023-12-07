package com.kh.springdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.springdb.model.Item;
import com.kh.springdb.model.Cart;
import com.kh.springdb.service.CartService;
import com.kh.springdb.service.ItemService;

@Controller
@RequestMapping("cart")
public class CartController {
	private final CartService cartService;
	private final ItemService itemService;

	public CartController (CartService cartService, ItemService itemService) {
		this.cartService = cartService;
		this.itemService = itemService;
	}
	
	//장바구니 목록을 보여주기 위한 Get
	@GetMapping()
	public String viewCart(Model model) {
		Cart cart = cartService.getCartById(1L);
		model.addAttribute("cart", cart);
		return "cartView";
	}
	
	//주소를 접속하기 위한 Get
	@GetMapping("/add/{itemId}")
	public String addToCart(@PathVariable int itemId, Model model){
		//장바구니에 상품 추가
		Item newItem = itemService.getItemById(itemId);
		
		//@PathVariable Long itemId : 만약 파라미터 값이 Long 일 경우 longValue 로 변환. intValue() : Integer 를 쓴 객체를 int 로 변환하는 메서드.
		//Item newItem = itemService.getItemById(itemId.intValue());
		
		cartService.addCart(1L, newItem, 1); //1L : 임의의 값을 지정해줄때 1L 이라는 표현을 쓰기도 함.
		//cartService.addCart(누구의 장바구니인지 소유자에 대한 값을 지정, newItem, 1);
		return "redirect:/cart";
	}
	
	@PostMapping("/add")
	public String addToCartItem(@RequestParam("itemId")Long itemId) {
		Item newItem = itemService.getItemById(itemId.intValue());
		cartService.addCart(1L, newItem, 1);// 1: 카트에 추가 할 아이템 수량
		return "redirect:/cart";
	}
}
/*
	int VS Integer
	Integer : Wrapper 클래스. 객체로 감싸져있기 때문에 null 값을 가질 수 있음.
	int : 자바에서 기본 데이터 타입. 정수를 나타내는 값. null 값을 가질 수 없음.
*/