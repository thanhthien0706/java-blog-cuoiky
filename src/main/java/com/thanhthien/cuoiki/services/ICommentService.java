package com.thanhthien.cuoiki.services;

import java.util.List;

import com.thanhthien.cuoiki.dto.CommentMainDto;
import com.thanhthien.cuoiki.form.CommentCreateForm;

public interface ICommentService {
	List<CommentMainDto> getAllCommentWithSlugPost(String slug, int limit);

	CommentMainDto createComment(CommentCreateForm commentCreateForm);
}
