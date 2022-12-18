package WORKERS.Boast.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import WORKERS.Boast.dto.BoastDTO;
import WORKERS.Boast.model.Boast;


@Mapper
public interface BoastMapper {
	
	public List<Boast> getBoastList() throws Exception;
	
	boolean insertBoast(Boast boast) throws Exception;
	
	
	
	
}