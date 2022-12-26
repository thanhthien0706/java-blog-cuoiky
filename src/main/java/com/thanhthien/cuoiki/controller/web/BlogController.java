package com.thanhthien.cuoiki.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.thanhthien.cuoiki.services.impl.PostService;

@Controller
@RequestMapping("/bai-viet")
public class BlogController {

	@Autowired
	PostService postService;

	@GetMapping(value = { "/{slugBlog}" })
	private ModelAndView getBlogDetail(@PathVariable String slugBlog) {
		ModelAndView mav = new ModelAndView("web/blog-detail.html");

		return mav;
	}
}
