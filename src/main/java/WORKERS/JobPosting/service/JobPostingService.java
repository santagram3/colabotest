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
		System.out.println("서비스 도착");
		
//		List<CompanyPosting> jpl = new ArrayList<>();
//		jpl = jobPostingMapper.JobPostingList();
		
		List<CompanyPosting> jpl = jobPostingMapper.JobPostingList();
		//mapper 호출해서 가져온 리스트를 리턴
		
		return jpl;
		
	}

}
