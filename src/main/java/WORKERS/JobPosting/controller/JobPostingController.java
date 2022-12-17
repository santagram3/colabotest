package WORKERS.JobPosting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import WORKERS.JobPosting.service.JobPostingService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/jobposting")
@RequiredArgsConstructor
@ComponentScan(basePackages = {"WORKERS.JobPosting.service.JobPostingService.jobPostingList()"})
public class JobPostingController {
	
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
	
	
	//구인공고 등록
	@GetMapping("/addForm")
	public String JobPostingAddForm() {		
		return "/jobPosting/jobPostingAdd";
	}
	

	@PostMapping("/add")
	public String JobPostingAdd(@ModelAttribute CompanyPosting companyposting) throws Exception {
		System.out.println("구인공고를 등록");
//		companyposting.getcDueDate();
		jobpostingservice.addJobPosting(companyposting);
		System.out.println(companyposting.toString());
		
		
		return "redirect:/jobposting/list";
	}
	
	@GetMapping("/delete/{cno}")
	public String JobPostingDelete(@PathVariable int cno) throws Exception {
		jobpostingservice.deleteJobPosting(cno);
		
		return "redirect:/jobposting/list";
	}
	
	
	@GetMapping("/view/{cno}")
	public String JobPostingView(@PathVariable int cno, Model model) throws Exception {
		CompanyPosting cp = jobpostingservice.viewJobPosting(cno);
		model.addAttribute("cp",cp);
		System.out.println(cp.toString());
		
		return "/jobPosting/jobPostingView";
	}

}
