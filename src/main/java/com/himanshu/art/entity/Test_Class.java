package com.himanshu.art.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Test_Class {

private int Test_id;
@Id
private int Class_id;
public int getTest_id() {
	return Test_id;
}
public void setTest_id(int test_id) {
	Test_id = test_id;
}
public int getClass_id() {
	return Class_id;
}
public void setClass_id(int class_id) {
	Class_id = class_id;
}
}
