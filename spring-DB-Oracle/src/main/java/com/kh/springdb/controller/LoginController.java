package com.kh.springdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.springdb.model.User;
import com.kh.springdb.service.LoginService;

@Controller
//@RequestMapping("LoginController 내에서 기본으로 앞에 제공하는 기본 URL 경로")
@RequestMapping("/user")
public class LoginController {
	
	private LoginService loginService;
	
	@Autowired
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}
	//  user/login 경로로 들어오는 GET 요청을 처리하며
	//	로그인 폼을 보여주기 위해 로그인 페이지로 이동시켜줌
	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}
	
	//HTTP POST 요청을 처리하는 메서드
	//     /user/login 경로로 들어오는 POST 요청을 처리해서
	// 실제 로그인을 수행할 수 있도록 진행해줌
	@PostMapping("/login")
	// public String login 메서드는 사용자가 입력한 이름, 사용자가 입력한 이메일을
	//		받아와서 LoginService를 통해 실제 로그인을 시도
	public String login(String mname, String memail, Model model) {
		User userInfo = loginService.login(mname, memail);
		if(userInfo != null) {// 만약에 로그인을 성공하게 된다면
			// 모델에 loginSuccess를 활용해서 로그인 성공여부를 추가
			// 필수로 필요한 것은 아니며 추가를 하지 않아도 됨
			model.addAttribute("loginSuccess", true);
			return "loginSuccess";
		} else {
			// 로그인을 실패하면 error속성을 모델에 추가해서 
			// 로그인에 실패했습니다 라는 메세지를 모델에 담을 수 있도록 진행함
			model.addAttribute("error", "로그인에 실패했습니다");
			// 로그인 실패 후 다시 로그인을 하기 위해
			//      /user/login 페이지로 이동할 수 있도록 지정해줌
			return "login";
		}
		
	}
}