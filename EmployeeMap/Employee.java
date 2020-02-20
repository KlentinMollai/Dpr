package EmployeeMap;

/**
 * In the class Employee, fields name, number and salary are defined.
 * It also implements getters and setters and a toString method.
 * These fields are unique to each OBJECT: that is any variable
 * (object) of type Employee has its own name, number and salary.  
 * There are also two constructor and 6 regular methods and toString method.
 *  The regular methods also are per object.
 */
class Employee {

	private String employeeName;
	private Integer employeeNumber;
	private double employeeSalary;

	public Employee() {
	}
	/**
	 * In the constructor are passed number, name and salary fields
	 * as parameters to  the constructor
	 */
    
	public Employee(Integer number, String name, double salary) {
		employeeNumber = number;
		employeeName = name;
		employeeSalary = salary;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	private void setEmployeeName(String name) {
		employeeName = name;
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	void setEmployeeNumber(int number) {
		employeeNumber = number;
	}

	public double getEmployeeSalary() {
		return employeeSalary;
	}

	 void setEmployeeSalary(double salary) {
		employeeSalary = salary;
	}
 /**
  * Returns the string representation of Employee class fields
  * employeeNumber, employeeName, employeeSalary.
  */
@Override	 
	public String toString() {
		return String.format("%d: %s $%.2f ",employeeNumber, employeeName, employeeSalary);
	}

}
