package com.thanhthien.cuoiki.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDetailDto extends BaseDto {
	private String title;
	private String avatar;
	private String slug;
	private String summary;
	private String content;
	private String status;
	private Boolean deleted;
	private Date deleteAt;
	private String category;
	private Long count;
	private PostMaintDto parentPost;
	private List<PostMaintDto> childPost;
	private UserDto author;
}
