package com.cmcglobal.service.serviceImpl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cmcglobal.entity.Question;
import com.cmcglobal.repository.QuestionRepository;
import com.cmcglobal.service.QuestionServices;

@Service
public class QuestionServiceImpl implements QuestionServices {

	@Autowired
	QuestionRepository questionRepository;

	@Autowired
	EntityManager entityManager;

	@Override
	public Question findById(String id) {
		return questionRepository.getOne(id);
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
	public List<Question> searchByContent(String contentSearch, Pageable pageable) {
		return questionRepository.findByContentContaining(contentSearch, pageable);
	}

	@Override
	public List<Question> pageQuestion(Pageable pageable) {
		return questionRepository.pageQuestion(pageable);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cmcglobal.service.QuestionServices#countQuestion()
	 */
	@Override
	public String countQuestion() {
		// TODO Auto-generated method stub
		return questionRepository.questionSum();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cmcglobal.service.QuestionServices#filterByTestString(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.util.Date,
	 * java.lang.String, org.springframework.data.domain.Pageable)
	 */
	@Override
	public List<Question> filterByAttribute(String categoryName, String levelName, String typeName, String fullName,
	        java.util.Date dateCreated, String tagName, Pageable pageable) {
		// TODO Auto-generated method stub
		return questionRepository.filterByAttribute(categoryName, levelName, typeName, fullName, dateCreated, tagName,
		        pageable);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cmcglobal.service.QuestionServices#filterByAll(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.util.Date,
	 * java.lang.String, org.springframework.data.domain.Pageable)
	 */
	@Override
	public List<Question> filterByAll(String categoryName, String levelName, String typeName, String fullName,
	        java.util.Date dateCreated, String tagName, Pageable pageable) {

		return questionRepository.filterByAll(categoryName, levelName, typeName, fullName, dateCreated, tagName,
		        pageable);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cmcglobal.service.QuestionServices#countSearchQuestion(java.lang.String)
	 */
	@Override
	public String countSearchQuestion(String content) {
		// TODO Auto-generated method stub
		content = "%" + content + "%";
		return questionRepository.countSearchQuestion(content);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cmcglobal.service.QuestionServices#filterQuestion(java.lang.String)
	 */
	@Override
	public List<Question> filterQuestion(String userName, Date dateCreated, Integer tagId, Integer levelId,
	        Integer categoryId, Integer typeId, Pageable pageable) {
		return questionRepository.filterQuestion(userName, dateCreated, tagId, levelId, categoryId, typeId, pageable);
	}

}
