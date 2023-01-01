package com.thanhthien.cuoiki.services.impl;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.Locale;
import java.util.regex.Pattern;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.thanhthien.cuoiki.security.CustomUserDetails;
import com.thanhthien.cuoiki.services.IUtilsService;

@Service
public class UtilsService implements IUtilsService {

	private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
	private static final Pattern WHITESPACE = Pattern.compile("[\\s]");

	@Override
	public Long getIdUserCurrent() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CustomUserDetails customUser = (CustomUserDetails) authentication.getPrincipal();
		return customUser.getId();
	}

	@Override
	public String convertSlug(String title) {
		String nowhitespace = WHITESPACE.matcher(title).replaceAll("-");
		String normalized = Normalizer.normalize(nowhitespace, Form.NFD);
		String slug = NONLATIN.matcher(normalized).replaceAll("");
		return slug.toLowerCase(Locale.ENGLISH);
	}

	@Override
	public String getUserNameCurrent() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CustomUserDetails customUser = (CustomUserDetails) authentication.getPrincipal();
		return customUser.getUsername();
	}

}