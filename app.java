package com.mph.view;

import java.util.Scanner;

import com.mph.controller.EmployeeController;

public class App {

	public static void main(String[] args) {
		EmployeeController ec=new EmployeeController();
		Scanner sc=new Scanner(System.in);
		String s=null;
		
		do {System.out.println("enter choice: 1.Add Employee 2.View 3.Update 4.getEmployee 5.search by email 6.getbydeptname 7.namewithM");
		int n=sc.nextInt();
		
		switch(n) {
		case 1:{
			
		ec.addEmployee();break;
		}
		case 2:{
			ec.viewEmployee();break;
		}
		case 3:{
			ec.updateEmployee();break;
		}
		case 4:{
			ec.getEmployeeID();break;
		}
		case 5:{
			ec.searchByEmail();break;
		}
		case 6:{
			ec.getEmployeeByDept();break;
		}
		case 7:{
			ec.nameStartWithM();break;
		}
		}
		System.out.println("if want to continue : press y");
		s = sc.next();	
		}while(s.equals("y"));
		
		System.out.println("Thanks for using!!!");
		
		
	}

}
