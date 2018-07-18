package com.himanshu.art.entity;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "test_tb")
public class Test {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "test_id")
	private int test_id;

	
	public int getTest_id() {
		return test_id;
	}

	public void setTest_id(int test_id) {
		this.test_id = test_id;
	}

	public void setClsList(List<MyClass> clsList) {
		this.clsList = clsList;
	}

	@Column(name = "test_finished")
	private Timestamp finished_at;

	@Column(name = "test_started")
	private Timestamp started_at;
	@Column(name = "test_duration")
	private long duration;
	@Column(name = "test_name")
	private String name;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "test_class", joinColumns = { @JoinColumn(name = "test_id") }, inverseJoinColumns = { @JoinColumn(name = "class_id") })
	private List<MyClass> clsList = new ArrayList<MyClass>();

	/*
	 * @Override public String toString() { return "Test [name=" + name +
	 * ", duration_ms=" + duration_ms + ", started_at=" + started_at +
	 * ", finished_at=" + finished_at + ", class=" + cls + "]"; }
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MyClass> getClsList() {
		return clsList;
	}

	
	public Timestamp getFinished_at() {
		return finished_at;
	}

	public void setFinished_at(Timestamp finished_at) {
		this.finished_at = finished_at;
	}

	public Timestamp getStarted_at() {
		return started_at;
	}

	public void setStarted_at(Timestamp started_at) {
		this.started_at = started_at;
	}

	public long getDuration_ms() {
		return duration;
	}

	public void setDuration_ms(long duration_ms) {
		this.duration = duration_ms;
	}
	
}