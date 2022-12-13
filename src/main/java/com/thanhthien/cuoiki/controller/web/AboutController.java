package com.thanhthien.cuoiki.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AboutController {

	@GetMapping(value = { "/chung-toi" })
	private ModelAndView aboutPage() {
		ModelAndView mav = new ModelAndView("web/about-us.html");
		return mav;
	}
}
