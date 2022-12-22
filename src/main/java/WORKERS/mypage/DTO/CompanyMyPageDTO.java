package WORKERS.mypage.DTO;


import java.util.Date;

import lombok.Data;

@Data
public class CompanyMyPageDTO {
	private int cno;
	private String cTitle;
	private Date cDueDate;
	private String companyImg;

}
