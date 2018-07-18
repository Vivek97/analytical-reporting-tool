package com.himanshu.art.entity;

import javax.persistence.*;

@Entity
@Table(name = "result_tb")
public class Result {

	@Column(name = "result_duration ")
	private Long duration;

	@Column(name = "result_status ")
	private String status;

	@Column(name = "result_error_message ")
	private String error_message;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "result_id")
	private int id;
	
	public String getError_message() {
		return error_message;
	}

	public void setError_message(String error_message) {
		this.error_message = error_message;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
