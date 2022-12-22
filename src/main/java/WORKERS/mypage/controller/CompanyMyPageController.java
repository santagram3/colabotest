package WORKERS.mypage.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import WORKERS.JobPosting.service.JobPostingService;
import WORKERS.mypage.DTO.CompanyMyPageDTO;
import WORKERS.mypage.DTO.cnoListDTO;
import WORKERS.mypage.model.CompanyUser;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/companymypage")
@RequiredArgsConstructor
public class CompanyMyPageController {
	
	@Autowired
	private JobPostingService jobpostingservice;
	
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
	

}
