package com.thanhthien.cuoiki.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.thanhthien.cuoiki.dto.CategoryListDto;
import com.thanhthien.cuoiki.dto.CommentMainDto;
import com.thanhthien.cuoiki.dto.PostDetailDto;
import com.thanhthien.cuoiki.services.impl.CategoryService;
import com.thanhthien.cuoiki.services.impl.CommentService;
import com.thanhthien.cuoiki.services.impl.PostService;

@Controller
@RequestMapping("/bai-viet")
public class BlogController {

	@Autowired
	PostService postService;

	@Autowired
	CommentService commentService;

	@Autowired
	CategoryService categoryService;

	@GetMapping("/{slugBlog}")
	private ModelAndView getBlogDetail(@PathVariable("slugBlog") String slugBlog) {

		PostDetailDto postMain = postService.getPostDetailWithSlug(slugBlog);

		List<CommentMainDto> comments = commentService.getAllCommentWithSlugPost(slugBlog, 5);
		List<CategoryListDto> categories = categoryService.findAllNameListCategory();
		Long countComments = commentService.countCommentsByIdPost(postMain.getId());

		ModelAndView mav = new ModelAndView("web/blog-detail.html");

		mav.addObject("postMain", postMain);
		mav.addObject("comments", comments);
		mav.addObject("categories", categories);
		mav.addObject("countComments", countComments);

		return mav;
	}

}
