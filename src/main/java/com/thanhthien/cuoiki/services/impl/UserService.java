package com.thanhthien.cuoiki.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thanhthien.cuoiki.model.UserEntity;
import com.thanhthien.cuoiki.repository.UserRepository;
import com.thanhthien.cuoiki.services.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	UserRepository userRepository;

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

}
