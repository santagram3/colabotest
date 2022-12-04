package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component // 빈등록 하는거에요 
public class BoastDAO {
	final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	
	// DB 연결을 가져오는 메서드, DBCP를 사용하는 것이 좋음
	public Connection open() {
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL,"java","oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public List<Boast> getAll() throws Exception {
		Connection conn = open();
		List<Boast> newsList = new ArrayList<>();
		
		String sql = "select bNoSP, bTitle, bDate as cdate from BoastTable order by regdate";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		try(conn; pstmt; rs) {
			while(rs.next()) {
				Boast b = new Boast();
				b.setbNoSP(rs.getInt("bNoSP"));
				b.setbTitle(rs.getString("bTitle"));
				b.setbDate(rs.getString("cdate")); 
				
				newsList.add(b);
			}
			return newsList;			
		}
	}
	
	public Boast getBoast(int bNoSP) throws SQLException {
		Connection conn = open();
		
		Boast b = new Boast();
		String sql = "select bNoSP, bTitle, bImage, bDate as cdate from BoastTable where bNoSP=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		pstmt.setInt(1, bNoSP);
		rs.next();
		
		try(conn; pstmt; rs) {
			b.setbNoSP(rs.getInt("bNoSP"));
			b.setbTitle(rs.getString("bTitle"));
			b.setbImage(rs.getString("bImage"));
			b.setbDate(rs.getString("cdate"));
			b.setbContent(rs.getString("bContent"));
			pstmt.executeQuery();
			return b;
		}
	}
	
public void addBoast(Boast b) throws Exception {
		Connection conn = open();
		
		String sql ="insert into news(bNoSP,bTitle,bimage,bDate,bContent) "
				  + " values(new_seq.nextval,?,?,sysdate,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		try(conn; pstmt) {
			pstmt.setString(1, b.getbTitle());
			pstmt.setString(2, b.getbImage());
			pstmt.setString(3, b.getbContent());
			pstmt.executeUpdate();
		}
	}
	
	public void delBoast(int bNoSP) throws SQLException {
		Connection conn = open();
		
		String sql = "delete from BoastTable where bNoSP=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		try(conn; pstmt) {
			pstmt.setInt(1, bNoSP);
			// 삭제된 뉴스 기사가 없을 경우
			if(pstmt.executeUpdate() == 0) {
				throw new SQLException("DB에러");
			}
		}
	}

	public void updateBoast(int bNoSP, String bTitle, String bImage, String bContent) throws SQLException {
		Connection conn = open();
		System.out.println("121212");
		System.out.println(bTitle);
		System.out.println(bImage);
		System.out.println(bContent);
		
		String sql ="update BoastTable set bTitle=?, bImage=?, bDate=sysdate, bContent=? where bNoSP=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		try(conn; pstmt) {
			pstmt.setString(1, bTitle);
			pstmt.setString(2, bImage);
			pstmt.setString(3, bContent);
			pstmt.setInt(4, bNoSP);
			pstmt.executeUpdate();
		}
		
	}
	
	public void addCom(int aid, String nickname, String commentContent) throws SQLException {
		Connection conn = open();
		
		String sql ="insert into comments(commentAid,nickname,commentContent,commentDate,aid)"
				  + " values(com_seq.nextval,?,?,sysdate,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		try(conn; pstmt) {
			pstmt.setString(1, nickname);
			pstmt.setString(2, commentContent);
			pstmt.setInt(3, aid);
			pstmt.executeUpdate();
		}		
	}
	
	public List<Comment> getAllComment(int aid) throws Exception {
		Connection conn = open();
		List<Comment> commentlist = new ArrayList<>();
		
		String sql = "select commentAid,nickname,commentContent,commentDate from comments where aid=? order by commentDate";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, aid);
		ResultSet rs = pstmt.executeQuery();
		
		try(conn; pstmt; rs) {
			while(rs.next()) {
				Comment c = new Comment();
				c.setCommentAid(rs.getInt("commentAid"));
				c.setNickname(rs.getString("nickname"));
				c.setCommentContent(rs.getString("commentContent"));
				c.setCommentDate(rs.getString("commentDate")); 
				
				commentlist.add(c);
			}
			return commentlist;			
		}
	}

	public Comment getComments(int aid) throws SQLException {
		Connection conn = open();
		
		Comment c = new Comment();
		String sql = "select commentAid, nickname, commentContent, commentDate, aid from comments where aid=?";
	
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, aid);
		ResultSet rs = pstmt.executeQuery();
		
		rs.next();
		
		try(conn; pstmt; rs) {
			c.setCommentAid(rs.getInt("commentAid"));
			c.setNickname(rs.getString("nickname"));
			c.setCommentContent(rs.getString("commentContent"));
			c.setCommentDate(rs.getString("commentDate"));
			c.setaid(rs.getInt("aid"));
			
			return c;
		}
	}

	public void delComments(int commentAid) throws SQLException {
		Connection conn = open();
		
		String sql = "delete from comments where commentAid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		try(conn; pstmt) {
			pstmt.setInt(1, commentAid);
			if(pstmt.executeUpdate() == 0) {
				throw new SQLException("DB에러");
			}
		}
		
	}

	public int getAidInComments(int commentAid) throws SQLException {
		Connection conn = open();
		
		Comment c = new Comment();
		String sql = "select aid from comments where commentAid=?";
	
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, commentAid);
		ResultSet rs = pstmt.executeQuery();
		
		rs.next();
		
		try(conn; pstmt; rs) {
			
			c.setaid(rs.getInt("aid"));
			System.out.println(c.getaid());
			return c.getaid();
		}
		
	}

	public void updateComments(int commentAid, String nickname, String commentContent) throws SQLException {
		Connection conn = open();
		
		String sql = "update comments set commentContent=?, commentDate=sysdate where commentAid=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		try(conn; pstmt;) {
			pstmt.setString(1, commentContent);
			pstmt.setInt(2, commentAid);
			pstmt.executeUpdate();
		}
	}
	
	
}