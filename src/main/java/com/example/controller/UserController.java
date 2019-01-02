package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.form.UserForm;
import com.example.model.UserInfo;
import com.example.service.UserService;
import com.example.validator.SignupValidation;

@Controller
@RequestMapping("/")
public class UserController {
	@Autowired
	SignupValidation  signupValidation;
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/list", method= RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("user/list");
		model.addObject("list", userService.list());
		
		
		return model;
		
	}
	@RequestMapping(value= "/changePass/{username}", method= RequestMethod.GET)
	public ModelAndView changePass(@PathVariable("username") String username) {
		ModelAndView model = new ModelAndView("user/change_pass");
		model.addObject("user", userService.findUserbyUsername(username));
		
		return model;
		
	}
	@RequestMapping(value= "/save", method=RequestMethod.GET)
	public ModelAndView save (@ModelAttribute("user") UserInfo user) {
		//the name of the JSP 
		ModelAndView model = new ModelAndView("/user/change_pass");
		userService.update(user.getUsername(), user.getPassword());
		model.addObject("msg", "Password change successful!");
		return model;
		
	}
	@RequestMapping(value= "/signup", method=RequestMethod.GET)
	public ModelAndView signup() {
		//name of the jsp class
		ModelAndView model = new ModelAndView("/user/signup");
		model.addObject("user",new UserForm());
		return model;
		
	}
	@RequestMapping(value = "/register", method=RequestMethod.GET)
	public String register(@ModelAttribute("userform")UserForm userform, BindingResult result, RedirectAttributes redirectAttributes){
		signupValidation.validate(userform, result);
		
		if(result.hasErrors()) {
			return "/user/signup";
			
		}else {
			userService.add(userform.getUser(), userform.getPassword());
			redirectAttributes.addFlashAttribute("msg","Your account has been created successfully");
		
		}
		
		return "redirect:/login";
		
		
		
		
	}

}
