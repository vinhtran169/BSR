package brycen.salaryreport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import brycen.salaryreport.model.User;
import brycen.salaryreport.model.UserLogin;
import brycen.salaryreport.service.UserService;

@Controller
@SessionAttributes("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value= "/login", method = RequestMethod.GET)
	public String login(Model model){
		UserLogin userLogin = new UserLogin();
		model.addAttribute("userLogin", userLogin);
		return "login";
	}

	@RequestMapping(value ="/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("userLogin") UserLogin userLogin){
		boolean found = userService.getUserByLogin(userLogin.getUsername(), userLogin.getPassword());
		if(found){
			return "success";
		}else 
		return "failure";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model){
		User user = new User();
		model.addAttribute("user", user);
		return "signup";
	}
	
	@RequestMapping(value ="/signup", method = RequestMethod.POST)
		public String signup(@ModelAttribute("user") User user, Model model){
		boolean isExist = userService.getUserByUserName(user.getUsername());
		if(isExist){
			model.addAttribute("message", "Username is exist.");
			return "signup";
		}else{
			userService.insertUser(user);
			model.addAttribute("message", "Saved!");
			return "redirect:login.html";
		}
		
	}
}
