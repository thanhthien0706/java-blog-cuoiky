package com.thanhthien.cuoiki.services;

import java.util.List;

import com.thanhthien.cuoiki.dto.CommentMainDto;

public interface ICommentService {
	List<CommentMainDto> getAllCommentWithSlugPost(String slug, int limit);
}
