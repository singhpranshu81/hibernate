package com.mph.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="emply")
@NamedQueries({
	@NamedQuery(name="GET_EMP_BY_ID",query="from Emplyee e where e.eid= :id"),
	@NamedQuery(name="GET_EMP_BY_DID",query="from Emplyee e where e.did= :ed")
	
	
})
public class Emplyee {
	@Id
	private int eid;
	@Embedded
	private Name ename;
	private String email;
	private String password;
	private String gender;
	
	
	@OneToOne
	@JoinColumn(name="DeptID")
	private Department did;
	
	@OneToMany(mappedBy = "emp", cascade = CascadeType.ALL )
	private List<Address> address;
	public Emplyee() {
		super();
	}
	
	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
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
	
	public Name getEname() {
		return ename;
	}

	public void setEname(Name ename) {
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
