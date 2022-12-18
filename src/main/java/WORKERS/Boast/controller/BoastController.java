package WORKERS.Boast.controller;

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

import WORKERS.Boast.dto.BoastDTO;
import WORKERS.Boast.model.Boast;
import WORKERS.Boast.service.BoastService;
import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("/boast")
@RequiredArgsConstructor
public class BoastController {

	@Autowired
	private BoastService boastService;


	@Value("${boast.imgdir}")
	String fdir;
	
	@PostMapping("/add")
	public String addBoast(@ModelAttribute Boast boast , Model m ,@RequestParam("file") MultipartFile file  ) {
		
		System.out.println("\n==========1\n");
		try {
			// 저장 파일 객체 생성 
			File dest = new File(fdir+"/"+file.getOriginalFilename());
			System.out.println("fdir : "+ fdir);
			System.out.println("dest : "+ dest);
			// 파일 저장 
			file.transferTo(dest);
			System.out.println("\n==========2\n");
			// news /객체에 파일 이름 저장 
			// 1번 
			//news.setImg(fdir+dest.getName());
			// 2번 
		//	boast.setbImage("/img/"+dest.getName()); // 이게 정답 .. 
			// 3번 
			//news.setImg("img/"+dest.getName());
			// 3번 
			//news.setImg("img/"+dest.getName());
			
			//news.setImg(fdir+dest.getName());
			System.out.println("fdir+dest.getName() : "+fdir+dest.getName());
			System.out.println("dest.getName() : "+ dest.getName());
		//	boastMapper.BoastMapper(boast);

		} catch (Exception e) {
			System.out.println("\n==========3\n");
			e.printStackTrace();
			m.addAttribute("error","자랑글이 정상적으로 등록되지 않았습니다.");
		}
		return "redirect:/boast/list";
		
	}


	@GetMapping("/list")
	public String listBoast(Model m) throws Exception {

			List<Boast> boastlist = boastService.boastList();
			m.addAttribute("boastlist",boastlist);
					
		return "/boast/boastList"; //boastList jsp를 의미
	}

	@GetMapping("/view/{bNoSP}")
	public String BoastView(@PathVariable int bNoSP, Model model) throws Exception {
		Boast boast = boastService.viewBoast(bNoSP);
		model.addAttribute("boast",boast);
		
		return "/boast/boastView";
	}
	
	
	@GetMapping("/delete/{bNoSP}")
	public String BoastDelete(@PathVariable int bNoSP) throws Exception {
		System.out.println("공부자랑 삭제");
		boastService.deleteBoast(bNoSP);
		
		return "redirect:/boast/list";
	}
	
}
	
/*
	
	@GetMapping("/modify/{bNoSP}")
	   public String updatePage(@PathVariable int bNoSP, Model m) throws SQLException {
			BoastDTO boast= dao.getBoast(bNoSP);
			
			m.addAttribute("boast" ,boast);			
	      return "boastModify";
	   }
	
	@PostMapping("/modify/{bNoSP}")
	public String updateBoast(@PathVariable int bNoSP, @ModelAttribute BoastDTO boast, @RequestParam("file") MultipartFile file) throws SQLException, IllegalStateException, IOException {
		String bTitle = boast.getbTitle();
		String bImage = boast.getbImage();
		String bContent = boast.getbContent();
		File dest = new File(fdir+"/"+file.getOriginalFilename());
		System.out.println("fdir : "+ fdir);
		System.out.println("dest : "+ dest);
		// 파일 저장 
		file.transferTo(dest);
		bImage ="/img/"+dest.getName();
		try {			
			dao.updateBoast(bNoSP, bTitle, bImage, bContent);
	      }catch(SQLException e) {
	         e.printStackTrace();
	         logger.warn("글 수정 과정에서 문제 발생!!");
	      }
	      return "redirect:/boast/list";
	}

	
		
	@PostMapping("/addcomment/{aid}")
	public String addComment(@PathVariable int aid, @ModelAttribute Comment comment) {
		//입력한 get~값들을 String으로 변환 -> dao에 보낼때 이쁘게 보내려고
		String nickname = comment.getNickname();
		String commentContent = comment.getCommentContent();
		//데이터가 잘 담겼는지 확인
		System.out.println("닉네임: "+nickname);
		System.out.println("댓글 내용: "+commentContent);
		try {
			dao.addCom(aid, nickname, commentContent);
		}catch(Exception e) {
			e.printStackTrace();
	         logger.warn("댓글 등록 과정에서 문제 발생!!");
		}
	//댓글 추가하고 원래 있던 페이지 게시글 번호로 리턴
	return "redirect:/boast/getBoast?aid={aid}";
}
	
	@GetMapping("/deleteComment/{commentAid}")
	   public String deleteComments(@PathVariable int commentAid) throws SQLException {
		System.out.println("123123");
	      
	    	int i = dao.getAidInComments(commentAid);
	    	System.out.println("게시글번호: "+i);
	        dao.delComments(commentAid);
	     	        	      
	      return "redirect:/boast/getBoast?aid="+i;
	   }
	
	@PostMapping("updateComment/{commentAid}")
		public String updateComments(@PathVariable int commentAid, @ModelAttribute Comment comment) throws SQLException {
		
		String nickname = comment.getNickname();
		String commentContent = comment.getCommentContent();
		
		dao.updateComments(commentAid, nickname, commentContent);
		
		int i = dao.getAidInComments(commentAid);
		System.out.println("게시글번호: "+i);
		
		return "redirect:/boast/getBoast?aid="+i;
	}
	
}
*/