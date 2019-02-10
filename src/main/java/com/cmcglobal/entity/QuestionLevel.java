package com.cmcglobal.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="question_level", schema = "TESTING_SYSTEM_DATABASE")
public class QuestionLevel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "level_id", nullable = false)
	private int id;
	
	@Column(name = "level_name")
	private String levelName;
	
	@Column(name = "status")
	private int status;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "questionLevel")
	@JsonBackReference
	private Set<Question> questionL;


	public QuestionLevel(int id, String levelName, int status, Set<Question> questionL) {
		super();
		this.id = id;
		this.levelName = levelName;
		this.status = status;
		this.questionL = questionL;
	}


	public QuestionLevel() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLevelName() {
		return levelName;
	}


	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public Set<Question> getQuestionL() {
		return questionL;
	}


	public void setQuestionL(Set<Question> questionL) {
		this.questionL = questionL;
	}

}
