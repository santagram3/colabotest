package com.example.news;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
		
		try {
			// 저장 파일 객체 생성 
			File dest = new File(fdir+"/"+file.getOriginalFilename());
			System.out.println("dest : "+ dest);
			// 파일 저장 
			file.transferTo(dest);
			
			// news /객체에 파일 이름 저장 
			news.setImg(dest.getName());
			System.out.println("dest.getName() : "+ dest.getName());
			dao.addNews(news);
		
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("뉴스 추가 과정에서 문제가 발생!");
			m.addAttribute("error","뉴스가 정상적으로 등록되지 않았습니다.");
		}
		return "redirect:/newsList";
		
	}


	@GetMapping("/list")
	public String listNews(Model m) {
		
		try {
			List<News> newslist = dao.getAll();
			m.addAttribute("newslist",newslist);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("뉴스 불러오기 과정에서 문제가 발생!");
			m.addAttribute("error","뉴스가 정상적으로 불러오지 않았습니다.");
		}
		
		return "/newsList.jsp";
	}

	public String getNews(HttpServletRequest request) {
		int aid = Integer.parseInt(request.getParameter("aid"));
		try {
			News n = dao.getNews(aid);
			request.setAttribute("news", n);
		} catch (SQLException e) {
			e.printStackTrace();
			
			request.setAttribute("error", "뉴스를 정상적으로 가져오지 못했습니다!!");
		}

		return "/newsView.jsp";

	}



}
