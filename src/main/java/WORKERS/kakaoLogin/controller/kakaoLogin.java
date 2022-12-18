package WORKERS.kakaoLogin.controller;

import java.sql.Date;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import WORKERS.kakaoLogin.model.KakaoProfile;
import WORKERS.kakaoLogin.model.OAuthToken;
import WORKERS.mypage.DTO.LoginDTO;
import WORKERS.mypage.model.User;
import WORKERS.mypage.service.UserService;
import lombok.RequiredArgsConstructor;

@RequestMapping("/kakao")
@Controller
@RequiredArgsConstructor
public class kakaoLogin {

	private final UserService userService;

	@GetMapping("/login")
	// 데이터를 리턴해주는 컨트롤러
	public String kakaoLogin(String code, HttpSession session) throws Exception {
		System.out.println("inputkakao");

		// POST 방식으로 key = value 데이터 요청(카카오 쪽으로)
		// Retrofit2
		// OkHttp
		// RestTemplate
		RestTemplate rt = new RestTemplate();

		System.out.println("1");
		// HttpHeader 오브젝트 생성
		org.springframework.http.HttpHeaders header = new org.springframework.http.HttpHeaders();
		System.out.println("2");
		header.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		System.out.println("3");
		// HttpBody 오브젝트 생성
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", "6078a2a05d3e31937245be4308a040f4");
		params.add("redirect_uri", "http://localhost:8898/kakao/login");
		params.add("code", code);
		System.out.println("4");
		// HttpHeader 와 HttpBody를 하나의 오브젝트에 담기
		HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(params, header);
		System.out.println("5");
		// Http 요청학기 -Post 방식으로 - 그리고 response 변수의 응답 받음.
		ResponseEntity<String> response = rt.exchange("https://kauth.kakao.com/oauth/token", //
				HttpMethod.POST, // 어떤 방식으로 넣을지
				kakaoTokenRequest, String.class // 응답을 받을 타입을 적어줌
		);

		System.out.println("6");
		System.out.println("response.getBody() = " + response.getBody());
		// response.getBody()
		// response > 이걸 다른곳에 담아야 한다 !
		// Gson, Json Simple , ObjectMapper

		ObjectMapper objectMapper = new ObjectMapper();
		System.out.println("7");
		OAuthToken oauthToken = null;
		try {
			System.out.println("8");
			// response.getBody() 를 꼭 String 으로 파싱해줘야됨!
			oauthToken = objectMapper.readValue((String) response.getBody(), OAuthToken.class);
		} catch (JsonMappingException e) {
			System.out.println("JsonMappingException");
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			System.out.println("JsonProcessingException");
			e.printStackTrace();
		}

		// 카카오 엑세스 토큰!~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`
		System.out.println("9");
		System.out.println("oauthToken.getAccess_token() = " + oauthToken.getAccess_token());
		System.out.println("10");

		// ----------------------------------------------------------------

		RestTemplate rt2 = new RestTemplate();

		System.out.println("2-1");
		// HttpHeader 오브젝트 생성
		org.springframework.http.HttpHeaders header2 = new org.springframework.http.HttpHeaders();
		System.out.println("2-2");
		// Authorization: Bearer ${ACCESS_TOKEN}/KakaoAK ${APP_ADMIN_KEY}
		// "/KakaoAK "+"309e79fefcb66ee51ed2978312aeefa2")
		header2.add("Authorization", "Bearer " + oauthToken.getAccess_token());
		System.out.println("2-3");
		// Content-type: application/x-www-form-urlencoded;charset=utf-8
		header2.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		System.out.println("2-4");
		// HttpHeader 와 HttpBody를 하나의 오브젝트에 담기
		HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest2 = new HttpEntity<>(header2);
		System.out.println("2-5");
		// Http 요청학기 -Post 방식으로 - 그리고 response 변수의 응답 받음.
		ResponseEntity<String> response2 = rt2.exchange("https://kapi.kakao.com/v2/user/me", //
				HttpMethod.POST, // 어떤 방식으로 넣을지
				kakaoProfileRequest2, String.class // 응답을 받을 타입을 적어줌
		);
		System.out.println("2-6");

		System.out.println("response2.getHeaders() = " + response2.getHeaders());
		System.out.println("====================");
		System.out.println("response2.getBody() = " + response2.getBody());

		System.out.println(response2);

		// ---------------------------------------------------------------------------
		ObjectMapper objectMapper2 = new ObjectMapper();

		KakaoProfile kakaoProfile = null;
		try {
			System.out.println("8");
			// response.getBody() 를 꼭 String 으로 파싱해줘야됨!
			kakaoProfile = objectMapper2.readValue((String) response2.getBody(), KakaoProfile.class);
		} catch (JsonMappingException e) {
			System.out.println("JsonMappingException2");
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			System.out.println("JsonProcessingException2");
			e.printStackTrace();
		}

		// User 오브젝트 : userName, password , email
		System.out.println("카카오 아이디(번호) : " + kakaoProfile.getId());
		System.out.println("카카오 이메일 getHas_email() : " + kakaoProfile.getKakao_account());
		System.out.println(
				"카카오 이메일 getEmail_needs_agreement() : " + kakaoProfile.getKakao_account().getEmail_needs_agreement());

		System.out.println("workers 아이디(이메일) : " + kakaoProfile.getKakao_account().getEmail());
		System.out.println("workers 닉네임(닉네임) : " + kakaoProfile.getKakao_account().getProfile().getNickname());
		System.out.println("생년 월일 Date 타입으로 받음 " + kakaoProfile.getKakao_account().getBirthday());

		User kakaoUser = new User();
		// 이메일 가져옴
		kakaoUser.setUserEmail(kakaoProfile.getKakao_account().getEmail());
		// 비밀번호는 이메일 이랑 똑같음
		kakaoUser.setUserPw(kakaoProfile.getKakao_account().getEmail());
		// 현재시간 불러옴
		//Date date = new Date(0);
		//System.out.println("date = " + date);
		kakaoUser.setBirthday(kakaoProfile.getKakao_account().getBirthday());
		// 카카오에서 가져온 이름
		kakaoUser.setNickName(kakaoProfile.getKakao_account().getProfile().getNickname());
		// 자기소개
		kakaoUser.setSelfIntroduce("카카오로그인으로 들어온 가입자");

		System.out.println("111111111111111");
		System.out.println(kakaoUser.toString());
		// 받아온 이메일 kakaoProfile.getKakao_account().getEmail()
		
		// 이걸로 아이디 찾기함 !! 카카오 이메일!
		String kakaoGetEmail = kakaoProfile.getKakao_account().getEmail();
		System.out.println("2222222222222222");

		String findUserId = userService.findUserIdService(kakaoGetEmail);
		System.out.println("333333333333333");
		// 찾았는데 없으면 가입 시키기
		if (findUserId == null) {
			System.out.println("4444444444444");
			// 서비스 객체 가져와서 가입 시키기
			userService.trimInfo(kakaoUser);
		}
		System.out.println("555555555555555555");
		// 찾았는데 있으면 바로 로그인!
		LoginDTO loginDTO = new LoginDTO();
		loginDTO.setUserEmail(kakaoProfile.getKakao_account().getEmail());
		loginDTO.setUserPw(kakaoProfile.getKakao_account().getEmail());
		System.out.println("66666666666666666");
		userService.loginSessionService(loginDTO, session);

		System.out.println("777777777777777777");
		return "redirect:/test/header";
	}

}
