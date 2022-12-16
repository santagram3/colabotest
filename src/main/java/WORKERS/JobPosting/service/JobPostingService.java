package WORKERS.JobPosting.service;

import java.util.List;

import WORKERS.JobPosting.model.CompanyPosting;
import WORKERS.JobPosting.repository.JobPostingMapper;

public class JobPostingService {
	
	JobPostingMapper jobpostingmapper;

	public List<CompanyPosting> jobPostingList() throws Exception{
		System.out.println("서비스 도착");
		
		List<CompanyPosting> jobpostinglist = jobpostingmapper.JobPostingList();
		//mapper 호출해서 가져온 리스트를 리턴
		return jobpostinglist;
		
	}

}
