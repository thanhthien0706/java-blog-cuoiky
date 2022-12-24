package com.thanhthien.cuoiki.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostMaintDto extends BaseDto {
	private String title;
	private String avatar;
	private String slug;
	private String summary;
	private String content;
	private String status;
	private Boolean deleted;
	private Date deleteAt;
	private List<CategoryMainDto> categories;
	private PostDto2 parentPost;
	private List<PostDto2> childPost;
	private UserDto author;
	private List<CommentMainDto> comments;

}
