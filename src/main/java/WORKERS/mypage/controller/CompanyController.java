package WORKERS.mypage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {
	
	
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
		return "/mypage/CompanySignUp2";
	}

}
