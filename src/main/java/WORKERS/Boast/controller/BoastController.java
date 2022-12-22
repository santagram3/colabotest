package WORKERS.Boast.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

import WORKERS.Boast.model.Boast;
import WORKERS.Boast.model.BoastImage;
import WORKERS.Boast.model.BoastStar;
import WORKERS.Boast.model.Comments;
import WORKERS.Boast.service.BoastService;
import WORKERS.JobPosting.model.Pagination;
import WORKERS.mypage.model.User;
import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("/boast")
@RequiredArgsConstructor
public class BoastController {

	@Autowired
	private BoastService boastService;


	@Value("${boast.imgdir}")
	String fdir;
	
	@RequestMapping(value = "list")
	public ModelAndView AllListView(
            @RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage,
            @RequestParam(value = "cntPerPage", required = false, defaultValue = "10") int cntPerPage,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
            Map<String, Object> map, HttpServletRequest request) throws Exception {
        ModelAndView mav = new ModelAndView();
        
        int listCnt = boastService.testTableCount();
        Pagination pagination = new Pagination(currentPage, cntPerPage, pageSize);
        pagination.setTotalRecordCount(listCnt);
 
        mav.addObject("pagination",pagination);
        mav.addObject("AllList",boastService.SelectAllList(pagination));
        mav.setViewName("/boast/boastList");
        
        return mav;
	}
	
	@GetMapping("/addForm")
	public String BoastAddForm(HttpSession session, Model model) {	
		User sessionLoginUser = (User)session.getAttribute("loginUser");
		String loginUsernickName = sessionLoginUser.getNickName();
		model.addAttribute("loginUsernickName",loginUsernickName);
		return "/boast/boastAdd";
	}
	
		
	@PostMapping("/add")
	public String addBoast(@ModelAttribute Boast boast ,@ModelAttribute BoastImage boastImg, @ModelAttribute BoastStar bs,
						@RequestParam("file") MultipartFile file )throws Exception  {
		
			File dest = new File(fdir+"/"+file.getOriginalFilename());
			file.transferTo(dest);
			boastImg.setbImage(dest.getName());
			boastService.addBoast(boast);
			
			int i = boastService.findbNoSP();			
			boastImg.setbImageNoF(i);
			bs.setBStarNoF(i);
			
			boastService.addBoastStar(bs);
			boastService.addBoastImg(boastImg);	
			return "redirect:/boast/list";			

	}

	@GetMapping("/view/{bNoSP}")
	public String BoastView(@PathVariable int bNoSP, Model model, HttpSession session) throws Exception {
		
		Boast boast = boastService.viewBoast(bNoSP);
		int bImageNoF = bNoSP;
		int aid = bNoSP;
		System.out.println("bImageNoF: "+bImageNoF);
		BoastImage bi = boastService.viewBoastImage(bImageNoF);
		List<Comments> commentlist = boastService.listComment(aid);
		
		int bStarNoF = bNoSP;		
		BoastStar boaststar = boastService.getBoastStar(bStarNoF);
		System.out.println("boaststar: " + boaststar.toString());
		int bStar=boaststar.getBStar();
		model.addAttribute("bStar",bStar);
		
		User sessionLoginUser = (User)session.getAttribute("loginUser");
		String loginUsernickName = sessionLoginUser.getNickName();
		model.addAttribute("loginUsernickName",loginUsernickName);
		
		model.addAttribute("boast",boast);
		model.addAttribute("bi",bi);
		model.addAttribute("commentlist",commentlist);
		System.out.println(bi.getbImage());
		
		return "/boast/boastView";
	}
	
	
	@GetMapping("/delete/{bNoSP}")
	public String BoastDelete(@PathVariable int bNoSP) throws Exception {
		
		System.out.println("공부자랑 삭제");
		boastService.deleteBoast(bNoSP);
		
		return "redirect:/boast/list";
	}
	
	
	//공부자랑 수정폼
	@GetMapping("/modifyForm/{bNoSP}")
	public String BoastModifyForm(@PathVariable int bNoSP, Model model) throws Exception {
		
		Boast boast = boastService.viewBoast(bNoSP);		
		model.addAttribute("boast",boast);
		
		return "/boast/boastModify";
	}
	
	//공부자랑 수정
	@PostMapping("/modify/{bNoSP}")
	public String JobPostingModify(@PathVariable int bNoSP, @ModelAttribute Boast boast, @ModelAttribute BoastImage boastimage,
									@RequestParam("newfile") MultipartFile file) throws Exception {

		boastService.modifyBoast(boast);
		File dest = new File(fdir+"/"+file.getOriginalFilename());
		file.transferTo(dest);
		boastimage.setbImage(dest.getName());		
		boastimage.setbImageNoF(bNoSP);
		boastService.modifyBoastImg(boastimage);
		
		return "redirect:/boast/view/"+bNoSP;
	}
	
	
	@PostMapping("/addcomment/{bNoSP}")
	public String AddComment(@PathVariable int bNoSP, @ModelAttribute Comments c) {
		int aid = bNoSP;
		c.setAid(aid);
		System.out.println(c.toString());
		System.out.println(bNoSP);
		boastService.addBoastComment(c);
		
		return "redirect:/boast/view/"+bNoSP;
	}
	
	@PostMapping("/view/modcomment/{commentAid}")
	public String BoastCommentModify(@PathVariable int commentAid, @ModelAttribute Comments c) throws Exception {
		int bNoSP = boastService.findbNoSP2(commentAid);
		System.out.println("bNoSP: " +bNoSP);
		boastService.modifyBoastComment(c);
		
		return "redirect:/boast/view/"+bNoSP;
	}
	
	@GetMapping("/view/deleteComment/{commentAid}")
	public String BoastCommentDelete(@PathVariable int commentAid) throws Exception {
	int bNoSP=boastService.findbNoSP2(commentAid);

		System.out.println("2");
		boastService.deleteBoastComment(commentAid);	
		System.out.println("1");
		
		return "redirect:/boast/view/"+bNoSP;
	}
	
	
	@GetMapping("/addboaststar/{bNoSP}")
	public String AddStarBoast(@PathVariable int bNoSP, BoastStar boastStar) throws Exception {
		// 1 . 글 번호 가져옴 
		int bStarNoF = bNoSP;
		// 2. 글 번호로 > 좋아요 목록 가져옴 
		
		boastStar = boastService.getBoastStar(bStarNoF);
		int bStar = boastStar.getBStar()+1;
		
		boastStar.setBStarNoF(bStarNoF);
		boastStar.setBStar(bStar);
		
		boastService.modifyBoastStar(boastStar);
		
		return "redirect:/boast/view/"+bNoSP;
	}
	

}
