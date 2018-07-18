package com.himanshu.art.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Class_Testmethod {

private int class_id;
@Id
private int method_id;
public int getClass_id() {
	return class_id;
}
public void setClass_id(int class_id) {
	this.class_id = class_id;
}
public int getMethod_id() {
	return method_id;
}
public void setMethod_id(int method_id) {
	this.method_id = method_id;
}

}
