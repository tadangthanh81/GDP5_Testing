package com.cmcglobal.service;

import java.util.List;

import com.cmcglobal.entity.Question;

public interface QuestionServices {
	List<Question> getAllQuestion();
	Question findById(String id); 
	void insertQuestion(Question question);
	void deletebyId(String id);
	String editQuestion(String id, Question newQuestion);
	List<Question> searchByContent( String contentSearch);
}
