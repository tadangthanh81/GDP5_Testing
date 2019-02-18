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

	@Autowired
	QuestionTypeRepository typeRepoitory;
	/* (non-Javadoc)
	 * @see com.cmcglobal.service.TypeSevice#getAllType()
	 */
	@Override
	public List<QuestionType> getAllType() {
		// TODO Auto-generated method stub
		return typeRepoitory.findAll();
	}

}
