package WORKERS.mypage.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import WORKERS.mypage.DTO.CompanyLoginDTO;
import WORKERS.mypage.DTO.LoginDTO;
import WORKERS.mypage.model.CompanyUser;
import WORKERS.mypage.model.User;
import WORKERS.mypage.service.CompanyService;
import WORKERS.mypage.service.UserService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

	private final UserService userService;

	private final CompanyService companyService;

	@PostMapping("/login")
	public String loginSuccess(LoginDTO loginDTO, HttpSession session, Model model) throws Exception {

		System.out.println("loginSuccess in LoginController");

		System.out.println("loginDTO = " + loginDTO);

		String answer = userService.loginSessionService(loginDTO, session);

		if (answer == "loginSuccess") {
			System.out.println("loginSuccess");
			// 로그인 성공
			model.addAttribute(answer, "loginSuccess");
			return "redirect:/main/page";
		} else if (answer == "pwFail") {

			// 비밀번호 틀림
			System.out.println("pwFail");
			model.addAttribute(answer, "pwFail");
			return "redirect:/main/page";
		} else {
			// 아이디 없음 !
			System.out.println("noId");
			model.addAttribute(answer, "noId");
			return "redirect:/main/page";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {

		System.out.println("===========login/logout===============");
		String ACCESS_TOKEN = (String) session.getAttribute("access_token");
		System.out.println("ACCESS_TOKEN: " + ACCESS_TOKEN);
		// POST /v1/user/logout HTTP/1.1
		// Host: kapi.kakao.com
		// Authorization: Bearer ${ACCESS_TOKEN}/KakaoAK ${APP_ADMIN_KEY}
		User user = (User) session.getAttribute("loginUser");
		System.out.println("user = " + user);
		String oauth = user.getOauth();
		System.out.println("oauth = " + oauth);
		System.out.println("===========login/logout===============\n");

		System.out.println("==========kakaologout=========");
		if (oauth == "KAKAO") {
			RestTemplate rt2 = new RestTemplate();

			System.out.println("2-1");
			// HttpHeader 오브젝트 생성
			org.springframework.http.HttpHeaders header2 = new org.springframework.http.HttpHeaders();
			System.out.println("2-2");
			// Authorization: Bearer ${ACCESS_TOKEN}/KakaoAK ${APP_ADMIN_KEY}
			header2.add("Authorization", "Bearer " + ACCESS_TOKEN);
			System.out.println("2-3");
			// HttpHeader 와 HttpBody를 하나의 오브젝트에 담기
			HttpEntity<MultiValueMap<String, String>> kakaoLogout = new HttpEntity<>(header2);
			System.out.println("2-4");
			// Http 요청학기 -Post 방식으로 - 그리고 response 변수의 응답 받음.
			ResponseEntity<String> response2 = rt2.exchange("https://kapi.kakao.com/v1/user/logout", //
					HttpMethod.POST, // 어떤 방식으로 넣을지
					kakaoLogout, String.class // 응답을 받을 타입을 적어줌
			);
		}

		System.out.println("==========kakaologout=========");

		// 형변환 해줘야 됨 !
		// User user = (User) session.getAttribute("loginUser");

		if (user != null) { // 로그인 상태라면 ?

			session.removeAttribute("loginUser"); // loginUser 라는 내용을 세션에서 삭제
			session.invalidate(); // 세션 객체 삭제

			return "redirect:/main/page";
		}

		// 로그인 상태가 아니라면
		return "redirect:/main/page";
	}

	@PostMapping("/companyLogin")
	public String companyLoginController(CompanyLoginDTO companyLoginDTO, HttpSession session) throws Exception {
		// 1. 잘 들어왔는지 확인
		System.out.println("companyLoginController -------");
		System.out.println("companyLoginDTO = " + companyLoginDTO);

		// 2. 잘 들어온놈 분리
		// 2-1 이메일
		String inputEmail = companyLoginDTO.getCompanyEmail();
		// 2-2 비밀번호
		String inputPwd = companyLoginDTO.getCompanyPwd();

		// 이메일 있는지 없는지 확인
		String result = companyService.findCompanyEmailService(inputEmail);

		if (result == "yesCompanyEmail") {
			// 있는 사용자라면 ?
			System.out.println("DB Have CompanyEmail");
			if (inputPwd.equals(companyService.findCompanyPwdService(inputEmail).trim())) {
				// 들어온 비밀번호와 찾은 비밀번호가 같다면
				System.out.println("equal pwd");
				// 객체 찾아서 넣어준다 !
				CompanyUser loginCompanyUser = companyService.findCompanyUserService(inputEmail);

				session.setAttribute("loginCompanyUser", loginCompanyUser);
				session.setMaxInactiveInterval(60 * 60); // 한시간
				return "redirect:/main/page";

			} else {
				// 들어온 비밀번호와 찾은 비밀번호가 다르다면
				System.out.println("not equal pwd");
				return "redirect:/main/page";
			}

		} else {
			System.out.println("DB don't Have CompanyEmail");
			return "redirect:/main/page";
		}

	}

	@GetMapping("/companyLogout")
	public String companyLogout(HttpSession session) {

		CompanyUser loginCompanyUser = (CompanyUser) session.getAttribute("loginCompanyUser");

		if (loginCompanyUser != null) { // 로그인 상태라면 ?

			session.removeAttribute("loginCompanyUser"); // loginUser 라는 내용을 세션에서 삭제
			session.invalidate(); // 세션 객체 삭제

			return "redirect:/main/page";
		}

		return "redirect:/main/page";
	}

}