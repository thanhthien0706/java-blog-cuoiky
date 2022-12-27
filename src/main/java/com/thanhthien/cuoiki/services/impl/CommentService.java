package com.thanhthien.cuoiki.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thanhthien.cuoiki.converts.CommentConvert;
import com.thanhthien.cuoiki.dto.CommentMainDto;
import com.thanhthien.cuoiki.model.CommentEntity;
import com.thanhthien.cuoiki.model.PostEntity;
import com.thanhthien.cuoiki.repository.CommentRepository;
import com.thanhthien.cuoiki.repository.PostRepository;
import com.thanhthien.cuoiki.services.ICommentService;

@Service
public class CommentService implements ICommentService {

	@Autowired
	CommentConvert commentConvert;

	@Autowired
	CommentRepository commentRepository;

	@Autowired
	PostRepository postRepository;

	@Override
	public List<CommentMainDto> getAllCommentWithSlugPost(String slug, int limit) {

		PostEntity post = postRepository.findOneBySlug(slug);

		if (post == null) {
			return null;
		}

		List<CommentEntity> comments = commentRepository.getCommentWithId(post.getId(), limit);

		if (comments == null) {
			return null;
		}

		List<CommentMainDto> dtos = commentConvert.toListDto(comments);

		return dtos;
	}

}