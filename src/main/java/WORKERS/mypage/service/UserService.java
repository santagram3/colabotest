package WORKERS.mypage.service;

import java.util.List;

import javax.servlet.http.HttpSession;

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
@RequiredArgsConstructor
public class UserService {

   private final UserMapper userMapper;

   // 가입할 때 양옆에 공백제거
   public void trimInfo(User user) throws Exception {

      System.out.println("\n=========trim service ======\n");
      user.setUserEmail(user.getUserEmail().trim());
      user.setUserPw(user.getUserPw().trim());
      user.setNickName(user.getNickName().trim());
      user.setSelfIntroduce(user.getSelfIntroduce().trim());
//      user.setOauth(user.getOauth().trim());
      // 맵퍼를 불러서 메소드 사용 !
      userMapper.signUpUser(user);
   }

   // 아이디 받아오는 메소드 있으면 아이디 반환 없으면 반환 안함.
   public String findUserIdService(String userEmail) throws Exception {
      //
      System.out.println("findUserIdService = " + userEmail);
      // 여기까진 들어왔음 r1241 이걸로 ..
      String trimEmail = userEmail.trim();

      if (userEmail.equals(trimEmail)) {
         System.out.println("Equal email");
      } else {
         System.out.println("not Equal email");
      }

      String id = userMapper.findUserId(trimEmail);

      System.out.println("userMapper.findUserId = " + id);
      return id;
   }

   // 아이디 넣으면 그 사람 정보 다 가져옴(세션에 넣을것!)
   public String loginSessionService(LoginDTO loginDTO, HttpSession session) throws Exception {

      System.out.println("=============loginSessionService==========");
      loginDTO.getUserEmail().trim();
      loginDTO.getUserPw().trim();

      String loginEmail = loginDTO.getUserEmail();

      System.out.println("loginEmail = " + loginEmail);

      User user = userMapper.findUser(loginEmail);

      System.out.println("user = " + user);

      // 찾은 유저가 있다면 ?
      if (user != null) {
         System.out.println("x");
         // 비밀번호 비교 해야지 비교해서 맞으면 ?
         if (loginDTO.getUserPw().equals(userMapper.findPw(loginEmail))) {
            session.setAttribute("loginUser", user);
            // 한시간 !
            session.setMaxInactiveInterval(60 * 60);
            return "loginSuccess";
         }
         return "pwFail";
      } else {
         System.out.println("y");
         // 아이디 없음
         return "noId";
      }

   }

}