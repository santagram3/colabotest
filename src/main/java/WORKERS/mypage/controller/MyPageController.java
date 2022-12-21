package WORKERS.mypage.controller;

import javax.servlet.http.HttpSession;

import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import WORKERS.mypage.model.User;
import WORKERS.mypage.service.UserService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MyPageController {
	
	private final UserService userService;
	
	// 회원가입창 만들기 
	@GetMapping("/UserSignUp")
	public String GetUserSignUp() {	
		// 정상 작동 
		System.out.println("GetUserSignUp");
		return "/mypage/UserSignUp";
	}
	
	// 회원 가입 정보 폼으로 받고 가져오기 
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
		
		System.out.println("id = " + id);
		
		if(userEmail.equals(id)) {
			// 아이디가 있다는 뜻  
			return "double";
		}else {
			return "onlyone"; 
		}
	
	}
	
	
	// 로그인 유저 정보 !! 
	@GetMapping("/info")
	public String myInfo(HttpSession session,Model model) throws Exception{
		System.out.println("/mypage/info");
		// 세션에서 받아온 로그인 유저 
		User sessionLoginUser = (User)session.getAttribute("loginUser");
		
		// 세션에서 받아온 로그인에서 이메일 가져옴 
		String loginUserEmail = sessionLoginUser.getUserEmail();
		
		// 그걸 앞 뒤 공백 다 자름 
		loginUserEmail.trim();
		
		// 받아온 이메일로 사람 정보 찾아서 가져옴 ! 
		User loginUserInfo = userService.findUserService(loginUserEmail);
		
		model.addAttribute("loginUserInfo",loginUserInfo);
		
		
		return "/mypage/mypageInfo";
	}
	
	
	@PostMapping("/modifyinfo/{userEmail}")
	public String ModifyInfo(HttpSession session,@PathVariable String userEmail, @ModelAttribute User user, Model model) throws Exception {
		System.out.println("마이페이지 수정을 시작");
		System.out.println(user.toString());
		userService.modifyUserInfo(user);

		User sessionLoginUser = (User)session.getAttribute("loginUser");		
		String loginUserEmail = sessionLoginUser.getUserEmail();		
		loginUserEmail.trim();

		User loginUserInfo = userService.findUserService(loginUserEmail);		
		model.addAttribute("loginUserInfo",loginUserInfo);
		
		return "/mypage/mypageInfo";
	}
	
	@PostMapping("/deleteinfo/{userEmail}")
	public String DeleteInfo(HttpSession session, @PathVariable String userEmail, @ModelAttribute User user) throws Exception{
		System.out.println("userEmail: "+user.getUserEmail());
		System.out.println("user: "+user.toString());
		
		User sessionLoginUser = (User)session.getAttribute("loginUser");
		if(user.getUserPw().equals(sessionLoginUser.getUserPw()))
			userService.deleteUserInfo(user);
		System.out.println("삭제완료");
		
        session.removeAttribute("loginUser"); // loginUser 라는 내용을 세션에서 삭제
        session.invalidate(); // 세션 객체 삭제
		

        
		return "/header/header";
	}
	
	
	
	

}
