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

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="user", schema = "TESTING_SYSTEM_DATABASE")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id", nullable = false)
	private  int id;
	
	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "mobile")
	private String mobile;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "status")
	private int status;
	
//	@OneToMany(cascade = CascadeType.ALL,mappedBy = "userQuestion")
//	@JsonManagedReference
//	private Set<Question> userQ;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "userQuestion")
	private Set<Question> userQ;
	
//	@OneToMany(cascade = CascadeType.ALL,mappedBy = "userCategory")
//	@JsonManagedReference
//	private Set<QuestionCategory> userC;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "userCategory")
	private Set<QuestionCategory> userC;

	public User() {
		super();
	}

	public User(int id, String fullName, String email, String mobile, String password, int status, Set<Question> userQ,
			Set<QuestionCategory> userC) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.status = status;
		this.userQ = userQ;
		this.userC = userC;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Set<Question> getUserQ() {
		return userQ;
	}

	public void setUserQ(Set<Question> userQ) {
		this.userQ = userQ;
	}

	public Set<QuestionCategory> getUserC() {
		return userC;
	}

	public void setUserC(Set<QuestionCategory> userC) {
		this.userC = userC;
	}
	
	
	
}
