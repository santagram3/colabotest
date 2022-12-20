package WORKERS.mypage.service;

import org.springframework.stereotype.Service;

import WORKERS.mypage.model.CompanyUser;
import WORKERS.mypage.repository.CompanyMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyService {

	private final CompanyMapper companyMapper;
	
	public void companyRegisterService(CompanyUser companyUser) throws Exception{
		

		System.out.println("CompanyService++++++++++333+++++");

		companyUser.setCompanyEmail(companyUser.getCompanyEmail().trim());
		companyUser.setCompanyPwd(companyUser.getCompanyPwd().trim());
		companyUser.setCompanyName(companyUser.getCompanyName().trim());
		companyUser.setBusinessNumber(companyUser.getBusinessNumber().trim());
		companyUser.setUserGrade(companyUser.getUserGrade().trim());
		
		companyMapper.registerCompany(companyUser);
	}
	
	
	
	
	
	
	
}
