package com.cmcglobal.service;

import java.util.List;

import com.cmcglobal.entity.Answer;

public interface AnswerService {
	List<Answer> getAllAnswer();
	Answer findById(String id); 
	void insertAnswer(Answer answer);
	void deletebyId(String id);
	String editAnswer(String id, Answer newAnswer);
}
