package com.thanhthien.cuoiki.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.thanhthien.cuoiki.dto.UserDto;
import com.thanhthien.cuoiki.form.SignupForm;
import com.thanhthien.cuoiki.form.UpdateAvatarForm;
import com.thanhthien.cuoiki.form.UpdateInforUser;
import com.thanhthien.cuoiki.form.UpdatePassForm;
import com.thanhthien.cuoiki.model.UserEntity;

public interface IUserService {
	UserEntity findByUserName(String username);

	UserEntity findOneByEmail(String email);

	UserEntity findOneById(Long id);

	UserEntity saveUser(SignupForm signupForm);

	String updateAvatar(UpdateAvatarForm updateAvatarForm);

	Boolean updateInforUser(UpdateInforUser updateInforUser);

	UserDto getUserByUsername(String username);

	void updatePasswordById(UpdatePassForm updatePassForm);

	List<UserDto> findAllUserByRole(String roleName);

	Boolean updateActiveUser(Long idUser, Boolean active);

	Long countAllUser();
}
