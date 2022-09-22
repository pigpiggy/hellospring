package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.vo.EmaillistVo;
import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {
  
  @Autowired
  private SqlSession sqlSession;

  
  public List<GuestbookVo> getList(){
    System.out.println("----> sqlSession.selectList()");
    System.out.println(sqlSession);

    return sqlSession.selectList("GuestBookXml.selectList");
  }
  
  public int insert(GuestbookVo vo) {
		System.out.println("insert:" + vo); //vo 객체 잘 들어왔는지 확인
		return sqlSession.insert("GuestBookXml.insert", vo);
		  
	  }
  
  public int delete(int no) {
		System.out.println("delete:" + no); //vo 객체 잘 들어왔는지 확인
		return sqlSession.delete("GuestBookXml.delete", no);
		  
	  }
}
