package com.thanhthien.cuoiki.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thanhthien.cuoiki.converts.CommentConvert;
import com.thanhthien.cuoiki.dto.CommentMainDto;
import com.thanhthien.cuoiki.form.CommentCreateForm;
import com.thanhthien.cuoiki.form.CommentUpdateAcceptForm;
import com.thanhthien.cuoiki.model.CommentEntity;
import com.thanhthien.cuoiki.model.PostEntity;
import com.thanhthien.cuoiki.repository.CommentRepository;
import com.thanhthien.cuoiki.repository.PostRepository;
import com.thanhthien.cuoiki.repository.UserRepository;
import com.thanhthien.cuoiki.services.ICommentService;

@Service
public class CommentService implements ICommentService {

	@Autowired
	CommentConvert commentConvert;

	@Autowired
	CommentRepository commentRepository;

	@Autowired
	PostRepository postRepository;

	@Autowired
	UserRepository userRepository;

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

	@Override
	public CommentMainDto createComment(CommentCreateForm commentCreateForm) {

		CommentEntity commentEntity = commentConvert.toEntity(commentCreateForm);
		commentEntity.setPost(postRepository.findOneById(commentCreateForm.getIdPost()));
		commentEntity.setUser(userRepository.findOneById(commentCreateForm.getIdUser()));

		commentEntity = commentRepository.save(commentEntity);

		if (commentEntity == null) {
			return null;
		}

		CommentMainDto dto = commentConvert.toDto(commentEntity);

		return dto;
	}

	@Override
	public List<CommentMainDto> getAllCommentWithAuthorId(Long idAuthor) {

		List<CommentEntity> comments = commentRepository.getAllByAuthorId(idAuthor);

		if (comments == null) {
			return null;
		}

		List<CommentMainDto> dtos = commentConvert.toListDto(comments);

		return dtos;
	}

	@Override
	public CommentMainDto updateStatusComment(CommentUpdateAcceptForm commentUpdateAcceptForm) {

		CommentEntity oldComment = commentRepository.findOneById(commentUpdateAcceptForm.getCommentId());

		if (oldComment == null) {
			return null;
		}

		oldComment.setStatus(commentUpdateAcceptForm.getCommentStatus());

		CommentEntity newComment = commentRepository.save(oldComment);

		return commentConvert.toDto(newComment);
	}

	@Override
	public CommentMainDto createCommentReply(CommentCreateForm commentCreateForm) {
		CommentEntity commentEntity = commentConvert.toEntity(commentCreateForm);
		commentEntity.setPost(postRepository.findOneById(commentCreateForm.getIdPost()));
		commentEntity.setUser(userRepository.findOneById(commentCreateForm.getIdUser()));
		commentEntity.setCommentParent(commentRepository.findOneById(commentCreateForm.getIdCommentParent()));

		commentEntity = commentRepository.save(commentEntity);

		if (commentEntity == null) {
			return null;
		}

		CommentMainDto dto = commentConvert.toDto(commentEntity);

		return dto;
	}

	@Transactional
	@Override
	public void deleteCommentById(Long idComment) {

		commentRepository.deleteById(idComment);
		commentRepository.onDeleteByCommentParentId(idComment);
	}

	@Override
	public List<CommentMainDto> getNewCommentLimit(int limit) {
		List<CommentEntity> comments = commentRepository.getNewCommentLimit(limit);

		if (comments == null) {
			return null;
		}

		List<CommentMainDto> dtos = commentConvert.toListDto(comments);
		return dtos;
	}

	@Override
	public Long countAllComments() {
		return commentRepository.count();
	}

}
