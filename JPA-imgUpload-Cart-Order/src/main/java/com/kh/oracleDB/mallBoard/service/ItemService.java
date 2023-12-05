package com.kh.oracleDB.mallBoard.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.oracleDB.mallBoard.repository.ItemRepository;
import com.kh.oracleDB.mallBoard.vo.Item;

@Service
public class ItemService {
	private ItemRepository itemRepository;
	
	@Autowired
	public ItemService (ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	
	//상품추가
	public void addItem(Item item, MultipartFile photoFile) throws IllegalStateException, IOException {
		//상품명, 저장 될 파일명 경로생성
		String originPhotoName = photoFile.getOriginalFilename(); //이미지 파일 정보에 대해서 추출.
		String photoName = ""; //업로드 된 이미지 파일의 원본 파일명을 가져옴.
		String photoPath = System.getProperty("user.dir") + "src/main/resources/static/uploadImg/"; //업로드 된 이미지 파일 경로 설정.
		//System.getProperty("user.dir") : 현재 코드가 작업하고 있는 폴더 위치("현재 작업하고 있는 사용자 폴더")
		
		//새로운 파일명을 생성해 주기 위해 UUID 를 사용하거나
		//UUID uuid = UUID.randomUUID();
		//아니면
		String saveFileName = "khShop" + originPhotoName; //saveFileName 로 만약에 판매자가 사진1 을 올리면 내 폴더 안에는 khShop_사진1 로 저장이 됨.
		
		photoName = saveFileName; //빈 값에 한번 더 재정의로 넣어줌.
		
		File saveFile = new File(photoPath, photoName); //파일을 저장하기 위해 빈 File 객체를 가져옴. photoPath : 파일저장경로, photoName : 파일명
		
		//만약 이름을 변경해서 저장하고 싶지 않다면 originPhotoName 으로 저장해도 됨. 판매자 컴퓨터에 있는 이미지 이름 그대로 업로드 됨.
		//File saveFile = new File(photoPath, originPhotoName);
		
		photoFile.transferTo(saveFile); //업로드 된 이미지 파일을 지정된 경로에 저장하기 위해 설정. transferTo 서버에 특정 경로에 저장할 수 있도록 해주는 메서드.
        item.setImgName(photoName);
        item.setImgPath("/files/" + photoName);
		
		itemRepository.save(item); //DB 에 저장할 수 있도록 save.
	}
	
	//상품읽기
	public Item getItemById(Integer id) {
		return itemRepository.findById(id).get(); // findById 를 사용해서 Id 에 해당하는 값을 가져오고 get 을 이용해서 Item 객체를 반환
	}
	
	//모든 상품 가져오기 List
	public List<Item> allItemList(){
		return itemRepository.findAll();
	}
	
	//상품삭제
	public void itemDelete(Integer Id) {
		itemRepository.deleteById(Id);
	}
}
