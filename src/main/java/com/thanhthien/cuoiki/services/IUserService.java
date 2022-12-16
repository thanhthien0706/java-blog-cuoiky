package com.thanhthien.cuoiki.services;

import com.thanhthien.cuoiki.model.UserEntity;

public interface IUserService {
	UserEntity findByUserName(String username);

	UserEntity findOneByEmail(String email);

	UserEntity findOneById(Long id);
}
