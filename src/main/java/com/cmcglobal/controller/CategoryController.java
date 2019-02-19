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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
 * Description: category controller
 * Version 1.0
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge=3600)
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value="/category", method = RequestMethod.GET)
	public List<QuestionCategory> getAllCategories(){
		return categoryService.getAllCategory();
	}
	

	@RequestMapping(value = "category/{id}", method = RequestMethod.GET)
	public QuestionCategory getCById(@PathVariable("id") Integer id) {
		return categoryService.findById(id);
	}


	@RequestMapping(value = "category/add", method = RequestMethod.POST)
	public void insert(@RequestBody QuestionCategory category) {
		categoryService.insertCategory(category);
	}

	@RequestMapping(value = "category/delete/{id}", method = RequestMethod.DELETE)
	public void deleteCategory(@PathVariable("id") Integer id) {
		categoryService.deletebyId(id);
	}

	@RequestMapping(value = "category/edit/{id}", 
	method = RequestMethod.PATCH)
	private String editCategory(@PathVariable("id") Integer id, @RequestBody QuestionCategory newCategory) {
		return categoryService.editCategory(id, newCategory);
	}


}
