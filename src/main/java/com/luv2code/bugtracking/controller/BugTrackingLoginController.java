package com.luv2code.bugtracking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BugTrackingLoginController {

	@RequestMapping("/showMyLoginPage")
	public String showLoginPage() {
		return "plain-login";
	}
}
