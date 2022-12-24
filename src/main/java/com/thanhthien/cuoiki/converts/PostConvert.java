package com.thanhthien.cuoiki.converts;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thanhthien.cuoiki.dto.CategoryMainDto;
import com.thanhthien.cuoiki.dto.PostMaintDto;
import com.thanhthien.cuoiki.form.PostCreateForm;
import com.thanhthien.cuoiki.dto.PostDto2;
import com.thanhthien.cuoiki.model.CategoryEntity;
import com.thanhthien.cuoiki.model.PostEntity;
import com.thanhthien.cuoiki.model.EnumType.StatusPost;

@Component
public class PostConvert {

	@Autowired
	CategoryConvert categoryConvert;

	@Autowired
	UserConvert userConvert;

	@Autowired
	CommentConvert commentConvert;

	public PostEntity toEntity(PostCreateForm form) {
		PostEntity post = new PostEntity();

		post.setTitle(form.getTitle());
		post.setSummary(form.getSummary());
		post.setContent(form.getContent());

		StatusPost status;
		if (form.getStatus() == "DRAFT") {
			status = StatusPost.DRAFT;
		} else if (form.getStatus() == "PUBLIC") {
			status = StatusPost.PUBLIC;
		} else {
			status = StatusPost.UNPUBLIC;
		}
		post.setStatus(status);

		return post;
	}

	public PostMaintDto toDto(PostEntity entity) {
		PostMaintDto dto = new PostMaintDto();

		dto.setTitle(entity.getTitle());
		dto.setAvatar(entity.getAvatar());
		dto.setSlug(entity.getSlug());
		dto.setSummary(entity.getSummary());
		dto.setContent(entity.getContent());
		dto.setStatus(entity.getStatus().name());
		dto.setDeleteAt(entity.getDeleteAt());
		dto.setDeleted(entity.getDeleted());
		dto.setCategories(categoryConvert.toListDto(entity.getCategories()));
		dto.setParentPost(toDto2(entity.getParent()));
		dto.setChildPost(toListDto2(entity.getPosts()));
		dto.setAuthor(userConvert.toDto(entity.getAuthor()));
		dto.setComments(commentConvert.toListDto(entity.getComments()));

		return dto;
	}

	public List<PostMaintDto> toListDto(List<PostEntity> posts) {
		List<PostMaintDto> dtos = new ArrayList<>();

		for (PostEntity post : posts) {
			dtos.add(toDto(post));
		}

		return dtos;
	}

	public PostDto2 toDto2(PostEntity post) {
		PostDto2 dto2 = new PostDto2();

		dto2.setAvatar(post.getAvatar());
		dto2.setId(post.getId());
		dto2.setSummary(post.getSummary());
		dto2.setSlug(post.getSlug());
		dto2.setTitle(post.getTitle());

		return dto2;
	}

	public List<PostDto2> toListDto2(List<PostEntity> posts) {
		List<PostDto2> dto2s = new ArrayList<>();

		for (PostEntity post : posts) {
			dto2s.add(toDto2(post));
		}

		return dto2s;
	}

}
