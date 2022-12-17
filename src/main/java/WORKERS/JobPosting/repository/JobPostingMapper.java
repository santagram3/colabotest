package WORKERS.JobPosting.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import WORKERS.JobPosting.model.CompanyPosting;

@Mapper
public interface JobPostingMapper {
	
	// id = JobPostingList
	List<CompanyPosting> JobPostingList() throws Exception;

	void AddJobPosting( CompanyPosting companyposting) throws Exception;

	void DeleteJobPosting(int cno) throws Exception;

	CompanyPosting ViewJobPosting(int cno) throws Exception;

	void ModifyJobPosting(CompanyPosting companyposting) throws Exception;
	


}
