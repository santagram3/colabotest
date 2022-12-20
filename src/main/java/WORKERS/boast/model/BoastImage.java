package WORKERS.boast.model;

public class BoastImage {

	private int bImageNoF;
	private String bImage;

	public int getbImageNoF() {
		return bImageNoF;
	}

	public void setbImageNoF(int bImageNoF) {
		this.bImageNoF = bImageNoF;
	}

	public String getbImage() {
		return bImage;
	}

	public void setbImage(String bImage) {
		this.bImage = bImage;
	}

	@Override
	public String toString() {
		return "BoastImg [bImageNoF=" + bImageNoF + ", bImage=" + bImage + "]";
	}

}
