package com.thanhthien.cuoiki.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentUpdateAcceptForm {
	private Boolean commentStatus;
	private Long commentId;
	private Long postId;
}
