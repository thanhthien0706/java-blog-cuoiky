package com.thanhthien.cuoiki.form;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostEditForm {

	private Long idPost;
	private String title;
	private MultipartFile avatar;
	private String summary;
	private String content;
	private String status;
	private String categories;
}
