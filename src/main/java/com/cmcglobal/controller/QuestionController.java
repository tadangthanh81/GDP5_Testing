package com.cmcglobal.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cmcglobal.entity.Question;
import com.cmcglobal.service.serviceImpl.QuestionServiceImpl;

@RestController
public class QuestionController {
	@Autowired
	private QuestionServiceImpl questionService;

	@RequestMapping(value = "question/all", method = RequestMethod.GET)
	private List<Question> getAllQuestion() {
		return questionService.getAllQuestion();
	}
	
	@RequestMapping(value="question/pagination", method = RequestMethod.GET)
	private List<Question> getPageQuestion(
			@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(name = "size", required = false, defaultValue = "10") Integer size) {    
	    Pageable pageable = PageRequest.of(page, size);	    
		return questionService.pageQuestion(pageable);
	}

	@RequestMapping(value = "question/{id}", method = RequestMethod.GET)
	public Question getQById(@PathVariable("id") String id) {
		return questionService.findById(id);
	}

	@RequestMapping(value = "question/search-by-content", method = RequestMethod.GET)
	private List<Question> searchByContent(@RequestParam("contentSearch") String contentSearch,
			@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(name = "size", required = false, defaultValue = "10") Integer size ) {
				Pageable pageable = PageRequest.of(page, size);	 
		return questionService.searchByContent(contentSearch, pageable);

	}
	
//	@RequestMapping(value = "question/filter", method = RequestMethod.GET)
//	private List<Question> filterByAttribute(@RequestParam("categoryID") Integer categoryID, 
//			@RequestParam(name = "levelID", required = false) Integer levelID, @RequestParam(name = "typeID", required = false) Integer typeID,
//			@RequestParam(name = "userIdCreated", required = false) Integer userIdCreated,
//			@RequestParam(name = "dateCreated", required = false) Date dateCreated, @RequestParam(name = "tagID", required = false) Integer tagID) {
//		return questionService.filterByAttribute(categoryID, levelID, typeID, userIdCreated, dateCreated, tagID);
//
//	}
	@RequestMapping(value = "question/filter", method = RequestMethod.GET)
	public List<Question> filterByAttribute(
			@RequestParam(name = "categoryName", required = false) String categoryName,
			@RequestParam(name = "levelName", required = false) String levelName,
			@RequestParam(name = "typeName", required = false) String typeName,
			@RequestParam(name = "fullName", required = false) String fullName,
			@RequestParam(name = "dateCreated", required = false) Date dateCreated,
			@RequestParam(name = "tagName", required = false) String tagName,
			@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(name = "size", required = false, defaultValue = "10") Integer size 
			) {
		Pageable pageable = PageRequest.of(page, size);	 
		String emt = "";
		if(emt.equals(categoryName)|| emt.equals(levelName) || emt.equals(typeName)
				|| emt.equals(fullName) || dateCreated == null  || emt.equals(tagName)) {
			return questionService.filterByAttribute(categoryName, levelName, typeName, 
					fullName, dateCreated, tagName, pageable);
			} else {
			return questionService.filterByAll(categoryName, levelName, typeName, fullName, dateCreated, tagName, pageable);
			}
		}
		

	@RequestMapping(value = "question/add", method = RequestMethod.POST)
	public void insert(@RequestBody Question question) {
		questionService.insertQuestion(question);
	}

	@RequestMapping(value = "question/delete/{questionID}", method = RequestMethod.DELETE)
	public void deleteQuestion(@PathVariable("questionID") String questionID) {
		questionService.deletebyId(questionID);
	}

	@RequestMapping(value = "question/edit/{questionID}", 
	method = RequestMethod.PATCH)
	private String editQuestion(@PathVariable("questionID") String questionID, @RequestBody Question newQuestion) {
		return questionService.editQuestion(questionID, newQuestion);
	}

	@RequestMapping(value = "question/updateMT/{questionID}", method = RequestMethod.PATCH)
	private String udpateMultiQuestion() {
		return "";
	}
	
	
}
