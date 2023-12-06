package com.kh.springdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.springdb.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{
	//상세보기와 수정하기를 위한 메서드
	Item findItemById(int id);
	
	//페이지네이션이나 검색을 위한 메서드
}
