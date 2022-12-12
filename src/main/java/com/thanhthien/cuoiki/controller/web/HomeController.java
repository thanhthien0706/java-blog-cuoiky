package com.thanhthien.cuoiki.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@GetMapping(value = { "/", "/trang-chu" })
	private ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("web/home.html");
		return mav;
	}
}
