package com.thanhthien.cuoiki.model;

import java.util.Date;
import java.util.List;

import com.thanhthien.cuoiki.model.EnumType.StatusPost;

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
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "db_comments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentEntity extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "post_id")
	private PostEntity post;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;

	@Column
	private String content;

	@Column
	private Boolean status;

	@Column
	private Boolean deleted = Boolean.FALSE;

	@Column
	private Date deleteAt;
}
