package com.cmcglobal.service.serviceImpl;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
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
	public List<Question> getAllQuestion() {
		return questionRepository.findAll();
	}

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
	public List<Question> searchByContent(String contentSearch, Pageable pageable) {
		return questionRepository.findByContentContaining(contentSearch, pageable);
	}


//	@Override
//	public void updateMultiQuestion(String category_id, String level_id, String tag_id, String question_id) {
//		// TODO Auto-generated method stub
//		questionRepository.updateMultiQuestion(category_id, level_id, tag_id, question_id);
//	}
//	
	@Override
	public List<Question> pageQuestion(Pageable pageable) {
		return questionRepository.pageQuestion(pageable);
	}


//	@Override
//	public List<Question> filterByAttribute(Integer categoryID, Integer levelID, Integer typeID, Integer userIdCreated,
//	        java.util.Date dateCreated, Integer tagID) {
//		// TODO Auto-generated method stub
//		return questionRepository.filterByOneAttribute(categoryID, levelID, typeID, userIdCreated, dateCreated, tagID);
//	}

	/* (non-Javadoc)
	 * @see com.cmcglobal.service.QuestionServices#filterByTestString(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Date, java.lang.String, org.springframework.data.domain.Pageable)
	 */
	@Override
	public List<Question> filterByAttribute(String categoryName, String levelName, String typeName, String fullName,
	        java.util.Date dateCreated, String tagName, Pageable pageable) {
		// TODO Auto-generated method stub
		return questionRepository.filterByAttribute(categoryName, levelName, typeName, fullName, dateCreated, tagName, pageable);
	}

	/* (non-Javadoc)
	 * @see com.cmcglobal.service.QuestionServices#filterByAll(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Date, java.lang.String, org.springframework.data.domain.Pageable)
	 */
	@Override
	public List<Question> filterByAll(String categoryName, String levelName, String typeName, String fullName,
	        java.util.Date dateCreated, String tagName, Pageable pageable) {
		
		return questionRepository.filterByAll(categoryName, levelName, typeName, fullName, dateCreated, tagName, pageable);
	}

	

}
