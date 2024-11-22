package org.doit.ik.persistence;

import java.io.File;
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.doit.ik.domain.NoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public interface NoticeDao {

	int getCount(String field, String query) throws ClassNotFoundException, SQLException;

	List<NoticeVO> getNotices(int page, String field, String query) throws ClassNotFoundException, SQLException;

	int delete(String seq) throws ClassNotFoundException, SQLException;
	
	
	
	
}
