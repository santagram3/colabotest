package WORKERS.boast.repository;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import WORKERS.boast.model.Boast;
import WORKERS.boast.model.BoastImage;
import WORKERS.boast.Comment;

@Mapper
public interface BoastMapper {
	
//list	
	public List<Boast> getBoastList() throws Exception;
	//comment
		public List<Comment> getBoastCommentList(int aid) throws Exception;
//add	
	public void addBoast(Boast boast) throws Exception;	
	public int findbNoSP() throws Exception;	
	public void addBoastImg(BoastImage boastImg) throws Exception;
	//comment
		public void addBoastComment(Comment comment) throws Exception;
		
//view	
	public Boast ViewBoast(int bNoSP) throws Exception;
	public BoastImage ViewBoastImg(int bImageNoF) throws Exception;
	
//delete	
	public void DeleteBoast(int bNoSP) throws Exception;
	public void DeleteBoastImg(int bImageNoF) throws Exception;
	//comment
		public void deleteBoastComment(int commentAid) throws Exception;
		
//modify	
	public void ModifyBoast(Boast boast) throws Exception;
	public void ModifyBoastImg(BoastImage boastimage) throws Exception;
	//comment
	public void modifyBoastComment(Comment comment) throws Exception;
	public int FindbNoSP2(int commentAid);



}