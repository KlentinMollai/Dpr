package EmployeeMap;
/**
 * This program demonstrates a map structure that links (maps) numbers to Employee
 * class. Retrieves a keySet and uses it to retrieve 5 employee objects 
 * stored to map and uses toStrting method to display all employees, 
 * a specific employee or not found when fails to find it. It also displays 
 * employees that earn more than $60000
 * @author Klentin Mollai
 * @version 11/5/2019
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class EmployeeMap {

	/** This is the main method for the project */
	public static void main(String[] arg) {
		System.out.println("\n\tBegin Map demo program\n\n");

		Map<Integer, Employee> staff = new HashMap<Integer, Employee>();

		staff.put(1, new Employee(1, "Noan Mollai", 45000));
		staff.put(5, new Employee(5, "Eti Mollai", 89000));
		staff.put(2, new Employee(2, "Aron Thanasi", 120000));
		staff.put(4, new Employee(4, "Emily Thanasi", 135000));
		staff.put(3, new Employee(3, "Klentin Mollai", 199000));

		Set<Integer> keySet = staff.keySet();
		Employee emp = new Employee();
		for (Integer key : keySet) {
			emp = staff.get(key);
			System.out.println(emp.toString());
		}

		Scanner in = new Scanner(System.in);
		System.out.print("\nEnter a key to search for the employee:");
		Integer input = in.nextInt();
		emp = staff.get(input);

		if (emp == null)
			System.out.println("  Key not found");

		else
			System.out.println(emp.toString());

		System.out.print("\nEnter a salary to search for the employee's salary : \n");
		input = in.nextInt();

		for (Integer key : keySet) {
			emp = staff.get(key);

			if (emp.getEmployeeSalary() > (double) input) {

				System.out.println(emp.toString());
			}
		}

		in.close();
		System.out.println("\n\tEnd Map demo program\n");

	}
}