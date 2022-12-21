package WORKERS.mypage.repository;

import org.apache.ibatis.annotations.Mapper;

import WORKERS.mypage.model.CompanyUser;

@Mapper
public interface CompanyMapper {
	
	// 이메일 찾아주는 메소드 
	String findCompanyEmail (String ComanyEmail) throws Exception;
	
	// 가입시켜주는 메소드 
	boolean registerCompany(CompanyUser companyUser) throws Exception;
	
	
	
}
