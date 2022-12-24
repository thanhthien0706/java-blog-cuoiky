package com.thanhthien.cuoiki.converts;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.thanhthien.cuoiki.dto.CategoryMainDto;
import com.thanhthien.cuoiki.model.CategoryEntity;
import com.thanhthien.cuoiki.model.PostEntity;

@Component
public class CategoryConvert {

	public CategoryMainDto toDto(CategoryEntity entity) {
		CategoryMainDto dto = new CategoryMainDto();

		dto.setTitle(entity.getTitle());
		dto.setSlug(entity.getSlug());
		dto.setStatus(entity.getStatus());
		dto.setDeleteAt(entity.getDeleteAt());
		dto.setDeleted(entity.getDeleted());

		List<Long> idPosts = new ArrayList<>();

		for (PostEntity post : entity.getPosts()) {
			idPosts.add(post.getId());
		}

		dto.setPosts(idPosts);

		return dto;
	}

	public List<CategoryMainDto> toListDto(List<CategoryEntity> categories) {
		List<CategoryMainDto> dtos = new ArrayList<>();

		for (CategoryEntity category : categories) {
			dtos.add(toDto(category));
		}

		return dtos;
	}

}
