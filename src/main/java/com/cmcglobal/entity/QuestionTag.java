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
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="tag", schema = "TESTING_SYSTEM_DATABASE")
public class QuestionTag {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tag_id", nullable = false)
	private int id;
	
	@Column(name = "tag_name")
	private String tagName;
	
	@Column(name = "status")
	private int status;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "questionTag")
	@JsonBackReference
	private Set<Question> questionT;

	public QuestionTag(int id, String tagName, int status, Set<Question> questionT) {
		super();
		this.id = id;
		this.tagName = tagName;
		this.status = status;
		this.questionT = questionT;
	}

	public QuestionTag() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Set<Question> getQuestionT() {
		return questionT;
	}

	public void setQuestionT(Set<Question> questionT) {
		this.questionT = questionT;
	}

	

}
