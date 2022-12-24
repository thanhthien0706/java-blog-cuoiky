package com.thanhthien.cuoiki.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto2 {
	private Long id;
	private String title;
	private String avatar;
	private String slug;
	private String summary;
}
