package com.cmcglobal.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cmcglobal.entity.QuestionCategory;
@Repository
public interface QuestionCategoryRepository extends JpaRepository<QuestionCategory, Integer> {
 
	@Query("select c from QuestionCategory c where c.categoryName like ?1 and c.status = 1")
	List<QuestionCategory> findByCategoryNameContaining(String contentSearch, Pageable pageable);

	@Query("SELECT c FROM QuestionCategory c where status=1")
	List<QuestionCategory> pageQuestionCategory(Pageable pageable);

	@Query("select count(category_id) from QuestionCategory where status=1")
	String questionCategorySum();
	
	@Query("select c FROM QuestionCategory c where status=1")
	List<QuestionCategory> getListCategory();
	
	@Query("select count(category_id) from QuestionCategory c where c.categoryName like ?1 and c.status = 1")
	String countSearchCategory(String content);
}
