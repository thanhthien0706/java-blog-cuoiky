package com.thanhthien.cuoiki.services;

import com.thanhthien.cuoiki.form.CategoryCreateForm;
import com.thanhthien.cuoiki.model.CategoryEntity;

public interface ICategoryService {
	CategoryEntity createCategory(CategoryCreateForm categoryCreateForm);
	
	CategoryEntity findCategoryBySlug(String slug);

	Boolean checkExistCategoryBySlug(String slug);

	String convertSlug(String title);
}
