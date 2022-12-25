package com.thanhthien.cuoiki.dto;

import java.util.Date;
import java.util.List;

import com.thanhthien.cuoiki.model.EnumType.StatusPost;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostShowDto extends BaseDto {
	private UserDto author;
	private PostShowDto postParrent;
	private String title;
	private String avatar;
	private String slug;
	private String summary;
	private String status;
	private Boolean deleted;
	private Date deleteAt;
	private int countComments;
	private List<CategoryMainDto> categories;
}
