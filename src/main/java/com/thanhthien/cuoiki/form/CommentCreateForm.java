package com.thanhthien.cuoiki.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentCreateForm {
	private Long idPost;
	private String slug;
	private Long idUser;
	private String content;
}
