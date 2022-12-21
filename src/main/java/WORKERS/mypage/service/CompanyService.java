package WORKERS.mypage.service;

import org.springframework.stereotype.Service;

import WORKERS.mypage.model.CompanyUser;
import WORKERS.mypage.repository.CompanyMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyService {

	private final CompanyMapper companyMapper;

	// 회원가입 시키는 메소드
	public void companyRegisterService(CompanyUser companyUser) throws Exception {

		System.out.println("CompanyService++++++++++333+++++");

		companyUser.setCompanyEmail(companyUser.getCompanyEmail().trim());
		companyUser.setCompanyPwd(companyUser.getCompanyPwd().trim());
		companyUser.setCompanyName(companyUser.getCompanyName().trim());
		companyUser.setBusinessNumber(companyUser.getBusinessNumber().trim());
		companyUser.setUserGrade(companyUser.getUserGrade().trim());

		companyMapper.registerCompany(companyUser);
	}

	// 이메일 찾아주는 메소드
	public String findCompanyEmailService(String companyEmail) throws Exception {
		System.out.println("insert companyEmail = " + companyEmail);
		String email = companyMapper.findCompanyEmail(companyEmail);
		System.out.println("out companyEmail = " + email);
		if(email !=null) {
			System.out.println("yesCompanyEmail");
			return "yesCompanyEmail";
		}else {
			System.out.println("noCompanyEmail");
			return "noCompanyEmail";
		}
	}

	// 사업자 번호 있는지 없는지 확인하는 메소드 
	public String BNbooleanService(String BusinessNumber) throws Exception{
		
		System.out.println("=======BNbooleanService====");
		String number = companyMapper.BNboolean(BusinessNumber);
		
		if(number == null) {
			// 사업자 번호가 없으면 > 중복 아님 
			System.out.println("noBN");
			return"noBN";
		}else {
			//사업자 번호가 있으면 > 중복
			System.out.println("yesBN");
			return"yesBN";
		}
		
	}
	
	
	
	
	
	
}
