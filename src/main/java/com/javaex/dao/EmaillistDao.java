package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.EmaillistVo;

@Repository
public class EmaillistDao {
  
  @Autowired
  private SqlSession sqlSession;

  
  
  public List<EmaillistVo> getList(){
	System.out.println("----> sqlSession.selectList()"); //진입했는지
    System.out.println(sqlSession); //콘솔에 찍어보려고

    return sqlSession.selectList("emaillist.list"); //namespace 자리, query문장 ID
  }
  
  public int insert(EmaillistVo vo) {
	System.out.println("insert:" + vo); //vo 객체 잘 들어왔는지 확인
	return sqlSession.insert("emaillist.insert", vo);
	  
  }
  
  public int delete(int no) {
		System.out.println("delete:" + no); //vo 객체 잘 들어왔는지 확인
		return sqlSession.delete("emaillist.delete", no);
		  
	  }
}
