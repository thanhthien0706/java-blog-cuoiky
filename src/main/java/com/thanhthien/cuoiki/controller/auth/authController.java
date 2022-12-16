package com.thanhthien.cuoiki.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.core.model.Model;

@Controller
public class authController {

	@GetMapping("/dang-nhap")
	private ModelAndView getLogin() {
		ModelAndView mav = new ModelAndView("login.html");
		return mav;
	}

	@GetMapping("/dang-ky")
	private ModelAndView getSignUp() {
		ModelAndView mav = new ModelAndView("signup.html");
		return mav;
	}

	@PostMapping("/dang-nhap")
	private String postLogin() {
//		ModelAndView mav = new ModelAndView("login.html");
		return "dang nhap";
	}
}
