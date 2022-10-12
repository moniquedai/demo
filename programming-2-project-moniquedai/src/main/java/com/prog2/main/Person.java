package com.prog2.main;

import java.util.Objects;

public abstract class Person {
	private int employeeID;
	private String name;
	private String address;
	private String phoneNum;
	private char gender;
	private int departmentID;
	private String department;
	
	public Person() {
		
	}
	
	public Person(int employeeID,String name, String address, String phoneNum, char gender, int departmentID,String department) {
		this.employeeID=employeeID;
		this.name = name;
		this.address = address;
		this.phoneNum = phoneNum;
		this.departmentID = departmentID;
		this.gender = gender;
		this.department=department;
	}

	public abstract String PersonCategory();
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(address, other.address) && Objects.equals(department, other.department)
				&& departmentID == other.departmentID && employeeID == other.employeeID && gender == other.gender
				&& Objects.equals(name, other.name) && Objects.equals(phoneNum, other.phoneNum);
	}


	@Override
	public String toString() {
		return "Person [employeeID=" + employeeID + ", name=" + name + ", address=" + address + ", phoneNum=" + phoneNum
				+ ", gender=" + gender + ", departmentID=" + departmentID + ", department=" + department + "]";
	}
	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public int getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
