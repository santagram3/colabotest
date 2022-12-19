package WORKERS.Boast.repository;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import WORKERS.Boast.dto.BoastDTO;
import WORKERS.Boast.model.Boast;


@Mapper
public interface BoastMapper {
	
	public List<Boast> getBoastList() throws Exception;
	
	boolean insertBoast(Boast boast) throws Exception;

	public Boast ViewBoast(int bNoSP) throws Exception;

	public void DeleteBoast(int bNoSP) throws Exception;

	public void ModifyBoast(Boast boast) throws Exception;

	public void ModifyBoastImg(int bNoSP) throws Exception;

	public void ViewBoastImage(int bImageNoF) throws Exception;


}