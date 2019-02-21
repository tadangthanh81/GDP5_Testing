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

@Entity
@Table(name = "question", schema = "TESTING_SYSTEM_DATABASE")
public class Question {
	@Id
	@Column(name = "question_id", unique = true, nullable = false)
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

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	QuestionCategory questionCategory;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "type_id")
	Type questionType;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "level_id")
	QuestionLevel questionLevel;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "tag_id")
	QuestionTag questionTag;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id_created")
	User userQuestion;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "question_id")
	private List<Answer> questionAnswer;

	public Question(String id, String content, String sugguestion, int status, Date dateCreated,
	        QuestionCategory questionCategory, Type questionType, QuestionLevel questionLevel, QuestionTag questionTag,
	        User userQuestion, List<Answer> questionAnswer) {
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Question [id=" + id + ", content=" + content + ", sugguestion=" + sugguestion + ", status=" + status
		        + ", dateCreated=" + dateCreated + ", questionCategory=" + questionCategory + ", questionType="
		        + questionType + ", questionLevel=" + questionLevel + ", questionTag=" + questionTag + ", userQuestion="
		        + userQuestion + ", questionAnswer=" + questionAnswer + "]";
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

	public Type getQuestionType() {
		return questionType;
	}

	public void setQuestionType(Type questionType) {
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
