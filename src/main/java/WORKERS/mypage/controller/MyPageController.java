package WORKERS.mypage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import WORKERS.mypage.model.User;

@Controller
@RequestMapping("/mypage")
public class MyPageController {
	
	@GetMapping("/UserSignUp")
	public String GetUserSignUp() {	
		// 정상 작동 
		System.out.println("GetUserSignUp");
		return "/mypage/UserSignUp";
	}
	
	@PostMapping("/UserSignUp")
	public String PostUserSignUp(@ModelAttribute User user) {
		
		System.out.println("user.getUserEmail() = "+user.getUserEmail());
		System.out.println("user.getUserPw() = "+user.getUserPw());
		System.out.println("user.getUserEmail() = "+user.getNickName());
		System.out.println("user.getNickName() = "+user.getBirthday());
		System.out.println("user.getSelfIntroduce() = "+user.getSelfIntroduce());
		
		
		System.out.println("/PostUserSignUp");
		return "redirect:/test/header";
	}
	
	
	
	
	
	@GetMapping("/CompanySignUp1")
	public String CompanySignUp1() {
		// api 적용 전 
		System.out.println("/CompanySignUp1");
		return "/mypage/CompanySignUp1";
	}

	@GetMapping("/CompanySignUp2")
	public String CompanySignUp2() {
		// api 적용 후 
		System.out.println("/CompanySignUp2");
		return "";
	}
	

}
