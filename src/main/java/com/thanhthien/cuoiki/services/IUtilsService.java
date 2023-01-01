package com.thanhthien.cuoiki.services;

public interface IUtilsService {
	Long getIdUserCurrent();

	String getUserNameCurrent();

	String convertSlug(String title);
}
