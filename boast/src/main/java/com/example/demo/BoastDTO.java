package com.example.demo;

public class BoastDTO {

	private int bNoSP;
	private String bTitle;
	private String bWriter;
	private String bContent;
	private String bDate;
	private String bImage;
	
	public BoastDTO() {
		
	}

	
	public BoastDTO(int bNoSP, String bTitle, String bWriter, String bContent, String bDate, String bImage) {
		super();
		this.bNoSP = bNoSP;
		this.bTitle = bTitle;
		this.bWriter = bWriter;
		this.bContent = bContent;
		this.bDate = bDate;
		this.bImage = bImage;
	}

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

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public String getbDate() {
		return bDate;
	}

	public void setbDate(String bDate) {
		this.bDate = bDate;
	}

	public String getbImage() {
		return bImage;
	}

	public void setbImage(String bImage) {
		this.bImage = bImage;
	}
	
}
