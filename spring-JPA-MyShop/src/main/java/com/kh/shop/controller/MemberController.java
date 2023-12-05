package com.kh.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.shop.service.MemberService;
import com.kh.shop.vo.Member;

@Controller
@RequestMapping("/members")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	//회원가입하고 회원가입 결과  @GetMapping @PostMapping
	@GetMapping("/new")
	public String joinMember(Model model) {
		model.addAttribute("member", new Member());
		return "member/joinForm";
	}
	
	@PostMapping("/new")
	public String addMember(@ModelAttribute Member member) {
		//이미 존재하는 회원인지 아닌지에 대한 여부
		memberService.saveMember(member);
		return "redirect:/";
	}
	//로그인하고 로그인실패 @GetMapping @GetMapping
	@GetMapping("/login")
	public String loginMember() {
		return "/member/memberLoginForm";
	}
	
	@GetMapping("/login/error")
	public String loginError(Model model) {
		model.addAttribute("loginErrorMsg", true);
		//model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인하시길 바랍니다.");
		return "member/memberLoginForm";
	}
}
