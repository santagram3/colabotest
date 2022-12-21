package WORKERS.mypage.model;

import java.sql.Date;

import lombok.Data;

@Data
public class User {

	private String userEmail;
	private String userPw;
	private String nickName;
	private Date birthday;
	private String userGrade;
	private String selfIntroduce;
	private String oauth;

}
