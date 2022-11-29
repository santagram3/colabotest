package WORKERS.newsExample;

import java.io.File;
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

@Controller
@RequestMapping("/news")
public class NewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private NewsDAO dao;

	// 이거 임포트 안되서 앞에 붙어버림
	private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
	//application.properties 에서 news.imgdir 를 가져오려면 
	// @Value 어노테이션으로 가져온다 
	@Value("${news.imgdir}")
	String fdir;
	
	@Autowired
	public NewsController(NewsDAO dao) {
		this.dao=dao;
	}

	@PostMapping("/add")
	public String addNews(@ModelAttribute News news , Model m ,@RequestParam("file") MultipartFile file) {
		// 애초에 디비에서 사진은 무조건 넣어야 되기 때문에 꼭 넣어줘야 한다 
		System.out.println("Controller - add");
		
		System.out.println("news.getTitle() : "+news.getTitle());
		System.out.println("news.getImg() : "+news.getImg());
		System.out.println("news.getContent() :"+news.getContent());
		System.out.println("file = " + file);
		
		try {
			// 저장 파일 객체 생성 
			File dest = new File(fdir + "/"+file.getOriginalFilename());
			System.out.println("dest : " + dest);
		
			// 파일 저장 // 내가 지정한 곳에 저장 
			file.transferTo(dest);
			System.out.println("=========1");
			// 뉴스 이미지 경로 변경 
		
			news.setImg("/img/"+dest.getName()); // 이게 정답 ..
			System.out.println("=========2");
			//다오에서 .addNews메서드에 news를 넣어줌  
			dao.addNews(news);
			System.out.println("=========3");
		
		} catch (Exception e) {
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
		
		return "/newsExample/newsList";
	}

	@GetMapping("/getNews")
	   public String getNews(@RequestParam("aid") int aid, Model model) {
		
		///getNews?aid=123
	      News n = null;
	      try {
	    	  // 받아온 숫자로 뉴스를 추출해옴 
	         n = dao.getNews(aid);
	         System.out.println("\n\n\n");
	         System.out.println("aid : " + aid);
	         System.out.println(n.getImg());
	         System.out.println(n.getContent());
	         System.out.println(n.getTitle());
	         System.out.println("\n\n\n");
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      // 추출해온 n 을 모델에 news 라는 이름으로 담아서 줌 ! 
	      
	      model.addAttribute("news",n);
	      
	      return "newsExample/newsView";

	   }
	
	@GetMapping("/delete/{aid}")
	   public String deleteNews(@PathVariable int aid, Model m) {
	      // localhost:8989/news/delete/123
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
	
	@GetMapping("/modify/{aid}")
	   public String getModify(@PathVariable int aid, Model m) throws SQLException {
		System.out.println("modify/{aid} : "+aid);
		//news/modify/{aid}
		// 받아온 번호로 수정할 정보를 받아온다 !
		News news = dao.getNews(aid);
	     
	     m.addAttribute("news",news);
	      // 수정할 jsp 에 수정 하고싶은 정보를 담아서 준다 ! 
	      return "newsExample/newsModify"; 

	   }
	
	@PostMapping("/modify/{aid}")
	public String modifyNews(@PathVariable int aid, @ModelAttribute News news , Model m ,@RequestParam("file") MultipartFile file ) throws SQLException {
		// 이미 지금 들어올 때부터 사진이 필수 이기 때문에 만약 사진을 수정 하고싶다면 ? 
			
		System.out.println("Controller - modify");
		System.out.println(news.getTitle());
		System.out.println(news.getImg()); // 지금 이게 널이거든 ? 
		System.out.println(news.getContent());
		
		try {
			// 저장 파일 객체 생성 
			File dest = new File(fdir+"/"+file.getOriginalFilename());
			System.out.println("dest : " + dest);
			// 파일 저장 // 내가 지정한 곳에 저장 
			file.transferTo(dest);
			// 뉴스 이미지 경로 변경 
			news.setImg("/img/"+dest.getName()); // 이게 정답 .. 
			
			// 수정하기 
			dao.ModifyNews(news);
		
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("뉴스 수정 과정에서 문제가 발생!");
			m.addAttribute("error","뉴스가 정상적으로 수정되지 않았습니다.");
		}
		return "redirect:/news/list";
		
	}
	
	
	


}
