/**
 * 
 */
package com.cmcglobal.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmcglobal.entity.QuestionLevel;
import com.cmcglobal.repository.QuestionLevelRepository;
import com.cmcglobal.service.LevelService;

/**
 * @author User
 *
 */
@Service
public class LevelQuestionImpl implements LevelService {

	@Autowired
	QuestionLevelRepository levelRepository;

	@Override
	public List<QuestionLevel> getAllQuestionLevel() {
		// TODO Auto-generated method stub
		return levelRepository.findAll();
	}

}
