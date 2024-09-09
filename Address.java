package com.mph.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Address {
	@Id
  public long addrId;
  public int doorNo;
  public String street;
  public String city;
  @Column(name="zipcode")
  public int pincode;
  
  @ManyToOne
  @JoinColumn(name="eid", referencedColumnName="EID")
  public Emplyee emp;
public Address() {
	super();
	// TODO Auto-generated constructor stub
}

public Emplyee getEmp() {
	return emp;
}

public void setEmp(Emplyee emp) {
	this.emp = emp;
}

public long getAddrId() {
	return addrId;
}
public void setAddrId(long addrId) {
	this.addrId = addrId;
}
public int getDoorNo() {
	return doorNo;
}
public void setDoorNo(int doorNo) {
	this.doorNo = doorNo;
}
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public int getPincode() {
	return pincode;
}
public void setPincode(int pincode) {
	this.pincode = pincode;
}
@Override
public String toString() {
	return "Address [addrId=" + addrId + ", doorNo=" + doorNo + ", street=" + street + ", city=" + city + ", pincode="
			+ pincode + ", getAddrId()=" + getAddrId() + ", getDoorNo()=" + getDoorNo() + ", getStreet()=" + getStreet()
			+ ", getCity()=" + getCity() + ", getPincode()=" + getPincode() + ", getClass()=" + getClass()
			+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}
  
  
}
