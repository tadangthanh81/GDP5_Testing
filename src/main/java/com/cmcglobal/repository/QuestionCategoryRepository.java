package com.cmcglobal.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cmcglobal.entity.QuestionCategory;
@Repository
public interface QuestionCategoryRepository extends JpaRepository<QuestionCategory, Integer> {

	List<QuestionCategory> findByCategoryNameContaining(String contentSearch);

	@Query("SELECT c FROM QuestionCategory c where c.status=1")
	List<QuestionCategory> pageQuestionCategory(Pageable pageable);

	@Query("select count(category_id) from QuestionCategory")
	String questionCategorySum();
	
	@Query("select c FROM QuestionCategory c where c.status=1")
	List<QuestionCategory> getListCategory();
}
