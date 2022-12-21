package WORKERS.mypage.repository;

import org.apache.ibatis.annotations.Mapper;

import WORKERS.mypage.model.CompanyUser;

@Mapper
public interface CompanyMapper {
	
	// 이메일 찾아주는 메소드 
	String findCompanyEmail (String companyEmail) throws Exception;
	
	// 비밀번호 찾아주는 메소드 
	String findCompanyPwd (String companyEmail) throws Exception;
	
	// 전체 정보 가져오는 메소드 
	CompanyUser findCompanyUser(String companyEmail) throws Exception;
	
	// 가입시켜주는 메소드 
	boolean registerCompany(CompanyUser companyUser) throws Exception;
	
	// 비동기 사업자번호 중복 있는지 없는지 사용 
	String BNboolean(String BusinessNumber) throws Exception;
	
	
	
}
