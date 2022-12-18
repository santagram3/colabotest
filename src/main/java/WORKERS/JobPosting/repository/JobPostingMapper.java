package WORKERS.JobPosting.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import WORKERS.JobPosting.model.CompanyPosting;
import WORKERS.JobPosting.model.CompanyPostingImg;

@Mapper
public interface JobPostingMapper {
	
	// id = JobPostingList
	List<CompanyPosting> JobPostingList() throws Exception;

	void AddJobPosting( CompanyPosting companyposting) throws Exception;

	void DeleteJobPosting(int cno) throws Exception;

	CompanyPosting ViewJobPosting(int cno) throws Exception;

	void ModifyJobPosting(CompanyPosting companyposting) throws Exception;

	void AddJobPostingImg(CompanyPostingImg cpi);

	int FindCno() throws Exception;

	CompanyPostingImg ViewJobPostingImg(int cno) throws Exception;
	


}
