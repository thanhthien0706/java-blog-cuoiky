package com.thanhthien.cuoiki.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryCreateForm {

	private String title;
	private Boolean status;

}
