package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Controller
@RequestMapping("/guest")
public class GuestController {
	
	///////////////////////
	// field
	///////////////////////
	
	
	///////////////////////
	// constructor
	///////////////////////
	
	
	///////////////////////
	// method
	/////////////////////// 
	@RequestMapping(value="addList", method= {RequestMethod.GET, RequestMethod.POST})
	public String addList(Model model) {
		System.out.println("/guest/addList");
		
		GuestbookDao guestDao = new GuestbookDao();
		List<GuestbookVo> guestList = guestDao.getList();
		
		model.addAttribute("guestList", guestList);
		
		return "/WEB-INF/views/addList.jsp";
	}
	
	@RequestMapping(value="deleteForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String deleteForm(@RequestParam int no, Model model) {
		System.out.println("/guest/deleteForm");
		
		model.addAttribute("no", no);
		
		return "/WEB-INF/views/deleteForm.jsp";
	}
	
	@RequestMapping(value="delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@ModelAttribute GuestbookVo gvo) {
		System.out.println("/gueset/delete");
		
		System.out.println(gvo);
		
		GuestbookDao guestDao = new GuestbookDao();
		guestDao.delete(gvo);
		
		return "redirect:/guest/addList";
	}
	
	@RequestMapping(value="insert", method= {RequestMethod.GET, RequestMethod.POST})
	public String insert(@ModelAttribute GuestbookVo gvo) {
		System.out.println("/guest/insert");
		
		GuestbookDao guestDao = new GuestbookDao();
		guestDao.addGuest(gvo);
		
		return "redirect:/guest/addList";
	}
}
