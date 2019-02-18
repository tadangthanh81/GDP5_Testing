package com.cmcglobal.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cmcglobal.entity.Question;
import com.cmcglobal.repository.QuestionRepository;
import com.cmcglobal.service.QuestionServices;

@Service
public class QuestionServiceImpl implements QuestionServices {

	@Autowired
	QuestionRepository questionRepository;

	@Override
	public Question findById(String id) {
		return questionRepository.findById(id).get();
	}

	@Override
	public void insertQuestion(Question question) {
		questionRepository.save(question);
	}

	@Override
	public void deletebyId(String id) {
		questionRepository.deleteById(id);

	}

	@Override
	public String editQuestion(String id, Question newQuestion) {
		Boolean existQ = questionRepository.existsById(id);
		if (!existQ) {
			return "No question with id above";
		} else {
			newQuestion.setId(id);
			questionRepository.saveAndFlush(newQuestion);
			return "Update success";
		}
	}
	
	@Override
	public String editQuestion1(Question newQuestion) {
			System.out.println(newQuestion.getId());
			questionRepository.saveAndFlush(newQuestion);
			return "Update success";
	}

	@Override
	public List<Question> searchByContent(String contentSearch) {
		return questionRepository.findByContentContaining(contentSearch);
	}
	
	@Override
	public List<Question> pageQuestion(Pageable pageable) {
		return questionRepository.pageQuestion(pageable);
	}

	/* (non-Javadoc)
	 * @see com.cmcglobal.service.QuestionServices#countQuestion()
	 */
	@Override
	public String countQuestion() {
		// TODO Auto-generated method stub
		return questionRepository.questionSum();
	}

}
