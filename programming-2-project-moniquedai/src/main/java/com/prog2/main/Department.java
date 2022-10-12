package com.prog2.main;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import javax.management.loading.PrivateClassLoader;

public class Department {
	private ArrayList<Staff> staffs=new ArrayList<>(); 
	private ArrayList<FullTimeTeacher> fullTimeTeachers=new ArrayList<>();
	private ArrayList<PartTimeTeacher> partTimeTeachers=new ArrayList<>();
	private Teacher departmentDean;
	private int departmentID;
	private static List<Department> deplist = new ArrayList<>();
	
	
	public Department() {	
	}
	
	public Department(int deparmentID) {
		this.departmentID=departmentID;
	}
	
	public static List<Department> getAllDep(){
		return deplist;
	}
	
	public static void addDepartment(Department d) {
		deplist.add(d);
	}
	
	
	public void addFullTimeTeacher(FullTimeTeacher ft) throws TwoInfoTheSameException {
		final int employeeID = ft.getEmployeeID();
		Department.getAllDep().forEach(d -> {
			d.getFullTimeTeachers().forEach(t -> {
				if (t.getEmployeeID() == employeeID)
					throw new TwoInfoTheSameException();
			});
		});
		fullTimeTeachers.add(ft);
	}
	public void addPartTimeTeacher(PartTimeTeacher pt) throws TwoInfoTheSameException {
		final int employeeID = pt.getEmployeeID();
		Department.getAllDep().forEach(d -> {
			d.getPartTimeTeachers().forEach(t -> {
				if (t.getEmployeeID() == employeeID)
					throw new TwoInfoTheSameException();
			});
		});

		partTimeTeachers.add(pt);
	}
	public void addStaff(Staff staff) throws TwoInfoTheSameException {
		final int employeeID = staff.getEmployeeID();
		Department.getAllDep().forEach(d -> {
			d.getStaffs().forEach(t -> {
				if (t.getEmployeeID() == employeeID)
					throw new TwoInfoTheSameException();
			});
		});
		staffs.add(staff);
	}
	
	public ArrayList<FullTimeTeacher> getFullTimeTeachers() {
		return fullTimeTeachers;
	}

	public void setFullTimeTeachers(ArrayList<FullTimeTeacher> fullTimeTeachers) {
		this.fullTimeTeachers = fullTimeTeachers;
	}

	public ArrayList<PartTimeTeacher> getPartTimeTeachers() {
		return partTimeTeachers;
	}

	public void setPartTimeTeachers(ArrayList<PartTimeTeacher> partTimeTeachers) {
		this.partTimeTeachers = partTimeTeachers;
	}
	
	public static void readDepartmentFile(String path) throws RepeatedDepartmentException,InexistentDepartmentException {
		File file = new File(path);
		try (Scanner input = new Scanner(file)) {

			while (input.hasNext()) {
				String row = input.nextLine();
				int departmentID = Integer.parseInt(row);
				Department dp = new Department();
				dp.setDepartmentID(departmentID);

				List<Department> ld = getAllDep();
				int i;
				for (i = 0; i < ld.size(); i++) {
					if (departmentID == ld.get(i).getDepartmentID()) {
						throw new RepeatedDepartmentException();
					}
				}
				ld.add(dp);
			}
			input.close();
		} catch (IOException e) {
			System.out.println(String.format("File %s does not exist", path));
		}
	}

	public static void readStaffsFile(String path) throws TwoInfoTheSameException, InexistentDepartmentException{
	 	File file=new File(path);
		try(Scanner input=new Scanner(file)){
			
			while(input.hasNext()) {
				String row=input.nextLine();
				String[] data = row.split(",");
				Integer employeeID=Integer.parseInt(data[0]);
				String name=data[1]; 
				String address=data[2];
				String phoneNum=data[3];
				char gender=data[4].charAt(0);
				Integer departmentID=-1;
				try {
					departmentID=Integer.parseInt(data[5]);
				}catch(java.lang.NumberFormatException e) {
				}
				String department=data[6];
				String duty=data[7];
				double workload=Double.parseDouble(data[8]);
				Staff staff=new Staff(employeeID,name,address,phoneNum,gender,departmentID,department,duty,workload);
				
				List<Department> ld=getAllDep();
				Department dp;
				int i;
				for (i=0;i<ld.size();i++) {
					if(departmentID==ld.get(i).getDepartmentID())
						{
						dp=ld.get(i);
						dp.addStaff(staff);
						i=ld.size()+1;
						}
				}
				if(i==ld.size())
					throw new InexistentDepartmentException();
			}
			input.close();
		}catch(IOException e) {
			 System.out.println(String.format("File %s does not exist", path));
		}	
	}
	
		
	public static void readFullTimeTeachersFile(String path) throws TwoInfoTheSameException,InexistentDepartmentException {
		File file = new File(path);
		try (Scanner input = new Scanner(file)) {
			while (input.hasNext()) {
				String row = input.nextLine();
				String[] data = row.split(",");
				Integer employeeID = Integer.parseInt(data[0]);
				String name = data[1];
				String address = data[2];
				String phoneNum = data[3];
				char gender = data[4].charAt(0);
				Integer departmentID = -1;
				try {
					departmentID = Integer.parseInt(data[5]);
				} catch (java.lang.NumberFormatException e) {
				}

				String department = data[6];
				String specialty = data[7];
				String degree = data[8];
				String course = data[9];
				String hireDate = data[10];
				Double yearsOfTeaching = Double.parseDouble(data[11]);
				String partTimeOrFullTime = data[12];
				boolean dean = data[13].equalsIgnoreCase("TRUE");
				FullTimeTeacher fullTimeTeacher = new FullTimeTeacher(employeeID, name, address, phoneNum, gender,
						departmentID, department, specialty, degree, course, hireDate, yearsOfTeaching,
						partTimeOrFullTime, dean);
				List<Department> ld = getAllDep();
				Department dp;
				int i;
				for (i = 0; i < ld.size(); i++) {
					if (departmentID == ld.get(i).getDepartmentID()) {
						dp = ld.get(i);
						dp.addFullTimeTeacher(fullTimeTeacher);
						i = ld.size() + 1;
					}
				}
				if (i == ld.size())
					throw new InexistentDepartmentException();
			}
			input.close();
		} catch (IOException e) {
			System.out.println(String.format("File %s does not exist", path));
		}
	}
	
	public static void readPartTimeTeachersFile(String path)throws TwoInfoTheSameException,InexistentDepartmentException  {
		File file = new File(path);
		try (Scanner input = new Scanner(file)) {
			while (input.hasNext()) {
				String row = input.nextLine();
				String[] data = row.split(",");
				Integer employeeID = Integer.parseInt(data[0]);
				String name = data[1];
				String address = data[2];
				String phoneNum = data[3];
				char gender = data[4].charAt(0);
				Integer departmentID = -1;
				try {
					departmentID = Integer.parseInt(data[5]);
					final int depID2 = departmentID;
					if (getAllDep().stream().filter((d) -> d.departmentID == depID2).count() < 1)
						throw new InexistentDepartmentException();
				} catch (java.lang.NumberFormatException e) {
				}
				String department = data[6];
				String specialty = data[7];
				String degree = data[8];
				String course = data[9];
				String hireDate = data[10];
				Double yearsOfTeaching = Double.parseDouble(data[11]);
				String partTimeOrFullTime = data[12];
				boolean dean = data[13].equalsIgnoreCase("TRUE");
				Double workingHour = Double.parseDouble(data[14]);

				PartTimeTeacher partTimeTeacher = new PartTimeTeacher(employeeID, name, address, phoneNum, gender,
						departmentID, department, specialty, degree, course, hireDate, yearsOfTeaching,
						partTimeOrFullTime, dean, workingHour);
				List<Department> ld = getAllDep();
				Department dp;
				int i;
				for (i = 0; i < ld.size(); i++) {
					if (departmentID == ld.get(i).getDepartmentID()) {
						dp = ld.get(i);
						dp.addPartTimeTeacher(partTimeTeacher);
						i = ld.size() + 1;
					}
				}
				if (i == ld.size())
					throw new InexistentDepartmentException();
			}
			input.close();
		} catch (IOException e) {
			System.out.println(String.format("File %s does not exist", path));
		}
	}
	
	public static void writeDepartmentFile(String path) {
		try (PrintWriter pw = new PrintWriter(new FileWriter(path, false))) {
			getAllDep().forEach(d -> pw.println(String.valueOf(d.getDepartmentID())));
		} catch (Exception ex) {
		}
	}
	
	public static void writeStaffsFile(String path) {
		try (PrintWriter pw = new PrintWriter(new FileWriter(path, false))) {
			getAllDep().forEach(d -> d.getStaffs().forEach(s -> {
				StringBuilder sb = new StringBuilder();
				sb.append(String.valueOf(s.getEmployeeID()));
				sb.append(",");
				sb.append(s.getName());
				sb.append(",");
				sb.append(s.getAddress());
				sb.append(",");
				sb.append(s.getPhoneNum());
				sb.append(",");
				sb.append("" + s.getGender());
				sb.append(",");
				sb.append(String.valueOf(s.getDepartmentID()));
				sb.append(",");
				sb.append(s.getDepartment());
				sb.append(",");
				sb.append(s.getDuty());
				sb.append(",");
				sb.append(String.valueOf(s.getWorkload()));
				pw.println(sb);
			}));
		} catch (Exception ex) {
		}
	}
	

	public static void writeFullTimeTeacherFile(String path) {
		try (PrintWriter pw = new PrintWriter(new FileWriter(path, false))) {
			getAllDep().forEach(d -> d.getFullTimeTeachers().forEach(s -> {
				StringBuilder sb = new StringBuilder();
				sb.append(String.valueOf(s.getEmployeeID())); // 0
				sb.append(",");
				sb.append(s.getName()); // 1
				sb.append(",");
				sb.append(s.getAddress()); // 2
				sb.append(",");
				sb.append(s.getPhoneNum()); // 3
				sb.append(",");
				sb.append("" + s.getGender()); // 4
				sb.append(",");
				sb.append(String.valueOf(s.getDepartmentID())); // 5
				sb.append(",");
				sb.append(s.getDepartment()); // 6
				sb.append(",");
				sb.append(s.getSpecialty()); // 7
				sb.append(",");
				sb.append(s.getDegree()); // 8
				sb.append(",");
				sb.append(s.getCourse()); // 9
				sb.append(",");
				sb.append(s.getHireDate()); // 10
				sb.append(",");
				sb.append(String.valueOf(s.getYearsOfTeaching())); // 11
				sb.append(",");
				sb.append(s.getParttimeOrFulltime()); // 12
				sb.append(",");
				sb.append(s.isDean() ? "TRUE" : "FALSE"); // 13
				pw.println(sb);
			}));
		} catch (Exception ex) {
		}
	}
	
	public static void writePartTimeTeacherFile(String path) {
		try (PrintWriter pw = new PrintWriter(new FileWriter(path, false))) {
			getAllDep().forEach(d -> d.getPartTimeTeachers().forEach(s -> {
				StringBuilder sb = new StringBuilder();
				sb.append(String.valueOf(s.getEmployeeID())); // 0
				sb.append(",");
				sb.append(s.getName()); // 1
				sb.append(",");
				sb.append(s.getAddress()); // 2
				sb.append(",");
				sb.append(s.getPhoneNum()); // 3
				sb.append(",");
				sb.append("" + s.getGender()); // 4
				sb.append(",");
				sb.append(String.valueOf(s.getDepartmentID())); // 5
				sb.append(",");
				sb.append(s.getDepartment()); // 6
				sb.append(",");
				sb.append(s.getSpecialty()); // 7
				sb.append(",");
				sb.append(s.getDegree()); // 8
				sb.append(",");
				sb.append(s.getCourse()); // 9
				sb.append(",");
				sb.append(s.getHireDate()); // 10
				sb.append(",");
				sb.append(String.valueOf(s.getYearsOfTeaching())); // 11
				sb.append(",");
				sb.append(s.getParttimeOrFulltime()); // 12
				sb.append(",");
				sb.append(s.isDean() ? "TRUE" : "FALSE"); // 13
				sb.append(",");
				sb.append(String.valueOf(s.getWorkingHour())); // 14
				pw.println(sb);
			}));
		} catch (Exception ex) {
		}
	}
	
	public ArrayList<Staff> getStaffs() {
		return staffs;
	}

	public void setStaffs(ArrayList<Staff> staffs) {
		this.staffs = staffs;
	}

	
	public Person getDepartmentDean() {
		return departmentDean;
	}
	
	public  void setDepartmentDean(Teacher departmentDean)throws DepartmentDeanException{
		if(departmentID!=departmentDean.getDepartmentID())
			throw new DepartmentDeanException();
		this.departmentDean=departmentDean;	
	}
	
	public int getDepartmentID() {
		return departmentID;
	}
	
	public void setDepartmentID(int departmentID) {
		this.departmentID=departmentID;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return Objects.equals(departmentDean, other.departmentDean) && departmentID == other.departmentID
				&& Objects.equals(fullTimeTeachers, other.fullTimeTeachers)
				&& Objects.equals(partTimeTeachers, other.partTimeTeachers) && Objects.equals(staffs, other.staffs);
	}

	
	@Override
	public String toString() {
		return "Department [staffs=" + staffs + ", fullTimeTeachers=" + fullTimeTeachers + ", partTimeTeachers="
				+ partTimeTeachers + ", departmentDean=" + departmentDean + ", departmentID=" + departmentID + "]";
	}

	


	

}
