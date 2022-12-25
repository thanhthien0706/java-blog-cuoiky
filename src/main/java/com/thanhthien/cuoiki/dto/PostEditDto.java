package com.thanhthien.cuoiki.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostEditDto {
	private Long id;
	private String title;
	private String avatar;
	private String summary;
	private String content;
	private String status;
	private String categories;
}
