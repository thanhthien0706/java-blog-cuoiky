package com.thanhthien.cuoiki.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.thanhthien.cuoiki.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM db_users u WHERE u.user_name = :username AND u.active = 1")
	UserEntity findByUserName(String username);

	UserEntity findOneByEmail(String email);

	UserEntity findOneById(Long id);

	UserEntity findOneByUserName(String userName);

	@Query(nativeQuery = true, value = "SELECT * FROM db_users u INNER JOIN db_roles r ON u.role_id = r.id WHERE r.`name` = :roleName")
	List<UserEntity> findAllUserWithRoleName(String roleName);

	@Query(nativeQuery = true, value = "SELECT COUNT(*) FROM db_users u INNER JOIN db_roles r ON u.role_id = r.id WHERE r.`name` = :roleName")
	Long countUserbyRoleName(String roleName);

}
