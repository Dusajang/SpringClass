package org.doit.ik.mapper;

import java.io.File;
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.doit.ik.domain.NoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

// @Transactional
public interface NoticeMapper {

   // XML 파일이 필요 없는 코딩 @Select("SELECT COUNT(*) CNT        FROM NOTICES       WHERE ${ filed } LIKE '%${ param2 }%'")
   public int getCount(@Param("field") String field, @Param("query")String query) throws ClassNotFoundException, SQLException;

   public List<NoticeVO> getNotices(int page, String field, String query) throws ClassNotFoundException, SQLException;

   public int delete(String seq) throws ClassNotFoundException, SQLException;

   public int update(NoticeVO notice) throws ClassNotFoundException, SQLException;

   public int insert(NoticeVO notice) throws ClassNotFoundException, SQLException;

   public NoticeVO getNotice(String seq) throws ClassNotFoundException, SQLException;

   // 새글작성 + 포인트 1증가
   //public void insertAndPointUpOfMember(NoticeVO notice, String id) throws ClassNotFoundException, SQLException;
   
   // [격리레벨]
   public void hitUp(String seq) throws ClassNotFoundException, SQLException ;   
   public int getHit(String seq) throws ClassNotFoundException, SQLException ;
   
}
