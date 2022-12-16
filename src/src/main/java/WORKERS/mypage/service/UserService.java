package WORKERS.mypage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import WORKERS.mypage.DTO.LoginDTO;
import WORKERS.mypage.model.User;
import WORKERS.mypage.repository.UserMapper;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
public class UserService {
	
	private UserMapper userMapper;

	
	public UserService(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	//가입할 때 양옆에 공백제거 
	public void trimInfo(User user) throws Exception {
		
		System.out.println("\n=========trim service ======\n");
		user.setUserEmail(user.getUserEmail().trim());
		user.setUserPw(user.getUserPw().trim());
		user.setNickName(user.getNickName().trim());
		user.setSelfIntroduce(user.getSelfIntroduce().trim());
		// 맵퍼를 불러서 메소드 사용 ! 
		userMapper.signUpUser(user);
	}
	
	// 아이디 받아오는 메소드 
	public String findUserIdService(String userEmail)throws Exception{
		
		String id = userMapper.findUserId(userEmail);
		
		return id;
	}
	
}
