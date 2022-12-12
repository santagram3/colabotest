package WORKERS.config;


import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.HikariConfig;

import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration

public class DataBaseConfig {
	
	@Value("${spring.datasource.driver-class-name}")  // 1
	private String driver;
	@Value("${spring.datasource.url}")  // 1
	private String url;
	@Value("${spring.datasource.username}")  // 1
	private String username;
	@Value("${spring.datasource.password}")  // 1
	private String password;
	
		@Bean
		public DataSource dataSource() {
			HikariConfig hikariConfig = new HikariConfig();
			
			hikariConfig.setDriverClassName(driver);
			hikariConfig.setJdbcUrl(url);
			hikariConfig.setUsername(username);
			hikariConfig.setPassword(password);

			return new HikariDataSource(hikariConfig); // 4
	    }

}
