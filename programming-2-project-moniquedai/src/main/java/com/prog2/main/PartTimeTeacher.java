package com.prog2.main;

import java.security.PublicKey;
import java.sql.Date;
import java.util.Objects;

public class PartTimeTeacher extends Teacher implements PayRoll{
	private double workingHour;
	
	public PartTimeTeacher() {
		
	}

	
	public PartTimeTeacher(int employeeID,String name, String address, String phoneNum, char gender,int departmentID,
			String department,String specialty, String degree,String course,String hireDate, 
			double yearsOfTeaching,String parttimeOrFulltime, boolean dean,double workingHour)
	{
		super(employeeID,name,address,phoneNum,gender,departmentID,department,specialty,degree,course,
				hireDate,yearsOfTeaching,parttimeOrFulltime,dean);
		
		this.workingHour=workingHour;
	}
	
	
	public double getWorkingHour() {
		return workingHour;
	}
	
	public void setWorkingHour(double workingHour) {
		this.workingHour=workingHour;
	}
	
	@Override
	public String toString() {
		return "Part time Teacher {"+super.toString()+ ", working hours=" + workingHour + "]";
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PartTimeTeacher other = (PartTimeTeacher) obj;
		return  workingHour == other.workingHour;
	}


	@Override
	public  String PersonCategory() {
		String category="part time teacher";
		return category;
	}
	
	@Override
	public double ComputePayRoll(){
		double payroll = 0.0;
		switch(getDegree()) {
			case("phd"):
				payroll=workingHour*ratePhd*2*0.76;
				break;
			case("Master"):
				payroll=workingHour*rateMaster*2*0.76;
				break;
			case("Bachelor"):
				payroll=workingHour*rateBachelor*2*0.76;
				break;
		}
		return payroll;
	}

}
