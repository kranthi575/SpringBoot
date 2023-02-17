package in.kp.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import in.kp.StudentFactory.StudentControllerFactory;
import in.kp.controller.StudentController;
import in.kp.dto.Student;

public class App {
	
	public static void create() {
		
		
		Scanner sc=new Scanner(System.in);
		
		String name=sc.next();
		String email=sc.next();
		String city=sc.next();
		String country=sc.next();
		
		Student stud=new Student(name,email,city,country);
		
		StudentController stdController=StudentControllerFactory.getStudentController();
		
		String str=stdController.save(stud);
		
		System.out.println(str);
		
		
	}
	
	public static void main(String args[])
	{

   try {	
	   
	System.out.println("Pls select option \n1.Create\n2.Read\n3.Update\n4.Delete\n");
	BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
	
	switch(Integer.parseInt(in.readLine())) {
	
	case 1:
		App.create();
		break;
	case 2:
		System.out.println("Read");
		break;
	case 3:
		System.out.println("update");
		break;
	case 4:
		System.out.println("Delete");
		break;
	default:
		System.out.println("Select valid option");
		break;
	
	}
	
	
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	
	}

}
