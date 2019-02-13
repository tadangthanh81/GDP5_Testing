package com.cmcglobal.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tag", schema = "TESTING_SYSTEM_DATABASE")
public class QuestionTag {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tag_id", nullable = false)
	private int id;

	@Column(name = "tag_name")
	private String tagName;

	@Column(name = "status")
	private int status;
	
//	 @OneToMany(mappedBy = "questionTag", fetch = FetchType.EAGER,cascade = CascadeType.DETACH)
//     @JsonBackReference
//     private List<Question> questionT;

	public QuestionTag(int id, String tagName, int status) {
		super();
		this.id = id;
		this.tagName = tagName;
		this.status = status;
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
}
