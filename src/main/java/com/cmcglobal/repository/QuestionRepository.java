package com.cmcglobal.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cmcglobal.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, String> {
	List<Question> findByContentContaining(String contentSearch);

	@Query("SELECT q FROM Question q")
	List<Question> pageQuestion(Pageable pageable);

	@Query("select count(question_id) from Question")
	String questionSum();
}
