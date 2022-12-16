package com.thanhthien.cuoiki.services;

import com.thanhthien.cuoiki.model.RoleEnity;

public interface IRoleService {
	RoleEnity findOneByName(String name);

	RoleEnity findOneById(Long id);
}
