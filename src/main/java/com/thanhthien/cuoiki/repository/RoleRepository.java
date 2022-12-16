package com.thanhthien.cuoiki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thanhthien.cuoiki.model.RoleEnity;

@Repository
public interface RoleRepository extends JpaRepository<RoleEnity, Long> {
	RoleEnity findOneByName(String name);

	RoleEnity findOneById(Long id);
}
