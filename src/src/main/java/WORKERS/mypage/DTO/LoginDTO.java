package WORKERS.mypage.DTO;

//import lombok.Getter;

public class LoginDTO {
	
	private String userEmail;
	private String userPw;
	
	@Override
	public String toString() {
		return "LoginDTO [userEmail=" + userEmail + ", userPw=" + userPw + "]";
	}
	public LoginDTO() {
		super();
	}
	public LoginDTO(String userEmail, String userPw) {
		super();
		this.userEmail = userEmail;
		this.userPw = userPw;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	
	
	

}
