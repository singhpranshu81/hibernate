package com.mph.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="emply")
public class Emplyee {
	@Id
	private int eid;
	private String ename;
	private String email;
	private String password;
	private String gender;
	
	
	@OneToOne
	@JoinColumn(name="DeptID")
	private Department did;
	public Emplyee() {
		super();
	}
	public Department getDid() {
		return did;
	}
	public void setDid(Department did) {
		this.did = did;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Emplyee [eid=" + eid + ", ename=" + ename + ", email=" + email + ", password=" + password + ", gender="
				+ gender + "]";
	}
	
}
