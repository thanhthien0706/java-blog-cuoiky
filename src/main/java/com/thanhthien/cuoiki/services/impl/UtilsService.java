package com.thanhthien.cuoiki.services.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.thanhthien.cuoiki.security.CustomUserDetails;
import com.thanhthien.cuoiki.services.IUtilsService;

@Service
public class UtilsService implements IUtilsService {

	@Override
	public Long getIdUserCurrent() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CustomUserDetails customUser = (CustomUserDetails) authentication.getPrincipal();
		return customUser.getId();
	}

}