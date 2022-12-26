package com.thanhthien.cuoiki.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.thanhthien.cuoiki.dto.CategoryShowHomeDto;
import com.thanhthien.cuoiki.dto.PostShowHomeDto;
import com.thanhthien.cuoiki.services.impl.CategoryService;
import com.thanhthien.cuoiki.services.impl.PostService;

@Controller
public class CategoryController {

	@Autowired
	PostService postService;

	@Autowired
	CategoryService categoryService;

	@GetMapping(value = { "/the-loai" })
	private ModelAndView categoryPage(@RequestParam(name = "the-loai", required = false) Long idCategory) {

		List<CategoryShowHomeDto> categoryList = categoryService.getCategoriesTitleWithLimit(5);

		List<PostShowHomeDto> postCategory;

		if (idCategory == null) {
			postCategory = postService.getPostWithCatogryAndLimit(categoryList.get(0).getId(), 4);
		} else {
			postCategory = postService.getPostWithCatogryAndLimit(idCategory, 4);
		}

		ModelAndView mav = new ModelAndView("web/category.html");

		mav.addObject("categoryList", categoryList);
		mav.addObject("postCategory", postCategory);

		return mav;
	}
}
