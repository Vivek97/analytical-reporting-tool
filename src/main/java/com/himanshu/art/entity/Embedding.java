package com.himanshu.art.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "embedding_tb")
public class Embedding {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "embedding_id")
	private int id;

	@Column(name= " embedding_mime_type ")
	private String mime_type;

	@Column(name= " embedding_data ")
	private String data;

	public String getMime_type() {
		return mime_type;
	}

	public void setMime_type(String mime_type) {
		this.mime_type = mime_type;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
