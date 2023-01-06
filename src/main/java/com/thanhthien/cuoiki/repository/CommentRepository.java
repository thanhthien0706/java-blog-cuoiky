package com.thanhthien.cuoiki.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thanhthien.cuoiki.model.CommentEntity;

@Repository
public interface CommentRepository extends CrudRepository<CommentEntity, Long> {

	CommentEntity findOneById(Long id);

	@Query(nativeQuery = true, value = "SELECT * FROM db_comments c WHERE c.post_id = :idPost AND c.parent_id IS NULL ORDER BY c.create_at DESC LIMIT :limit ")
	List<CommentEntity> getCommentWithId(Long idPost, int limit);

	@Query(nativeQuery = true, value = "SELECT * FROM db_comments c INNER JOIN db_posts p ON c.post_id = p.id WHERE p.author_id = :authorId AND c.parent_id IS NULL")
	List<CommentEntity> getAllByAuthorId(Long authorId);

	@Modifying
	@Query(nativeQuery = true, value = "DELETE FROM db_comments c WHERE c.parent_id = :idParentComent")
	void onDeleteByCommentParentId(Long idParentComent);

//	void deleteAllByCommentParentId(Long idParentComent);

	@Query(nativeQuery = true, value = "SELECT * FROM db_comments c ORDER BY c.create_at DESC LIMIT :limit")
	List<CommentEntity> getNewCommentLimit(int limit);

	@Query(nativeQuery = true, value = "SELECT COUNT(*) FROM db_comments c WHERE c.post_id = :idPost")
	Long countCommentsByIdPost(Long idPost);

}
