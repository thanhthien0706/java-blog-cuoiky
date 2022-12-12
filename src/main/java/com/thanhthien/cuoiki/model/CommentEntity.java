package com.thanhthien.cuoiki.model;

import java.util.Date;
import java.util.List;

import com.thanhthien.cuoiki.model.EnumType.StatusPost;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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

	@Column
	private String content;

	@Column
	private Boolean status;

	@Column
	private Boolean deleted = Boolean.FALSE;

	@Column
	private Date deleteAt;
}
