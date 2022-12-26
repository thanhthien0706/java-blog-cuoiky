package com.thanhthien.cuoiki.services;

import java.util.List;

import com.thanhthien.cuoiki.dto.CategoryShowHomeDto;
import com.thanhthien.cuoiki.form.CategoryCreateForm;
import com.thanhthien.cuoiki.model.CategoryEntity;

public interface ICategoryService {
	CategoryEntity createCategory(CategoryCreateForm categoryCreateForm);

	CategoryEntity findCategoryBySlug(String slug);

	Boolean checkExistCategoryBySlug(String slug);

	String convertSlug(String title);

	List<CategoryShowHomeDto> getCategoriesTitleWithLimit(int limit);
}
