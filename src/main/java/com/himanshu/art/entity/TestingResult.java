package com.himanshu.art.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "test_results_tb")
public class TestingResult {

	@Id
	@GeneratedValue
	@Column(name = "tst_res_id")
	private int tst_res_id;
	// String Reporter_output;
	@Column(name = "test_result_skip")
	private int skipped;
	@Column(name = "test_result_fail")
	private int failed;
	@Column(name = "test_result_total")
	private int total;

	public int getTst_res_id() {
		return tst_res_id;
	}

	public void setTst_res_id(int tst_res_id) {
		this.tst_res_id = tst_res_id;
	}

	public int getSkipped() {
		return skipped;
	}

	public void setSkipped(int skipped) {
		this.skipped = skipped;
	}

	public int getFailed() {
		return failed;
	}

	public void setFailed(int failed) {
		this.failed = failed;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPassed() {
		return passed;
	}

	public void setPassed(int passed) {
		this.passed = passed;
	}

	public List<Suite> getSuiteList() {
		return suiteList;
	}

	public void setSuiteList(List<Suite> suiteList) {
		this.suiteList = suiteList;
	}

	public projectDetail getPro() {
		return pro;
	}

	public void setPro(projectDetail pro) {
		this.pro = pro;
	}

	@Column(name = "test_result_pass")
	private int passed;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "testResult_suite", joinColumns = { @JoinColumn(name = "tst_res_id") }, inverseJoinColumns = { @JoinColumn(name = "suite_id") })
	private List<Suite> suiteList = new ArrayList<Suite>();

	@ManyToOne
	@JoinColumn(name = "project_id")
	private projectDetail pro;

}
