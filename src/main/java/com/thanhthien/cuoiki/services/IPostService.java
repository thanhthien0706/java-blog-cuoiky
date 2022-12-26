package com.thanhthien.cuoiki.services;

import java.util.List;

import com.thanhthien.cuoiki.dto.PostEditDto;
import com.thanhthien.cuoiki.dto.PostShowDto;
import com.thanhthien.cuoiki.dto.PostShowHomeDto;
import com.thanhthien.cuoiki.form.PostCreateForm;
import com.thanhthien.cuoiki.form.PostEditForm;
import com.thanhthien.cuoiki.model.PostEntity;

public interface IPostService {
	PostEntity createPost(PostCreateForm postCreateForm);

	Boolean existPost(String slug);

	String convertSlug(String title);

	List<PostShowDto> getPostsWithStatus(String status);

	PostEditDto getPostById(Long id);

	PostEntity updatePost(PostEditForm postEditForm);

	void deletePostById(Long id);

	List<PostShowHomeDto> getAllPostNew();

	List<PostShowHomeDto> getPostsCount(int limit);

	List<PostShowHomeDto> getPostWithCatogryAndLimit(Long idCategory, int limit);

}
