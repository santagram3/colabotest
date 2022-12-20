package WORKERS.JobPosting.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import WORKERS.JobPosting.model.CompanyPosting;
import WORKERS.JobPosting.model.CompanyPostingImg;
import WORKERS.JobPosting.model.Pagination;
import WORKERS.JobPosting.repository.JobPostingMapper;
import lombok.RequiredArgsConstructor;


@Service
@Transactional
@RequiredArgsConstructor
public class JobPostingService {
	
	@Autowired
	private JobPostingMapper jobPostingMapper;

//list
	public List<CompanyPosting> getJobPostingList() throws Exception{
		List<CompanyPosting> jpl = jobPostingMapper.JobPostingList();		
		return jpl;		
	}
	
//add
	public void addJobPosting(CompanyPosting companyposting) throws Exception {
		jobPostingMapper.AddJobPosting(companyposting);		
	}
	
	public int findCno() throws Exception {
		int i = jobPostingMapper.FindCno();
		return i;
	}
	
	public void addJobPostingImg(CompanyPostingImg cpi) {
		jobPostingMapper.AddJobPostingImg(cpi);		
	}

//delete	
	public void deleteJobPosting(int cno) throws Exception {
		jobPostingMapper.DeleteJobPosting(cno);		
	}

//view	
	public CompanyPosting viewJobPosting(int cno) throws Exception {	
		CompanyPosting c = new CompanyPosting();
		c= jobPostingMapper.ViewJobPosting(cno);		
		return c;
	}

	public CompanyPostingImg viewJobPostingImg(int cno) throws Exception {
		CompanyPostingImg c = new CompanyPostingImg();
		c= jobPostingMapper.ViewJobPostingImg(cno);
		return c;
	}
	
//modify	
	public void modifyJobPosting(CompanyPosting companyposting) throws Exception {
		jobPostingMapper.ModifyJobPosting(companyposting);		
	}
	
	public void modifyJobPostingImg(CompanyPostingImg cpi) throws Exception {
		jobPostingMapper.ModifyJobPostingImg(cpi);		
	}
	
	
	public List<Map<String, Object>> SelectAllList() throws Exception {
        return jobPostingMapper.SelectAllList();
    }
 
    public List<Map<String, Object>> SelectAllList(Pagination pagination) throws Exception {
        return jobPostingMapper.SelectAllList(pagination);
    }
 
    public int testTableCount() throws Exception {
        return jobPostingMapper.testTableCount();
    }
    
}
