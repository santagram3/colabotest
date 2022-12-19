package WORKERS.boast.repository;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import WORKERS.boast.model.Boast;
import WORKERS.boast.model.BoastImg;


@Mapper
public interface BoastMapper {
	
	public List<Boast> getBoastList() throws Exception;
	
	public void addBoast(Boast boast) throws Exception;
	
	public int findbNoSP() throws Exception;
	
	public void addBoastImg(BoastImg boastImg);

	public Boast ViewBoast(int bNoSP) throws Exception;

	public void DeleteBoast(int bNoSP) throws Exception;
	

}