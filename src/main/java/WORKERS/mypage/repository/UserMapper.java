package WORKERS.mypage.repository;

import org.apache.ibatis.annotations.Mapper;

import WORKERS.mypage.model.User;

@Mapper
public interface UserMapper {
	
	
	// 회원가입
	boolean signUpUser(User user) throws Exception;
	
	// 아이디 넣으면 아이디 가져옴 !
	String findUserId (String userEmail) throws Exception;
	
	// 이메일 넣으면 그 사람 정보 가져옴 //
	User findUser(String userEmail) throws Exception;
	
	// 로그인할때 -- 성공 값 잘나옴 
	int findUserInt(String userEmail) throws Exception;
	
	// 비밀번호 비교 
	String findPw(String userPw) throws Exception;

	//일반회원 마이페이지 수정
	void ModifyUserInfo(User user) throws Exception;

	void DeleteUserInfo(String userEmail) throws Exception;
	
	
	

}
