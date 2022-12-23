package com.thanhthien.cuoiki.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.thanhthien.cuoiki.form.SignupForm;
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
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

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

}
