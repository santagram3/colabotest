package WORKERS.mypage.repository;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import com.example.news.dto.News;

import WORKERS.mypage.model.User;

@Mapper
public interface UserMapper {
	
	//내가 만든것 ! 
	boolean signUpUser(User user) throws Exception;
	
	
	public List<News> getAll() throws Exception;
	public News getNews(int aid) throws SQLException;
	public void addNews(News n) throws Exception;
	
	@Delete(" delete from news where aid=#{aid}")
	public void delNews(int aid) throws SQLException;

}
