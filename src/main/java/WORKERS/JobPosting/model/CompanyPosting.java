package WORKERS.JobPosting.model;

import java.sql.Date;

import lombok.Data;

@Data
public class CompanyPosting {
	private int cno;
	private String cTitle;
	private String cWriter;
	private String cContent;
	private Date cDate;
	private Date cDueDate;
	private String cAddress;
	
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
	
	@Override
	public String toString() {
		return "CompanyPosting [cno=" + cno + ", cTitle=" + cTitle + ", cWriter=" + cWriter + ", cContent=" + cContent
				+ ", cDate=" + cDate + ", cDueDate=" + cDueDate + ", cAddress=" + cAddress + "]";
	}
	
	

}
