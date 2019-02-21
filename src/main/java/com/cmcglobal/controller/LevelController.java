/**
 * 
 */
package com.cmcglobal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cmcglobal.entity.QuestionLevel;
import com.cmcglobal.service.LevelService;

/**
 * Create by: thanhtd - CMC
 * Create date: Feb 11, 2019
 * Modifier: thanhtd Modified
 * date: Feb 11, 2019
 * Description: Level Controller
 * Version 1.0
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge=3600)
public class LevelController {

	@Autowired
	private LevelService levelService;

	/**
	 * get all lvl
	 * @return list level
	 */
	@RequestMapping(value = "/level", method = RequestMethod.GET)
	public  List<QuestionLevel> getAllLevel() {
		return levelService.getAllQuestionLevel();
	}
}
