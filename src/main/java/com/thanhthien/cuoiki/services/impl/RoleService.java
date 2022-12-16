package com.thanhthien.cuoiki.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thanhthien.cuoiki.model.RoleEnity;
import com.thanhthien.cuoiki.repository.RoleRepository;
import com.thanhthien.cuoiki.services.IRoleService;

@Service
public class RoleService implements IRoleService {

	@Autowired
	RoleRepository roleRepository;

	@Override
	public RoleEnity findOneByName(String name) {
		return roleRepository.findOneByName(name);
	}

	@Override
	public RoleEnity findOneById(Long id) {
		return roleRepository.findOneById(id);
	}

}
