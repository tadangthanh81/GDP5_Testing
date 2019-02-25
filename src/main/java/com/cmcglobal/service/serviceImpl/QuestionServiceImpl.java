package com.cmcglobal.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cmcglobal.entity.Question;
import com.cmcglobal.repository.QuestionRepository;
import com.cmcglobal.service.QuestionServices;


@Service
public class QuestionServiceImpl implements QuestionServices {

	@Autowired
	QuestionRepository questionRepository;

	@Override
	public Question findById(String id)  {
		try {
			return questionRepository.findById(id).get();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void insertQuestion(Question question) {
		try {
			questionRepository.save(question);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void deletebyId(String id) {
		try {
			questionRepository.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public String editQuestion(String id, Question newQuestion) {
		try {
			Boolean existQ = questionRepository.existsById(id);
			if (!existQ) {
				return "No question with id above";
			} else {
				newQuestion.setId(id);
				questionRepository.saveAndFlush(newQuestion);
				return "Update success";
			}
		} catch (Exception e) {
			return "fail";
		}
	}
	
	@Override
	public String editQuestion1(Question newQuestion) {
			try {
				System.out.println(newQuestion.getId());
				questionRepository.saveAndFlush(newQuestion);
				return "Update success";
			} catch (Exception e) {
				return "fail";
			}
	}

	@Override
	public List<Question> searchByContent(String contentSearch, Pageable pageable) {
		try {
			return questionRepository.findByContentContaining(contentSearch, pageable);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Question> pageQuestion(Pageable pageable) {
		try {
			return questionRepository.pageQuestion(pageable);
		} catch (Exception e) {
			return null;
		}
	}


	/* (non-Javadoc)
	 * @see com.cmcglobal.service.QuestionServices#countQuestion()
	 */
	@Override
	public String countQuestion() {
		try {
			return questionRepository.questionSum();
		} catch (Exception e) {
			return "fail";
		}
	}

	/* (non-Javadoc)
	 * @see com.cmcglobal.service.QuestionServices#filterByTestString(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Date, java.lang.String, org.springframework.data.domain.Pageable)
	 */
	@Override
	public List<Question> filterByAttribute(String categoryName, String levelName, String typeName, String fullName,
	         String tagName, Pageable pageable) {
		try {
			return questionRepository.filterByAttribute(categoryName, levelName, typeName, fullName, tagName, pageable);
		} catch (Exception e) {
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.cmcglobal.service.QuestionServices#filterByAll(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Date, java.lang.String, org.springframework.data.domain.Pageable)
	 */
	@Override
	public List<Question> filterByAll(String categoryName, String levelName, String typeName, String fullName,
	        java.util.Date dateCreated, String tagName, Pageable pageable) {
		
		try {
			return questionRepository.filterByAll(categoryName,
					levelName, typeName, fullName, dateCreated, tagName, pageable);
		} catch (Exception e) {
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.cmcglobal.service.QuestionServices#countSearchQuestion(java.lang.String)
	 */
	@Override
	public String countSearchQuestion(String content) {
		try {
			content = "%" + content + "%" ;
			return questionRepository.countSearchQuestion(content);
		} catch (Exception e) {
			return null;
		}
	}


}
