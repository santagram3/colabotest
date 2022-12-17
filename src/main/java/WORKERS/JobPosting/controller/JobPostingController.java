package WORKERS.JobPosting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
		//List<CompanyPosting> jobpostinglist = null;
		
		//리스트 뽑아오기 위해 Service 호출
		List<CompanyPosting> jobpostinglist = jobpostingservice.getJobPostingList();
		System.out.println("1");
		model.addAttribute("jobpostinglist",jobpostinglist);
		System.out.println(jobpostinglist.toString());
		return "/jobPosting/jobPostingList";
	}
	
	//구인공고 작성 화면 불러오기
		@GetMapping("/add")
			public String GetJobPostinAdd() {	
				System.out.println("GetJobPostinAdd");
				return "/jobPosting/jobPostingAdd";
				}
		
		//구인공고 뷰 화면 불러오기
		@GetMapping("/view")
			public String GetJobPostingView() {	
				System.out.println("GetJobPostinView");
				return "/jobPosting/jobPostingView";
				}
		
		//구인공고 수정 화면 불러오기
		@GetMapping("/modify")
			public String GetJobPostigModify() {	
				System.out.println("GetJobPostigModify");
				return "/jobPosting/jobPostingModify";
				}
	
	//구인공고 등록
	@PostMapping("/add")
	public String JobPostingAdd(@ModelAttribute CompanyPosting companyposting) throws Exception {
		System.out.println("구인공고를 등록");
		
		jobpostingservice.addJobPosting();
		
		return "redirect:/jobposting/list";
	}

}
