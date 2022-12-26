package com.thanhthien.cuoiki.services.impl;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thanhthien.cuoiki.converts.CategoryConvert;
import com.thanhthien.cuoiki.dto.CategoryShowHomeDto;
import com.thanhthien.cuoiki.form.CategoryCreateForm;
import com.thanhthien.cuoiki.model.CategoryEntity;
import com.thanhthien.cuoiki.repository.CategoryRepository;
import com.thanhthien.cuoiki.services.ICategoryService;

@Service
public class CategoryService implements ICategoryService {

	private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
	private static final Pattern WHITESPACE = Pattern.compile("[\\s]");

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	CategoryConvert categoryConvert;

	@Override
	public CategoryEntity createCategory(CategoryCreateForm categoryCreateForm) {
		Boolean check = checkExistCategoryBySlug(convertSlug(categoryCreateForm.getTitle()));

		if (check) {
			return null;
		}

		CategoryEntity category = new CategoryEntity();

		category.setTitle(categoryCreateForm.getTitle());
		category.setSlug(convertSlug(categoryCreateForm.getTitle()));
		category.setStatus(categoryCreateForm.getStatus());

		category = categoryRepository.save(category);

		if (category != null) {
			return category;
		}

		return null;
	}

	@Override
	public CategoryEntity findCategoryBySlug(String slug) {
		return categoryRepository.findOneBySlug(slug);
	}

	@Override
	public Boolean checkExistCategoryBySlug(String slug) {
		return categoryRepository.existsBySlug(slug);
	}

	@Override
	public String convertSlug(String title) {
		String nowhitespace = WHITESPACE.matcher(title).replaceAll("-");
		String normalized = Normalizer.normalize(nowhitespace, Form.NFD);
		String slug = NONLATIN.matcher(normalized).replaceAll("");
		return slug.toLowerCase(Locale.ENGLISH);
	}

	@Override
	public List<CategoryShowHomeDto> getCategoriesTitleWithLimit(int limit) {
		List<CategoryEntity> category = categoryRepository.getCategoriesTitleWithLimit(limit);

		if (category == null) {
			return null;
		}

		List<CategoryShowHomeDto> dtos = categoryConvert.toListDtoShowHome(category);

		return dtos;
	}

}
