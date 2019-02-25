/**
 * 
 */
package com.cmcglobal.service.serviceImpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
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
	
	private static final Logger logger = Logger.getLogger(LevelQuestionImpl.class);
	
	@Autowired
	EntityManager entityManager;

	@Autowired
	QuestionLevelRepository levelRepository;

	@Override
	public List<QuestionLevel> getAllQuestionLevel() {
		try {
			logger.info("get all level");
			return levelRepository.findAll();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.cmcglobal.service.LevelService#getOneById(int)
	 */
	@Override
	public QuestionLevel getOneById(int levelId) {
		try {
			logger.info("get all level by id = " + levelId);
			return entityManager.find(QuestionLevel.class, levelId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

}