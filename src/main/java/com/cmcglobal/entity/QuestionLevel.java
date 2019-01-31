package com.cmcglobal.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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


	public QuestionLevel() {
		super();
	}
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "questionLevel")
	private List<Question> questions = new ArrayList<>();


	public QuestionLevel(int id, String levelName, int status, List<Question> questions) {
		super();
		this.id = id;
		this.levelName = levelName;
		this.status = status;
		this.questions = questions;
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


	public List<Question> getQuestions() {
		return questions;
	}


	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
}
