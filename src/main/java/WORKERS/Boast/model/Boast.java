package WORKERS.Boast.model;

import java.sql.Date;

public class Boast {
	private int bNoSP;
	private String bTitle;
	private String bWriter;
	private String bContent;
	private Date bDate;
	
	
	public int getbNoSP() {
		return bNoSP;
	}
	public void setbNoSP(int bNoSP) {
		this.bNoSP = bNoSP;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbWriter() {
		return bWriter;
	}
	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}
	public Date getbDate() {
		return bDate;
	}
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	
	@Override
	public String toString() {
		return "Boast [bNoSP=" + bNoSP + ", bTitle=" + bTitle + ", bWriter=" + bWriter + ", bDate=" + bDate
				+ ", bContent=" + bContent + "]";
	}


	
}
