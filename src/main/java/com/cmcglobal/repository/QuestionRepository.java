package com.cmcglobal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmcglobal.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, String> {
	List<Question>  findByContentContaining(String contentSearch);
}
