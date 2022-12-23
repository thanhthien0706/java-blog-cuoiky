package com.thanhthien.cuoiki.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thanhthien.cuoiki.form.PostCreateForm;
import com.thanhthien.cuoiki.model.PostEntity;
import com.thanhthien.cuoiki.repository.PostRepository;
import com.thanhthien.cuoiki.services.IPostService;

@Service
public class PostService implements IPostService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private StorageService storageService;

	@Override
	public PostEntity createPost(PostCreateForm postCreateForm) {
		return null;
	}

}
