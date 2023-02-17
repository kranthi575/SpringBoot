package com.kp.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.kp.app.App;
import com.kp.controller.IStudentController;
import com.kp.controller.StudentControllerImple;
import com.kp.model.Student;
import com.kp.studentFactory.StudentControllerFactory;

public class App {
	
	public static void create() {
		
	IStudentController studController=StudentControllerFactory.getStudentController();
	Scanner sc=new Scanner(System.in);
	Student stud=new Student();
	
	System.out.println("Enter student details::");
	
	System.out.println("Enter student id:");
	int sid=sc.nextInt();
	System.out.println("Enter student name:");
	String sname=sc.next();
	System.out.println("Enter student age ");
	int sage=sc.nextInt();
	
	stud.setSid(sid);
	stud.setSname(sname);
	stud.setSage(sage);
	
	String msg=studController.save(stud);
	
	System.out.println(msg);
	}
	public static void read()   {}
	public static void update() {
		IStudentController studController=StudentControllerFactory.getStudentController();
		Scanner sc=new Scanner(System.in);
		Student stud=new Student();
		
		System.out.println("Enter student details::");
		
		System.out.println("Enter student id:");
		int sid=sc.nextInt();
		System.out.println("Enter student name:");
		String sname=sc.next();
		System.out.println("Enter student age ");
		int sage=sc.nextInt();
		
		stud.setSid(sid);
		stud.setSname(sname);
		stud.setSage(sage);
		
		String msg=studController.update(stud);
		
		System.out.println(msg);
		
	}
	public static void delete() {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter student Id to delete:");
		int sid=sc.nextInt();
		
		IStudentController studController=StudentControllerFactory.getStudentController();
		
		String msg=studController.delete(sid);
		
		System.out.println(msg);
		
	}
	public static void search() {
		
		System.out.println("Enter student id:");
		Scanner sc=new Scanner(System.in);
		int sid=sc.nextInt();
		
		IStudentController studController=StudentControllerFactory.getStudentController(); 
		
		Student stud=studController.search(sid);
		
		if(stud==null)
			System.out.println("No Student found with that ID");
		else {
			System.out.println("Student with that ID details: ");
			System.out.println("Student ID:"+stud.getSid());
			System.out.println("Student Name:"+stud.getSname());
			System.out.println("Student Age:"+stud.getSage());
			stud=null;
		}
		
	}

	public static void main(String[] args) {
		
		System.out.println("welcome to HBCURD Application");
		Scanner sc=new Scanner(System.in);
		String input=null;
		do {
		try {	
			   
			System.out.println("Pls select option \n1.Save\n2.Read\n3.Update\n4.Delete\n5.Search\n");
			BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
			
			switch(Integer.parseInt(in.readLine())) {
			
			case 1:
				App.create();
				break;
			case 2:
				App.read();
				break;
			case 3:
				App.update();
				break;
			case 4:
				App.delete();
				break;
			case 5:
				App.search();
				break;
			default:
				System.out.println("Select valid option");
				break;
			
			}
			
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		    System.out.println("::Appliction ended::");
			System.out.println("Do you want to conntinue: y/n:");
			input=sc.next();
		}
		while(input.equalsIgnoreCase("y"));
			

	}

}
