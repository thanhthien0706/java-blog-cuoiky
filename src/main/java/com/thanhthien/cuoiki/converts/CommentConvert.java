package com.thanhthien.cuoiki.converts;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thanhthien.cuoiki.dto.CommentMainDto;
import com.thanhthien.cuoiki.model.CommentEntity;

@Component
public class CommentConvert {

	@Autowired
	UserConvert userConvert;

	public CommentMainDto toDto(CommentEntity comment) {
		CommentMainDto dto = new CommentMainDto();

		dto.setPostId(comment.getPost().getId());
		dto.setUser(userConvert.toDto(comment.getUser()));
		dto.setContent(comment.getContent());
		dto.setStatus(comment.getStatus());
		dto.setDeleteAt(comment.getDeleteAt());
		dto.setDeleted(comment.getDeleted());

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
