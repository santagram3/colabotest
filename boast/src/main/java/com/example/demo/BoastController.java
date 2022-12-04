package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

//import javax.servlet.http.HttpServlet;

import org.slf4j.LoggerFactory;
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

//import oracle.net.aso.c;

@Controller
@RequestMapping("/boast")
public class BoastController {

	private BoastDAO dao;


	// 이거 임포트 안되서 앞에 붙어버림
	private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${boast.imgdir}")
	String fdir;
	
	@Autowired
	public BoastController(BoastDAO dao) {
		this.dao=dao;
	}

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
			boast.setbImage("/img/"+dest.getName()); // 이게 정답 .. 
			// 3번 
			//news.setImg("img/"+dest.getName());
			// 3번 
			//news.setImg("img/"+dest.getName());
			
			//news.setImg(fdir+dest.getName());
			System.out.println("fdir+dest.getName() : "+fdir+dest.getName());
			System.out.println("dest.getName() : "+ dest.getName());
			dao.addBoast(boast);
		
		} catch (Exception e) {
			System.out.println("\n==========3\n");
			e.printStackTrace();
			logger.info("자랑글 추가 과정에서 문제가 발생!");
			m.addAttribute("error","자랑글이 정상적으로 등록되지 않았습니다.");
		}
		return "redirect:/boast/list";
		
	}


	@GetMapping("/list")
	public String listBoast(Model m) {
			System.out.println("\n\n===================\n\n");
		try {
			List<Boast> boastlist = dao.getAll();
			m.addAttribute("boastlist",boastlist);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("자랑글 불러오기 과정에서 문제가 발생!");
			m.addAttribute("error","자랑글이 정상적으로 불러오지 않았습니다.");
		}
		
		return "boastList";//boastList jsp를 의미
	}

	@GetMapping("/getBoast")
	   public String getBoast(@RequestParam("aid") int aid, Model model, Model model1, Model  model2) {
		
		//getNews?aid=123
	      Boast b = null;
	      Comment c = null;
	      try {
	    	  //aid값을 조건으로 News테이블과 Comment테이블에서 데이터 가져오고 
	    	  //댓글은 리스트로 forEach 돌려서 띄울거니까 데이터들 List 배열로 담아서 commentlist에 저장
	         b = dao.getBoast(aid);
	         c = dao.getComments(aid);
	         List<Comment> commentlist = dao.getAllComment(aid);
	         model2.addAttribute("commentlist",commentlist);
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      
	      model.addAttribute("boast",b);			//news정보 news에 담음		-> news.title news.img라고 사용가능
	      model.addAttribute("comments",c);		//댓글 정보 comments에 담음
	      
	      return "boastView";

	   }

	
	@GetMapping("/delete/{bNoSP}")
	   public String deleteBoast(@PathVariable int bNoSP, Model m) {
	      // localhost:8989/news/delete/
		System.out.println("123123");
	      try {
	         dao.delBoast(bNoSP);
	      }catch(SQLException e) {
	         e.printStackTrace();
	         logger.warn("글 삭제 과정에서 문제 발생!!");
	         m.addAttribute("error","글이 정상적으로 삭제되지 않았습니다!!");
	      }
	      return "redirect:/b/list";
	   }
	
	
	@GetMapping("/update/{bNoSP}")
	   public String updatePage(@PathVariable int bNoSP, Model m) throws SQLException {
			Boast boast= dao.getBoast(bNoSP);
			
			m.addAttribute("boast" ,boast);			
	      return "boastUpdate";
	   }
	
	@PostMapping("/update/{bNoSP}")
	public String updateNews(@PathVariable int bNoSP, @ModelAttribute Boast boast, @RequestParam("file") MultipartFile file) throws SQLException, IllegalStateException, IOException {
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
	