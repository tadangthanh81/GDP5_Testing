/**
 * Create by: User - CMC
 * Create date: Feb 15, 2019
 * Modifier: User
 * Modified date: Feb 15, 2019
 * Description: ....
 * Version 1.0
 */
package com.cmcglobal.service.serviceImpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmcglobal.entity.QuestionType;
import com.cmcglobal.repository.QuestionTypeRepository;
import com.cmcglobal.service.TypeSevice;

/**
 * Create by: thanhtd - CMC
 * Create date: Feb 15, 2019
 * Modifier: thanhtd
 * Modified date: Feb 15, 2019
 * Description: ....
 * Version 1.0
 */
@Service
public class TypeSeriveImpl implements TypeSevice {
	
	private static final Logger logger = Logger.getLogger(TypeSeriveImpl.class);
	
	@Autowired
	EntityManager entityManager;

	@Autowired
	QuestionTypeRepository typeRepoitory;
	/* (non-Javadoc)
	 * @see com.cmcglobal.service.TypeSevice#getAllType()
	 */
	@Override
	public List<QuestionType> getAllType() {
		try {
			logger.info("get all Type");
			return typeRepoitory.findAll();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	/* (non-Javadoc)
	 * @see com.cmcglobal.service.TypeSevice#getOneById(int)
	 */
	@Override
	public QuestionType getOneById(int typeId) {
		try {
			logger.info("get Type by id = " + typeId);
			return entityManager.find(QuestionType.class, typeId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

}