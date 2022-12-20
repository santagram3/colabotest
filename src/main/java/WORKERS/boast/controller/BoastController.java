package WORKERS.boast.controller;

import java.io.File;
import java.util.List;

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

import WORKERS.boast.model.Boast;
import WORKERS.boast.model.BoastImage;
import WORKERS.boast.service.BoastService;
import WORKERS.comment.Comment;
import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("/boast")
@RequiredArgsConstructor
public class BoastController {

	@Autowired
	private BoastService boastService;


	@Value("${boast.imgdir}")
	String fdir;
	
	@GetMapping("/list")
	public String listBoast(Model m) throws Exception {
		
		List<Boast> boastlist = boastService.boastList();
		m.addAttribute("boastlist",boastlist);
		
		List<Comment> commentAll = boastService.boastCommentList(); 
		m.addAttribute("commentAll",commentAll);
		
		
		return "/boast/boastList"; //boastList jsp를 의미
	}
	
	@GetMapping("/addForm")
	public String BoastAddForm() {		
		return "/boast/boastAdd";
	}
	
		
	@PostMapping("/add")
	public String addBoast(@ModelAttribute Boast boast ,@ModelAttribute BoastImage boastImg ,
			@RequestParam("file") MultipartFile file )throws Exception  {
		
			File dest = new File(fdir+"/"+file.getOriginalFilename());
			file.transferTo(dest);
			boastImg.setbImage(dest.getName());
			boastService.addBoast(boast);
			
			int i = boastService.findbNoSP();			
			boastImg.setbImageNoF(i);
		
			
			boastService.addBoastImg(boastImg);	
			return "redirect:/boast/list";			

	}

	@GetMapping("/view/{bNoSP}")
	public String BoastView(@PathVariable int bNoSP,@PathVariable int aid, @ModelAttribute Comment comment,
			Model model) throws Exception {
		
		Boast boast = boastService.viewBoast(bNoSP);
		int bImageNoF = bNoSP;
		System.out.println("bImageNoF: "+bImageNoF);
		BoastImage bi = boastService.viewBoastImg(bImageNoF);
		
		int aid = bNoSP;
		Comment commentlist = boastService.viewBoastComment(aid);
		
		boastService.addBoastComment(comment);
		model.addAtrribuSte("commentlist",commentlist);
		
		model.addAttribute("boast",boast);
		model.addAttribute("bi",bi);
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

}