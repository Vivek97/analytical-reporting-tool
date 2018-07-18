package com.himanshu.art.entity;

import javax.persistence.*;

@Entity
@Table(name = "project_tb")
public class projectDetail {
	@Id
	@Column(name = "project_id")
	private int project_id;
	@Column(name = "pro_name")
	private String pro_name;

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	// @OneToMany(mappedBy="projectDetail")
	// public List <TestingResult> Tstlist= new ArrayList<TestingResult>();

}
