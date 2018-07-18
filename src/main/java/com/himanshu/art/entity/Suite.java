package com.himanshu.art.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "suite_tb")
public class Suite {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "id")
	private int suite_id;
	
	@Column(name = "suite_name")
	private String name;
	
	@Column(name = "suite_duration")
	private long duration_ms;

	@Column(name = "suite_started")
	private Timestamp started_at;

	@Column(name = "suite_finished")
	private Timestamp finished_at;

	public int getSuite_id() {
		return suite_id;
	}

	public void setSuite_id(int suite_id) {
		this.suite_id = suite_id;
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

	public List<Test> getTestlist() {
		return Testlist;
	}

	public void setTestlist(List<Test> testlist) {
		Testlist = testlist;
	}

	// public String groups;
	// @OneToMany(mappedBy="suite_tb")
	// public List<Groups> groupList = new ArrayList<Groups>();
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "suite_test", joinColumns = { @JoinColumn(name = "suite_id") }, inverseJoinColumns = { @JoinColumn(name = "test_id") })
	private List<Test> Testlist;

}
