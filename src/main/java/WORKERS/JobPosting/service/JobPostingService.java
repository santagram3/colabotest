package WORKERS.JobPosting.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import WORKERS.JobPosting.model.CompanyPosting;
import WORKERS.JobPosting.repository.JobPostingMapper;
import lombok.RequiredArgsConstructor;


@Service
@Transactional
@RequiredArgsConstructor
public class JobPostingService {
	
	@Autowired
	private JobPostingMapper jobPostingMapper;

	public List<CompanyPosting> getJobPostingList() throws Exception{
		System.out.println("list 서비스 도착");
		
//		List<CompanyPosting> jpl = new ArrayList<>();
//		jpl = jobPostingMapper.JobPostingList();
		
		List<CompanyPosting> jpl = jobPostingMapper.JobPostingList();
		//mapper 호출해서 가져온 리스트를 리턴
		
		return jpl;
		
	}

	public void addJobPosting(CompanyPosting companyposting) throws Exception {
		System.out.println("add 서비스 도착");
		jobPostingMapper.AddJobPosting(companyposting);
		
	}

	public void deleteJobPosting(int cno) throws Exception {
		System.out.println("delete 서비스 도착");
		jobPostingMapper.DeleteJobPosting(cno);
		
	}

	public CompanyPosting viewJobPosting(int cno) throws Exception {
		System.out.println("view 서비스 도착");
		
		CompanyPosting c = new CompanyPosting();
		c= jobPostingMapper.ViewJobPosting(cno);
		
		return c;
	}

}
