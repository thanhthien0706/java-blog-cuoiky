package com.thanhthien.cuoiki.services.impl;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.Locale;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thanhthien.cuoiki.converts.PostConvert;
import com.thanhthien.cuoiki.dto.PostMaintDto;
import com.thanhthien.cuoiki.form.PostCreateForm;
import com.thanhthien.cuoiki.model.PostEntity;
import com.thanhthien.cuoiki.repository.CategoryRepository;
import com.thanhthien.cuoiki.repository.PostRepository;
import com.thanhthien.cuoiki.services.IPostService;

@Service
public class PostService implements IPostService {

	private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
	private static final Pattern WHITESPACE = Pattern.compile("[\\s]");

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private StorageService storageService;

	@Autowired
	private PostConvert postConvert;

	@Override
	public PostEntity createPost(PostCreateForm postCreateForm) {
		Boolean existSlug = existPost(convertSlug(postCreateForm.getTitle()));

		if (existSlug) {
			return null;
		}

		PostEntity postEnti = postConvert.toEntity(postCreateForm);
		
		

		return null;
	}

	@Override
	public Boolean existPost(String slug) {
		return postRepository.existsBySlug(slug);
	}

	@Override
	public String convertSlug(String title) {
		String nowhitespace = WHITESPACE.matcher(title).replaceAll("-");
		String normalized = Normalizer.normalize(nowhitespace, Form.NFD);
		String slug = NONLATIN.matcher(normalized).replaceAll("");
		return slug.toLowerCase(Locale.ENGLISH);
	}

}
