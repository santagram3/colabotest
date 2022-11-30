package com.example.news;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServlet;

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

import oracle.net.aso.c;

@Controller
@RequestMapping("/news")
public class NewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private NewsDAO dao;

	// 이거 임포트 안되서 앞에 붙어버림
	private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${news.imgdir}")
	String fdir;
	
	@Autowired
	public NewsController(NewsDAO dao) {
		this.dao=dao;
	}

	@PostMapping("/add")
	public String addNews(@ModelAttribute News news , Model m ,@RequestParam("file") MultipartFile file  ) {
		
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
			news.setImg("/img/"+dest.getName()); // 이게 정답 .. 
			// 3번 
			//news.setImg("img/"+dest.getName());
			// 3번 
			//news.setImg("img/"+dest.getName());
			
			//news.setImg(fdir+dest.getName());
			System.out.println("fdir+dest.getName() : "+fdir+dest.getName());
			System.out.println("dest.getName() : "+ dest.getName());
			dao.addNews(news);
		
		} catch (Exception e) {
			System.out.println("\n==========3\n");
			e.printStackTrace();
			logger.info("뉴스 추가 과정에서 문제가 발생!");
			m.addAttribute("error","뉴스가 정상적으로 등록되지 않았습니다.");
		}
		return "redirect:/news/list";
		
	}


	@GetMapping("/list")
	public String listNews(Model m) {
			System.out.println("\n\n===================\n\n");
		try {
			List<News> newslist = dao.getAll();
			m.addAttribute("newslist",newslist);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("뉴스 불러오기 과정에서 문제가 발생!");
			m.addAttribute("error","뉴스가 정상적으로 불러오지 않았습니다.");
		}
		
		return "newsList";
	}

	@GetMapping("/getNews")
	   public String getNews(@RequestParam("aid") int aid, Model model, Model model1, Model  model2) {
		
		///getNews?aid=123
	      News n = null;
	      Comment c = null;
	      try {
	    	  //aid값을 조건으로 News테이블과 Comment테이블에서 데이터 가져오고 
	    	  //댓글은 리스트로 forEach 돌려서 띄울거니까 데이터들 List 배열로 담아서 commentlist에 저장
	         n = dao.getNews(aid);
	         c = dao.getComments(aid);
	         List<Comment> commentlist = dao.getAllComment(aid);
	         model2.addAttribute("commentlist",commentlist);
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      
	      model.addAttribute("news",n);			//news정보 news에 담음		-> news.title news.img라고 사용가능
	      model.addAttribute("comments",c);		//댓글 정보 comments에 담음
	      
	      return "newsView";

	   }
	
	@GetMapping("/delete/{aid}")
	   public String deleteNews(@PathVariable int aid, Model m) {
	      // localhost:8989/news/delete/
		System.out.println("123123");
	      try {
	         dao.delNews(aid);
	      }catch(SQLException e) {
	         e.printStackTrace();
	         logger.warn("뉴스 삭제 과정에서 문제 발생!!");
	         m.addAttribute("error","뉴스가 정상적으로 삭제되지 않았습니다!!");
	      }
	      return "redirect:/news/list";
	   }
	
	
	@GetMapping("/update/{aid}")
	   public String updatePage(@PathVariable int aid, Model m) throws SQLException {
			News news= dao.getNews(aid);
			
			m.addAttribute("news" ,news);			
	      return "newsUpdate";
	   }
	
	@PostMapping("/update/{aid}")
	public String updateNews(@PathVariable int aid, @ModelAttribute News news, @RequestParam("file") MultipartFile file) throws SQLException, IllegalStateException, IOException {
		String title = news.getTitle();
		String img = news.getImg();
		String content = news.getContent();
		File dest = new File(fdir+"/"+file.getOriginalFilename());
		System.out.println("fdir : "+ fdir);
		System.out.println("dest : "+ dest);
		// 파일 저장 
		file.transferTo(dest);
		img ="/img/"+dest.getName();
		try {			
			dao.updateNews(aid, title, img, content);
	      }catch(SQLException e) {
	         e.printStackTrace();
	         logger.warn("뉴스 수정 과정에서 문제 발생!!");
	      }
	      return "redirect:/news/list";
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
	return "redirect:/news/getNews?aid={aid}";
}
	
	@GetMapping("/deleteComment/{commentAid}")
	   public String deleteComments(@PathVariable int commentAid) throws SQLException {
		System.out.println("123123");
	      
	    	int i = dao.getAidInComments(commentAid);
	    	System.out.println("게시글번호: "+i);
	        dao.delComments(commentAid);
	     	        	      
	      return "redirect:/news/getNews?aid="+i;
	   }
	
	@PostMapping("updateComment/{commentAid}")
		public String updateComments(@PathVariable int commentAid, @ModelAttribute Comment comment) throws SQLException {
		
		String nickname = comment.getNickname();
		String commentContent = comment.getCommentContent();
		
		dao.updateComments(commentAid, nickname, commentContent);
		
		int i = dao.getAidInComments(commentAid);
		System.out.println("게시글번호: "+i);
		
		return "redirect:/news/getNews?aid="+i;
	}
	
}