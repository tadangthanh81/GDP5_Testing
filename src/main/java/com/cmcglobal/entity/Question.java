package com.cmcglobal.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="question", schema = "TESTING_SYSTEM_DATABASE")
public class Question {
	@Id
	@Column(name = "question_id",  unique = true, nullable = false)
	private String id;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "sugguestion")
	private String sugguestion;
	
	@Column(name = "status")
	private int status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_created")
	private Date dateCreated;
	
	@ManyToOne(cascade=CascadeType.DETACH,fetch=FetchType.EAGER)
	@JoinColumn(name = "category_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonManagedReference
	QuestionCategory questionCategory;

	@ManyToOne(cascade=CascadeType.DETACH,fetch=FetchType.EAGER)
	@JoinColumn(name = "type_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonManagedReference
	QuestionType questionType;
	
//	@ManyToOne(cascade=CascadeType.DETACH,fetch=FetchType.EAGER)
//	@JoinColumn(name = "level_id")
//	@OnDelete(action = OnDeleteAction.CASCADE)
//	@JsonBackReference
//	QuestionLevel questionLevel;
	@ManyToOne(cascade=CascadeType.DETACH,fetch=FetchType.EAGER)
	@JoinColumn(name = "level_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonManagedReference
	QuestionLevel questionLevel;
	
	@ManyToOne(cascade=CascadeType.DETACH,fetch=FetchType.EAGER)
	@JoinColumn(name = "tag_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonManagedReference
	QuestionTag questionTag;
	

	@ManyToOne(cascade=CascadeType.DETACH,fetch=FetchType.EAGER)
	@JoinColumn(name = "user_id_created")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonManagedReference
	User userQuestion;
	
	
//	@OneToMany(cascade = CascadeType.ALL,mappedBy = "question")
//	@JsonManagedReference
//	private Set<Answer> questionAnswer;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "question")
	@JsonBackReference
	private List<Answer> questionAnswer;

	public Question(String id, String content, String sugguestion, int status, Date dateCreated,
		QuestionCategory questionCategory, QuestionType questionType, QuestionLevel questionLevel,
		QuestionTag questionTag, User userQuestion, List<Answer> questionAnswer) {
	super();
	this.id = id;
	this.content = content;
	this.sugguestion = sugguestion;
	this.status = status;
	this.dateCreated = dateCreated;
	this.questionCategory = questionCategory;
	this.questionType = questionType;
	this.questionLevel = questionLevel;
	this.questionTag = questionTag;
	this.userQuestion = userQuestion;
	this.questionAnswer = questionAnswer;
}

	public Question() {
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

	public String getSugguestion() {
		return sugguestion;
	}

	public void setSugguestion(String sugguestion) {
		this.sugguestion = sugguestion;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public QuestionCategory getQuestionCategory() {
		return questionCategory;
	}

	public void setQuestionCategory(QuestionCategory questionCategory) {
		this.questionCategory = questionCategory;
	}

	public QuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}

	public QuestionLevel getQuestionLevel() {
		return questionLevel;
	}

	public void setQuestionLevel(QuestionLevel questionLevel) {
		this.questionLevel = questionLevel;
	}

	public QuestionTag getQuestionTag() {
		return questionTag;
	}

	public void setQuestionTag(QuestionTag questionTag) {
		this.questionTag = questionTag;
	}

	public User getUserQuestion() {
		return userQuestion;
	}

	public void setUserQuestion(User userQuestion) {
		this.userQuestion = userQuestion;
	}

	public List<Answer> getQuestionAnswer() {
		return questionAnswer;
	}

	public void setQuestionAnswer(List<Answer> questionAnswer) {
		this.questionAnswer = questionAnswer;
	}



	
	
}
