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

import WORKERS.Boast.dto.BoastLikeDTO;
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
		System.out.println("bImageNoF: " + bImageNoF);
		BoastImage bi = boastService.viewBoastImage(bImageNoF);
		List<Comments> commentlist = boastService.listComment(aid);

		int bStarNoF = bNoSP;
		BoastStar boaststar = boastService.getBoastStar(bStarNoF);
		System.out.println("boaststar: " + boaststar.toString());

		User sessionLoginUser = (User) session.getAttribute("loginUser");
		String loginUsernickName = sessionLoginUser.getNickName();
		model.addAttribute("loginUsernickName", loginUsernickName);

		model.addAttribute("boast", boast);
		model.addAttribute("bi", bi);
		model.addAttribute("commentlist", commentlist);
		System.out.println(bi.getbImage());

		// 좋아요 갯수
		// bNoSP
		int likeCount = boastService.likeCount(bNoSP);

		model.addAttribute("likeCount", likeCount);

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
		int bStar = boastStar.getBStar() + 1;

		boastStar.setBStarNoF(bStarNoF);
		boastStar.setBStar(bStar);

		boastService.modifyBoastStar(boastStar);

		return "redirect:/boast/view/" + bNoSP;
	}

	// 좋아요
	@GetMapping("/like/{bNoSP}")
	public String boastLike(@PathVariable int bNoSP, HttpSession session) throws Exception {

		System.out.println("/like1");

		// 1. @PathVariable로 글 번호 가져옴 bNoSP

		// 2. session 으로 좋아요 누른 사람 정보 가져옴 !
		User user = (User) session.getAttribute("loginUser");
		System.out.println("/like2");
		// 3. 글 번호 bNoSP로 리스트 가져옴
		List<String> likeList = boastService.likeListService(bNoSP);
		//System.out.println(likeList==null);
		//System.out.println(likeList.size());
		System.out.println("/like3");
		// 4. 누른 사람 정보 가져온 후 거기서 이메일 정보 가져오고 , 그걸 clicker 로 치환함
		String clicker = user.getUserEmail();
		System.out.println("/like4");
		// 좌우 공백 제거
		clicker.trim();
		// 5. BoastLikeDTO 객체 만듬
		BoastLikeDTO boastLikeDTO = new BoastLikeDTO();
		System.out.println("/like5");
		// 번호 세팅
		boastLikeDTO.setBNoSP(bNoSP);
		// 이메일 세팅
		boastLikeDTO.setClicker(clicker);
		System.out.println("/like6");
		if (likeList.size() < 1) {
			System.out.println("likeList ~ Null");
			// 리스트가 길이가 0 이라면 ? > 좋아요 아무도 안누른 상태니까.. 그냥 좋아요 해주자 
			boastService.likeUpService(boastLikeDTO);
		} else {
			System.out.println("likeList ~ NotNull");
			// 리스트가 존재한다는건 좋아요가 1 이라도 있는 상태 // 그러니까 판단을 해야됨 
			for (String email : likeList) {
				System.out.println("/like7");
				if (!clicker.equals(email.trim())) {
					System.out.println("/like8");
					// 좋아요 안눌렀다면 ? // 좋아요 처리 // 사람을 추가
					boastService.likeUpService(boastLikeDTO);
				} else {
					System.out.println("/like9");
					// 좋아요 눌렀다면 ? // 다시 숫자 떨어지는 처리 // 사람을 지움
					boastService.likeDownService(clicker);
				}

			}

		}
		System.out.println("/like10");
		return "redirect:/boast/view/" + bNoSP;
	}
	

}
