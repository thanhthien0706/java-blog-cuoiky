package com.thanhthien.cuoiki.dto;

import java.sql.Date;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseDto {
	private Long id;
	private Date createAt;
	private LocalDateTime updateAt;
}
