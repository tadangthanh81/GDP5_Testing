package com.cmcglobal.service.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmcglobal.entity.Question;
import com.cmcglobal.repository.QuestionRepository;
import com.cmcglobal.service.QuestionServices;
@Service
public class QuestionServiceImpl implements QuestionServices {
	
	@Autowired
	QuestionRepository questionRepository;
	@Override
	public List<Question> getAllQuestion() {
		return questionRepository.findAll();
	}

	@Override
	public Question findById(String id) {
		return questionRepository.findById(id).get();
	}

	@Override
	public void insertQuestion(Question question) {
		questionRepository.saveAndFlush(question);
		
	}

	@Override
	public void deletebyId(String id) {
		questionRepository.deleteById(id);
		
	}

	@Override
	public String editQuestion(String id, Question newQuestion) {
		Boolean existQ = questionRepository.existsById(id);
		if(!existQ) {
			return "No question with id above";
		} else {
			questionRepository.saveAndFlush(newQuestion);
			return "Update success";
		}
	}

	@Override
	public List<Question> searchByContent(String contentSearch) {
		return questionRepository.findByContentContaining(contentSearch);
	}

}
