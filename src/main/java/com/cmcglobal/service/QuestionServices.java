package com.cmcglobal.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.cmcglobal.entity.Question;


public interface QuestionServices {

	Question findById(String id);

	void insertQuestion(Question question);

	void deletebyId(String id);

	String editQuestion(String id, Question newQuestion);

	String editQuestion1(Question newQuestion);

	List<Question> searchByContent(String contentSearch, Pageable pageable);

	List<Question> pageQuestion(Pageable pageable);

	String countQuestion();

	String countSearchQuestion(String content);

	List<Question> filterByAttribute(String categoryName, String levelName, String typeName, String fullName,
	        Date dateCreated, String tagName, Pageable pageable);

	List<Question> filterByAll(String categoryName, String levelName, String typeName, String fullName,
	        Date dateCreated, String tagName, Pageable pageable);
}
