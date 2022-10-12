package com.prog2.main;

import java.sql.Date;
import java.util.ArrayList;

/**
 * @author adinashby
 *
 */

public class Main {

	/**
	 * Write your test code below in the main.
	 *
	 */
	public static void main(String[] args) {

		FullTimeTeacher teacher1=new FullTimeTeacher(1021,"Joe","35 Road","(514)234-8765",'m',1001,"Mathematics",
				                              "math","Phd","2021-04-21","FullTime",20.0,"math",false);
		PartTimeTeacher teacher2=new PartTimeTeacher(1031,"Joan","78 Road","(514)456-8765",'f',1001,"Mathematics",
				           "Computer Science","Master","2021-07-21","PartTime",10.5,"computer",false,32);
		Staff staff1=new Staff(1013,"Steve","135 Road Louis","(514)239-8456",'m',1001,"Mathematics",
				               "administration",35);
		
		teacher1.ComputePayRoll();
		System.out.printf("This fulltime teacher salary is: %.2f\n",teacher1.ComputePayRoll());
		teacher2.ComputePayRoll();
		System.out.printf("This parttime teacher salary is: %.2f\n",teacher2.ComputePayRoll());
		staff1.ComputePayRoll();
		System.out.printf("This staff salary is: %.2f\n",staff1.ComputePayRoll());
		
		System.out.println("This person's category is: "+teacher1.PersonCategory());
		System.out.println("This person's category is: "+teacher2.PersonCategory());
		System.out.println("This person's category is: "+staff1.PersonCategory());
		
		
		Department mathDepartment=new Department();
		Department.addDepartment(mathDepartment);
		mathDepartment.setDepartmentID(1000);
		
		try {
			Teacher mathDean=new Teacher(1001,"Hance","345 Westmount","(514)988-8765",'m',1000,
					"Mathematics","math","Phd","math","2000-02-21",30.0,"FullTime",true);
			mathDepartment.setDepartmentDean(mathDean);
		}catch(DepartmentDeanException e) {
			System.out.println("Error,this dean is not in this department.");
		}
		
		
		Department scienceDepartment=new Department();
		Department.addDepartment(scienceDepartment);
		scienceDepartment.setDepartmentID(2000);
		
		try {
			Teacher scienceDean=new Teacher(2001,"Henry","1345 Westmount","(514)566-8765",'m',2000,
					"Science","physics","Phd","physics","2000-01-21",35.0,"FullTime",true);
			scienceDepartment.setDepartmentDean(scienceDean);
		}catch(DepartmentDeanException e) {
			System.out.println("Error,this dean is not in this department.");
		}
		
		try{
			Department.readStaffsFile("staffs.txt");
			Department.getAllDep().forEach(d->System.out.println(d.getStaffs()));
		}catch(TwoInfoTheSameException c) {
			System.out.println("The staff is already in the list.");
		}catch(InexistentDepartmentException c) {
			System.out.println("The department doesn't exit.");
		}

		try {
			Department.readFullTimeTeachersFile("fullTimeTeachers.txt");
			Department.getAllDep().forEach(d -> System.out.println(d.getFullTimeTeachers()));
		} catch (TwoInfoTheSameException c) {
			System.out.println("The teacher is already in the list.");
		} catch (InexistentDepartmentException c) {
			System.out.println("The department doesn't exit.");
		}

		try {
			Department.readPartTimeTeachersFile("PartTimeTeachers.txt");
			Department.getAllDep().forEach(d -> System.out.println(d.getPartTimeTeachers()));
		} catch (TwoInfoTheSameException c) {
			System.out.println("The teacher is already in the list.");
		} catch (InexistentDepartmentException c) {
			System.out.println("The department doesn't exit.");
		}
		mainFrame window=new mainFrame();
		window.setVisible(true);
		
		
	}
	
}

	
	