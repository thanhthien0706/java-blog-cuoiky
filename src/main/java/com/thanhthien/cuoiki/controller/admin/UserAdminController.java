package com.thanhthien.cuoiki.controller.admin;

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

import com.thanhthien.cuoiki.dto.UserDto;
import com.thanhthien.cuoiki.form.UpdateUserActiveForm;
import com.thanhthien.cuoiki.services.impl.UserService;

@Controller
@RequestMapping("/admin/users")
public class UserAdminController {

	@Autowired
	UserService userService;

	@GetMapping
	private ModelAndView getUserAdminPage() {

		List<UserDto> usersRoleUser = userService.findAllUserByRole("ROLE_USER");

		ModelAndView mav = new ModelAndView("admin/user.html");
		mav.addObject("usersRoleUser", usersRoleUser);

		return mav;
	}

	@PutMapping("/active")
	private ResponseEntity<Object> updateActiveUser(@ModelAttribute UpdateUserActiveForm updateUserActiveForm) {
		System.out.println(updateUserActiveForm);
		Boolean active = userService.updateActiveUser(updateUserActiveForm.getIdUser(),
				updateUserActiveForm.getActive());

		return ResponseEntity.status(HttpStatus.OK).body(active);
	}
}
