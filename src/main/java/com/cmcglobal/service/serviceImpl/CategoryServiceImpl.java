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

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cmcglobal.entity.Category;
import com.cmcglobal.repository.CategoryRepository;
import com.cmcglobal.service.CategoryService;

/**
 * Create by: thanhtd - CMC Create date: Feb 11, 2019 Modifier: thanhtd Modified
 * date: Feb 11, 2019 Description: .... Version 1.0
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	private static final Logger logger = Logger.getLogger(CategoryServiceImpl.class);
	
	@Autowired
	EntityManager entityManager;

	@Autowired
	CategoryRepository categoryRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cmcglobal.service.CategoryService#getAllCategory()
	 */
	@Override
	public List<Category> getAllCategory() {
		try {
			logger.info("Get all category");
			return categoryRepository.getListCategory();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cmcglobal.service.CategoryService#insertCategory(com.cmcglobal.entity.
	 * QuestionCategory)
	 */
	@Override
	public void insertCategory(Category category) {
		try {
			logger.info("Insert answer");
			categoryRepository.save(category);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cmcglobal.service.CategoryService#deletebyId(java.lang.String)
	 */
	@Override
	public void deletebyId(Integer id) {
		try {
			logger.info("Delete category by id = " + id);
			categoryRepository.deleteById(id);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cmcglobal.service.CategoryService#editCategory(java.lang.String,
	 * com.cmcglobal.entity.Question)
	 */
	@Override
	public String editCategory(Integer id, Category newCategory) {
		try {
			logger.info("Edit category by id = " + id);
			Boolean existC = categoryRepository.existsById(id);
			if (!existC) {
				return "No category with id above";
			} else {
				newCategory.setId(id);
				categoryRepository.save(newCategory);
			}
			return null;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return "fail";
		}
		}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cmcglobal.service.CategoryService#findById(java.lang.Integer)
	 */
	@Override
	public Category findById(Integer id) {
		try {
			logger.info("Find category by id = " + id);
			return categoryRepository.findById(id).get();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cmcglobal.service.CategoryService#searchByContent(java.lang.String)
	 */
	@Override
	public List<Category> searchByContent(String contentSearch, Pageable pageable) {
		contentSearch = "%" + contentSearch + "%";
		try {
			logger.info("Search category by text = " + contentSearch);
			return categoryRepository.findByCategoryNameContaining(contentSearch, pageable);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cmcglobal.service.CategoryService#pageQuestionCategory(org.
	 * springframework.data.domain.Pageable)
	 */
	@Override
	public List<Category> pageQuestionCategory(Pageable pageable) {

		try {
			logger.info("get all category by pagination");
			return categoryRepository.pageQuestionCategory(pageable);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cmcglobal.service.CategoryService#countQuestionCategory()
	 */
	@Override
	public String countQuestionCategory() {
		try {
			return categoryRepository.questionCategorySum();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return "fail";
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cmcglobal.service.CategoryService#countSearchCategory(java.lang.String)
	 */
	@Override
	public String countSearchCategory(String content) {
		content = "%" + content + "%";
		try {
			return categoryRepository.countSearchCategory(content);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return "fail";
		}
	}

	/* (non-Javadoc)
	 * @see com.cmcglobal.service.CategoryService#getOneById(int)
	 */
	@Override
	public Category getOneById(int categoryId) {
		try {
			logger.info("Get Category by id = " + categoryId);
			return entityManager.find(Category.class, categoryId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
}
