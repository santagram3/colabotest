package com.example.demo;

public class BoastDTO {

	private int bNoSP;
	private String bTitle;
	private String bWriter;
	private int bContent;
	private int bDate;
	private int bImage;
	
	public BoastDTO() {
		
	}

	
	public BoastDTO(int bNoSP, String bTitle, String bWriter, int bContent, int bDate, int bImage) {
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

	public int getbContent() {
		return bContent;
	}

	public void setbContent(int bContent) {
		this.bContent = bContent;
	}

	public int getbDate() {
		return bDate;
	}

	public void setbDate(int bDate) {
		this.bDate = bDate;
	}

	public int getbImage() {
		return bImage;
	}

	public void setbImage(int bImage) {
		this.bImage = bImage;
	}
	
}
