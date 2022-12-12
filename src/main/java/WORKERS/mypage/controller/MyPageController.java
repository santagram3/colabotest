package WORKERS.mypage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import WORKERS.mypage.model.User;
import WORKERS.mypage.repository.UserMapper;
import WORKERS.mypage.service.UserService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/mypage")
public class MyPageController {
	
	private UserService userService;

	public MyPageController(UserService userService) {
		this.userService = userService ;
	}
	
	
	@GetMapping("/UserSignUp")
	public String GetUserSignUp() {	
		// 정상 작동 
		System.out.println("GetUserSignUp");
		return "/mypage/UserSignUp";
	}
	
	@PostMapping("/UserSignUp")
	public ResponseEntity<String> PostUserSignUp1(@ModelAttribute User user) throws Exception {
		// 값이 잘 들어오는지 확인! 
		System.out.println("=========================================");
		System.out.println("user.getUserEmail() = "+user.getUserEmail());
		System.out.println("user.getUserPw() = "+user.getUserPw());
		System.out.println("user.getUserEmail() = "+user.getNickName());
		System.out.println("user.getNickName() = "+user.getBirthday());
		System.out.println("user.getSelfIntroduce() = "+user.getSelfIntroduce());
		
		// 아이디 중복 체크 ! 
		//String id = userService.findUserIdService(user.getUserEmail());
		//if(id==null) {}
		
		// 비밀번호 확인 ! 
		
		// db에 등록 
		
		// 회원가입 완료 .. // 로그인 화면으로 이동 
		
		System.out.println("/PostUserSignUp");
		// 서비스 안에 메소드 사용 ! 
		userService.trimInfo(user);
		
		return null ;
	}
	
	@PostMapping("/UserSignUp1")
	public String PostUserSignUp(@ModelAttribute User user) throws Exception {
		
		System.out.println("user.getUserEmail() = "+user.getUserEmail());
		System.out.println("user.getUserPw() = "+user.getUserPw());
		System.out.println("user.getUserEmail() = "+user.getNickName());
		System.out.println("user.getNickName() = "+user.getBirthday());
		System.out.println("user.getSelfIntroduce() = "+user.getSelfIntroduce());
		
		
		System.out.println("/PostUserSignUp");
		// 서비스 안에 메소드 사용 ! 
		userService.trimInfo(user);
		
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
