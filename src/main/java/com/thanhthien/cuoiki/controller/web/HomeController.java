package com.thanhthien.cuoiki.controller.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.thanhthien.cuoiki.security.CustomUserDetails;

@Controller
public class HomeController {

	@GetMapping(value = { "/", "/trang-chu", "/bai-viet" })
	private ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("web/home.html");
		return mav;
	}
}
