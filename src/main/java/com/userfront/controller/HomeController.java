package com.userfront.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.userfront.domain.User;
import com.userfront.domain.UserService;

@Controller
public class HomeController {
	
	private UserService userService;

	@GetMapping({"/"})
	public String home(Model model) {
		return "redirect:/index";
	}
	
	@GetMapping({"/index"})
	public String index(Model model) {
		return "index";
	}
	
	@GetMapping({"/signup"})
	public String signup(Model model) {

		User user = new User();
		
		model.addAttribute("user", user);
		
		return "signup";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signupPost(@ModelAttribute("user") User user,  Model model) {

		if(userService.checkUserExists(user.getUsername(), user.getEmail())) {
			
			if(userService.checkEmailExists(user.getEmail())) {
				model.addAttribute("emailExists", true);
			}
			
			if(userService.checkUsernameExists(user.getUsername())) {
				model.addAttribute("usernameExists", true);
			}
			return "signup";
			
		} else {
			userService.save(user);
			
			return "redirect:/";
		}
		
    }
}
