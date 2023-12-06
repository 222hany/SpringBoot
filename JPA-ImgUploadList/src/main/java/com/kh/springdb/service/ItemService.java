package com.kh.springdb.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.springdb.model.Item;
import com.kh.springdb.repository.ItemRepository;

import lombok.*;

@Service
@RequiredArgsConstructor
public class ItemService {
	private final ItemRepository itemRepository;
	//모든 상품 리스트 불러오기 메서드
	public List<Item> allItemView(){
		return itemRepository.findAll();
	}
	
	//상세보기나 수정하기를 할 수 있는 메서드
	public Item getItemById(int id) {
		return itemRepository.findItemById(id);
	}
	
	//상품을 등록할 수 있는 메서드
	public void saveItem(Item item, MultipartFile imgFile) throws IllegalStateException, IOException { //기존에는 상품명이나 글자로 이루어진 내용을 넣었지만 이미지를 넣어주기위해 파일을 파라미터에 받겠다 작성
		String originName = imgFile.getOriginalFilename();
		String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/img/";
		
		File saveFile = new File(projectPath, originName);
		imgFile.transferTo(saveFile);
		
		item.setImgName(projectPath);
		item.setImgPath("/img/" + originName);
		
		itemRepository.save(item);
	}
}
