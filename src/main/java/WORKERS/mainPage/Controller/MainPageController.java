package WORKERS.mainPage.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import WORKERS.JobPosting.service.JobPostingService;

@Controller
//@RequiredArgsConstructor
@RequestMapping("/main")
public class MainPageController {
	@Autowired
	private JobPostingService jobpostingservice;

	@GetMapping("/page")
	public String mainPageLoad(Model model)throws Exception{
		
		System.out.println("---------/main/Page-----------------");
		model.addAttribute("duelist",jobpostingservice.getJobPostingList());
		
		return "mainPage";
	}
}
