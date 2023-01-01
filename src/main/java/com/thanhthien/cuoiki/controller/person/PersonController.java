package com.thanhthien.cuoiki.controller.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.thanhthien.cuoiki.dto.PostShowDto;
import com.thanhthien.cuoiki.dto.UserDto;
import com.thanhthien.cuoiki.form.PostEditForm;
import com.thanhthien.cuoiki.form.UpdateAvatarForm;
import com.thanhthien.cuoiki.form.UpdateInforUser;
import com.thanhthien.cuoiki.form.UpdatePassForm;
import com.thanhthien.cuoiki.services.impl.PostService;
import com.thanhthien.cuoiki.services.impl.UserService;
import com.thanhthien.cuoiki.services.impl.UtilsService;

@Controller
@RequestMapping("/nguoi-dung")
public class PersonController {

	@Autowired
	UtilsService utilsService;

	@Autowired
	PostService postService;

	@Autowired
	UserService userService;

	@GetMapping(value = { "/{username}", "/{username}/bai-viet" })
	private ModelAndView getHomePageUser(@PathVariable("username") String username) {

		Long idUser = utilsService.getIdUserCurrent();

		List<PostShowDto> postsFalse = postService.getPostsWithActionAndIdAuthor(false, idUser);

		List<PostShowDto> postsTrue = postService.getPostsWithActionAndIdAuthor(true, idUser);

		ModelAndView mav = new ModelAndView("person/home.html");

		mav.addObject("postsFalse", postsFalse);
		mav.addObject("postsTrue", postsTrue);

		return mav;
	}

	@GetMapping("/p/{username}")
	private ModelAndView getProfileUserPage(@PathVariable("username") String username) {

		UserDto user = userService.getUserByUsername(username);

		System.out.println(user.getAvatar());

		ModelAndView mav = new ModelAndView("person/profile.html");
		mav.addObject("user", user);

		return mav;
	}

	@PutMapping("/a")
	private ResponseEntity<Object> updateAvatarUser(@ModelAttribute UpdateAvatarForm updateAvatarForm) {

		String avatar = userService.updateAvatar(updateAvatarForm);

		return ResponseEntity.ok().body(avatar);
	}

	@PostMapping("/infor")
	private String updateAvatarUser(@ModelAttribute UpdateInforUser updateInforUser) {

		Boolean check = userService.updateInforUser(updateInforUser);

		return "redirect:/nguoi-dung/p/" + utilsService.getUserNameCurrent();
	}

	@PostMapping("/mat-khau")
	private String updatePassUser(@ModelAttribute UpdatePassForm updateInforUser) {

		userService.updatePasswordById(updateInforUser);

		return "redirect:/nguoi-dung/p/" + utilsService.getUserNameCurrent();
	}

}
