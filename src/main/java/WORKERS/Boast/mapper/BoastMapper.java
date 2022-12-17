package WORKERS.Boast.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import WORKERS.Boast.dto.BoastDTO;
import WORKERS.Boast.model.Boast;


@Mapper

public interface BoastMapper {
	public List<BoastDTO> getList() throws Exception;
	boolean insertBoast(Boast boast) throws Exception;
	
	
	
	
}