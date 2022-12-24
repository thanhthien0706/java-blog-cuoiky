package com.thanhthien.cuoiki.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDataDto extends BaseDto {
	private String title;
	private String avatar;
	private String slug;
	private String summary;
	private String content;
	private String status;
	private Boolean deleted;
	private Date deleteAt;
	private String[] categories;
	private PostMaintDto parentPost;
	private PostMaintDto[] childPost;
	private UserDto author;
}
