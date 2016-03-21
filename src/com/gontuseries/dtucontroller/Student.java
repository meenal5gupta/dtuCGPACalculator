package com.gontuseries.dtucontroller;

import com.sun.istack.internal.NotNull;
import org.hibernate.validator.constraints.Length;

import org.hibernate.validator.constraints.Range;



public class Student {
	private String studentName;
	private String branch;
	private double aggregate;
	
	
	private int dr;
	
	
	private String username;
	
	@NotNull 
	private String password;
	
	
	public int getDr() {
		return dr;
	}
	public void setDr(int dr) {
		this.dr = dr;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Student(String studentName, String branch, double aggregate, int dr, String username, String password) {
		super();
		this.studentName = studentName;
		this.branch = branch;
		this.aggregate = aggregate;
		this.dr = dr;
		this.username = username;
		this.password = password;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public double getAggregate() {
		return aggregate;
	}
	public void setAggregate(double aggregate) {
		this.aggregate = aggregate;
	}

}
