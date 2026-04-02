package com.shivam.monocept.employee.model1;



public class Employee {

    private long employeeId;
    private String name;
    private String department;
    private double salary;
    private int experience;
    private boolean activeStatus;
    private static long counter=1234; 
    public Employee( String name, String department,
                    double salary, int experience, boolean activeStatus) {
        this.employeeId = counter++;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.experience = experience;
        this.activeStatus = activeStatus;
    }

    public long getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public int getExperience() { return experience; }
    public boolean isActiveStatus() { return activeStatus; }

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", department=" + department + ", salary="
				+ salary + ", experience=" + experience + ", activeStatus=" + activeStatus + "]";
	}

  
   
}