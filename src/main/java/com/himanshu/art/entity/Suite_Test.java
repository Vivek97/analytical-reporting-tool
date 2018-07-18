package com.himanshu.art.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Suite_Test")
public class Suite_Test {
	
	
	
	private int suite_id;
	@Id
	private int test_id;
	
	public int getSuite_id() {
		return suite_id;
	}
	
	public void setSuite_id(int suite_id) {
		this.suite_id = suite_id;
	}
	
	public int getTest_id() {
		return test_id;
	}
	
	public void setTest_id(int test_id) {
		this.test_id = test_id;
	}

}
