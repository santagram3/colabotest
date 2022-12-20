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
	
	
	
	
	public List<Comment> boastCommentList() throws Exception {
		List<Comment> cl = boastMapper.getBoastCommentList();
		return cl;
	}
	
	public void addBoastComment(Comment comment, int bNoSP) throws Exception {
		boastMapper.addBoastComment(comment, bNoSP);
	}
	

	public void deleteBoastComment(int commentAid, int aid) throws Exception {
		int bNoSP = aid;
		boastMapper.deleteBoastComment(commentAid,aid);	
	}

	public void modifyBoastComment(Comment comment) throws Exception {
		boastMapper.modifyBoastComment(comment);		
	}

}