package com.thanhthien.cuoiki.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.thanhthien.cuoiki.model.PostEntity;
import com.thanhthien.cuoiki.model.EnumType.StatusPost;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
	Boolean existsBySlug(String slug);

	List<PostEntity> findAllByStatus(StatusPost status);

	PostEntity findOneById(Long id);

	PostEntity findOneByIdAndAuthorId(Long id, Long authorId);

	List<PostEntity> findAllByOrderByCreateAtDesc();

	@Query(nativeQuery = true, value = "SELECT * FROM db_posts p WHERE p.status = 'PUBLIC' ORDER BY p.count DESC LIMIT :limit")
	List<PostEntity> getPostOrderCountWithLimit(int limit);

	@Query(nativeQuery = true, value = "SELECT p.* FROM db_posts p JOIN post_category pc ON p.id = pc.post_id WHERE pc.category_id = :idCategory ORDER BY p.count DESC LIMIT :limit")
	List<PostEntity> getPostWithCatogryAndLimit(Long idCategory, int limit);

	PostEntity findOneBySlug(String slug);

	@Query(nativeQuery = true, value = "SELECT * FROM db_posts p WHERE p.slug = \' + :slug + \' LIMIT 1")
	PostEntity getOnePostBySlug(String slug);

//	@Query(nativeQuery = true, value = "SELECT * ")
	List<PostEntity> findAllByActionAndAuthorId(Boolean action, Long idAuthor);
}
