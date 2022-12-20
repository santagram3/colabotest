package WORKERS.Boast.repository;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import WORKERS.Boast.model.Boast;
import WORKERS.Boast.model.BoastImage;
import WORKERS.Boast.model.Comments;


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




}