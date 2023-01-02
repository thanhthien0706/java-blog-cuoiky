package com.thanhthien.cuoiki.controller.admin;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.thanhthien.cuoiki.converts.PostConvert;
import com.thanhthien.cuoiki.dto.PostEditDto;
import com.thanhthien.cuoiki.dto.PostShowDto;
import com.thanhthien.cuoiki.form.PostCreateForm;
import com.thanhthien.cuoiki.form.PostEditForm;
import com.thanhthien.cuoiki.model.PostEntity;
import com.thanhthien.cuoiki.model.EnumType.StatusPost;
import com.thanhthien.cuoiki.security.CustomUserDetails;
import com.thanhthien.cuoiki.services.impl.PostService;
import com.thanhthien.cuoiki.services.impl.UtilsService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Controller
@RequestMapping("/admin")
public class PostAdminController {

	@Autowired
	UtilsService utilsService;

	@Autowired
	PostService postService;

	@GetMapping("/post")
	private ModelAndView getPagePost() {
		List<PostShowDto> posts = postService.getPostsWithStatus("ALL", Boolean.FALSE);
		List<PostShowDto> postsTrue = postService.getPostsWithStatus("ALL", Boolean.TRUE);

		ModelAndView mav = new ModelAndView("admin/posts.html");
		mav.addObject("posts", posts);
		mav.addObject("postsTrue", postsTrue);
		return mav;
	}

	@GetMapping("/post/add")
	private ModelAndView getPagePostAdd() {
		ModelAndView mav = new ModelAndView("admin/add-post.html");
		return mav;
	}

	@PostMapping("/post/add")
	private ModelAndView postPagePostAdd(@ModelAttribute PostCreateForm postCreateForm) {
		ModelAndView mav = new ModelAndView("admin/add-post.html");
		try {
			postCreateForm.setAuthorId(utilsService.getIdUserCurrent());

			postService.createPost(postCreateForm);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return mav;
	}

	@GetMapping("/post/edit/{id}")
	private ModelAndView getPostEdit(@PathVariable Long id) {

		PostEditDto post = postService.getPostById(id);

		ModelAndView mav = new ModelAndView("admin/edit-post.html");
		mav.addObject("post", post);
		return mav;
	}

	@PostMapping("/post/edit/{id}")
	private String updatePostEdit(@ModelAttribute PostEditForm postEditForm, @PathVariable Long id) {
		postEditForm.setIdPost(id);

		postService.updatePost(postEditForm);

		return "redirect:/admin/post";
	}

	@GetMapping("/post/delete/{id}")
	private String deletePost(@PathVariable Long id) {
		postService.deletePostById(id);
		return "redirect:/admin/post";
	}

	@GetMapping("/post/{id}")
	private ModelAndView getPostById(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("admin/post.html");
		return mav;
	}

	@GetMapping("/post/censor")
	private String censorPost(@RequestParam(name = "idPost") Long idPost,
			@RequestParam(name = "action") Boolean action) {

		postService.censorPost(idPost, action);

		return "redirect:/admin/post";
	}

}
