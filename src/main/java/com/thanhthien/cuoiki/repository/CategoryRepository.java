package com.thanhthien.cuoiki.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.thanhthien.cuoiki.model.CategoryEntity;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
	Boolean existsBySlug(String slug);

	CategoryEntity findOneBySlug(String slug);

	@Query(nativeQuery = true, 
			value = "SELECT DISTINCT c.* FROM db_categorys c JOIN post_category pc ON c.id = pc.category_id GROUP BY pc.category_id ORDER BY COUNT(pc.category_id) DESC LIMIT :limit")
	List<CategoryEntity> getCategoriesTitleWithLimit(int limit);
}
