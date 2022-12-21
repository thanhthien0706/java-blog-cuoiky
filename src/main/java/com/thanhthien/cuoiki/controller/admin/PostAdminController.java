package com.thanhthien.cuoiki.controller.admin;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class PostAdminController {

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/post")
	private ModelAndView getPagePost() {
		ModelAndView mav = new ModelAndView("admin/posts.html");
		return mav;
	}
	
	@GetMapping("/post/add")
	private ModelAndView getPagePostAdd() {
		ModelAndView mav = new ModelAndView("admin/add-post.html");
		return mav;
	}
}