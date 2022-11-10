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

	
	
	
	
	
	
	
	
	
	
	public String deleteNews(HttpServletRequest request) {
		int aid = Integer.parseInt(request.getParameter("aid"));
		try {
			dao.delNews(aid);
		} catch (SQLException e) {
			e.printStackTrace();
			ctx.log("뉴스 삭제 과정에서 문제 발생!!");
			request.setAttribute("error", "뉴스가 정상적으로 삭제되지 않았습니다!!");
			return listNews(request);
		}
		return "redirect:/news.nhn?action=listNews";
	}

	public String listNews(HttpServletRequest request) {
		List<News> list;
		try {
			list = dao.getAll();
			request.setAttribute("newslist", list);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("뉴스 목록 생성과정에서 문제발생!!!!!");
			request.setAttribute("error", "뉴스 목록이 정상적으로 처리되지 않았습니다!!");
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
			ctx.log("뉴스를 가져오는 과정에서 문제 발생!!");
			request.setAttribute("error", "뉴스를 정상적으로 가져오지 못했습니다!!");
		}

		return "/newsView.jsp";

	}

// multipart 헤더에서 파일이름 추출 
	private String getFilename(Part part) {
		String fileName = null;
		// 파일이름이 들어있는 헤더 영역을 가지고 옴
		String header = part.getHeader("content-disposition");
		// part.getHeader -> form-data; name="img"; filename="사진5.jpg"
		System.out.println("Header => " + header);

		// 파일 이름이 들어있는 속성 부분의 시작위치를 가져와 쌍따옴표 사이의 값 부분만 가지고옴
		int start = header.indexOf("filename=");
		fileName = header.substring(start + 10, header.length() - 1);
		ctx.log("파일명:" + fileName);
		return fileName;
	}

}
