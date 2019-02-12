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

}
