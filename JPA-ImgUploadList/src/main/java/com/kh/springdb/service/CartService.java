package com.kh.springdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.springdb.model.Cart;
import com.kh.springdb.model.CartItem;
import com.kh.springdb.model.Item;
import com.kh.springdb.repository.CartItemRepository;
import com.kh.springdb.repository.CartRepository;
import com.kh.springdb.repository.ItemRepository;

import jakarta.transaction.Transactional;

@Service
public class CartService {
  @Autowired
  private CartItemRepository carItemRepository;

  @Autowired
  private ItemRepository itemRepository;

  @Autowired
  private CartRepository cartRepository;

  public List<CartItem> findCartItemByCartId(int cartId) {
      return carItemRepository.findCartItemByItemId(cartId);
  }

  public List<CartItem> findByItemId(int itemId) {
      return carItemRepository.findByItemId(itemId);
  }

  public Cart getCartById(Long cartId) {
      return cartRepository.findById(cartId).orElse(null);
  }

	@Transactional
	public void addCart(Long cartId, Item newItem, int amount) {
	    // 현재 담긴 장바구니가 없을 때 장바구니 생성해주는 코드
	    Cart cart = cartRepository.findById(cartId).orElseGet(() -> {
	        Cart newCart = new Cart();
	        return cartRepository.save(newCart);
	    });

	    // 장바구니에 해당 아이템이 이미 담겨져 있는지 확인
	    CartItem cartItem = carItemRepository.findByCartIdAndItemId(cartId, newItem.getId());

	    if (cartItem == null) {
	        // 장바구니에 해당 아이템이 없으면 새로운 CartItem 생성
	        cartItem = new CartItem();
	        cartItem.setCart(cart);
	        cartItem.setItem(newItem);
	        cartItem.setCount(amount);
	    } else {
	        // 장바구니에 해당 아이템이 이미 담겨져 있으면 수량 증가
	        cartItem.addCount(amount);
	    }

	    // 생성 또는 업데이트된 CartItem을 저장
	    carItemRepository.save(cartItem);

	 
	}
	
}
