package com.cmcglobal.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cmcglobal.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, String> {

//	@Query("SELECT q FROM Question q WHERE q.content LIKE %?1%")
	List<Question> findByContentContaining(String contentSearch, Pageable pageable);

	// filter by one attribute
	@Query("select q from Question q where q.category.categoryName like ?1  or q.questionLevel.levelName like ?2 "
	        + "or q.questionType.typeName like ?3 or q.userQuestion.fullName like ?4  or q.questionTag.tagName like ?5")
	List<Question> filterByAttribute(String categoryName, String levelName, String typeName, String fullName,
	        String tagName, Pageable pageable);

	// filter by all attribute

	@Query("select q from Question q where q.category.categoryName like ?1  and q.questionLevel.levelName like ?2 "
	        + "and q.questionType.typeName like ?3 and q.userQuestion.fullName like ?4 and q.dateCreated = ?5 and q.questionTag.tagName like ?6")
	List<Question> filterByAll(String categoryName, String levelName, String typeName, String fullName,
	        Date dateCreated, String tagName, Pageable pageable);

	@Query("SELECT q FROM Question q")
	List<Question> pageQuestion(Pageable pageable);

	@Query("select count(id) from Question")
	String questionSum();

	@Query("select count(question_id) from Question where content like ?1")
	String countSearchQuestion(String content);

}
