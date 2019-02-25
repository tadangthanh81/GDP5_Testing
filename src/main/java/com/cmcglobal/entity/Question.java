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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "question", schema = "TESTING_SYSTEM_DATABASE")
public class Question {
	@Id
	@Column(name = "question_id", unique = true, nullable = false)
	private String questionId;

	@Column(name = "content")
	private String content;

	@Column(name = "sugguestion")
	private String sugguestion;

	@Column(name = "status")
	private int status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_created")
	private Date dateCreated;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	@JsonIgnoreProperties("categorys")
	Category category;


	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "type_id")
	QuestionType questionType;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "level_id")
	QuestionLevel questionLevel;

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "tag_id")
	QuestionTag questionTag;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id_created")
	User userQuestion;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "question_id")
	@JsonIgnoreProperties("answerQ")
	private List<Answer> questionAnswer;

	public Question(String questionId, String content, String sugguestion, int status, Date dateCreated,
	        Category questionCategory, QuestionType questionType, QuestionLevel questionLevel, QuestionTag questionTag,
	        User userQuestion, List<Answer> questionAnswer) {

		super();
		this.questionId = questionId;
		this.content = content;
		this.sugguestion = sugguestion;
		this.status = status;
		this.dateCreated = dateCreated;
		this.category = questionCategory;
		this.questionType = questionType;
		this.questionLevel = questionLevel;
		this.questionTag = questionTag;
		this.userQuestion = userQuestion;
		this.questionAnswer = questionAnswer;
	}

	public Question() {
		super();
	}

	/**
	 * @return the questionId
	 */
	public String getQuestionId() {
		return questionId;
	}

	/**
	 * @param questionId the questionId to set
	 */
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getContent() {
		return content;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Question [id=" + questionId + ", content=" + content + ", sugguestion=" + sugguestion + ", status=" + status
		        + ", dateCreated=" + dateCreated + ", questionCategory=" + category + ", questionType=" + questionType
		        + ", questionLevel=" + questionLevel + ", questionTag=" + questionTag + ", userQuestion=" + userQuestion
		        + ", questionAnswer=" + questionAnswer + "]";
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

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;

	}


	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;

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
