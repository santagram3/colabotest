
package WORKERS.Boast.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import WORKERS.Boast.dto.BoastLikeDTO;
import WORKERS.Boast.model.Boast;
import WORKERS.Boast.model.BoastImage;
import WORKERS.Boast.model.BoastStar;
import WORKERS.Boast.model.Comments;
import WORKERS.Boast.repository.BoastMapper;
import WORKERS.JobPosting.model.Pagination;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BoastService {
	
	@Autowired
	private BoastMapper boastMapper;

	public List<Boast> boastList() throws Exception {
		List<Boast> bl = boastMapper.getBoastList();
		return bl;
	}
	
	public void addBoast(Boast boast) throws Exception {
		boastMapper.addBoast(boast);
	}
	
	public int findbNoSP() throws Exception {
		
		int i = boastMapper.findbNoSP();
		return i;
	}
	
	public void addBoastImg(BoastImage boastImg) throws Exception{
		boastMapper.addBoastImg(boastImg);		
	}

	public Boast viewBoast(int bNoSP) throws Exception {
		Boast boast = boastMapper.ViewBoast(bNoSP);
		return boast;
	}

	public void deleteBoast(int bNoSP) throws Exception {
		int bImageNoF = bNoSP;
		boastMapper.DeleteBoastImg(bImageNoF);
		boastMapper.DeleteBoast(bNoSP);
		
	}

	public void modifyBoast(Boast boast) throws Exception {
		boastMapper.ModifyBoast(boast);		
	}

	public void modifyBoastImg(BoastImage boastimage) throws Exception {
		boastMapper.ModifyBoastImg(boastimage);		
	}

	public BoastImage viewBoastImage(int bImageNoF) throws Exception {
		BoastImage b = boastMapper.ViewBoastImage(bImageNoF);
		return b;
	}

	public List<Comments> listComment(int aid) throws Exception {
		List<Comments> comments = boastMapper.ListComment(aid);
		return comments;
	}

	public void addBoastComment(Comments c) {
		boastMapper.AddBoastComment(c);
		
	}

	
	
	public List<Map<String, Object>> SelectAllList() throws Exception {
        return boastMapper.SelectAllList();
    }
 
    public List<Map<String, Object>> SelectAllList(Pagination pagination) throws Exception {
        return boastMapper.SelectAllList(pagination);
    }
 
    public int testTableCount() throws Exception {
        return boastMapper.testTableCount();
    }

	public void modifyBoastComment(Comments c) throws Exception {
		boastMapper.ModifyBoastComment(c);	
	}

	public int findbNoSP2(int commentAid)  throws Exception{
		int i = boastMapper.FindbNoSP2(commentAid);
		return i;
	}
	
	public void deleteBoastComment(int commentAid) throws Exception {		
		boastMapper.deleteBoastComment(commentAid);			
	}

	public void addBoastStar(BoastStar bs) throws Exception{
		boastMapper.AddBoastStar(bs);
	}

	public BoastStar getBoastStar(int bStarNoF) throws Exception{
		return boastMapper.GetBoastStar(bStarNoF);
	}

	public void modifyBoastStar(BoastStar boastStar) throws Exception{
		boastMapper.ModifyBoastStar(boastStar);		
	}
	
	
	// 좋아요 관련 메소드 
	public void likeUpService (BoastLikeDTO boastLikeDTO)throws Exception{
		// 좋아요 테이블에 값 넣기 서비스 
		System.out.println("=========likeUpService======");
		System.out.println("boastLikeDTO.getBNoSP() = " + boastLikeDTO.getBNoSP());
		System.out.println("boastLikeDTO.getClicker() = " + boastLikeDTO.getClicker());
		boastMapper.likeUp(boastLikeDTO);
		System.out.println("=========likeUpService======");
	}
	
	public void likeDownService (String userEmail)throws Exception{
		// 좋아요 테이블에 지우기 서비스 
		System.out.println("=========likeDownService======");
		System.out.println("userEmail = " + userEmail);
		boastMapper.likeDown(userEmail);
		System.out.println("=========likeDownService======");
	}
	
	// 이 글에 좋아요 한 사람들 리스트 가죠옴
	public List<String> likeListService(int bNoSP)throws Exception{
		System.out.println("=========likeListService ========");
		
		List<String> likeList = boastMapper.likeList(bNoSP);
		
		System.out.println("likeList = \n"+likeList);
		
		System.out.println("=========likeListService ========");
		
		return likeList;
	}
	
	// 이 글에 좋아요 한 사람들 수 뱉어내는 메소드 
	
	public int likeCount(int bNoSP) throws Exception{
		
		System.out.println("=========likeCountService ========");
		
		System.out.println("int bNoSP = " + bNoSP);
		int likeCount = boastMapper.likeCount(bNoSP);
		
		System.out.println("likeCount = " + likeCount);
		System.out.println("=========likeCountService ========");
	
		return likeCount;
	}
	
	
	
	
}
