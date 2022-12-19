package WORKERS.mainPage.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
//@RequiredArgsConstructor
@RequestMapping("/main")
public class MainPageController {

	@GetMapping("/page")
	public String mainPageLoad()throws Exception{
		
		System.out.println("---------/main/Page-----------------");
		
		return "/mainPage";
	}
}
