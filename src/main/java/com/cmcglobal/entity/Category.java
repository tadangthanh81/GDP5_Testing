package com.cmcglobal.entity;

import java.util.Date;
import java.util.List;

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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "category", schema = "TESTING_SYSTEM_DATABASE")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "category_id", nullable = false, unique = true)
	private int id;

	@Column(name = "category_name")
	private String categoryName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_created")
	private Date dateCreated;

	@Column(name = "status")
	private int status;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id_created")
	User userCategory;

	public Category(int id, String categoryName, Date dateCreated, int status, User userCategory) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.dateCreated = dateCreated;
		this.status = status;
		this.userCategory = userCategory;
	}

	public Category() {
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

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public User getUserCategory() {
		return userCategory;
	}

	public void setUserCategory(User userCategory) {
		this.userCategory = userCategory;
	}

}
