package com.thanhthien.cuoiki.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.thanhthien.cuoiki.converts.UserConvert;
import com.thanhthien.cuoiki.dto.UserDto;
import com.thanhthien.cuoiki.form.SignupForm;
import com.thanhthien.cuoiki.form.UpdateAvatarForm;
import com.thanhthien.cuoiki.form.UpdateInforUser;
import com.thanhthien.cuoiki.form.UpdatePassForm;
import com.thanhthien.cuoiki.model.RoleEnity;
import com.thanhthien.cuoiki.model.UserEntity;
import com.thanhthien.cuoiki.repository.RoleRepository;
import com.thanhthien.cuoiki.repository.UserRepository;
import com.thanhthien.cuoiki.services.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	StorageService storageService;

	@Autowired
	UserConvert userConvert;

	@Override
	public UserEntity findByUserName(String username) {
		return userRepository.findByUserName(username);
	}

	@Override
	public UserEntity findOneByEmail(String email) {
		return userRepository.findOneByEmail(email);
	}

	@Override
	public UserEntity findOneById(Long id) {
		return userRepository.findOneById(id);
	}

	@Override
	public UserEntity saveUser(SignupForm signupForm) {
		UserEntity user = new UserEntity();
		user.setActive(true);
		user.setAvatar("https://res.cloudinary.com/dd1yamek1/image/upload/v1671810246/db-javaweb/user_veikez.png");
		user.setFullName(signupForm.getFullname());
		user.setUserName(signupForm.getUsername());
		user.setEmail(signupForm.getEmail());
		user.setPassword(passwordEncoder.encode(signupForm.getPassword()));

		RoleEnity role = roleRepository.findOneByName("ROLE_USER");

		if (role != null) {
			user.setRole(role);
		}

		user = userRepository.save(user);

		if (user != null) {
			return user;
		}

		return null;

	}

	public String getTest() {
		return "Vao dduowcj nha";
	}

	@Override
	public String updateAvatar(UpdateAvatarForm updateAvatarForm) {

		if (!updateAvatarForm.getAvatar().isEmpty()) {
			UserEntity oldUser = userRepository.findOneById(updateAvatarForm.getIdUser());

			if (oldUser == null) {
				return null;
			}
			String avatar = storageService.storageFile(updateAvatarForm.getAvatar());

			oldUser.setAvatar(avatar);

			userRepository.save(oldUser);

			return avatar;
		}

		return null;
	}

	@Override
	public Boolean updateInforUser(UpdateInforUser updateInforUser) {

		Boolean check = false;

		UserEntity oldUser = userRepository.findOneById(updateInforUser.getIdUser());

		if (oldUser == null) {
			return null;
		}

		oldUser.setFullName(updateInforUser.getFullName());

		UserEntity newUser = userRepository.save(oldUser);

		if (newUser == null) {
			return null;
		}
		check = true;

		return check;
	}

	@Override
	public UserDto getUserByUsername(String username) {
		UserEntity user = userRepository.findOneByUserName(username);

		if (user == null) {
			return null;
		}

		UserDto dto = userConvert.toDto(user);
		return dto;
	}

	@Override
	public void updatePasswordById(UpdatePassForm updatePassForm) {
		UserEntity oldUser = userRepository.findOneById(updatePassForm.getIdUser());

		if (oldUser != null) {
			Boolean checkPass = passwordEncoder.matches(updatePassForm.getOldPassword(), oldUser.getPassword());

			if (checkPass) {
				oldUser.setPassword(passwordEncoder.encode(updatePassForm.getNewPassword()));

				userRepository.save(oldUser);

			}
		}

	}

	@Override
	public List<UserDto> findAllUserByRole(String roleName) {
		List<UserEntity> users = userRepository.findAllUserWithRoleName(roleName);

		if (users == null) {
			return null;
		}

		List<UserDto> dtos = userConvert.toListDto(users);

		return dtos;
	}

	@Override
	public Boolean updateActiveUser(Long idUser, Boolean active) {
		UserEntity oldUser = userRepository.findOneById(idUser);

		if (oldUser == null) {
			return null;
		}

		oldUser.setActive(active);

		UserEntity newUser = userRepository.save(oldUser);

		if (newUser != null) {
			return true;
		}

		return false;
	}

	@Override
	public Long countAllUser() {
		return userRepository.countUserbyRoleName("ROLE_USER");
	}

}
