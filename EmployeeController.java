package com.mph.controller;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.mph.entity.Address;
import com.mph.entity.Department;
import com.mph.entity.Emplyee;
import com.mph.entity.Name;

public class EmployeeController {
  SessionFactory sf=new Configuration().configure().buildSessionFactory();
  Session session = sf.openSession();
  Transaction txn;
  Emplyee emp;
  Department d;
  Address ad;
  Scanner sc=new Scanner(System.in);
  public void addEmployee() {
	  txn=session.beginTransaction();
	  emp = new Emplyee();
	  System.out.println("enter id: ");
	  int id= sc.nextInt();
	  emp.setEid(id);  
	  System.out.println("enter email: ");
	  String e= sc.next();
	  emp.setEmail(e);
	  System.out.println("enter first name: ");
	  String fname= sc.next();
	  System.out.println("enter last name: ");
	  String lname= sc.next();
	  Name ename = new Name(fname,lname);
	  emp.setEname(ename);
	    System.out.println("enter gender: ");
	  String gender= sc.next();
	  emp.setGender(gender);
	
	  System.out.println("enter password: ");
	  String password= sc.next();
	  emp.setPassword(password);
	
	  
	  d=new Department();
	  System.out.println("enter Dept id: ");
	  int i=sc.nextInt();
	  d.setDid(i);
	  System.out.println("enter Dname: ");
	  String v=sc.next();
	  d.setDname(v);
	  
	  emp.setDid(d);//setting object department to employee
	  
	  ad=new Address();
	  
	  System.out.println("enter Address id: ");
	  ad.setAddrId(sc.nextLong());
	  System.out.println("enter Door no: ");
	  ad.setDoorNo(sc.nextInt());
	  System.out.println("enter Street: ");
	  ad.setStreet(sc.next());
	  System.out.println("enter city: ");
	  ad.setCity(sc.next());
	  System.out.println("enter pincode: ");
	  ad.setPincode(sc.nextInt());
	  List<Address> al=new ArrayList<Address>();
	  ad.setEmp(emp);
	  al.add(ad);
	  
	  emp.setAddress(al);
	  session.save(ad);
	  session.save(emp);
	  session.save(d);
	  txn.commit();
	  System.out.println("Employee added successfully!!!");
  }
  public void viewEmployee() {
	  session.clear();
	  Query qry= session.createQuery("from Emplyee");
	  List<Emplyee> l=qry.list();
	  Iterator i=l.iterator();
	  while(i.hasNext()) {
		  System.out.println(i.next());
	  }
  }
  
  public void updateEmployee() {
	  txn=session.beginTransaction();
	  
	  System.out.println("Enter your eid: ");
	  int p=sc.nextInt();
	  System.out.println("Enter email to be updated: ");
	  String l=sc.next();
	  
	  Query qry=session.createQuery("update Emplyee set email =:mail where eid =:j").setString("mail", l).setInteger("j",p);
	  int row=qry.executeUpdate();
	  txn.commit();
	  System.out.println("updated "+row+" successfully");
  }
  
  
  public void getEmployeeID() {
	  System.out.println("Enter your eid: ");
	  int emid=sc.nextInt();
	  Query qry=session.createNamedQuery("GET_EMP_BY_ID").setInteger("id", emid);
	  Emplyee emp= (Emplyee) qry.uniqueResult();
	  System.out.println(emp);
  }
  
  public void searchByEmail() {
	  System.out.println("Enter email : ");
	  String l=sc.next();
	  Criteria c=session.createCriteria(Emplyee.class);
	  c.add(Restrictions.eqOrIsNull("email", l));
	  Emplyee emp= (Emplyee) c.uniqueResult();
	  System.out.println(emp);
  }
  
  public void getEmployeeByDept() {
	  List<Emplyee> e=new ArrayList<Emplyee>();
	  System.out.println("Enter your dept name: ");
	  String dept=sc.next();
	  Query qry=session.createNamedQuery("GET_EMP_BY_Deptname").setString("d", dept);
	  List<Emplyee> emp= ( List<Emplyee>) qry.getResultList();
	  Iterator i=emp.iterator();
	  while(i.hasNext()) {
		  Department d=(Department) i.next();
		  int did=d.getDid();
		  Query y=session.createNamedQuery("GET_EMP_BY_DID").setInteger("ed", did);
		  Emplyee f= (Emplyee) y.uniqueResult();
		  e.add(f);
	  }
	  System.out.println(e);
  }
  
  
  public void nameStartWithM() {
	  List<Emplyee> e=new ArrayList<Emplyee>();
	  Criteria c=session.createCriteria(Emplyee.class);
	  List<Emplyee> emp= c.add(Restrictions.like("ename.fname", "M%")).list();
	  System.out.println(emp);
  }
  
  
  
  
  
  
  
  
  
  
  
  
}
