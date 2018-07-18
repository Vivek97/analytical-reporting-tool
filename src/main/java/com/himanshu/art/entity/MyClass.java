package com.himanshu.art.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "class_tb")
public class MyClass {
	@Id
	@GeneratedValue
	@Column(name = "class_id")
	private int class_id;
	@Column(name = "Class_name")
	private String name;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "class_testMethod", joinColumns = { @JoinColumn(name = "class_id") }, inverseJoinColumns = { @JoinColumn(name = "method_id") })
	private List<TestMethod> testMethod = new ArrayList<TestMethod>();

	

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TestMethod> getTestMethod() {
		return testMethod;
	}

	public void setTestMethod(List<TestMethod> testMethod) {
		this.testMethod = testMethod;
	}

	

}
