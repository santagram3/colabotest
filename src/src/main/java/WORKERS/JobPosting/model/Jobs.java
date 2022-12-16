package WORKERS.JobPosting.model;

import java.sql.Date;

public class Jobs {
	private int cno; //posting번호 
	private String cTitle; //제목
	private String cWriter; //구인공고 작성자
	private String cContent; //구인공고 내용
	private Date cDate; //작성 날짜
	private Date cDueDate; //마감 날짜
	private String cAddress; //회사 주소
	private String CompanyPostingImg; //이미지

	
	
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getcTitle() {
		return cTitle;
	}
	public void setcTitle(String cTitle) {
		this.cTitle = cTitle;
	}
	public String getcWriter() {
		return cWriter;
	}
	public void setcWriter(String cWriter) {
		this.cWriter = cWriter;
	}
	public String getcContent() {
		return cContent;
	}
	public void setcContent(String cContent) {
		this.cContent = cContent;
	}
	public Date getcDate() {
		return cDate;
	}
	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}
	public Date getcDueDate() {
		return cDueDate;
	}
	public void setcDueDate(Date cDueDate) {
		this.cDueDate = cDueDate;
	}
	public String getcAddress() {
		return cAddress;
	}
	public void setcAddress(String cAddress) {
		this.cAddress = cAddress;
	}
	public String getCompanyPostingImg() {
		return CompanyPostingImg;
	}
	public void setCompanyPostingImg(String companyPostingImg) {
		CompanyPostingImg = companyPostingImg;
	}

}
