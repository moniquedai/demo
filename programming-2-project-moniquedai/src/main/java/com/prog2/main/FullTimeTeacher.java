package com.prog2.main;

import java.sql.Date;
import java.util.Objects;

import javax.lang.model.element.NestingKind;

public class FullTimeTeacher extends Teacher implements PayRoll{
	

	public FullTimeTeacher() {
		
	}
	
	public FullTimeTeacher(int employeeID,String name, String address, String phoneNum,char gender,int departmentID,
			String department,String specialty, String degree,String course,String hireDate, double yearsOfTeaching,
			String parttimeOrFulltime,boolean dean) {
		super(employeeID,name,address,phoneNum,gender, departmentID,department,specialty,degree,course,
				hireDate,yearsOfTeaching,parttimeOrFulltime,dean);
		
	}
	
	
	@Override
	public  String PersonCategory() {
		String category="full time teacher";
		return category;
	}
	
	@Override
	public double ComputePayRoll( ){
		double payroll = 0.0;
		switch(getDegree()) {
			case("Phd"):
				payroll=32*ratePhd*2*0.85;
				break;
			case("Master"):
				payroll=32*rateMaster*2*0.85;
				break;
			case("Bachelor"):
				payroll=32*rateBachelor*2*0.85;
				break;
		}
		return payroll;
		
	}
	
	@Override
	public String toString() {
		return "FullTimeTeacher {"+super.toString()+"]";
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}


	
}
