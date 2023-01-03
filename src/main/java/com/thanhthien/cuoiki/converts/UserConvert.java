package com.thanhthien.cuoiki.converts;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.thanhthien.cuoiki.dto.UserDto;
import com.thanhthien.cuoiki.model.BaseEntity;
import com.thanhthien.cuoiki.model.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
public class UserConvert extends BaseEntity {
	public UserDto toDto(UserEntity user) {
		UserDto dto = new UserDto();

		dto.setId(user.getId());
		dto.setFullName(user.getFullName());
		dto.setUserName(user.getUserName());
		dto.setAvatar(user.getAvatar());
		dto.setEmail(user.getEmail());
		dto.setActive(user.getActive());
		dto.setRoleName(user.getRole().getName());
		dto.setCreateAt(user.getCreateAt());
		dto.setUpdateAt(user.getUpdateAt());

		return dto;
	}

	public List<UserDto> toListDto(List<UserEntity> users) {
		List<UserDto> dtos = new ArrayList<>();

		for (UserEntity user : users) {
			dtos.add(toDto(user));
		}

		return dtos;
	}
}
