package com.thanhthien.cuoiki.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.thanhthien.cuoiki.form.SignupForm;
import com.thanhthien.cuoiki.model.UserEntity;
import com.thanhthien.cuoiki.services.impl.UserService;

import ch.qos.logback.core.model.Model;

@Controller
public class authController {

	@Autowired
	private UserService userService;

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
		System.out.println("Chao ban Da vao Login");
//		ModelAndView mav = new ModelAndView("login.html");
		return "dang nhap";
	}

	@PostMapping(value = { "/dang-ky" })
	private ModelAndView postSignUp(@ModelAttribute SignupForm signupForm) {

		ModelAndView mav;
		UserEntity user = userService.saveUser(signupForm);

		if (user != null) {
			mav = new ModelAndView("login.html");
		} else {
			mav = new ModelAndView("signup.html");
		}

		return mav;
	}
}
