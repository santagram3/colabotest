package WORKERS.JobPosting.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import WORKERS.JobPosting.model.CompanyPosting;
import WORKERS.JobPosting.model.CompanyPostingImg;

@Mapper
public interface JobPostingMapper {
	
//list
	List<CompanyPosting> JobPostingList() throws Exception;

//add
	void AddJobPosting( CompanyPosting companyposting) throws Exception;
	int FindCno() throws Exception;
	void AddJobPostingImg(CompanyPostingImg cpi);

//delete
	void DeleteJobPosting(int cno) throws Exception;

//view
	CompanyPosting ViewJobPosting(int cno) throws Exception;
	CompanyPostingImg ViewJobPostingImg(int cno) throws Exception;

//modify
	void ModifyJobPosting(CompanyPosting companyposting) throws Exception;
	void ModifyJobPostingImg(CompanyPostingImg cpi) throws Exception;
	


}
