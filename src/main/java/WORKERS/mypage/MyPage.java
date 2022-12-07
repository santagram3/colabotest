package WORKERS.mypage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
public class MyPage {
	
	@GetMapping("/UserSignUp")
	public String GetUserSignUp() {	
		// 정상 작동 
		System.out.println("UserSignUp");
		return "/mypage/UserSignUp";
	}
	
	@PostMapping("/UserSignUp")
	public String PostUserSignUp() {	
		System.out.println("UserSignUp");
		return "/mypage/UserSignUp";
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
