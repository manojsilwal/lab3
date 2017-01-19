package com.example.controller;

import java.net.HttpCookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.service.UserSerivce;
import com.example.service.UserServiceImpl;

@Controller
public class HomeController {
	@Autowired
	UserSerivce userService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String welcomePage() {
		return "home";
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam("name") String name, @RequestParam("pass") String pass,
			Model model, HttpSession session, @RequestParam(value="remember",required = false) String remember, 
			@CookieValue(value="username",defaultValue="") String username, HttpServletResponse response, 
			RedirectAttributes redirectAttribute) {
		if("on".equals(remember)&&username.isEmpty()){
			Cookie cookie1 = new Cookie("username", name);
			cookie1.setMaxAge(60*60*24*30);
			response.addCookie(cookie1);
		}
		if(!("on".equals(remember))){
			Cookie cookie1 = new Cookie("username", null);
			cookie1.setMaxAge(0);
			response.addCookie(cookie1);
		}
		if(userService.loginCheck(name, pass)){
			session.setAttribute("name", name);
			return "welcome";
		}
		else{
			redirectAttribute.addFlashAttribute("error","UserName and/or password incorrect");
			return "redirect:/login";
		}
 	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginpage(Model model) {
		return "login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome() {
		return "welcome";
	}
	
}
