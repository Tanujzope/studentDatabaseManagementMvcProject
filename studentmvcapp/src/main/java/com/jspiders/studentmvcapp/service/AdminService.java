package com.jspiders.studentmvcapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.studentmvcapp.pojo.AdminPojo;
import com.jspiders.studentmvcapp.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository repository;
	
	
	public AdminPojo getAdmin() {
		AdminPojo pojo = repository.getAdmin();
		return pojo;
	}

	public AdminPojo createAccount(String username, String password) {
		AdminPojo pojo = repository.createAccount(username, password);
		return pojo;
	}

	public AdminPojo login(String username, String password) {
		AdminPojo pojo = repository.login(username, password);
		return pojo;
	}

	

	
	

}
