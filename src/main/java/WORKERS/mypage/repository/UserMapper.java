package WORKERS.mypage.repository;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;


import WORKERS.mypage.model.User;

@Mapper
public interface UserMapper {
	
	
	// 회원가입
	boolean signUpUser(User user) throws Exception;
	
	// 아이디 넣으면 아이디 가져옴 !
	String findUserId (String userEamil) throws Exception;
	
	// 이메일 넣으면 그 사람 정보 가져옴 
	User findUser(String userEmail) throws Exception;
	
	// 로그인할때 -- 성공 값 잘나옴 
	int findUserInt(String userEmail) throws Exception;
	

}