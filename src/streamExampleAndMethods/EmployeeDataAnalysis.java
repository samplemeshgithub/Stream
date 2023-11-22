package streamExampleAndMethods;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EmployeeDataAnalysis {
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}

	int id;
	String name;
	String department;
	double salary;
	String  joindate;



public String getJoindate() {
		return joindate;
	}



	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}



public EmployeeDataAnalysis (int id,String name,String department,double salary,String joindate) {
	this.id=id;
	this.name=name;
	this.department=department;
	this.salary=salary;
	this.joindate=joindate;
}
 
 
 


public static void main(String[] args) {
	 
	 List<EmployeeDataAnalysis> employeedtanalysis = new ArrayList<EmployeeDataAnalysis>();
	 employeedtanalysis.add(new EmployeeDataAnalysis(1,"Alice","IT",70000,"2020-01-01"));
	 employeedtanalysis.add(new EmployeeDataAnalysis(2,"Bob","HR",50000,"2021-06-01"));
	 employeedtanalysis.add(new EmployeeDataAnalysis(1,"Charile","IT",80000,"2022-01-01"));
	 
	 //.String targetDepartment = "IT";
//	 ArrayList<EmployeeDataAnalysis> employeeJoinedAftercertaindate= (ArrayList<EmployeeDataAnalysis>) employeedtanalysis.stream().filter(e-> e.joinDate=="2020-01-01").collect(Collectors.toList());
//	 System.out.println(employeedtanalysis);
	 
	List<EmployeeDataAnalysis>  employeejoinedoncertaindate  = employeedtanalysis.stream().filter(employee -> employee.getJoindate().equals("2021-06-01")).collect(Collectors.toList());
	 
	// System.out.println("Employees who joined on " + employeejoinedoncertaindate + ":");
	 employeejoinedoncertaindate.forEach(employee ->
             System.out.println("ID: " + employee.getId() +
                     ", name: " + employee.getName() 
                    ));
	 
	 double averageSalary = employeedtanalysis.stream()
		        .filter(employee -> employee.getDepartment().equals("IT"))
		        .mapToDouble(EmployeeDataAnalysis::getSalary)
		        .average()
		        .orElse(0.0);
	 System.out.println("Average salary in IT Departmernt :" +averageSalary);
	 
	 
	 List<String> employeeNamesInDepartment = employeedtanalysis.stream()
             .filter(employee -> employee.getDepartment().equals("IT"))
             .map(EmployeeDataAnalysis::getName) // Change this to map(Employee::getName) if there is a name attribute
             .collect(Collectors.toList());

     // Print the names of employees in the specified department
     System.out.println("Names of employees in the " + "IT" + " department: " + employeeNamesInDepartment);
	 
     double highestSalary = employeedtanalysis.stream()
             .mapToDouble(EmployeeDataAnalysis::getSalary)
             .max().orElse(0.0);
             
            System.err.println("Highest salary of the employee :"+highestSalary); 
     
            double lowestSalary = employeedtanalysis.stream()
                    .mapToDouble(EmployeeDataAnalysis::getSalary)
                    .min().orElse(0.0);
                    
                   System.err.println("Lowest salary of the employee :"+lowestSalary);
 }


}



