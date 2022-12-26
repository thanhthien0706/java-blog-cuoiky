package com.thanhthien.cuoiki.controller.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.thanhthien.cuoiki.dto.PostShowHomeDto;
import com.thanhthien.cuoiki.security.CustomUserDetails;
import com.thanhthien.cuoiki.services.impl.PostService;

@Controller
public class HomeController {

	@Autowired
	PostService postService;

	@GetMapping(value = { "/", "/trang-chu", "/bai-viet" })
	private ModelAndView homePage() {

		List<PostShowHomeDto> postCount1 = postService.getPostsCount(4);
		List<PostShowHomeDto> postCount1Bottom = new ArrayList<>();
		postCount1Bottom.add(postCount1.get(1));
		postCount1Bottom.add(postCount1.get(2));
		postCount1Bottom.add(postCount1.get(3));

		List<PostShowHomeDto> postAllNew = postService.getAllPostNew();

		List<PostShowHomeDto> postRightNew = new ArrayList<>();
		postRightNew.add(postAllNew.get(0));
		postRightNew.add(postAllNew.get(1));
		postRightNew.add(postAllNew.get(2));
		postRightNew.add(postAllNew.get(3));

		ModelAndView mav = new ModelAndView("web/home.html");

		mav.addObject("postCount1Top", postCount1.get(0));
		mav.addObject("postCount1Bottom", postCount1Bottom);
		mav.addObject("postAllNew", postAllNew);
		mav.addObject("postRightNew", postRightNew);

		return mav;
	}
}
