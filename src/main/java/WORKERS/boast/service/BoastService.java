package WORKERS.boast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import WORKERS.boast.model.Boast;
import WORKERS.boast.model.BoastImg;
import WORKERS.boast.repository.BoastMapper;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BoastService {
	
	@Autowired
	private BoastMapper boastMapper;
	
	//list
	public List<Boast> boastList() throws Exception {
		System.out.println("list 서비스 도착");
		List<Boast> bl = boastMapper.getBoastList();
		System.out.println("list 서비스 완료");
		return bl;
	}

	//add
		public void addBoast(Boast boast) throws Exception {
			System.out.println("add 서비스도착");
			boastMapper.addBoast(boast);
			System.out.println("add 서비스 완료");
		}
		
		public int findbNoSP() throws Exception {
			
			int i = boastMapper.findbNoSP();
			return i;
		}
		
		public void addBoastImg(BoastImg boastImg) {
			boastMapper.addBoastImg(boastImg);		
		}

	
	
	
	
	
	public Boast viewBoast(int bNoSP) throws Exception {
		Boast boast = boastMapper.ViewBoast(bNoSP);
		return boast;
	}

	public void deleteBoast(int bNoSP) throws Exception {
		boastMapper.DeleteBoast(bNoSP);
		
	}
}