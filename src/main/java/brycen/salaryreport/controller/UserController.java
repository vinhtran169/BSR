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
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup(Model model) {
		User user= new User();
		model.addAttribute("user", user);
		return "signup";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(@ModelAttribute("user") User user, Model model) {
		if(userService.getUserByUserName(user.getUserName())) {
			model.addAttribute("message", "User Name exists. Try another user name");
			return "signup";
		} else {
			if(user.getUserName().isEmpty() && user.getPassword().isEmpty() && user.getEmail().isEmpty()){
				model.addAttribute("message", "Fill in all field!");
				return "signup";
			}else{
				userService.insertUser(user);
				model.addAttribute("message", "Saved student details");
				return "redirect:login.html";
			}
			
		}
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {
		UserLogin userLogin = new UserLogin();
		model.addAttribute("userLogin", userLogin);
		
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute("userLogin") UserLogin userLogin) {
		boolean found = userService.getUserByLogin(userLogin.getUserName(), userLogin.getPassword());
		if (found) {				
			return "success";
		} else {				
			return "failure";
		}
	}
}
