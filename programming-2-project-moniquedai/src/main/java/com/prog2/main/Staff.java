package com.prog2.main;

import java.util.Objects;

public class Staff extends Person implements PayRoll{
	private String duty;
	private double workload;
	
	public Staff() {
		super();
		duty=null;
		workload=0;
	}
	
	public Staff(int employeeID,String name, String address, String phoneNum, char gender,int departmentID,
			String department, String duty,double workload) {
		
		super(employeeID,name, address, phoneNum, gender, departmentID, department);
		
		this.duty=duty;
		this.workload=workload;	
	}
	
	@Override
	public  String PersonCategory() {
		String category="staff";
		return category;
	}
	
	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public double getWorkload() {
		return workload;
	}

	public void setWorkload(double workload) {
		this.workload = workload;
	}

	@Override
	public double ComputePayRoll(){
		if (workload>40)
			return 0;
		else
			return (workload*32*2)*0.75;		
	}

	@Override
	public String toString() {
		return "Staff ["+super.toString()+", duty=" + duty + ", workload=" + workload + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Staff other = (Staff) obj;
		return Objects.equals(duty, other.duty) && workload == other.workload;
	}
	
	
	

	
	
}
