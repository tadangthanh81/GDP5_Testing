/**
 * Create by: User - CMC
 * Create date: Feb 15, 2019
 * Modifier: User
 * Modified date: Feb 15, 2019
 * Description: ....
 * Version 1.0
 */
package com.cmcglobal.service;

import java.util.List;

import com.cmcglobal.entity.Type;

/**
 * Create by: thanhtd - CMC
 * Create date: Feb 15, 2019
 * Modifier: thanhtd
 * Modified date: Feb 15, 2019
 * Description: ....
 * Version 1.0
 */
public interface TypeSevice {
	List<Type> getAllType();
	public Type getOneById(int typeId); //Yen 
}
