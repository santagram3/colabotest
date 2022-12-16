package WORKERS.JobPosting.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/jobs")
@Component
public class JobPostingController {
	
	
//구인공고 게시판 리스트 불러오기
	@GetMapping("/list")
		public String GetJobPostingList() {	
			System.out.println("GetJobPostingList");
			return "/jobs/jobPostingList";
		}
		
	
	
//구인공고 수정 화면 불러오기
	@GetMapping("/modify")
		public String GetJobPostinModify() {	
			System.out.println("GetJobPostinModify");
			return "/jobs/jobPostingModify";
			}
			
	
//구인공고 작성 화면 불러오기
	@GetMapping("/add")
		public String GetJobPostinAdd() {	
			System.out.println("GetJobPostinAdd");
			return "/jobs/jobPostingAdd";
			}
	
//구인공고 작성 화면 불러오기
	@GetMapping("/view")
		public String GetJobPostinView() {	
		System.out.println("GetJobPostinView");
		return "/jobs/jobPostingView";
				}
					
				

}
