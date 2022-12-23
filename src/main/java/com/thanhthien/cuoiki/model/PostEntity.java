package com.thanhthien.cuoiki.model;

import java.util.Date;
import java.util.List;

import com.thanhthien.cuoiki.model.EnumType.StatusPost;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "db_posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "author_id")
	private UserEntity author;

	@ManyToOne
	@JoinColumn(name = "parent_id")
	private PostEntity parent;

	@Column
	private String title;

	@Column
	private String avatar;

	@Column
	private String slug;

	@Column
	private String summary;

	@Column
	private String content;

	@Column
	@Enumerated(EnumType.STRING)
	private StatusPost status;

	@Column
	private Boolean deleted = Boolean.FALSE;

	@Column
	private Date deleteAt;

	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
	private List<PostEntity> posts;

	@OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
	private List<CommentEntity> comments;

	@ManyToMany
	@JoinTable(name = "post_category", joinColumns = @JoinColumn(name = "post_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private List<CategoryEntity> categories;

}
