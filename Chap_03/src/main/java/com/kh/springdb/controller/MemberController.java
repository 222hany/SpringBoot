package com.kh.springdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.springdb.model.vo.MemberVO;
import com.kh.springdb.service.MemberService;

@Controller
@RequestMapping("/members")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/create")
	public String displayCreateForm(Model model) {
		model.addAttribute("member", new MemberVO());
		return "member-form";
	}
	
	@PostMapping("/create")
	public String insertMember(@ModelAttribute MemberVO member) {
		memberService.insertMember(member);
		return "redirect:/members";
	}
	
}