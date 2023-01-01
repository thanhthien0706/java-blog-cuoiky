package com.thanhthien.cuoiki.form;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAvatarForm {
	private MultipartFile avatar;
	private Long idUser;
}
