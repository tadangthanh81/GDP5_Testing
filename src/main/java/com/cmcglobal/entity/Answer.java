package com.cmcglobal.entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="answer", schema = "TESTING_SYSTEM_DATABASE")

public class Answer {

	@Id
	@Column(name = "answer_id", nullable = false, unique=true)
	private  String answerId;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "is_true")
	private int isTrue;
	
	@Column(name = "status")
	private int status;
	
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "question_id")
	@JsonIgnoreProperties("questionAnswer")
	Question answerQ;
	
	public Answer(String answerId, String content, int isTrue, int status, Question answerQ) {
		super();
		this.answerId = answerId;
		this.content = content;
		this.isTrue = isTrue;
		this.status = status;
		this.answerQ = answerQ;
	}

	public Answer() {
		super();
	}

	/**
	 * @return the answerId
	 */
	public String getAnswerId() {
		return answerId;
	}

	/**
	 * @param answerId the answerId to set
	 */
	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getIsTrue() {
		return isTrue;
	}

	public void setIsTrue(int isTrue) {
		this.isTrue = isTrue;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Question getAnswerQ() {
		return answerQ;
	}

	public void setAnswerQ(Question answerQ) {
		this.answerQ = answerQ;
	}
	
	
	
}
