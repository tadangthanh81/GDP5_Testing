package com.cmcglobal.service.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cmcglobal.entity.Answer;
import com.cmcglobal.repository.AnswerRepository;
import com.cmcglobal.service.AnswerService;

@Service
public class AnswerServiceImpl implements AnswerService {

	private static final Logger logger = Logger.getLogger(AnswerServiceImpl.class);

	@Autowired
	AnswerRepository answerRepository;

	@Override
	public List<Answer> getAllAnswer() {
		try {
			logger.info("Get all Answer");
			return answerRepository.findAll();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public Answer findById(String id) {
		try {
			logger.info("Get Answer By id");
			return answerRepository.findById(id).get();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}

	}

	@Override
	public void insertAnswer(Answer answer) {
		try {
			logger.info("Insert answer");
			answerRepository.save(answer);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

	@Override
	public void deletebyId(String id) {
		try {
			logger.info("Delete Answer By id");
			answerRepository.deleteById(id);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	@Override
	public String editAnswer(String id, Answer newAnswer) {
		try {
			Boolean existA = answerRepository.existsById(id);
			if (!existA) {
				return "No question with id above";
			} else {
				newAnswer.setId(id);
				answerRepository.saveAndFlush(newAnswer);
				return "Update success";
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return "fail";
		}
	}

}
