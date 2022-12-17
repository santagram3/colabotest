package WORKERS.newsExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component // 빈등록 하는거에요
public class NewsDAO {
	final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";

	// DB 연결을 가져오는 메서드, DBCP를 사용하는 것이 좋음
	public Connection open() {
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL, "java", "oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public List<News> getAll() throws Exception {
		Connection conn = open();
		List<News> newsList = new ArrayList<>();

		String sql = "select aid, title, regdate as cdate from news";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		// try~with~resources
		try (conn; pstmt; rs;) {
			while (rs.next()) {
				News n = new News();
				n.setAid(rs.getInt("aid"));
				n.setTitle(rs.getString("title"));
				n.setRegDate(rs.getString("cdate"));
				newsList.add(n);
			}
			return newsList;
		}
	}

	public News getNews(int aid) throws SQLException {
		Connection conn = open();

		// News n = new News();
		String sql = "select aid, title, img, regdate as cdate, content from news where aid=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		// 물음표 첫번째 = aid == // 이 메서드 안으로 들어온 int aid 를 말하는것임 !
		pstmt.setInt(1, aid);
		ResultSet rs = pstmt.executeQuery();
		// 쿼리의 결과물을 하나를 가져옴
		rs.next();

		try (conn; pstmt; rs) {
			News n = new News();
			n.setAid(rs.getInt("aid"));
			n.setTitle(rs.getString("title"));
			n.setImg(rs.getString("img"));
			n.setRegDate(rs.getString("cdate"));
			n.setContent(rs.getString("content"));
			// pstmt.executeQuery();
			return n;
		}
	}

	public void addNews(News n) throws Exception {
		System.out.println("DAO");
		System.out.println(n.getTitle());
		System.out.println(n.getAid());
		System.out.println(n.getContent());
		System.out.println(n.getImg());
		Connection conn = open();
		String sql = "insert into news(aid,title,img,regdate,content) "
					+ " values(new_seq.nextval,?,?,sysdate,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		try (conn; pstmt) {
			pstmt.setString(1, n.getTitle());
			pstmt.setString(2, n.getImg());
			pstmt.setString(3, n.getContent());
			pstmt.executeUpdate();
		}
	}
	
	public void ModifyNews(News n) throws Exception {
		System.out.println("ModiDAO");
		System.out.println(n.getAid());
		System.out.println(n.getTitle());
		System.out.println(n.getContent());
		System.out.println(n.getImg());
		Connection conn = open();
		String sql = "update news set title=?, img=?, content=?"
					+ " where aid = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		try (conn; pstmt) {
			pstmt.setString(1, n.getTitle());
			System.out.println("title update");
			pstmt.setString(2, n.getImg());
			System.out.println("img update");
			pstmt.setString(3, n.getContent());
			System.out.println("content update");
			pstmt.setInt(4, n.getAid());
			System.out.println("where aid = " +n.getAid());
			pstmt.executeUpdate();
		}
	}


	public void delNews(int aid) throws SQLException {
		Connection conn = open();

		String sql = "delete from news where aid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		try (conn; pstmt) {
			pstmt.setInt(1, aid);
			// 삭제된 뉴스 기사가 없을 경우
			if (pstmt.executeUpdate() == 0) {
				throw new SQLException("DB에러");
			}
		}
	}
}