package com.thanhthien.cuoiki.converts;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thanhthien.cuoiki.dto.CommentMainDto;
import com.thanhthien.cuoiki.form.CommentCreateForm;
import com.thanhthien.cuoiki.model.CommentEntity;
import com.thanhthien.cuoiki.services.impl.UtilsService;

@Component
public class CommentConvert {

	@Autowired
	UserConvert userConvert;

	@Autowired
	UtilsService utilsService;

	public CommentEntity toEntity(CommentCreateForm commentCreateForm) {
		CommentEntity entity = new CommentEntity();

		entity.setContent(commentCreateForm.getContent());
		entity.setStatus(true);

		return entity;
	}

	public CommentMainDto toDto(CommentEntity comment) {
		CommentMainDto dto = new CommentMainDto();

		dto.setId(comment.getId());
		dto.setPostId(comment.getPost().getId());
		dto.setPostName(comment.getPost().getTitle());
		dto.setPostSlug(comment.getPost().getSlug());
		dto.setUser(userConvert.toDto(comment.getUser()));
		dto.setContent(comment.getContent());
		dto.setStatus(comment.getStatus());
		dto.setDeleteAt(comment.getDeleteAt());
		dto.setDeleted(comment.getDeleted());
		dto.setCreateAt(comment.getCreateAt());
		dto.setUpdateAt(comment.getUpdateAt());

		return dto;
	}

	public List<CommentMainDto> toListDto(List<CommentEntity> comments) {
		List<CommentMainDto> dtos = new ArrayList<>();

		for (CommentEntity comment : comments) {
			dtos.add(toDto(comment));
		}

		return dtos;
	}

}
