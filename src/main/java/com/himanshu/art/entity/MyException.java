package com.himanshu.art.entity;

import javax.persistence.*;

@Entity
@Table(name="Exception_tb")
public class MyException {
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	   @Column(name = "id")
	private int exception_id;
	@Column(name="exception_class")
	private String cls;
    @Column(name="exception_message")
    @Lob
   	private String message;
    @Column(name="exception_full_stacktrace")
    @Lob
	private String full_stacktrace;
   
	public int getException_id() {
		return exception_id;
	}
	public void setException_id(int exception_id) {
		this.exception_id = exception_id;
	}
	public String getCls() {
		return cls;
	}
	public void setCls(String cls) {
		this.cls = cls;
	}
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getFull_stacktrace() {
		return full_stacktrace;
	}
	public void setFull_stacktrace(String full_stacktrace) {
		this.full_stacktrace = full_stacktrace;
	}
	
	
	
}
