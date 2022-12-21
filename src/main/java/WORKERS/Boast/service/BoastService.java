
package WORKERS.Boast.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import WORKERS.Boast.model.Boast;
import WORKERS.Boast.model.BoastImage;
import WORKERS.Boast.model.Comments;
import WORKERS.Boast.repository.BoastMapper;
import WORKERS.JobPosting.model.Pagination;
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

	public BoastImage viewBoastImage(int bImageNoF) throws Exception {
		BoastImage b = boastMapper.ViewBoastImage(bImageNoF);
		return b;
	}

	public List<Comments> listComment(int aid) throws Exception {
		List<Comments> comments = boastMapper.ListComment(aid);
		return comments;
	}

	public void addBoastComment(Comments c) {
		boastMapper.AddBoastComment(c);
		
	}

	
	
	public List<Map<String, Object>> SelectAllList() throws Exception {
        return boastMapper.SelectAllList();
    }
 
    public List<Map<String, Object>> SelectAllList(Pagination pagination) throws Exception {
        return boastMapper.SelectAllList(pagination);
    }
 
    public int testTableCount() throws Exception {
        return boastMapper.testTableCount();
    }

	public void modifyBoastComment(Comments c) throws Exception {
		boastMapper.ModifyBoastComment(c);	
	}

	public int findbNoSP2(int commentAid)  throws Exception{
		int i = boastMapper.FindbNoSP2(commentAid);
		return i;
	}
	
	public void deleteBoastComment(int commentAid) throws Exception {		
		boastMapper.deleteBoastComment(commentAid);			
	}
}
