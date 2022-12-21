package com.thanhthien.cuoiki.model;

import java.util.Date;
import java.util.List;

import com.thanhthien.cuoiki.model.EnumType.StatusPost;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
