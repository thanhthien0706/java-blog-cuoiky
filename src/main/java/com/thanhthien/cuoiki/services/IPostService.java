package com.thanhthien.cuoiki.services;

import com.thanhthien.cuoiki.form.PostCreateForm;
import com.thanhthien.cuoiki.model.PostEntity;

public interface IPostService {
	PostEntity createPost(PostCreateForm postCreateForm);

	Boolean existPost(String slug);

	String convertSlug(String title);
}
