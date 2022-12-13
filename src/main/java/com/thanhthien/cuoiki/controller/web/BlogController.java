package com.thanhthien.cuoiki.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bai-viet")
public class BlogController {

	@GetMapping(value = { "/{slugBlog}" })
	private ModelAndView getBlogDetail(@PathVariable String slugBlog) {
		System.out.println(slugBlog);
		ModelAndView mav = new ModelAndView("web/blog-detail.html");

		return mav;
	}
}
