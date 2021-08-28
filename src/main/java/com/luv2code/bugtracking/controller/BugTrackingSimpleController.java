package com.luv2code.bugtracking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.bugtracking.dao.BugTrackingDao;
import com.luv2code.bugtracking.entity.BugInformation;

@Controller
public class BugTrackingSimpleController {
	
	@Autowired
	private BugTrackingDao bugTrackingDao;
	
	@RequestMapping("/")
	public String homePage() {
		
		return "home-page";
	}
	
	@RequestMapping("/list")
	public String listAllBug(Model theModel) {
		
		List<BugInformation> list = bugTrackingDao.getAllBug();
		
		theModel.addAttribute("bugList", list);
		
		return "list";
	}
	
}
