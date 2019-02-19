/**
 * Create by: User - CMC
 * Create date: Feb 11, 2019
 * Modifier: User
 * Modified date: Feb 11, 2019
 * Description: ....
 * Version 1.0
 */
package com.cmcglobal.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cmcglobal.entity.QuestionCategory;
import com.cmcglobal.repository.QuestionCategoryRepository;
import com.cmcglobal.service.CategoryService;

/**
 * Create by: thanhtd - CMC
 * Create date: Feb 11, 2019
 * Modifier: thanhtd
 * Modified date: Feb 11, 2019
 * Description: ....
 * Version 1.0
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	QuestionCategoryRepository categoryRepository;
	/* (non-Javadoc)
	 * @see com.cmcglobal.service.CategoryService#getAllCategory()
	 */
	@Override
	public List<QuestionCategory> getAllCategory() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}
	/* (non-Javadoc)
	 * @see com.cmcglobal.service.CategoryService#insertCategory(com.cmcglobal.entity.QuestionCategory)
	 */
	@Override
	public void insertCategory(QuestionCategory category) {
		categoryRepository.save(category);
		
	}
	/* (non-Javadoc)
	 * @see com.cmcglobal.service.CategoryService#deletebyId(java.lang.String)
	 */
	@Override
	public void deletebyId(Integer id) {
		categoryRepository.deleteById(id);
		
	}
	/* (non-Javadoc)
	 * @see com.cmcglobal.service.CategoryService#editCategory(java.lang.String, com.cmcglobal.entity.Question)
	 */
	@Override
	public String editCategory(Integer id, QuestionCategory newCategory) {
		Boolean existC = categoryRepository.existsById(id);
		if(!existC) {
			return "No category with id above";
		} else {
			newCategory.setId(id);
			categoryRepository.save(newCategory);
		}
		return null;
	}
	/* (non-Javadoc)
	 * @see com.cmcglobal.service.CategoryService#findById(java.lang.Integer)
	 */
	@Override
	public QuestionCategory findById(Integer id) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(id).get();
	}
	/* (non-Javadoc)
	 * @see com.cmcglobal.service.CategoryService#searchByContent(java.lang.String)
	 */
	@Override
	public List<QuestionCategory> searchByContent(String contentSearch) {
		
		return categoryRepository.findByCategoryNameContaining(contentSearch);
	}
	/* (non-Javadoc)
	 * @see com.cmcglobal.service.CategoryService#pageQuestionCategory(org.springframework.data.domain.Pageable)
	 */
	@Override
	public List<QuestionCategory> pageQuestionCategory(Pageable pageable) {
		
		return categoryRepository.pageQuestionCategory(pageable);
		
	}
	/* (non-Javadoc)
	 * @see com.cmcglobal.service.CategoryService#countQuestionCategory()
	 */
	@Override
	public String countQuestionCategory() {
		return categoryRepository.questionCategorySum();
	}
	
//	Boolean existQ = questionRepository.existsById(id);
//	if (!existQ) {
//		return "No question with id above";
//	} else {
//		newQuestion.setId(id);
//		questionRepository.saveAndFlush(newQuestion);
//		return "Update success";
//	}

}
