package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.example.model.UserInfo;

public class LoginDaoImp implements LoginDao {
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public UserInfo findUserInfo(String username) {
		String sql =  "select username,password from users where username =:"; 
		UserInfo userInfo = namedParameterJdbcTemplate.queryForObject(sql, getsqParameterSource(username,""), new UserInfoMapper());
		return userInfo;
	}
	
	private static final class UserInfoMapper implements RowMapper <UserInfo>{

		public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			String username =rs.getString("username");
			String password =rs.getString("password");
			
			return new UserInfo(username, password);
		}
		
	}
	private SqlParameterSource getsqParameterSource(String username,String password) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("username",username);
		parameterSource.addValue("password",password);
		
		return parameterSource;
	}
	
	public List<String> getUserRoles(String username) {
		// TODO Auto-generated method stub
		String sql = "select user_roles where username = :";
		List<String> roles = namedParameterJdbcTemplate.queryForList(sql,getsqParameterSource(username, ""), String.class);
		
		return roles;
	}

}
