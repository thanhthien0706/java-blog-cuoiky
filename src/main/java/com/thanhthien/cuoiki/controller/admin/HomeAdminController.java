package com.thanhthien.cuoiki.controller.admin;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class HomeAdminController {

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value = { "/home" })
	private ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("admin/home.html");
		return mav;
	}
}