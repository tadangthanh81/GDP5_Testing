package com.cmcglobal.entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="answer", schema = "TESTING_SYSTEM_DATABASE")
public class Answer {

	@Id
	@Column(name = "answer_id", nullable = false, unique=true)
	private  String id;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "is_true")
	private int isTrue;
	
	@Column(name = "status")
	private int status;
	
//	@ManyToOne(cascade=CascadeType.DETACH,fetch=FetchType.EAGER)
//	@JoinColumn(name = "question_id")
//	@OnDelete(action = OnDeleteAction.CASCADE)
//	@JsonBackReference
//	Question question;
//	@ManyToOne(cascade=CascadeType.DETACH,fetch=FetchType.EAGER)
//	@JoinColumn(name = "question_id")
//	@OnDelete(action = OnDeleteAction.CASCADE)
//	@JsonBackReference
//	Question question;


	public Answer(String id, String content, int isTrue, int status, Question question) {
		super();
		this.id = id;
		this.content = content;
		this.isTrue = isTrue;
		this.status = status;
		//this.question = question;
	}

	public Answer() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

//	public Question getQuestion() {
//		return question;
//	}
//
//	public void setQuestion(Question question) {
//		this.question = question;
//	}
}
