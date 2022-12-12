package com.thanhthien.cuoiki.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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

	@ManyToOne
	@JoinColumn(name = "role_id")
	private RoleEnity role;

	@OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
	private List<PostEntity> posts;
}
