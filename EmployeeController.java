package com.mph.controller;


import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mph.entity.Department;
import com.mph.entity.Emplyee;

public class EmployeeController {
  SessionFactory sf=new Configuration().configure().buildSessionFactory();
  Session session = sf.openSession();
  Transaction txn;
  Emplyee emp;
  Department d;
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
	  System.out.println("enter name: ");
	  String name= sc.next();
	  emp.setEname(name);
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
	  
	  session.save(emp);
	  session.save(d);
	  txn.commit();
	  System.out.println("Employee added successfully!!!");
  }
}
