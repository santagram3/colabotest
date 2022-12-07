package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoastServiceImpl implements BoastService {
	@Autowired
	private BoastMapper boastMapper;
	
	@Override
	public List<BoastDTO> selectBoastList() throws Exception {
		// TODO Auto-generated method stub
		return boastMapper.selectBoastList();

	}
}