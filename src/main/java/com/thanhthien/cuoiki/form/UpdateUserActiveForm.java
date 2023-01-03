package com.thanhthien.cuoiki.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserActiveForm {
	private Long idUser;
	private Boolean active;
}
