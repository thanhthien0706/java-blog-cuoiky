package com.thanhthien.cuoiki.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.thanhthien.cuoiki.dto.CommentMainDto;
import com.thanhthien.cuoiki.form.CommentCreateForm;
import com.thanhthien.cuoiki.services.impl.CommentService;
import com.thanhthien.cuoiki.services.impl.UtilsService;

@Controller
@RequestMapping("/binh-luan")
public class CommentController {

	@Autowired
	CommentService commentService;

	@Autowired
	UtilsService utilsService;

	@PostMapping()
	private String createComment(@ModelAttribute CommentCreateForm commentCreateForm) {

		commentCreateForm.setIdUser(utilsService.getIdUserCurrent());

		CommentMainDto dto = commentService.createComment(commentCreateForm);

		return "redirect:/bai-viet/" + commentCreateForm.getSlug();
	}

}
