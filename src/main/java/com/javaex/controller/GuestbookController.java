package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Controller
public class GuestbookController {
  @Autowired
  GuestbookDao guestbookDao;
  
//  GuestbookDao guestbookDao = new GuestbookDao();
  
  @RequestMapping("/getGuestbookList")
  public ModelAndView getGuestbookList( ModelAndView mav) {
    System.out.println(">>> "+this.getClass()+ " 호출됨!");
    
//    mav = new ModelAndView(); 
    
    mav.addObject( "guestbookList", guestbookDao.getList() );
    mav.setViewName( "/WEB-INF/views/getGuestbookList.jsp" );
    //mav.setViewName( "getGuestbookList" );
    return mav;
  }
  
  @RequestMapping(value="/insert")
  public String insert(@ModelAttribute GuestbookVo guestbookVo) { //list페이지에 name을 일치시켜줘야 함
	  System.out.println("insert");
	  System.out.println(guestbookVo);
	  
	  guestbookDao.insert(guestbookVo);
	  return "redirect:/getGuestbookList"; // /뒤에건 url 
  }
  
  @RequestMapping(value="/deleteform", method=RequestMethod.GET)
  public String form(@RequestParam("no") String no) {
	  System.out.println("deleteform:" + no);
	  return "/WEB-INF/views/deleteform.jsp"; //굳이 requestParam 안쓰고 deleteform.jsp에서 그냥 param.no 하면 꺼내져
  }
  
  @RequestMapping(value="/guestbookdelete", method=RequestMethod.POST)
	public String delete(@RequestParam("no") String no, @RequestParam("password") String password,
			@RequestParam("pass") String pass) {//modelAttribute로 해보자 얘는 세터보다 먼저 빈생성자부터 호출하니까 필요해..
	  int num = Integer.parseInt(no);
	  System.out.println("guestbookdelete:" + no + password + pass);
	  
	  if(pass.equals(password)) { //pass는 기존 비밀번호 password는 삭제할 때 사용자가 입력하는 비밀번호 
		  guestbookDao.delete(num);
	  }
	  
	  System.out.println("guestbookdelete");
	  System.out.println(no);
	  
	  return "redirect:/getGuestbookList";
	  
  }

  
}