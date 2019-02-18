package com.cmcglobal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "question_type", schema = "TESTING_SYSTEM_DATABASE")
public class QuestionType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "type_id", nullable = false)
	private int id;

	@Column(name = "type_name")
	private String typeName;

	@Column(name = "status")
	private int status;
	
//	@OneToMany(mappedBy = "questionType", fetch = FetchType.EAGER,cascade = CascadeType.DETACH)
//    @JsonBackReference
//    private List<Question> questionTs;

	public QuestionType(int id, String typeName, int status) {
		super();
		this.id = id;
		this.typeName = typeName;
		this.status = status;
	}
	
	public QuestionType() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
