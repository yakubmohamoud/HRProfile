package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.model.UserInfo;

@Repository
public class UserDaoImpl implements UserDao {

		NamedParameterJdbcTemplate jdbcTemplate;
	@Autowired	
	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
			this.jdbcTemplate = jdbcTemplate;
		}

	public List<UserInfo> list() {
		// TODO Auto-generated method stub
		String sql = "select username from users;";
		List<UserInfo> list = jdbcTemplate.query(sql, getParameterSource(null, null), new UserMapper());
		return list;
	}
	private SqlParameterSource getParameterSource(String username, String password) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		if (username != null) {
			parameterSource.addValue("username", username);
			
		}
		if (password != null) {
			parameterSource.addValue("password", password);
			
		}
		return parameterSource;
		
	}
	
	private static final class UserMapper implements RowMapper<UserInfo> {

		public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			UserInfo user = new UserInfo();
			user.setUsername(rs.getString("username"));
			
			return user;
		}
		
	}

	public UserInfo findUserbyUsername(String username) {
		// TODO Auto-generated method stub
		
	String sql = "select username from users where username = :username";
	List<UserInfo> list = jdbcTemplate.query(sql, getParameterSource(username, null), new UserMapper());
	
			return list.get(0);
	}

	public void update(String username, String password) {
		// TODO Auto-generated method stub
		String sql = "update users set password = :password where username = :username";
		jdbcTemplate.update(sql, getParameterSource(username, password));
		
		
	}

	public void add(String username, String password) {
		// TODO Auto-generated method stub
		//Inserting users table
		String sql = "insert into users(username,password) values (:username, :password)";
		jdbcTemplate.update(sql, getParameterSource(username, password));
		//Inserting table user_roles
		sql = "insert into user_roles(username,role) values (:username,'ROLE_USER')";
		jdbcTemplate.update(sql,getParameterSource(username, password));
		
	}

	public boolean userExist(String username) {
		String sql = "select * from users where username = :username";
		List<UserInfo> list = jdbcTemplate.query(sql, getParameterSource(username, null), new UserMapper());
		if(list.size() > 0) {
			return true;
			
		}
		return false;
	}

	public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
