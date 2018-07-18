package com.himanshu.art.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "method_tb")
public class TestMethod {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int method_id;
	@Column(name = "method_status")
	private String status;
	@Column(name = "method_signature")
	private String signature;
	@Column(name = "method_name")
	private String name;
	@Column(name = "method_duration")
	private long duration_ms;

	@Column(name = "method_started")
	private Timestamp started_at;

	@Column(name = "method_finished")
	private Timestamp finished_at;

	// public String report_output;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "testMethod_exception", joinColumns = { @JoinColumn(name = "method_id") }, inverseJoinColumns = { @JoinColumn(name = "exception_id") })
	private List<MyException> exceptionList = new ArrayList<MyException>();

	public int getMethod_id() {
		return method_id;
	}

	public void setMethod_id(int method_id) {
		this.method_id = method_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getDuration_ms() {
		return duration_ms;
	}

	public void setDuration_ms(long duration_ms) {
		this.duration_ms = duration_ms;
	}


	public Timestamp getStarted_at() {
		return started_at;
	}

	public void setStarted_at(Timestamp started_at) {
		this.started_at = started_at;
	}

	public Timestamp getFinished_at() {
		return finished_at;
	}

	public void setFinished_at(Timestamp finished_at) {
		this.finished_at = finished_at;
	}

	public List<MyException> getExceptionList() {
		return exceptionList;
	}

	public void setExceptionList(List<MyException> exceptionList) {
		this.exceptionList = exceptionList;
	}

	
	
}
