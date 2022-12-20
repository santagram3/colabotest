package WORKERS.boast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import WORKERS.boast.model.Boast;
import WORKERS.boast.model.BoastImage;
import WORKERS.boast.repository.BoastMapper;
import WORKERS.boast.Comment;
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

	public BoastImage viewBoastImg(int bImageNoF) throws Exception {
		BoastImage b = boastMapper.ViewBoastImg(bImageNoF);
		return b;
	}
	
	
	
	
	public List<Comment> boastCommentList(int aid) throws Exception {
		List<Comment> dl = boastMapper.getBoastCommentList(aid);
		return dl;
	}
	
	public void addBoastComment(Comment comment) throws Exception {
		boastMapper.addBoastComment(comment);
	}
	

	public void deleteBoastComment(int commentAid) throws Exception {
		
		boastMapper.deleteBoastComment(commentAid);	
		
	}

	public void modifyBoastComment(Comment comment) throws Exception {
		boastMapper.modifyBoastComment(comment);		
	}

	public int findbNoSP2(int commentAid) {
		int i = boastMapper.FindbNoSP2(commentAid);
		return i;
	}

}