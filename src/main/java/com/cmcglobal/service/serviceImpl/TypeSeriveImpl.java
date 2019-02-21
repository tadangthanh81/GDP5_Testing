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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmcglobal.entity.Type;
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
	
	@Autowired
	EntityManager entityManager;

	@Autowired
	QuestionTypeRepository typeRepoitory;
	/* (non-Javadoc)
	 * @see com.cmcglobal.service.TypeSevice#getAllType()
	 */
	@Override
	public List<Type> getAllType() {
		// TODO Auto-generated method stub
		return typeRepoitory.findAll();
	}
	/* (non-Javadoc)
	 * @see com.cmcglobal.service.TypeSevice#getOneById(int)
	 */
	@Override
	public Type getOneById(int typeId) {
		// TODO Auto-generated method stub
		return entityManager.find(Type.class, typeId);
	}

}
