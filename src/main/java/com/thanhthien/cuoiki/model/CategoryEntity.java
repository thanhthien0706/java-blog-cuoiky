package com.thanhthien.cuoiki.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "db_categorys")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryEntity extends BaseEntity {

	@Column
	private String title;

	@Column
	private String slug;

	@Column
	private Boolean status;

	@Column
	private Boolean deleted = Boolean.FALSE;

	@Column
	private Date deleteAt;

	@ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
	private List<PostEntity> posts;
}
