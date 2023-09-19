package com.jspiders.studentmvcapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jspiders.studentmvcapp.pojo.AdminPojo;
import com.jspiders.studentmvcapp.pojo.StudentPojo;
import com.jspiders.studentmvcapp.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	
	@GetMapping("/home")
	public String home(@SessionAttribute(name = "login", required = false)AdminPojo pojo, ModelMap map) {
		if (pojo != null) {
			return "Home";
		}
		map.addAttribute("msg", "Session Inactive, Login to proceed...");
		return "Login";
		
	}
	
	@GetMapping("/add")
	public String addPage(@SessionAttribute(name = "login", required = false)AdminPojo pojo, ModelMap map) {
		if (pojo != null) {
			List<StudentPojo> students = service.findAllStudents();
			if (!students.isEmpty()) {
				map.addAttribute("students", students);
				return "Add";
			}
			return "Add";
		}
		map.addAttribute("msg", "Session Inactive, Login To Proceed...");
		return "Login";
	}
	
	
	@PostMapping("/add")
	public String addStudents(@SessionAttribute (name = "login", required = false)AdminPojo admin, @RequestParam String name,
						@RequestParam String email, @RequestParam long contact, @RequestParam String address, ModelMap map) {
		if (admin != null) {
			StudentPojo pojo = service.addStudent(name, email, contact, address);
			
			if (pojo!= null) {
				map.addAttribute("msg", "Data Inserted Successfully");
				List<StudentPojo> students = service.findAllStudents();
				map.addAttribute("students", students);
				return "Add";
			}
			
			map.addAttribute("msg", "Data not inserted");
			List<StudentPojo> students = service.findAllStudents();
			if (!students.isEmpty()) {
				map.addAttribute("students", students);
			}
			return "Add";
		}
		map.addAttribute("msg", "Session Inactive, Login to Proceed...");
		return "Login";
	}
	
	@GetMapping("/remove")
	public String removePage(@SessionAttribute(name = "login", required = false) AdminPojo admin, ModelMap map) {
		if (admin != null) {
			List<StudentPojo> students = service.findAllStudents();
			if (!students.isEmpty()) {
				map.addAttribute("students", students);
				return "Remove";
			}
			map.addAttribute("msg", "No Data Present");
			return "Remove";
		}
		map.addAttribute("msg", "Session Inactive, Login to Proceed");
		return "Login";
	}
	
	@PostMapping("/remove")
	public String removeStudent(@SessionAttribute(name = "login", required = false)AdminPojo admin, @RequestParam int id, ModelMap map) {
		if (admin != null) {
			StudentPojo pojo = service.removeStudent(id);
			List<StudentPojo> students = service.findAllStudents();
			if (pojo != null) {
				map.addAttribute("msg", "Data Removed Successfully");
				map.addAttribute("students", students);
				return "Remove";
			}
			map.addAttribute("msg", "Data Doesn't Exist...");
			map.addAttribute("students", students);
			return "Remove";
		}
		map.addAttribute("msg", "Session Inactive, Login to Proceed");
		return "Login";
	}
	
	@GetMapping("/update")
	public String updatePage(@SessionAttribute(name = "login", required = false)AdminPojo admin, ModelMap map) {
		if (admin != null) {
			List<StudentPojo> students = service.findAllStudents();
			map.addAttribute("students", students);
			return "Update";
		}
		map.addAttribute("msg", "Session Inactive, Login to Proceed");
		return "Login";
	}
	
	@PostMapping("/update")
	public String updateForm(@SessionAttribute(name = "login", required = false)AdminPojo admin, @RequestParam int id, ModelMap map) {
		if (admin != null) {
			StudentPojo pojo = service.searchStudent(id);
			if (pojo != null) {
				map.addAttribute("student", pojo);
				return "Update";
			}
			List<StudentPojo> students = service.findAllStudents();
			map.addAttribute("students", students);
			map.addAttribute("msg", "Student Data Not Found");
			return "Update";
			
		}
		map.addAttribute("msg", "Session Inactive, Login to Proceed");
		return "Login";
	}
	
	@PostMapping("/updateStudent")
	public String updateStudent(@SessionAttribute(name = "login", required = false)AdminPojo admin,
					@RequestParam int id, @RequestParam String name, @RequestParam String email, @RequestParam long contact, 
					@RequestParam String address, ModelMap map) {
		if (admin != null) {
			StudentPojo pojo = service.updateStudent(id, name, email, contact, address);
			if (pojo != null) {
				List<StudentPojo> students = service.findAllStudents();
				map.addAttribute("msg", "Data Updated Successfully");
				map.addAttribute("students", students);
				return "Update";
			}
			List<StudentPojo> students = service.findAllStudents();
			map.addAttribute("msg", "Data Not Updated");
			map.addAttribute("students", students);
			return "Update";
		}
		map.addAttribute("msg", "Session Inactive, Login to Proceed");
		return "Login";
	}
	
	@GetMapping("/search")
	public String searchPage(@SessionAttribute(name = "login", required = false)AdminPojo admin, ModelMap map) {
		if (admin != null) {
			return "Search";
		}
		map.addAttribute("msg", "Session Inactive, Login to Proceed");
		return "Login";
	}
	
	@PostMapping("/search")
	public String searchStudent(@SessionAttribute(name = "login", required = false)AdminPojo admin, @RequestParam int id, ModelMap map) {
		if (admin != null) {
			StudentPojo pojo = service.searchStudent(id);
			if (pojo != null) {
				map.addAttribute("student", pojo);
				map.addAttribute("msg", "Student Data Found");
				return "Search";
			}
			map.addAttribute("msg", "Student Data Not Found");
			return "Search";
		}
		map.addAttribute("msg", "Invalid Session, Login to Proceed");
		return "Login";
	}
	
	
}
