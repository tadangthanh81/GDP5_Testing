package com.cmcglobal.entity;

import java.util.ArrayList;
import java.util.List;
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
@Table(name="question_type", schema = "TESTING_SYSTEM_DATABASE")
public class QuestionType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "type_id", nullable = false)
	private int id;
	
	@Column(name = "type_name")
	private String typeName;
	
	@Column(name = "status")
	private int status;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "questionType")
	@JsonBackReference
	private Set<Question> questionTy;

	public QuestionType(int id, String typeName, int status, Set<Question> questionTy) {
		super();
		this.id = id;
		this.typeName = typeName;
		this.status = status;
		this.questionTy = questionTy;
	}

	public QuestionType() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Set<Question> getQuestionTy() {
		return questionTy;
	}

	public void setQuestionTy(Set<Question> questionTy) {
		this.questionTy = questionTy;
	}
	
	
}
