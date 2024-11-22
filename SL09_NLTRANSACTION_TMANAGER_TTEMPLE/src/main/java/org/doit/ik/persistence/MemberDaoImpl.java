package org.doit.ik.persistence;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.doit.ik.domain.MemberVO;
import org.doit.ik.domain.NoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	// 추가됨
	@Autowired
	private NamedParameterJdbcTemplate npJdbcTemplate;
	
	@Override
	public MemberVO getMember(String id) throws ClassNotFoundException, SQLException
	{
		String sql = " SELECT * "
					+ " FROM member "
					+ " WHERE id = :id ";

		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", id);
		
		return this.npJdbcTemplate.queryForObject(sql, paramSource, new BeanPropertyRowMapper<MemberVO>(MemberVO.class)); // 1개의 레코드
	}
	
	@Override
	public int insert(MemberVO member) {
	    String sql = "INSERT INTO MEMBER "
	               + "(id, pwd, name, gender, birth, is_lunar, cphone, email, habit, regdate) "
	               + "VALUES (:id, :pwd, :name, :gender, :birth, :is_lunar, :cphone, :email, :habit, SYSDATE)";

	    SqlParameterSource paramSource = new BeanPropertySqlParameterSource(member);

	    return this.npJdbcTemplate.update(sql, paramSource);
	}
}
