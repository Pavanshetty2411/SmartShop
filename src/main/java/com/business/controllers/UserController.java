package com.business.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.business.entities.User;
import com.business.services.UserServices;

@Controller
public class UserController
{
	@Autowired
	private UserServices services;
	
	@GetMapping("/register")
	public String showRegisterForm(Model model) {
	    model.addAttribute("user", new User());
	    return "register";
	}
	@PostMapping("/register")
    public String addnewUser(@ModelAttribute User user) {
        System.out.println("New User: " + user);
        this.services.addUser(user);
        return "redirect:/login";
    }
	@PostMapping("/addingUser")
	public String  addUser(@ModelAttribute User user)
	{
		System.out.println(user);
		this.services.addUser(user);
		return "redirect:/admin/services";
	}

	@PostMapping("/updatingUser/{id}")
	public String updateUser(@ModelAttribute User user, @PathVariable("id") int id)
	{
		this.services.updateUser(user, id);
		return "redirect:/admin/services";
	}

	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable("id" )int id)
	{
		this.services.deleteUser(id);
		return "redirect:/admin/services";
	}



}
