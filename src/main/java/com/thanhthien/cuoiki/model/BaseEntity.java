package com.thanhthien.cuoiki.model;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "createAt", updatable = false)
	@CreatedDate
	private Date createAt;

	@Column
	@LastModifiedDate
	private LocalDateTime updateAt;
}
