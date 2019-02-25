/**
 * 
 */
package com.cmcglobal.service.serviceImpl;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmcglobal.entity.User;
import com.cmcglobal.repository.UserRepository;
import com.cmcglobal.service.UserService;


/**
 * @author User
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User findEmail(String email) {		
		
		logger.info("Find by email");
		Optional<User> user = userRepository.findByEmail(email);
		if(user.isPresent()) {
			return user.get();
		}
		else
			return null;
	}

}
