package com.thanhthien.cuoiki.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thanhthien.cuoiki.model.PostEntity;
import com.thanhthien.cuoiki.model.EnumType.StatusPost;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
	Boolean existsBySlug(String slug);

	List<PostEntity> findAllByStatus(StatusPost status);

	PostEntity findOneById(Long id);
}
