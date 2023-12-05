package com.kh.oracleDB.mallBoard.controller;

import com.kh.oracleDB.mallBoard.service.ItemService;
import com.kh.oracleDB.mallBoard.vo.Item;

import java.io.IOException;
import java.util.*;

import lombok.*;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor //@NotNull 로 표시된 필드를 사용해서 생성자를 생성
public class ItemController {
	private final ItemService itemService;
	
	@GetMapping("/")
	public String mainPage(Model model) {
		List<Item> items = itemService.allItemList();
		model.addAttribute("items", items); //view html 과 연결하기 위해서 작성되는 페이지
		return "/index";
	}
	/*
	@GetMapping("/item/list")
	public String itemList(Model model, @PageableDefault(size = 12) Pageable pageable, @RequestParam(name = "keyword", required = false) String keyword) {
		//페이지네이션 처리를 위한 서비스. 검색 하지않고 페이징 처리를 원함.
		Page<Item> items = itemService.getItemByPage(pageable);
		return "itemList";
	}
	*/
	
	//상품등록 페이지 admin 만 등록가능
	@GetMapping("/new")
	public String addItemForm(Model model) {
		return "addItemForm.html";
	}
	@PostMapping("/save")
	public String saveItem(Item item, MultipartFile photoFile) throws IOException { //MultipartFile 을 이용해서 상품등록 시 이미지 파일도 등록될 수 있도록 파라미터 생성.
		//itemService.addItem(item); //이미지 없이 상품을 등록하고 싶다면 item 만 작성해도 되지만 이미지 또한 포함해서 상품을 등록하고 싶다면 item, photoFile 을 추가해서 작성.
		itemService.addItem(item, photoFile);
		return "redirect:/index";
	}
	
	//상품 상세보기
	@GetMapping("/view/{id}")
	public String viewItem(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("item", itemService.getItemById(id));
		return "viewItem";
	}
	
	//상품수정
	
	//상품삭제
	@GetMapping("/delete/{id}")
	public String deleteItem(@PathVariable("id") Integer id) {
		itemService.itemDelete(id);
		return "itemList";
	}
}
