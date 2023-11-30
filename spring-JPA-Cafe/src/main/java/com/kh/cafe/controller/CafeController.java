package com.kh.cafe.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.cafe.service.CafeService;
import com.kh.cafe.vo.Cafe;

@Controller
@RequestMapping("/cafes")
public class CafeController {
	private final CafeService cafeService;
	
	@Autowired
	public CafeController(CafeService cafeService) {
		this.cafeService = cafeService;
	}
	
	//전체보기
	@GetMapping
	public String getAllCafes(Model model, @RequestParam(required=false)String name) {
		/*
		@RequestParam(required=false) : 파라미터를 필수로 적어주지 않아도 됨을 나타냄
		@RequestParam : http 요청으로 파라미터를 메서드의 매개변수로 전달할 때 사용 클라이언트가 웹 애플리케이션에 보내는 요청의 파라미터 값을 받아서 처리하는데 사용
		@PathVariable VS @RequestParam
			@PathVariable : url 경로에서 변수 값을 추출 url/cafes/{id}
			@RequestParam : 한 경로 안에서 클라이언트가 요청한 파라미터 값을 추출 url/cafes?name=사용자가입력한값
		*/
		
		//카페 리스트를 만들어 준 후 만약 리스트에서 카페가 존재한다면 그 카페목록만 보여주고 만약 존재하지 않는다면 모든 카페목록을 보여줌
		List<Cafe> cafes;
		
		if(name != null && !name.isEmpty()) {
			cafes = cafeService.findCafeByName(name);
		}else {
			cafes = cafeService.getAllCafes();
		}
		model.addAttribute("cafes", cafes);
		return "cafeList";
	}
	
	//상세보기
	@GetMapping("/detail/{cafeId}")
	public String getCafeDetail(@PathVariable Long cafeId, Model model) {
		Optional<Cafe> cafe = cafeService.getCafeById(cafeId);
		cafe.ifPresent(value -> model.addAttribute("cafe", value));
		return "cafeDetail";
	}
	
	//카페저장
	@GetMapping("/new")
	public String displayCafeForm(Model model) {
		model.addAttribute("cafe", new Cafe());
		return "cafeForm";
	}
	@PostMapping("/save")
	public String saveCafe(@ModelAttribute Cafe cafe) {
		cafeService.saveCafe(cafe);
		return "redirect:/cafes";
	}
	
	//카페수정
	@GetMapping("/update/{cafeId}")
	public String updateCafe(@PathVariable Long cafeId, Model model) {
		Optional<Cafe> cafe = cafeService.getCafeById(cafeId);
		cafe.ifPresent(value -> model.addAttribute("cafe", value));
		return "cafeForm";
	}
	
	//전체삭제
	@GetMapping("/delete/all")
	public String deleteAllCafe() {
		cafeService.deleteAllCafe();
		return "redirect:/cafes";
	}
	//선택삭제
	@GetMapping("/delete/{cafeId}")
	public String deleteCafeById(@PathVariable Long cafeId) {
		cafeService.deleteCafeById(cafeId);
		return "redirect:/cafes";
	}
	
	//↓↓메인페이지에서 검색할 수 있게 getAllCafes() 와 합쳐줌↓↓
	//검색하기
	/*
	@GetMapping("/search")
	public String searchCafes(@RequestParam String keyword, Model model) {
		List<Cafe> cafes = cafeService.findCafeByName(keyword);
		model.addAttribute("cafes", cafes);
		return "searchResults";
	}
	*/
}
/*
	http://127.0.01:8082/board?keyword=키워드작성
		localhost = 127.0.01 : 내 아이피 주소
					   :8082 : 포트번호
					  /board : 요청경로(path) 특정 기능이나 페이지에 대한 요청을 나타냄
				   ?keyword= : 쿼리의 시작을 나타냄 DB 키 값을 작성 =과 필요한 키워드를 넣어 값을 작성
*/