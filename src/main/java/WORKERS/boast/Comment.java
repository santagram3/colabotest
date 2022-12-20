package WORKERS.boast;



import java.sql.Date;


public class Comment {
	private int commentAid;
	private String nickname;
	private String commentContent;
	private Date commentDate;
	private int aid;
	
	
	public int getCommentAid() {
		return commentAid;
	}


	public void setCommentAid(int commentAid) {
		this.commentAid = commentAid;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getCommentContent() {
		return commentContent;
	}


	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}


	public Date getCommentDate() {
		return commentDate;
	}


	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}


	public int getAid() {
		return aid;
	}


	public void setAid(int aid) {
		this.aid = aid;
	}


	@Override
	public String toString() {
		return "Comment [commentAid=" + commentAid + ", nickname=" + nickname + ", commentContent=" + commentContent
				+ ", commentDate=" + commentDate + ", aid=" + aid + "]";
	}
	
}
