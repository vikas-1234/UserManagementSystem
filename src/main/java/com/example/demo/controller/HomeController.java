package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserDtls;
import com.example.demo.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RestController
public class HomeController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String index()
	{
		return "index";
	}
	@GetMapping("/signin")
	public String login()
	{
		return "login";
	}
	@GetMapping("/register")
	public String register()
	{
		return "register";
	}
	
	@PostMapping("/createUser")
	public String createUser(@ModelAttribute UserDtls  user, HttpSession session ) {
		System.out.println("HomeController:createUser: user= " + user);
		boolean f=userService.checkEmail(user.getEmail());
		if (f) {
		  session.setAttribute("msg","Email id already exist");
		}
		else
		{
			UserDtls userDtls=userService.createUser(user);
			if (userDtls!=null) {

				  session.setAttribute("msg","Register Successfully");
			} else {
				  session.setAttribute("msg","Something went wrong on server side!!!");
			}
		}
			return "redirect:/register";
			
	
		
		
		
	}

}
