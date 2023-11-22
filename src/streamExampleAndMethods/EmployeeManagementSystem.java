package streamExampleAndMethods;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class EmployeeManagementSystem implements Comparable<EmployeeManagementSystem> {

	int id;
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

	String name;
	String department;
	double salary;
	
	public EmployeeManagementSystem (int id,String name,String department,double salary) {
		this.id=id;
		this.name=name;
		this.department=department;
		this.salary=salary;
		
	}
	
	
	 @Override
	    public boolean equals(Object obj) {
	        if (this == obj) return true;
	        if (obj == null || getClass() != obj.getClass()) return false;
	        EmployeeManagementSystem employee = (EmployeeManagementSystem) obj;
	        return id == employee.id && name.equals(employee.name)&&
	                Double.compare(employee.salary, salary) == 0 && 
	                department.equals(employee.department);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(id,name, salary, department);
	    }
	
	
	 @Override
	    public int compareTo(EmployeeManagementSystem other) {
	        // Compare employees based on their salaries
	        return Double.compare(this.salary, other.salary);
	    }
	
	public static void main(String[] args) {
		 TreeSet<EmployeeManagementSystem> employeesBySalary = new TreeSet<>();
		 List<EmployeeManagementSystem> employeemangmentsystem = new ArrayList<EmployeeManagementSystem>();
		 employeemangmentsystem.add(new EmployeeManagementSystem(1,"Alice","IT",60000));
		 employeemangmentsystem.add(new EmployeeManagementSystem(2,"Bob","HR",50000));
		 employeemangmentsystem.add(new EmployeeManagementSystem(3,"Charile","IT",65000));
		 employeemangmentsystem.add(new EmployeeManagementSystem(4,"Akash","HR",55000));
		
		 
		 employeesBySalary.add(new EmployeeManagementSystem(1,"Alice","IT",60000));
		 employeesBySalary.add(new EmployeeManagementSystem(2,"Bob","HR",70000));
		 employeesBySalary.add(new EmployeeManagementSystem(3,"Charile","IT",65000));
		 employeesBySalary.add(new EmployeeManagementSystem(4,"Akash","HR",55000));
		
		 
		 
		 Map<String, List<EmployeeManagementSystem>> employeesByDepartment = employeemangmentsystem.stream()
	                .collect(Collectors.groupingBy(EmployeeManagementSystem::getDepartment));

	        // Print the grouped employees
	        employeesByDepartment.forEach((department, employees) -> {
	            System.out.println("Employees in " + department + " department:");
	            employees.forEach(employee ->
	                    System.out.println(  "Name: " + employee.name
	                           
	                            ));
	            System.out.println();
	        });
	        
	        
	        double minSalary = 55000;
	        double maxSalary = 70000;

	        // Perform a range query to retrieve employees within the specified salary range
	        
	        
	        TreeSet<EmployeeManagementSystem> employeesInSalaryRange = new TreeSet<>(employeesBySalary.subSet(
	                new EmployeeManagementSystem(0, null, null, minSalary),
	                new EmployeeManagementSystem(0, null, null, maxSalary)));

	        // Print the employees in the salary range
	        System.out.println("Employees within the salary range $" + minSalary + " - $" + maxSalary + ":");
	        employeesBySalary.forEach(employee ->
	                System.out.println("name: " + employee.name +
	                        ", Salary: " + employee.getSalary() +
	                        ", Department: " + employee.getDepartment()));
	        
	        
	     // Create a HashSet to store unique employees
	        Set<EmployeeManagementSystem> uniqueEmployees = new HashSet<>();
	        uniqueEmployees.add(new EmployeeManagementSystem(1,"Alice","IT",60000));
	        uniqueEmployees.add(new EmployeeManagementSystem(2,"Bob","HR",50000));
	        uniqueEmployees.add(new EmployeeManagementSystem(3,"Charile","IT",65000));
	        uniqueEmployees.add(new EmployeeManagementSystem(4,"Akash","HR",55000));
	        
	        // Try to add a duplicate employee (it won't be added)
	        boolean isDuplicate = uniqueEmployees.add(new EmployeeManagementSystem(1, "Bob", "HR",50000));

	        // Print whether the duplicate employee was added
	        System.out.println("Is duplicate employee added? " + !isDuplicate);
	        
	       
	    }

	
	
	
		 
	}


