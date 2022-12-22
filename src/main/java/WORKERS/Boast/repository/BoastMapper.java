package WORKERS.Boast.repository;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import WORKERS.Boast.dto.BoastLikeDTO;
import WORKERS.Boast.model.Boast;
import WORKERS.Boast.model.BoastImage;
import WORKERS.Boast.model.BoastStar;
import WORKERS.Boast.model.Comments;
import WORKERS.JobPosting.model.Pagination;


@Mapper
public interface BoastMapper {
	
//list	
	public List<Boast> getBoastList() throws Exception;

//add	
	public void addBoast(Boast boast) throws Exception;	
	public int findbNoSP() throws Exception;	
	public void addBoastImg(BoastImage boastImg) throws Exception;

//view	
	public Boast ViewBoast(int bNoSP) throws Exception;
	public BoastImage ViewBoastImage(int bImageNoF) throws Exception;

//delete	
	public void DeleteBoast(int bNoSP) throws Exception;
	public void DeleteBoastImg(int bImageNoF) throws Exception;

//modify	
	public void ModifyBoast(Boast boast) throws Exception;
	public void ModifyBoastImg(BoastImage boastimage) throws Exception;

		
//댓글	
	public List<Comments> ListComment(int aid) throws Exception;

	public void AddBoastComment(Comments c);

	
	//페이지네이션
	//select * from Test_Table
    public List<Map<String, Object>> SelectAllList() throws Exception;    
    //Paging
    public List<Map<String, Object>> SelectAllList(Pagination pagination) throws Exception; 
    //count
    public int testTableCount() throws Exception;

	public void ModifyBoastComment(Comments c) throws Exception;

	public int FindbNoSP2(int commentAid);
	public void deleteBoastComment(int commentAid) throws Exception;


	public void AddBoastStar(BoastStar bs);

	public BoastStar GetBoastStar(int bStarNoF) throws Exception;

	public void ModifyBoastStar(BoastStar boastStar) throws Exception;

	// 좋아요 테이블에 값 넣기 
	boolean likeUp(BoastLikeDTO boastLikeDTO) throws Exception;
	
	// 좋아요 테이블에 값 뺴기 
	boolean likeDown(String UserEmail) throws Exception;
	
	// 게시물 번호 주면 , 게시물에 좋아요 누른 사람들 리스트 불러오는 메소드 
	List<String> likeList(int bNoSP) throws Exception;
	
	
	
}