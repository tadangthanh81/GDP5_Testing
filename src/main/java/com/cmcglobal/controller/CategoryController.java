/**
 * Create by: User - CMC
 * Create date: Feb 11, 2019
 * Modifier: User
 * Modified date: Feb 11, 2019
 * Description: ....
 * Version 1.0
 */
package com.cmcglobal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cmcglobal.entity.QuestionCategory;
import com.cmcglobal.service.CategoryService;

/**
 * Create by: thanhtd - CMC
 * Create date: Feb 11, 2019
 * Modifier: thanhtd
 * Modified date: Feb 11, 2019
 * Description: ....
 * Version 1.0
 */
@RestController
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value="/category", method = RequestMethod.GET)
	public List<QuestionCategory> getAllCategories(){
		return categoryService.getAllCategory();
	}
}