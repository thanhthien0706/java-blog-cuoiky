package com.thanhthien.cuoiki.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryShowHomeDto extends BaseDto {
	private String title;
	private String slug;
}
