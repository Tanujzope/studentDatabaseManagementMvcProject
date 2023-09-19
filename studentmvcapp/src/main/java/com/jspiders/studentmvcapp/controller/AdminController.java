package com.jspiders.studentmvcapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.studentmvcapp.pojo.AdminPojo;
import com.jspiders.studentmvcapp.service.AdminService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
	@Autowired
	private AdminService service;
	
	
	@GetMapping("/createAccount")
	public String createAccountPage(ModelMap map) {
		AdminPojo pojo = service.getAdmin();
		
		if (pojo != null) {
			map.addAttribute("msg", "Account Already Exist...");
			return "Login";
		}
		return "CreateAccount";
	}
	
	
	@PostMapping("/createAccount")
	public String createAccount(@RequestParam String username, @RequestParam String password, ModelMap map) {
		AdminPojo pojo = service.createAccount(username, password);
		if (pojo != null) {
			map.addAttribute("msg", "Account Created Successfully...");
			return "Home";
		}
		
		map.addAttribute("msg", "Account Not Created...");
		return "Login";
	}
	
	
	@PostMapping("/login")
	public String login(@RequestParam String username, String password, ModelMap map, HttpSession session) {
		AdminPojo pojo = service.login(username, password);
		if (pojo != null) {
			session.setAttribute("login", pojo);
			return "Home";
		}
		
		map.addAttribute("msg", "Invalid Username or Password...");
		return "Login";
	}
	
	@GetMapping("/logout")
	public String logout(ModelMap map, HttpSession session) {
		session.invalidate();
		map.addAttribute("msg", "Logged Out Successfully");
		return "Login";
	}
}
