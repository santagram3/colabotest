package WORKERS.kakaoLogin.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class KakaoProfile {

	public Long id;
	public String connected_at;
	public Properties properties;
	public KakaoAccount kakao_account;

	@Data
	@JsonIgnoreProperties(ignoreUnknown=true)
	public class KakaoAccount {
		
		public String email; //이메일 가져오기 
		public Date birthday; // 생년월일 
		public Boolean profile_nickname_needs_agreement;
		public Profile profile;
		public Boolean has_email;
		public Boolean email_needs_agreement;
		public Boolean has_gender;
		public Boolean gender_needs_agreement;

		@Data
		@JsonIgnoreProperties(ignoreUnknown=true)
		public class Profile {
			public String nickname;
		}

	}

	@Data
	@JsonIgnoreProperties(ignoreUnknown=true)
	public class Properties {
		public String nickname;

	}

}
