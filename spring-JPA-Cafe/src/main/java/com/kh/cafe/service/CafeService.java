package com.kh.cafe.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.cafe.repository.CafeRepository;
import com.kh.cafe.vo.Cafe;

@Service
public class CafeService {
	private final CafeRepository cafeRepository;
	
	@Autowired
	public CafeService(CafeRepository cafeRepository) {
		this.cafeRepository = cafeRepository;
	}
	
	//전체보기
	public List<Cafe> getAllCafes(){
		return cafeRepository.findAll();
	}
	
	//상세보기
	public Optional<Cafe> getCafeById(Long cafeId){
		return cafeRepository.findById(cafeId);
	}
	
	//저장하기
	public Cafe saveCafe(Cafe cafe) {
		return cafeRepository.save(cafe);
	}
	
	//전체삭제
	public void deleteAllCafe() {
		cafeRepository.deleteAll();
	}
	
	//선택삭제
	public void deleteCafeById(Long cafeId) {
		cafeRepository.deleteById(cafeId);
	}
	
	//검색하기
	public List<Cafe> findCafeByName(String keyword){
		//return cafeRepository.findCafe(keyword);
		return cafeRepository.findByNameContaining(keyword);
	}
	
	//지역카운터
	public int countCafesByLocation(String location) {
		return cafeRepository.countByLocation(location);
	}
	
	//카페존재여부
	public boolean existsCafeByName(String name) {
		return cafeRepository.existsByName(name);
	}
}
