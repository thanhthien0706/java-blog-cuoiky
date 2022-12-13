package com.thanhthien.cuoiki.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {
	@GetMapping(value = { "/the-loai" })
	private ModelAndView categoryPage() {
		ModelAndView mav = new ModelAndView("web/category.html");

		return mav;
	}
}
