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
import org.springframework.stereotype.Service;


import com.cmcglobal.entity.QuestionTag;
import com.cmcglobal.repository.QuestionTagRepository;
import com.cmcglobal.service.TagService;

/**
 * Create by: thanhtd - CMC
 * Create date: Feb 11, 2019
 * Modifier: thanhtd
 * Modified date: Feb 11, 2019
 * Description: ....
 * Version 1.0
 */
@Service
public class TagServiceImpl implements TagService {
	
	private static final Logger logger = Logger.getLogger(TagServiceImpl.class);
	
	@Autowired
	EntityManager entityManager;

	@Autowired
	QuestionTagRepository tagRepository;
	/* (non-Javadoc)
	 * @see com.cmcglobal.service.TagService#getAllTag()
	 */
	@Override
	public List<QuestionTag> getAllTag() {
		try {
			logger.info("get all level  ");
			return tagRepository.findAll();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	/* (non-Javadoc)
	 * @see com.cmcglobal.service.TagService#createTag(com.cmcglobal.entity.QuestionTag)
	 */
	@Override
	public void createTag(QuestionTag tag) {
		try {
			logger.info("Insert Tag ");
			tagRepository.save(tag);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	/* (non-Javadoc)
	 * @see com.cmcglobal.service.TagService#getOneById(int)
	 */
	@Override
	public QuestionTag getOneById(int tagId) {
		try {
			logger.info("get tag by id = " + tagId);
			return entityManager.find(QuestionTag.class, tagId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

}