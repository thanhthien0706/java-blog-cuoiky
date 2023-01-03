package com.thanhthien.cuoiki.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.thanhthien.cuoiki.dto.CommentMainDto;
import com.thanhthien.cuoiki.dto.PostShowHomeDto;
import com.thanhthien.cuoiki.services.impl.CommentService;
import com.thanhthien.cuoiki.services.impl.PostService;
import com.thanhthien.cuoiki.services.impl.UserService;

@Controller
@RequestMapping("/admin")
public class HomeAdminController {

	@Autowired
	PostService postService;

	@Autowired
	CommentService commentService;

	@Autowired
	UserService userService;

	@GetMapping(value = { "/home" })
	private ModelAndView homePage() {

		List<PostShowHomeDto> postsTop = postService.findPostLimitSort("desc", 5);

		List<CommentMainDto> commentNew = commentService.getNewCommentLimit(5);

		ModelAndView mav = new ModelAndView("admin/home.html");
		mav.addObject("postsTop", postsTop);
		mav.addObject("commentNew", commentNew);
		mav.addObject("countUser", userService.countAllUser());
		mav.addObject("countComment", commentService.countAllComments());
		mav.addObject("countPost", postService.countAllPost());

		return mav;
	}
}
