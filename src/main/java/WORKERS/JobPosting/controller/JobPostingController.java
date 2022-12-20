package WORKERS.JobPosting.controller;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.servlet.ModelAndView;

import WORKERS.JobPosting.model.CompanyPosting;
import WORKERS.JobPosting.model.CompanyPostingImg;
import WORKERS.JobPosting.model.Pagination;
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
	/*
	 * public String JobPostingList(Model model) throws Exception { //리스트 뽑아오기 위해
	 * Service 호출 List<CompanyPosting> jobpostinglist =
	 * jobpostingservice.getJobPostingList();
	 * model.addAttribute("jobpostinglist",jobpostinglist); return
	 * "/jobPosting/jobPostingList"; }
	 */
	@RequestMapping(value = "list")
//	@GetMapping("/list")
	public ModelAndView AllListView(
            @RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage,
            @RequestParam(value = "cntPerPage", required = false, defaultValue = "10") int cntPerPage,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
            Map<String, Object> map, HttpServletRequest request) throws Exception {
        ModelAndView mav = new ModelAndView();
        
        int listCnt = jobpostingservice.testTableCount();
        Pagination pagination = new Pagination(currentPage, cntPerPage, pageSize);
        pagination.setTotalRecordCount(listCnt);
 
        mav.addObject("pagination",pagination);
        mav.addObject("AllList",jobpostingservice.SelectAllList(pagination));
        mav.setViewName("/jobPosting/jobPostingList");
        System.out.println(mav.toString());
        
        return mav;
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
		
		File dest = new File(fdir+"/"+file.getOriginalFilename());
		file.transferTo(dest);
		cpi.setCompanyImg(dest.getName());
			
		jobpostingservice.addJobPosting(companyposting);
		int i = jobpostingservice.findCno();		
		cpi.setCno(i);
		
		jobpostingservice.addJobPostingImg(cpi);	
		return "redirect:/jobposting/list";
	}
	
	//구인공고 삭제
	@GetMapping("/delete/{cno}")
	public String JobPostingDelete(@PathVariable int cno) throws Exception {
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
		
		return "/jobPosting/jobPostingView";
	}
	
	//구인공고 수정폼
	@GetMapping("/modifyForm/{cno}")
	public String JobPostingModifyForm(@PathVariable int cno, Model model) throws Exception {
		
		CompanyPosting cp = jobpostingservice.viewJobPosting(cno);
		model.addAttribute("cp",cp);
		
		return "/jobPosting/jobPostingModify";
	}
	
	//구인공고 수정
	@PostMapping("/modifyForm/modify/{cno}")
	public String JobPostingModify(@PathVariable int cno, @ModelAttribute CompanyPosting companyposting, @ModelAttribute CompanyPostingImg cpi,
									@RequestParam("newfile") MultipartFile file) throws Exception {
	
		jobpostingservice.modifyJobPosting(companyposting);
		File dest = new File(fdir+"/"+file.getOriginalFilename());
		file.transferTo(dest);
		
		cpi.setCompanyImg(dest.getName());		
		cpi.setCno(cno);

		jobpostingservice.modifyJobPostingImg(cpi);
		
		return "redirect:/jobposting/view/"+cno;
	}

}
