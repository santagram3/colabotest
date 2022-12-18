package WORKERS.mypage.controller;

import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import WORKERS.mypage.DTO.LoginDTO;

import WORKERS.mypage.service.UserService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
	
	private final UserService userService;

	@PostMapping("/login")
	public String loginSuccess(LoginDTO loginDTO, HttpSession session, Model model) throws Exception {
		
		System.out.println("loginSuccess in LoginController");
		
		System.out.println("loginDTO = "+loginDTO);
		
	String answer =	userService.loginSessionService(loginDTO, session);
	
	
	if(answer =="loginSuccess") {
		System.out.println("loginSuccess");
		// 로그인 성공 
		model.addAttribute(answer,"loginSuccess"); 
		return "redirect:/test/header";
	}else if(answer =="pwFail") {
		
		// 비밀번호 틀림 
		System.out.println("pwFail");
		model.addAttribute(answer,"pwFail"); 
		return "redirect:/test/header";
	}else {
		// 아이디 없음 ! 
		System.out.println("noId");
		model.addAttribute(answer,"noId"); 
		return "redirect:/test/header";
		}
	}
	

}
