package com.thanhthien.cuoiki.controller.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.thanhthien.cuoiki.dto.CommentMainDto;
import com.thanhthien.cuoiki.dto.PostMaintDto;
import com.thanhthien.cuoiki.form.CommentUpdateAcceptForm;
import com.thanhthien.cuoiki.services.impl.CommentService;
import com.thanhthien.cuoiki.services.impl.UtilsService;

@Controller
@RequestMapping("/nguoi-dung/{username}/binh-luan")
public class CommentPersonController {

	@Autowired
	CommentService commentService;

	@Autowired
	UtilsService utilsService;

	@GetMapping()
	private ModelAndView getCommentPage() {
		List<CommentMainDto> comments = commentService.getAllCommentWithAuthorId(utilsService.getIdUserCurrent());

		System.out.println(comments);

		ModelAndView mav = new ModelAndView("person/comment.html");
		mav.addObject("comments", comments);

		return mav;
	}

	@PutMapping("/duyet")
	private ResponseEntity<Object> updateAcceptComment(
			@ModelAttribute CommentUpdateAcceptForm commentUpdateAcceptForm) {

		CommentMainDto comment = commentService.updateStatusComment(commentUpdateAcceptForm);

		return ResponseEntity.status(HttpStatus.OK).body(comment);
	}
}
