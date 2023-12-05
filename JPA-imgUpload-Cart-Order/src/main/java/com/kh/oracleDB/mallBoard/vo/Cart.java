package com.kh.oracleDB.mallBoard.vo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="cart_seq")
	@SequenceGenerator(name = "cart_seq", sequenceName="cart_seq",allocationSize=1)
    private int id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user; // 구매자

    private int count; // 카트에 담긴 총 상품 개수

    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItems = new ArrayList<>();

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate createDate; // 날짜

    @PrePersist
    public void createDate(){
        this.createDate = LocalDate.now();
    }

    public static Cart createCart(User user) {
        Cart cart = new Cart();
        cart.setCount(0);
        cart.setUser(user);
        return cart;
    }


}
