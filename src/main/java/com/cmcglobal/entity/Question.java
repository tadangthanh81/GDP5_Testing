package com.cmcglobal.entity;

import java.sql.Date;
import java.util.ArrayList;
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
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name="question", schema = "TESTING_SYSTEM_DATABASE")
public class Question {
	@Id
	@Column(name = "question_id",  unique = true, nullable = false)
	private String id;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "suggestion")
	private String suggestion;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "date_created")
	private Date dateCreated;
	
	@ManyToOne(cascade=CascadeType.DETACH,fetch=FetchType.EAGER)
	@JoinColumn(name = "category_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	QuestionCategory questionCategory;
	
	@ManyToOne(cascade=CascadeType.DETACH,fetch=FetchType.EAGER)
	@JoinColumn(name = "type_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	QuestionType questionType;
	
	@ManyToOne(cascade=CascadeType.DETACH,fetch=FetchType.EAGER)
	@JoinColumn(name = "level_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	QuestionLevel questionLevel;
	
	@ManyToOne(cascade=CascadeType.DETACH,fetch=FetchType.EAGER)
	@JoinColumn(name = "questionTag")
	@OnDelete(action = OnDeleteAction.CASCADE)
	QuestionTag questionTag;
	
	@ManyToOne(cascade=CascadeType.DETACH,fetch=FetchType.EAGER)
	@JoinColumn(name = "user_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	User userQuestion;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "question")
	private List<Answer> questionAnswer = new ArrayList<>();

	public Question(String id, String content, String suggestion, int status, Date dateCreated,
			QuestionCategory questionCategory, QuestionType questionType, QuestionLevel questionLevel,
			QuestionTag questionTag, User userQuestion, List<Answer> questionAnswer) {
		super();
		this.id = id;
		this.content = content;
		this.suggestion = suggestion;
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

	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
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

	@Override
	public String toString() {
		return "Question [id=" + id + ", content=" + content + ", suggestion=" + suggestion + ", status=" + status
				+ ", dateCreated=" + dateCreated + ", questionCategory=" + questionCategory + ", questionType="
				+ questionType + ", questionLevel=" + questionLevel + ", questionTag=" + questionTag + ", userQuestion="
				+ userQuestion + ", questionAnswer=" + questionAnswer + "]";
	}
	
}
