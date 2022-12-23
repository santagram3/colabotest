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

import WORKERS.JobPosting.service.JobPostingService;
import WORKERS.mypage.DTO.CompanyMyPageDTO;
import WORKERS.mypage.DTO.cnoListDTO;
import WORKERS.mypage.model.CompanyUser;
import WORKERS.mypage.service.CompanyService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/companymypage")
@RequiredArgsConstructor
public class CompanyMyPageController {
	
	@Autowired
	private JobPostingService jobpostingservice;
	@Autowired	
	private CompanyService companyService;
	
	@GetMapping("/companyinfo2")
	public String myInfo2(HttpSession session, Model model) throws Exception{
		//session으로부터 cWriter에 기업이름을 담았음
		CompanyUser sessionLoginCompanyUser = (CompanyUser)session.getAttribute("loginCompanyUser");
		String cWriter = sessionLoginCompanyUser.getCompanyName();
		
		List<cnoListDTO> clDTO = jobpostingservice.getcnoList(cWriter);
		int size = clDTO.size();
		System.out.println(clDTO);
		
		ArrayList<CompanyMyPageDTO> CompanyMyPageDTOs = new ArrayList<>();
		
		for (int i = 0; i <size; i++) {
			cnoListDTO cnolistdto = clDTO.get(i);
			
			CompanyMyPageDTO companyMyPageDTO = new CompanyMyPageDTO();
			int cno = cnolistdto.getCnos();
			
			companyMyPageDTO.setCno(cno);		//cno
			companyMyPageDTO.setCTitle(jobpostingservice.getcTitleFrom(cno));
			companyMyPageDTO.setCDueDate(jobpostingservice.getcDueDateFrom(cno));
			companyMyPageDTO.setCompanyImg(jobpostingservice.getCompanyImgFrom(cno));
			
			CompanyMyPageDTOs.add(companyMyPageDTO);
		}
		System.out.println("CompanyMyPageDTOs: "+CompanyMyPageDTOs.toString());
		model.addAttribute("CompanyMyPageDTOs",CompanyMyPageDTOs);

		return "/mypage/CompanymypageInfo2";
	}
	
	
	// 로그인 기업 정보 !! 
		@GetMapping("/companyinfo")
		public String myCompanyInfo(HttpSession session,Model model) throws Exception{
			System.out.println("/companymypage/companyinfo");
			// 세션에서 받아온 로그인 기업정보 
			CompanyUser sessionLoginCompany = (CompanyUser)session.getAttribute("loginCompanyUser");
			System.out.println("sessionLoginCompany:" +sessionLoginCompany);

			// 세션에서 받아온 로그인에서 기업이메일 가져옴 
			String loginCompanyEmail = sessionLoginCompany.getCompanyEmail();
			System.out.println("loginCompanyEmail:" +loginCompanyEmail);
			// 그걸 앞 뒤 공백 다 자름 
			loginCompanyEmail.trim();
			
			// 받아온 이메일로 사람 정보 찾아서 가져옴 ! 
			CompanyUser loginCompanyInfo = companyService.findCompanyUserService(loginCompanyEmail);
			
			model.addAttribute("loginCompanyInfo",loginCompanyInfo);
			
			
			return "/mypage/CompanymypageInfo";
		}
		
		
		
		@PostMapping("/modifycompanyinfo/{companyEmail}")
		public String CompanyModifyInfo(HttpSession session,@PathVariable String companyEmail,
				@ModelAttribute CompanyUser companyuser, Model model) throws Exception {
			System.out.println("기업회원 마이페이지 수정을 시작");
			System.out.println(companyuser.toString());
			companyService.modifyCompanyInfo(companyuser);

			CompanyUser sessionLoginCompany = (CompanyUser)session.getAttribute("loginCompanyUser");		
			String loginCompanyEmail = sessionLoginCompany.getCompanyEmail();		
			loginCompanyEmail.trim();

			CompanyUser loginCompanyInfo = companyService.findCompanyUserService(loginCompanyEmail);		
			model.addAttribute("loginCompanyInfo",loginCompanyInfo);
			
			model.addAttribute("duelist",jobpostingservice.getJobPostingList());
			
			return "/mypage/CompanymypageInfo";
		}
		
		@PostMapping("/deletecompanyinfo/{companyEmail}")
		public String CompanyDelete(HttpSession session, @PathVariable String companyEmail, @ModelAttribute CompanyUser companyuser, Model model) throws Exception{
			System.out.println("companyEmail: "+companyuser.getCompanyEmail());
			System.out.println("companyuser: "+companyuser.toString());
			
			CompanyUser sessionLoginCompany = (CompanyUser)session.getAttribute("loginCompanyUser");
			if(companyuser.getCompanyPwd().equals(sessionLoginCompany.getCompanyPwd()))
				companyService.deleteCompanyUser(companyuser);
			System.out.println("삭제완료");
			
	        session.removeAttribute("loginCompanyUser"); // loginUser 라는 내용을 세션에서 삭제
	        session.invalidate(); // 세션 객체 삭제
	        
	        model.addAttribute("duelist",jobpostingservice.getJobPostingList());
	  
			return "redirect:/main/page";
		}
	

}
