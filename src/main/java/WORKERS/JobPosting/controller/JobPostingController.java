package WORKERS.JobPosting.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import WORKERS.JobPosting.model.CompanyPosting;
import WORKERS.JobPosting.model.CompanyPostingImg;
import WORKERS.JobPosting.service.JobPostingService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/jobposting")
@RequiredArgsConstructor
@ComponentScan(basePackages = {"WORKERS.JobPosting.service.JobPostingService.jobPostingList()"})
public class JobPostingController {
	
	@Value("${companyposting.imgdir}")
	String fdir;
	
	//구인공고 서비스 호출
	@Autowired
	private JobPostingService jobpostingservice;// = new JobPostingService();
	
	//구인공고 리스트
	@GetMapping("/list")
	public String JobPostingList(Model model) throws Exception {
		System.out.println("구인공고 리스트");
		
		//리스트 뽑아오기 위해 Service 호출
		List<CompanyPosting> jobpostinglist = jobpostingservice.getJobPostingList();
		System.out.println("1");
		model.addAttribute("jobpostinglist",jobpostinglist);
		System.out.println(jobpostinglist.toString());
		return "/jobPosting/jobPostingList";
	}
	
	
	//구인공고 등록폼
	@GetMapping("/addForm")
	public String JobPostingAddForm() {		
		return "/jobPosting/jobPostingAdd";
	}
	
	//구인공고 등록
	@PostMapping("/add")
	public String JobPostingAdd(@ModelAttribute CompanyPosting companyposting, @ModelAttribute CompanyPostingImg cpi,
								@RequestParam("file") MultipartFile file) throws Exception {
		System.out.println("구인공고를 등록");
		File dest = new File(fdir+"/"+file.getOriginalFilename());
		file.transferTo(dest);
		cpi.setCompanyImg("/img/"+dest.getName());
		
		
		jobpostingservice.addJobPosting(companyposting);
		int i = jobpostingservice.findCno();
		System.out.println("i: "+i);
		
		cpi.setCno(i);
		System.out.println(cpi.getCno());
		
		jobpostingservice.addJobPostingImg(cpi);
		System.out.println(companyposting.toString());
		
		
		return "redirect:/jobposting/list";
	}
	
	//구인공고 삭제
	@GetMapping("/delete/{cno}")
	public String JobPostingDelete(@PathVariable int cno) throws Exception {
		System.out.println("구인공고를 삭제");
		jobpostingservice.deleteJobPosting(cno);
		
		return "redirect:/jobposting/list";
	}
	
	//구인공고 상세정보
	@GetMapping("/view/{cno}")
	public String JobPostingView(@PathVariable int cno, Model model) throws Exception {
		CompanyPosting cp = jobpostingservice.viewJobPosting(cno);
		CompanyPostingImg cpi = jobpostingservice.viewJobPostingImg(cno);
		model.addAttribute("cp",cp);
		model.addAttribute("cpi",cpi);
		System.out.println(cp.toString());
		System.out.println(cpi.getCompanyImg());
		
		return "/jobPosting/jobPostingView";
	}
	
	//구인공고 수정폼
	@GetMapping("/modifyForm/{cno}")
	public String JobPostingModifyForm(@PathVariable int cno, Model model) throws Exception {
		CompanyPosting cp = jobpostingservice.viewJobPosting(cno);
		model.addAttribute("cp",cp);
		System.out.println(cp.toString());
		
		return "/jobPosting/jobPostingModify";
	}
	
	//구인공고 수정
	@PostMapping("/modifyForm/modify/{cno}")
	public String JobPostingModify(@PathVariable int cno, @ModelAttribute CompanyPosting companyposting) throws Exception {
		jobpostingservice.modifyJobPosting(companyposting);
		
		return "redirect:/jobposting/view/"+cno;
	}

}
