package com.cmcglobal.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.cmcglobal.entity.Question;


public interface QuestionServices {

	Question findById(String id);

	void insertQuestion(Question question);

	void deletebyId(String id);

	String editQuestion(String id, Question newQuestion);

	String editQuestion1(Question newQuestion);

	List<Question> searchByContent(String contentSearch);

	List<Question> pageQuestion(Pageable pageable);

	String countQuestion();
}
