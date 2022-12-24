package com.thanhthien.cuoiki.dto;

import java.util.Date;
import java.util.List;

import com.thanhthien.cuoiki.model.PostEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryMainDto extends BaseDto {
	private String title;
	private String slug;
	private Boolean status;
	private Boolean deleted;
	private Date deleteAt;
	private List<Long> posts;
}
