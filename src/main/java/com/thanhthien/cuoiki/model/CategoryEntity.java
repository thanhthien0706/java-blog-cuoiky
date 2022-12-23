package com.thanhthien.cuoiki.model;

import java.util.Date;
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
import javax.persistence.Table;

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
