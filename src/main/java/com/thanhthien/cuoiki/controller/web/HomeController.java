package com.thanhthien.cuoiki.controller.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.thanhthien.cuoiki.dto.CategoryShowHomeDto;
import com.thanhthien.cuoiki.dto.PostShowHomeDto;
import com.thanhthien.cuoiki.security.CustomUserDetails;
import com.thanhthien.cuoiki.services.impl.CategoryService;
import com.thanhthien.cuoiki.services.impl.PostService;

@Controller
public class HomeController {

	@Autowired
	PostService postService;

	@Autowired
	CategoryService categoryService;

	@GetMapping(value = { "/", "/trang-chu", "/bai-viet" })
	private ModelAndView homePage(@RequestParam(name = "the-loai", required = false) Long idCategory) {

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

		List<PostShowHomeDto> postTop = postService.getPostsCount(10);

		List<CategoryShowHomeDto> categoryList = categoryService.getCategoriesTitleWithLimit(5);

		List<PostShowHomeDto> postCategory;

		if (idCategory == null) {
			postCategory = postService.getPostWithCatogryAndLimit(categoryList.get(0).getId(), 4);
		} else {
			postCategory = postService.getPostWithCatogryAndLimit(idCategory, 4);
		}

		ModelAndView mav = new ModelAndView("web/home.html");

		mav.addObject("postCount1Top", postCount1.get(0));
		mav.addObject("postCount1Bottom", postCount1Bottom);
		mav.addObject("postAllNew", postAllNew);
		mav.addObject("postRightNew", postRightNew);
		mav.addObject("postTop", postTop);
		mav.addObject("categoryList", categoryList);
		mav.addObject("postCategory", postCategory);

		return mav;
	}
}
