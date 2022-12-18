package WORKERS.mypage.controller;

import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import WORKERS.mypage.DTO.LoginDTO;
import WORKERS.mypage.model.User;
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
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		// 형변환 해줘야 됨 ! 
		User user = (User)session.getAttribute("loginUser");
		 
		if(user != null) { // 로그인 상태라면 ? 
			
			session.removeAttribute("loginUser"); // loginUser 라는 내용을 세션에서 삭제 
 			session.invalidate(); //세션 객체 삭제 
			
			return "redirect:/test/header";
		}
		
		// 로그인 상태가 아니라면 
		return "redirect:/test/header";
	}
	

}
