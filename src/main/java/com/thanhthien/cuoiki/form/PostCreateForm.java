package com.thanhthien.cuoiki.form;

import org.springframework.web.multipart.MultipartFile;

import com.thanhthien.cuoiki.model.EnumType.StatusPost;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostCreateForm {
	
	private String title;
	private MultipartFile avatar;
	private String summary;
	private String content;
	private String status;
	private String categories;
	
}
