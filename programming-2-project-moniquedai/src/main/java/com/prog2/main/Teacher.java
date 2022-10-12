package com.prog2.main;

import java.sql.Date;
import java.util.Objects;

public class Teacher extends Person  {
	private String specialty;
	private String degree;
	private String course;
	private String hireDate;
	private double yearsOfTeaching;
	private String parttimeOrFulltime;
	private boolean dean;
	
	public static final double ratePhd=112;
	public static final double rateMaster=82;
	public static final double rateBachelor=42;
	
	public Teacher() {
			
	}
	
	public Teacher(int employeeID,String name, String address, String phoneNum,  char gender,int departmentID,
			String department,String specialty, String degree,String course,String hireDate,
			double yearsOfTeaching,String parttimeOrFulltime,boolean dean) {
		super(employeeID,name, address, phoneNum,gender,departmentID,department);
		this.specialty=specialty;
		this.degree=degree;
		this.course=course;
		this.hireDate=hireDate;
		this.yearsOfTeaching=yearsOfTeaching;
		this.parttimeOrFulltime=parttimeOrFulltime;
		this.dean=dean;
	}


	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public boolean isDean() {
		return dean;
	}

	public void setDean(boolean dean) {
		this.dean = dean;
	}

	public static double getRatephd() {
		return ratePhd;
	}

	public static double getRatemaster() {
		return rateMaster;
	}

	public static double getRatebachelor() {
		return rateBachelor;
	}

	@Override
	public String toString() {
		return "Teacher ["+super.toString() +" specialty=" + specialty + ", degree=" + degree + ", course=" + course + ", hireDate="
				+ hireDate + ", yearsOfTeaching=" + yearsOfTeaching + ", parttimeOrFulltime=" + parttimeOrFulltime
				+ ", dean=" + dean + "]";
	}
	
	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getParttimeOrFulltime() {
		return parttimeOrFulltime;
	}

	public void setParttimeOrFulltime(String parttimeOrFulltime) {
		this.parttimeOrFulltime = parttimeOrFulltime;
	}
	
	public double getYearsOfTeaching() {
		return yearsOfTeaching;
	}

	public void setYearsOfTeaching(double yearsOfTeaching) {
		this.yearsOfTeaching = yearsOfTeaching;
	}


	@Override
	public  String PersonCategory() {
		String category="teacher";
		return category;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		return Objects.equals(course, other.course) && dean == other.dean && Objects.equals(degree, other.degree)
				&& Objects.equals(hireDate, other.hireDate)
				&& Objects.equals(parttimeOrFulltime, other.parttimeOrFulltime)
				&& Objects.equals(specialty, other.specialty)
				&& Double.doubleToLongBits(yearsOfTeaching) == Double.doubleToLongBits(other.yearsOfTeaching);
	}
	
	

	

	
	
	


}
