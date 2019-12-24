package com.mindtree.readwriteexcelfile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mindtree.readwriteexcelfile.entity.UserForm;
import com.mindtree.readwriteexcelfile.service.UserFormService;

@Controller
public class FormController {

	@Autowired
	UserFormService service;
	
	@GetMapping("/")
	public String showUserForm() {
		return "userform";
	}
	
	@PostMapping("/formAdded")
	public String addForm(UserForm userForm) {
		
		service.insertFormToDB(userForm);
		
		return "userform";
	}
	
	@PostMapping("/readfromfile")
	public String readFile() {
		
		List<UserForm> users = service.readFromFile();
		users.forEach(user->{
			System.out.println(user.getUserId()+"  "+user.getUserName()+"  "+user.getMobile()+"  "+user.getDesignation()+"  "+user.getGender()+"   "+user.getEmail());
		});
		return "userform";
	}
}
