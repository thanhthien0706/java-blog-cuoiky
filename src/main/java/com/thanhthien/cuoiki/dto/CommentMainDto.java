package com.thanhthien.cuoiki.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentMainDto extends BaseDto {
	private Long postId;
	private String postName;
	private String postSlug;
	private UserDto user;
	private String content;
	private Boolean status;
	private Boolean deleted;
	private Date deleteAt;
	private List<CommentMainDto> commentChilds;
}
