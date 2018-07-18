package com.himanshu.art.entity;

import javax.persistence.*;

@Entity
@Table(name = "arguments_tb")
public class Arguments {

	@Column(name = "arguments_val")
	private String val;

	@Column(name = "arguments_offset")
	private Long offset;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "arguments_id")
	private int id;

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	public Long getOffset() {
		return offset;
	}

	public void setOffset(Long offset) {
		this.offset = offset;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
