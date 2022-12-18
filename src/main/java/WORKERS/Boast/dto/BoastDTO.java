package WORKERS.Boast.dto;

import java.util.Date;

public class BoastDTO {
 private int bNoSP;
 private String bTitle;
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
public Date getbDate() {
	return bDate;
}
public void setbDate(Date bDate) {
	this.bDate = bDate;
}

@Override
public String toString() {
	return "BoastDTO [bNoSP=" + bNoSP + ", bTitle=" + bTitle + ", bDate=" + bDate + "]";
}
 
 

 
 
}
