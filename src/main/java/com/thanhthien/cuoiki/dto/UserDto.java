package com.thanhthien.cuoiki.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto extends BaseDto {
	private String fullName;
	private String userName;
	private String avatar;
	private String email;
	private Boolean active;
	private String roleName;
}
