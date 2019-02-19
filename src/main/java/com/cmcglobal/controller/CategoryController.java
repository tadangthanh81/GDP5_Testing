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

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value = "category/sum", method = RequestMethod.GET)
	private void sumCategory(HttpServletResponse responseHeaders) {
		responseHeaders.addHeader("SumCategory", categoryService.countQuestionCategory());
	}

	@RequestMapping(value = "category/pagination", method = RequestMethod.GET)
	private List<QuestionCategory> getPageCategory(
	        @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
	        @RequestParam(name = "size", required = false, defaultValue = "2") Integer size){
		Pageable pageable = PageRequest.of(page, size);
		return categoryService.pageQuestionCategory(pageable);
	}
		
	@RequestMapping(value="/category", method = RequestMethod.GET)
	public List<QuestionCategory> getAllCategories(){
		return categoryService.getAllCategory();
	}
	

	@RequestMapping(value = "category/{id}", method = RequestMethod.GET)
	public QuestionCategory getCById(@PathVariable("id") Integer id) {
		return categoryService.findById(id);
	}

	@RequestMapping(value = "category/search-by-content/{contentSearch}", method = RequestMethod.GET)
	private List<QuestionCategory> searchByContent(@PathVariable("contentSearch") String contentSearch) {
		return categoryService.searchByContent(contentSearch);
	}

	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public void insert(@RequestBody QuestionCategory category) {
		categoryService.insertCategory(category);
	}

	@RequestMapping(value = "category/{id}", method = RequestMethod.DELETE)
	public void deleteCategory(@PathVariable("id") Integer id) {
		categoryService.deletebyId(id);
	}

	@RequestMapping(value = "category/{id}", 
	method = RequestMethod.PATCH)
	private String editCategory(@PathVariable("id") Integer id, @RequestBody QuestionCategory newCategory) {
		return categoryService.editCategory(id, newCategory);
	}


}
