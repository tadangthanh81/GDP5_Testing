package com.cmcglobal.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import com.cmcglobal.entity.Question;

public interface QuestionServices {
	List<Question> getAllQuestion();
	Question findById(String id); 
	void insertQuestion(Question question);
	void deletebyId(String id);
	String editQuestion(String id, Question newQuestion);
	List<Question> searchByContent( String contentSearch, Pageable pageable);
//	void updateMultiQuestion(String category_id, String level_id, String tag_id, String question_id);
	List<Question> pageQuestion(Pageable pageable);
//	List<Question> filterByAttribute(Integer categoryID, 
//			Integer levelID, Integer typeID,  Integer userIdCreated,
//		Date dateCreated, Integer tagID);
	List<Question>  filterByAttribute(String categoryName, String levelName, String typeName, 
			String fullName,  Date dateCreated, String tagName, Pageable pageable);
	
	List<Question>  filterByAll(String categoryName, String levelName, String typeName, 
			String fullName,  Date dateCreated, String tagName, Pageable pageable );
}
