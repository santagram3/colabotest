package WORKERS.JobPosting.model;

public class CompanyPostingImg {
	private int cno;
	private String companyImg;
	
	
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getCompanyImg() {
		return companyImg;
	}
	public void setCompanyImg(String companyImg) {
		this.companyImg = companyImg;
	}
	
	@Override
	public String toString() {
		return "CompanyPostingImg [cno=" + cno + ", companyImg=" + companyImg + "]";
	}
	
}
