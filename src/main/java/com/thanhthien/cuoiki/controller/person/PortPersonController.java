package com.thanhthien.cuoiki.controller.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.thanhthien.cuoiki.form.PostCreateForm;
import com.thanhthien.cuoiki.services.impl.PostService;
import com.thanhthien.cuoiki.services.impl.UtilsService;

@Controller
@RequestMapping("/nguoi-dung/bai-viet")
public class PortPersonController {

	@Autowired
	UtilsService utilsService;

	@Autowired
	PostService postService;

	@GetMapping("/t")
	private ModelAndView getPagePostCreate() {
		ModelAndView mav = new ModelAndView("person/add-post.html");
		return mav;
	}

	@PostMapping("/t")
	private String postPagePostAdd(@ModelAttribute PostCreateForm postCreateForm) {
		try {
			postCreateForm.setAuthorId(utilsService.getIdUserCurrent());

//			System.out.println(postCreateForm);

			postService.createPost(postCreateForm);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/nguoi-dung/bai-viet";
	}
}
