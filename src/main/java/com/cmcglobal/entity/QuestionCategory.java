package com.cmcglobal.entity;

import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="category", schema = "TESTING_SYSTEM_DATABASE")
public class QuestionCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "category_id", nullable = false)
	private  int id;
	
	@Column(name = "category_name")
	private  String categoryName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_created")
	private  Date date_Create;
	
	@Column(name = "status")
	private  int status;
	
//	@OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
//	@JsonBackReference
//	private Set<Question> questions;

	@ManyToOne(cascade=CascadeType.DETACH,fetch=FetchType.EAGER)
	@JoinColumn(name = "user_id_created")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonManagedReference
	User userCategory;

//	public QuestionCategory(int id, String categoryName, Date date_created, int status, Set<Question> questions,
//			User userCategory) {
//		super();
//		this.id = id;
//		this.categoryName = categoryName;
//		this.date_created = date_created;
//		this.status = status;
//		this.questions = questions;
//		this.userCategory = userCategory;
//	}

	public QuestionCategory() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Date getDate_created() {
		return date_Create;
	}

	public void setDate_created(Date date_created) {
		this.date_Create = date_created;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

//	public Set<Question> getQuestions() {
//		return questions;
//	}
//
//	public void setQuestions(Set<Question> questions) {
//		this.questions = questions;
//	}

	public User getUserCategory() {
		return userCategory;
	}

	public void setUserCategory(User userCategory) {
		this.userCategory = userCategory;
	}

	
}
