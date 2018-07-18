package com.himanshu.art.entity;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.*;

@Entity
@Table(name = "feature_tb")
public class Feature {

	@Id
	private String feature_id;

	@Column(name = " feature_description ")
	private String description;

	@Column(name = " feature_keyword ")
	private String keyword;

	@Column(name = " feature_name ")
	private String name;

	@Column(name = " feature_line ")
	private Long line;

	private String uri;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Feature_Elements", joinColumns = { @JoinColumn(name = "feature_id") }, inverseJoinColumns = { @JoinColumn(name = "element_id") })
	private List<Element> elementList = new ArrayList<Element>();

	public String getFeature_id() {
		return feature_id;
	}

	public void setFeature_id(String feature_id) {
		this.feature_id = feature_id;
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

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public List<Element> getElementList() {
		return elementList;
	}

	public void setElementList(Element element) {
		this.elementList.add(element);
	}

	/*
	 * @Override public String toString() { return "Feature [feature_id=" +
	 * feature_id + ", description=" + description + ", keyword=" + keyword +
	 * ", name=" + name + ", line=" + line + ", uri=" + uri + ", elementList=" +
	 * elementList + "]"; }
	 */

}
