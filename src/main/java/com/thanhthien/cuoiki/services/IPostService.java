package com.thanhthien.cuoiki.services;

import java.util.List;

import javax.persistence.EntityManager;

import com.thanhthien.cuoiki.dto.PostDetailDto;
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

	List<PostShowDto> getPostsWithStatus(String status, Boolean action);

	List<PostShowDto> getPostsWithActionAndIdAuthor(Boolean action, Long idAuthor);

	PostEditDto getPostById(Long id);

	PostEditDto getPostByIdAndAuthorId(Long idPost, Long idAuthor);

	PostEntity updatePost(PostEditForm postEditForm);

	void deletePostById(Long id);

	List<PostShowHomeDto> getAllPostNew();

	List<PostShowHomeDto> getPostsCount(int limit);

	List<PostShowHomeDto> getPostWithCatogryAndLimit(Long idCategory, int limit);

	PostDetailDto getPostDetailWithSlug(String slug);

	void censorPost(Long idPost, Boolean action);

	List<PostShowHomeDto> findPostLimitSort(String sort, int limit);

	Long countAllPost();

	List<Long> countPostWithMonth(Long year);

//	List<PostEntity> getPostWithCategoryId(Long idCategory);

}
