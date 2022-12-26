package com.thanhthien.cuoiki.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostShowHomeDto extends BaseDto {
	private String title;
	private String avatar;
	private String category;
	private Long count;
}
