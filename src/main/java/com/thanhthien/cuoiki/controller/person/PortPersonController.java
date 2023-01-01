package com.thanhthien.cuoiki.controller.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.thanhthien.cuoiki.dto.PostEditDto;
import com.thanhthien.cuoiki.dto.PostShowDto;
import com.thanhthien.cuoiki.form.PostCreateForm;
import com.thanhthien.cuoiki.form.PostEditForm;
import com.thanhthien.cuoiki.services.impl.PostService;
import com.thanhthien.cuoiki.services.impl.UtilsService;

@Controller
@RequestMapping("/nguoi-dung/{username}/bai-viet")
public class PortPersonController {

	@Autowired
	UtilsService utilsService;

	@Autowired
	PostService postService;

	@GetMapping("/t")
	private ModelAndView getPagePostCreate(@PathVariable("username") String username) {

		ModelAndView mav = new ModelAndView("person/add-post.html");
		return mav;
	}

	@PostMapping("/t")
	private String postPagePostAdd(@PathVariable("username") String username,
			@ModelAttribute PostCreateForm postCreateForm) {
		try {
			postCreateForm.setAuthorId(utilsService.getIdUserCurrent());

//			System.out.println(postCreateForm);

			postService.createPost(postCreateForm);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/nguoi-dung/bai-viet";
	}

	@GetMapping("/e/{id}")
	private ModelAndView getPostEdit(@PathVariable Long id) {

		PostEditDto post = postService.getPostByIdAndAuthorId(id, utilsService.getIdUserCurrent());

		ModelAndView mav = new ModelAndView("person/edit-post.html");
		mav.addObject("post", post);
		return mav;
	}

	@PostMapping("/e/{id}")
	private String updatePostEdit(@PathVariable("username") String username, @ModelAttribute PostEditForm postEditForm,
			@PathVariable Long id) {
		postEditForm.setIdPost(id);

		postService.updatePost(postEditForm);

		return "redirect:/nguoi-dung/" + utilsService.getUserNameCurrent() + "/bai-viet";
	}

	@GetMapping("/d/{id}")
	private String deletePost(@PathVariable Long id) {
		postService.deletePostById(id);
		return "redirect:/nguoi-dung/" + utilsService.getUserNameCurrent() + "/bai-viet";
	}
}
