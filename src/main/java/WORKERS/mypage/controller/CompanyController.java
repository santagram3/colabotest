package WORKERS.mypage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import WORKERS.mypage.model.CompanyUser;
import WORKERS.mypage.service.CompanyService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {

	private final CompanyService companyService;

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

	@PostMapping("/CompanySignUp1")
	public String companyRegister1(@ModelAttribute CompanyUser companyUser) throws Exception {
		// 잘 들어오는 거확인
		System.out.println("companyUser = " + companyUser);

		companyService.companyRegisterService(companyUser);

		return "/mainPage";
	}

	@PostMapping("/CompanySignUp2")
	public String companyRegister2() {
		return "";
	}

	// 이메일 있는지 확인하는 메소드
	@GetMapping("/findCompanyEmail")
	@ResponseBody // 비동기
	public String findCompanyEmail(String companyEmail) throws Exception {
		System.out.println("@ResponseBody companyEmail = " + companyEmail);
		String result = companyService.findCompanyEmailService(companyEmail);
		System.out.println("result = " + result);
		//yesCompanyEmail or noCompanyEmail
		return result;
	}
	
	// 사업자 번호가 있는지 확인하는 비동기 메소드
		@GetMapping("/findBN")
		@ResponseBody // 비동기
		public String findfindBN(String BusinessNumber) throws Exception {
			System.out.println("@ResponseBody BusinessNumber = " + BusinessNumber);
			String result = companyService.BNbooleanService(BusinessNumber);
			System.out.println("result = " + result);
		
			return result;
		}
		
	
	
	

}
