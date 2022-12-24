package com.thanhthien.cuoiki.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "db_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity {
	@Column
	private String fullName;

	@Column
	private String userName;

	@Column
	private String avatar;

	@Column
	private String email;

	@Column
	private String password;

	@Column
	private Boolean active = true;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private RoleEnity role;

	@OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
	private List<PostEntity> posts;
}
