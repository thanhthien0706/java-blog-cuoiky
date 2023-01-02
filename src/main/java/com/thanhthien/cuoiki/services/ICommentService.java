package com.thanhthien.cuoiki.services;

import java.util.List;

import com.thanhthien.cuoiki.dto.CommentMainDto;
import com.thanhthien.cuoiki.form.CommentCreateForm;
import com.thanhthien.cuoiki.form.CommentUpdateAcceptForm;

public interface ICommentService {
	List<CommentMainDto> getAllCommentWithSlugPost(String slug, int limit);

	CommentMainDto createComment(CommentCreateForm commentCreateForm);

	List<CommentMainDto> getAllCommentWithAuthorId(Long idAuthor);

	CommentMainDto updateStatusComment(CommentUpdateAcceptForm commentUpdateAcceptForm);

	CommentMainDto createCommentReply(CommentCreateForm commentCreateForm);

	void deleteCommentById(Long idComment);
}
