package brycen.salaryreport.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import brycen.salaryreport.model.User;
import brycen.salaryreport.model.UserLogin;
import brycen.salaryreport.service.UserService;

@Controller
@SessionAttributes("user")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		UserLogin userLogin = new UserLogin();
		model.addAttribute("userLogin", userLogin);
		return "login";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("userLogin") UserLogin userLogin,
			Model model) {
		if (!userLogin.getUsername().isEmpty()
				&& !userLogin.getPassword().isEmpty()) {
			boolean found = userService.getUserByLogin(userLogin.getUsername(),
					userLogin.getPassword());
			if (found) {
				return "success";
			} else
				return "failure";
		} else {
			model.addAttribute("message", "Fill in all fields");
			return "login";
		}
	}
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "signup";
	}
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(@ModelAttribute("user") User user, Model model) {
		boolean isExist = userService.getUserByUserName(user.getUsername());
		if (isExist) {
			model.addAttribute("message", "Username is exist.");
			return "signup";
		} else {
			if (user.getUsername().isEmpty() || user.getPassword().isEmpty()
					|| user.getEmail().isEmpty()) {
				model.addAttribute("message", " Fill in all fields");
				return "signup";
			} else {
				userService.insertUser(user);
				model.addAttribute("message", "Saved!");
				return "redirect:login.html";
			}
		}
	}
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user(Model model) {
		List<User> userlist = userService.getAllUser();
		model.addAttribute("userList", userlist);
		return "user";
	}
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String user(@RequestParam(value = "sltEdit") Long[] id, Model model,
			HttpServletRequest request) {
		String action = request.getParameter("action");
		if (id.length == 1 && id != null) {
			if (action.equals("edit")) {
				model.addAttribute("message", "Enter new infomation");
				return "redirect:/user/" + id[0] + "/edit";				
			} else {
				return "redirect:/user/" + id[0] + "/delete";
			}
		} else {
			model.addAttribute("message", "Select only a checkbox");
			return "user";
		}
	}
	@RequestMapping(value = "/user/{id}")
	public String profileUser(@PathVariable("id") Long id, Model model) {
		User user = (User) userService.getUserByID(id);
		model.addAttribute("user", user);
		return "profile";
	}
	@RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
	public String editProfile(@ModelAttribute("user") User user, Model model) {
		if (!user.getUsername().isEmpty() && !user.getPassword().isEmpty()
				&& !user.getEmail().isEmpty()) {
			userService.updateUser(user);
			model.addAttribute("message", "Update sucessful");
			return "redirect:/user";
		} else {
			model.addAttribute("message", "Fill all field");
			return "redirect:/user";
		}
	}
	@RequestMapping(value = "/user/{id}/edit")
	public String editProfile(@PathVariable("id") Long id, Model model) {
		User user = (User) userService.getUserByID(id);
		model.addAttribute("user", user);
		return "editProfile";
	}
	@RequestMapping(value = "/user/{id}/delete")
	public String delete(@PathVariable("id") Long id, Model model) {
		User user = (User) userService.getUserByID(id);
		userService.deleteUser(user);
		model.addAttribute("message", "Deleted");
		return "redirect:/user";
	}
}
