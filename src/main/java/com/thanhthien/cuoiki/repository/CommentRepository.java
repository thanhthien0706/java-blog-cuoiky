package com.thanhthien.cuoiki.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.thanhthien.cuoiki.model.CommentEntity;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
	CommentEntity findOneById(Long id);

	@Query(nativeQuery = true, value = "SELECT * FROM db_comments c WHERE c.post_id = :idPost ORDER BY c.create_at DESC LIMIT :limit ")
	List<CommentEntity> getCommentWithId(Long idPost, int limit);
}
