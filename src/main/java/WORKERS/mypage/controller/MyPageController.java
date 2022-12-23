package WORKERS.mypage.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import WORKERS.Boast.model.Boast;
import WORKERS.Boast.model.BoastImage;
import WORKERS.Boast.service.BoastService;
import WORKERS.JobPosting.service.JobPostingService;
import WORKERS.mypage.DTO.MyPageDTO;
import WORKERS.mypage.DTO.bNoSPListDTO;
import WORKERS.mypage.model.User;
import WORKERS.mypage.service.UserService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MyPageController {
	
	private final UserService userService;
	@Autowired
	private BoastService boastService;	
	@Autowired
	private JobPostingService jobpostingservice;
	
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
		return "redirect:/main/page" ;
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
	
	//내가 쓴 글 페이지
	@GetMapping("/info2")
	public String myInfo2(HttpSession session, Model model) throws Exception{
		User sessionLoginUser = (User)session.getAttribute("loginUser");
		String loginUserEmail = sessionLoginUser.getUserEmail();
		loginUserEmail.trim();
 		User loginUserInfo = userService.findUserService(loginUserEmail);
		
		System.out.println(loginUserInfo.toString());
		

		String bWriter = loginUserInfo.getNickName();	//session 정보에서 따온 거에서 bWriter 뽑음
		List<bNoSPListDTO> bNoSPListDTOs = boastService.bNoSPList(bWriter);
		int size = bNoSPListDTOs.size();	//for 문의 사이즈를 정함
		
		ArrayList<MyPageDTO> MyPageDTOs = new ArrayList<>(); //bNoSP bTitle bImage bStar replyCount
		
		for (int i = 0; i <size; i++) {
			bNoSPListDTO bnosplistdto = bNoSPListDTOs.get(i);
			//myPageDTO에 칼럼들을 하나씩 넣어줄거임 -> 마지막에 MyPageDTOs에 한방에 넣음
			MyPageDTO myPageDTO = new MyPageDTO();
			
			int bnosp = bnosplistdto.getBNoSPs();			//bNoSP
			myPageDTO.setbNoSP(bnosp);
			
			myPageDTO.setbTitle(boastService.getbTitleFrom(bnosp));
			myPageDTO.setbImage(boastService.getbImageFrom(bnosp));
			myPageDTO.setbStar(boastService.likeCount(bnosp));
			myPageDTO.setReplyCount(boastService.getReplyCountFrom(bnosp));
			
			
			MyPageDTOs.add(myPageDTO);		//for문 안에서 얻은 정보들 한방에 넣음
			System.out.println("MyPageDTO: "+myPageDTO.toString());
		}
		System.out.println("MyPageDTOs: "+MyPageDTOs.toString());
		model.addAttribute("MyPageDTOs",MyPageDTOs);
		

		return "/mypage/mypageInfo2";
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
	public String DeleteInfo(HttpSession session, @PathVariable String userEmail, @ModelAttribute User user, Model model) throws Exception{
		System.out.println("userEmail: "+user.getUserEmail());
		System.out.println("user: "+user.toString());
		
		User sessionLoginUser = (User)session.getAttribute("loginUser");
		if(user.getUserPw().equals(sessionLoginUser.getUserPw()))
			userService.deleteUserInfo(user);
		System.out.println("삭제완료");
		
        session.removeAttribute("loginUser"); // loginUser 라는 내용을 세션에서 삭제
        session.invalidate(); // 세션 객체 삭제
        
        model.addAttribute("duelist",jobpostingservice.getJobPostingList());
  
		return "redirect:/main/page";
	}
	
	
	
	

}
