package WORKERS.mainPage.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import WORKERS.Boast.dto.MainBoastDTO;
import WORKERS.Boast.service.BoastService;
import WORKERS.JobPosting.service.JobPostingService;

@Controller
//@RequiredArgsConstructor
@RequestMapping("/main")
public class MainPageController {
	@Autowired
	private JobPostingService jobpostingservice;
	@Autowired
	private BoastService boastService;

	@GetMapping("/page")
	public String mainPageLoad(Model model)throws Exception{
		
		System.out.println("---------/main/Page-----------------");
		model.addAttribute("duelist",jobpostingservice.getJobPostingList());
		
		List<MainBoastDTO> mainBoastList = boastService.mainBoastListService();
		System.out.println("mainBoastList = " +mainBoastList);
	
		model.addAttribute("mainBoastList", mainBoastList);
		
		return "mainPage";
	}
}
