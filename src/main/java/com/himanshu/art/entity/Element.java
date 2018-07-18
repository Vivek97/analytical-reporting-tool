package com.himanshu.art.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "element_tb")
public class Element {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int element_id;

	@Column(name = " element_description ")
	private String description;

	@Column(name = " element_keyword ")
	private String keyword;

	@Column(name = " element_name ")
	private String name;

	@Column(name = " element_line ")
	private Long line;

	private String type;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Element_Steps", joinColumns = { @JoinColumn(name = "element_id") }, inverseJoinColumns = { @JoinColumn(name = "step_id") })
	private List<Step> stepList = new ArrayList<Step>();

	public int getElement_id() {
		return element_id;
	}

	public void setElement_id(int i) {
		this.element_id = i;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getLine() {
		return line;
	}

	public void setLine(Long line) {
		this.line = line;
	}

	public List<Step> getStepList() {
		return stepList;
	}

	public void setStepList(Step step) {
		this.stepList.add(step);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
