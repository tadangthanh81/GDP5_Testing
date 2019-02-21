/**
 * Create by: User - CMC
 * Create date: Feb 11, 2019
 * Modifier: User
 * Modified date: Feb 11, 2019
 * Description: ....
 * Version 1.0
 */
package com.cmcglobal.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.cmcglobal.entity.QuestionCategory;
import com.cmcglobal.entity.QuestionTag;

/**
 * Create by: thanhtd - CMC
 * Create date: Feb 11, 2019
 * Modifier: thanhtd
 * Modified date: Feb 11, 2019
 * Description: ....
 * Version 1.0
 */

public interface CategoryService {
	public List<QuestionCategory> getAllCategory();
	
	void insertCategory(QuestionCategory category);
	
	void deletebyId(Integer id);
	
	QuestionCategory findById(Integer id);
	
	String editCategory(Integer id, QuestionCategory newCategory);
	
	List<QuestionCategory> searchByContent(String contentSearch);

	List<QuestionCategory> pageQuestionCategory(Pageable pageable);

	String countQuestionCategory();
	public QuestionCategory getOneById(int categoryId); //Yen 
	
}
