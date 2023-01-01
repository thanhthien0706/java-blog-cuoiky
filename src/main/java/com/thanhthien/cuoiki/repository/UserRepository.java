package com.thanhthien.cuoiki.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thanhthien.cuoiki.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findByUserName(String username);

	UserEntity findOneByEmail(String email);

	UserEntity findOneById(Long id);

	UserEntity findOneByUserName(String userName);
}
