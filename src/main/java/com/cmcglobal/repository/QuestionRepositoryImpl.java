/**
 * Create by: User - CMC
 * Create date: Feb 23, 2019
 * Modifier: User
 * Modified date: Feb 23, 2019
 * Description: ....
 * Version 1.0
 */
package com.cmcglobal.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.cmcglobal.entity.Question;

/**
 * Create by: thanhtd - CMC Create date: Feb 23, 2019 Modifier: thanhtd Modified
 * date: Feb 23, 2019 Description: .... Version 1.0
 */
public class QuestionRepositoryImpl implements QuestionRepository {
	
	@Autowired
	EntityManager entityManager;
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.data.jpa.repository.JpaRepository#findAll()
	 */
	@Override
	public List<Question> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.data.jpa.repository.JpaRepository#findAll(org.
	 * springframework.data.domain.Sort)
	 */
	@Override
	public List<Question> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.data.jpa.repository.JpaRepository#findAllById(java.lang.
	 * Iterable)
	 */
	@Override
	public List<Question> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.data.jpa.repository.JpaRepository#saveAll(java.lang.
	 * Iterable)
	 */
	@Override
	public <S extends Question> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.data.jpa.repository.JpaRepository#flush()
	 */
	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.data.jpa.repository.JpaRepository#saveAndFlush(java.lang.
	 * Object)
	 */
	@Override
	public <S extends Question> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.data.jpa.repository.JpaRepository#deleteInBatch(java.lang
	 * .Iterable)
	 */
	@Override
	public void deleteInBatch(Iterable<Question> entities) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.data.jpa.repository.JpaRepository#deleteAllInBatch()
	 */
	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.data.jpa.repository.JpaRepository#getOne(java.lang.
	 * Object)
	 */
	@Override
	public Question getOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.data.jpa.repository.JpaRepository#findAll(org.
	 * springframework.data.domain.Example)
	 */
	@Override
	public <S extends Question> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.data.jpa.repository.JpaRepository#findAll(org.
	 * springframework.data.domain.Example, org.springframework.data.domain.Sort)
	 */
	@Override
	public <S extends Question> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.data.repository.PagingAndSortingRepository#findAll(org.
	 * springframework.data.domain.Pageable)
	 */
	@Override
	public Page<Question> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.data.repository.CrudRepository#save(java.lang.Object)
	 */
	@Override
	public <S extends Question> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.data.repository.CrudRepository#findById(java.lang.Object)
	 */
	@Override
	public Optional<Question> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.data.repository.CrudRepository#existsById(java.lang.
	 * Object)
	 */
	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.data.repository.CrudRepository#count()
	 */
	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.data.repository.CrudRepository#deleteById(java.lang.
	 * Object)
	 */
	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.data.repository.CrudRepository#delete(java.lang.Object)
	 */
	@Override
	public void delete(Question entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.data.repository.CrudRepository#deleteAll(java.lang.
	 * Iterable)
	 */
	@Override
	public void deleteAll(Iterable<? extends Question> entities) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.data.repository.CrudRepository#deleteAll()
	 */
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.data.repository.query.QueryByExampleExecutor#findOne(org.
	 * springframework.data.domain.Example)
	 */
	@Override
	public <S extends Question> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.data.repository.query.QueryByExampleExecutor#findAll(org.
	 * springframework.data.domain.Example,
	 * org.springframework.data.domain.Pageable)
	 */
	@Override
	public <S extends Question> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.data.repository.query.QueryByExampleExecutor#count(org.
	 * springframework.data.domain.Example)
	 */
	@Override
	public <S extends Question> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.data.repository.query.QueryByExampleExecutor#exists(org.
	 * springframework.data.domain.Example)
	 */
	@Override
	public <S extends Question> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cmcglobal.repository.QuestionRepository#findByContentContaining(java.lang
	 * .String, org.springframework.data.domain.Pageable)
	 */
	@Override
	public List<Question> findByContentContaining(String contentSearch, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cmcglobal.repository.QuestionRepository#filterByAttribute(java.lang.
	 * String, java.lang.String, java.lang.String, java.lang.String, java.util.Date,
	 * java.lang.String, org.springframework.data.domain.Pageable)
	 */
	@Override
	public List<Question> filterByAttribute(String categoryName, String levelName, String typeName, String fullName,
	        Date dateCreated, String tagName, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cmcglobal.repository.QuestionRepository#filterByAll(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.util.Date,
	 * java.lang.String, org.springframework.data.domain.Pageable)
	 */
	@Override
	public List<Question> filterByAll(String categoryName, String levelName, String typeName, String fullName,
	        Date dateCreated, String tagName, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cmcglobal.repository.QuestionRepository#pageQuestion(org.springframework.
	 * data.domain.Pageable)
	 */
	@Override
	public List<Question> pageQuestion(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cmcglobal.repository.QuestionRepository#questionSum()
	 */
	@Override
	public String questionSum() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cmcglobal.repository.QuestionRepository#countSearchQuestion(java.lang.
	 * String)
	 */
	@Override
	public String countSearchQuestion(String content) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cmcglobal.repository.QuestionRepository#filterQuestion(java.lang.String,
	 * java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Override
	public List<Question> filterQuestion(String userName, Date dateCreated, Integer tagId, Integer levelId,
	        Integer categoryId, Integer typeId, Pageable pageable) {			
		int check = 0;
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("select q from " + Question.class.getName() + " q ");
		if (userName != null) {
			stringBuffer.append(" where q.userQuestion.fullName like '%" + userName + "%'");
			check++;
		}
		if (dateCreated != null) {
			if (check == 0) {
				stringBuffer.append(" where q.dateCreated like '%" + dateCreated + "%'");
				check++;
			} else {
				stringBuffer.append(" and q.dateCreated like '%" + dateCreated + "%'");
			}
		}
		if (tagId != null) {
			if (check == 0) {
				stringBuffer.append(" where q.questionTag.id =" + tagId);
				check++;
			} else {
				stringBuffer.append(" and q.questionTag.id =" + tagId);
			}
		}
		if (levelId != null) {
			if (check == 0) {
				stringBuffer.append(" where q.questionLevel.id =" + levelId);
				check++;
			} else {
				stringBuffer.append(" and q.questionLevel.id =" + levelId);
			}
		}
		if (categoryId != null) {
			if (check == 0) {
				stringBuffer.append(" where q.categoryId.id =" + categoryId);
				check++;
			} else {
				stringBuffer.append(" and q.categoryId.id =" + categoryId);
			}
		}
		if (typeId != null) {
			if (check == 0) {
				stringBuffer.append(" where q.questionType.id =" + typeId);
				check++;
			} else {
				stringBuffer.append(" and q.questionType.id =" + typeId);
			}
		}
		String sql = stringBuffer.toString();
		System.out.println(sql);	
		Query query = entityManager.createQuery(sql, Question.class);
		return query.getResultList();
	}

}
