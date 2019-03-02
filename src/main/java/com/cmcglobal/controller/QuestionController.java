package com.cmcglobal.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cmcglobal.entity.Answer;
import com.cmcglobal.entity.Question;
import com.cmcglobal.service.AnswerService;
import com.cmcglobal.service.QuestionService;

@RestController
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@Autowired
	private AnswerService answerService;

	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * get sum question
	 * @param responseHeaders
	 */
	@RequestMapping(value = "question/sum", method = RequestMethod.GET)
	private void sumQuestion(HttpServletResponse responseHeaders) {
		responseHeaders.addHeader("SumQuestion", questionService.countQuestion());
	}

	/**
	 * count search
	 * @param responseHeaders
	 * @param content
	 */
	@RequestMapping(value = "question/count-search-question", method = RequestMethod.GET)
	private void countQuestion(HttpServletResponse responseHeaders, @RequestParam String content) {
		responseHeaders.addHeader("CountSearchQuestion", questionService.countSearchQuestion(content));
	}

	/**
	 * get question
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "question/pagination", method = RequestMethod.GET)
	private List<Question> getPageQuestion(
	        @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
	        @RequestParam(name = "size", required = false, defaultValue = "10") Integer size) {
		Pageable pageable = PageRequest.of(page, size);
		return questionService.pageQuestion(pageable);
	}


	/**
	 * get by id
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "question/{id}", method = RequestMethod.GET)
	public Question getQById(@PathVariable("id") String id) {
		return questionService.findById(id);
	}

	/**
	 * @param contentSearch
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "question/search-by-content", method = RequestMethod.GET)
	private List<Question> searchByContent(@RequestParam(defaultValue = "") String contentSearch,
	        @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
	        @RequestParam(name = "size", required = false, defaultValue = "5") Integer size) {
		Pageable pageable = PageRequest.of(page, size);
		String content = contentSearch.trim();
		if (content.equals("")) {
			return questionService.pageQuestion(pageable);
		}
		return questionService.searchByContent(content, pageable);
	}

	@RequestMapping(value = "question", method = RequestMethod.POST)
	public void insert(@RequestBody Question question) {
		questionService.insertQuestion(question);
		question.getQuestionId();
		List<Answer> answers = question.getQuestionAnswer();
		String id = question.getQuestionId();
		for (Answer answer : answers) {
			answer.setQuestionId(id);
			answerService.insertAnswer(answer);
		}
	}

	@PutMapping(value = "question/edit/{questionID}")
	private String editQuestion(@PathVariable("questionID") String questionID, @RequestBody Question newQuestion) {
		System.out.println(newQuestion);
		return questionService.editQuestion(questionID, newQuestion);
	}

	@PutMapping(value = "question/edit")
	private String editQuestion1(@RequestBody Question newQuestion) {
		System.out.println(newQuestion);
		return questionService.editQuestion1(newQuestion);
	}

	/**
	 * Yen
	 * 
	 * @param multipartFile
	 * @return
	 */
	@PostMapping("/question/importlist")
	public ResponseEntity<String> readExcelFile(@RequestParam("multipartFile") MultipartFile multipartFile) {

		File file = new File("files");
		String pathToSave = file.getAbsolutePath(); // save file vao server
		System.out.println(pathToSave);

		File fileTranfer = new File(pathToSave + "/" + multipartFile.getOriginalFilename());
		try {
			multipartFile.transferTo(fileTranfer);
		} catch (IllegalStateException e) {
		} catch (IOException e) {
		}
		System.out.println(fileTranfer.toString());
		System.out.println(multipartFile.getOriginalFilename());

		List<Question> listQuestion = questionService.readExcel(fileTranfer.toString()); // lay tu server ra r doc file
		if (listQuestion.size() == 0) {
			return ResponseEntity.ok("Not ok");
		}
		List<Question> list = questionService.findAll();
		int x = list.size();
		for (Question question : listQuestion) {

			String s = "Question" + " " + String.valueOf(x); // to create id for question
			question.setQuestionId(questionService.createId());
			++x;
			System.out.println(question);
			questionService.insertQuestion(question);
		}
		return ResponseEntity.ok("Ok");
	}

	@GetMapping(value = "question/filterQuestion")
	public List<Question> filterQuestion(@RequestParam(value = "userName", required = false) String userName,
	        @RequestParam(value = "dateCreated", required = false) Date dateCreated,
	        @RequestParam(value = "tagId", required = false) Integer tagId,
	        @RequestParam(value = "levelId", required = false) Integer levelId,
	        @RequestParam(value = "categoryId", required = false) Integer categoryId,
	        @RequestParam(value = "typeId", required = false) Integer typeId,
	        @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
	        @RequestParam(name = "size", required = false, defaultValue = "10") Integer size) {
		Pageable pageable = PageRequest.of(page, size);
		System.out.println("hehehe");
		return questionService.filterQuestion(userName, dateCreated, tagId, levelId, categoryId, typeId, pageable);
	}

	@RequestMapping(value = "question/add", method = RequestMethod.POST)
	public void insertQ(@RequestBody Question question) {
		questionService.insertQuestion(question);
	}

}
