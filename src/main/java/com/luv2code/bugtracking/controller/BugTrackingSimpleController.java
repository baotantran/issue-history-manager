package com.luv2code.bugtracking.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// Empty object for input data from user 
		BugInformation bugInformation = new BugInformation();
		
		// Pass the empty object to model to be pass to JSP
		theModel.addAttribute("bugInformation", bugInformation);
		
		return "bug-save-form";
	}
	
	@PostMapping("/saveBugInformation")
	public String saveBugInformation(@Valid @ModelAttribute("bugInformation") BugInformation bugInformation,
										BindingResult theBindingResult) {
		if(theBindingResult.hasErrors()) {
			return "bug-save-form";
		} else {
		bugTrackingDao.saveBug(bugInformation);
		
		return "redirect:/list";
		}
	}
		
	@RequestMapping("/updateBugInformation")
	public String showFormForUpdate(@RequestParam("bugId") int bugId, Model theModel) {
		
		BugInformation bugInformation = bugTrackingDao.getBugById(bugId);
		
		theModel.addAttribute("bugInformation", bugInformation);
		
		return "bug-save-form";
		
	}
	
	@RequestMapping("/deleteBugInformation")
	public String deleteBugInformation(@RequestParam("bugId") int bugId) {
		
		bugTrackingDao.deleteBug(bugId);
		
		return "redirect:/list";
	}
		
	@RequestMapping("/showMyLoginPage")
	public String showLoginPage() {
		return null;
	}
	
	
}
