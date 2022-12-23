package com.thanhthien.cuoiki.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "db_roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleEnity extends BaseEntity {
	public static final String AUTHOR_ADMIN = "ROLE_ADMIN";
	public static final String AUTHOR_USER = "ROLE_USER";

	@Column
	private String name;

	@Column
	private String description;

	@OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
	private List<UserEntity> users;
}
