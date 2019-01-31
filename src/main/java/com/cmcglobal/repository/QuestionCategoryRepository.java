package com.cmcglobal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmcglobal.entity.QuestionCategory;
@Repository
public interface QuestionCategoryRepository extends JpaRepository<QuestionCategory, Integer> {

}
