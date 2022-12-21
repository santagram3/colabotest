package WORKERS.mypage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import WORKERS.mypage.model.User;
import WORKERS.mypage.repository.UserMapper;
import WORKERS.mypage.service.UserService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MyPageController {
	
	private final UserService userService;
	
	
	@GetMapping("/UserSignUp")
	public String GetUserSignUp() {	
		// 정상 작동 
		System.out.println("GetUserSignUp");
		return "/mypage/UserSignUp";
	}
	
	@PostMapping("/UserSignUp")
	public String PostUserSignUp1(@ModelAttribute User user) throws Exception {
		// 값이 잘 들어오는지 확인! 
		System.out.println("=========================================");
		System.out.println("user.getUserEmail() = "+user.getUserEmail());
		System.out.println("user.getUserPw() = "+user.getUserPw());
		System.out.println("user.getUserEmail() = "+user.getNickName());
		System.out.println("user.getNickName() = "+user.getBirthday());
		System.out.println("user.getSelfIntroduce() = "+user.getSelfIntroduce());
		
		// 아이디가 없다는 뜻 // 그러므로 회원 가입 가능 ! 
		userService.trimInfo(user);
		
		// 가입 했으니까 돌아가 ! 
		return "/header/header" ;
	}
	
	// 이메일 있는지 없는지 비동기로 처리하는 메소드 
	@GetMapping("/eamilcheck") 
	@ResponseBody // 비동기 처리하는 어노테이션 
	public String eamilcheck(String userEmail) throws Exception {
		System.out.println("/eamilcheck");
		System.out.println(userEmail);
		System.out.println("=============");
		String id = userService.findUserIdService(userEmail);
		
		System.out.println( "id = " + id);
		
		if(userEmail.equals(id)) {
			// 아이디가 있다는 뜻  
			return "double";
		}else {
			return "onlyone"; 
		}
	
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
