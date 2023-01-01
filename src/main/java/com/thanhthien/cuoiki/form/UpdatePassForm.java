package com.thanhthien.cuoiki.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePassForm {
	private Long idUser;
	private String oldPassword;
	private String newPassword;
}
