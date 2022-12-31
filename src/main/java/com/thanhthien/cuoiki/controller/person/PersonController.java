package com.thanhthien.cuoiki.controller.person;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/nguoi-dung")
public class PersonController {

	@GetMapping(value = { "/{username}", "/{username}/bai-viet" })
	private ModelAndView getHomePageUser(@PathVariable("username") String slugBlog) {
		ModelAndView mav = new ModelAndView("person/home.html");

		return mav;
	}

}
