package FinalProject;

/**
 * Student class implements Comparable class 
 * Each student record consists of three fields
 * studentID, studentName, studentMajor 
 * 
 * @author Klentin Mollai
 * @version 12/05/2019
 */
import java.lang.Exception;

public class Student implements Comparable<Student> {

	int studentID;
	String studentName;
	String studentMajor;

	public Student() {

	}

	/**
	 * Regular constructor with all fields passed to it.
	 * 
	 * @param id
	 * @param name
	 * @param major
	 */
	public Student(int id, String name, String major) {
		studentID = id;
		studentName = name;
		studentMajor = major;
	}

	/**
	 * Special constructor (passed id)
	 * 
	 * @param id
	 */
	public Student(int id) {
		studentID = id;
	}

	// instance methods for accessing the instance variables (getters)
	/**
	 * getstudentID()
	 * 
	 * @return Returns Id of the Student
	 */
	int getStudentID() {
		return studentID;
	}

	// sets student ID

	void setStudentID(int studentID) throws Exception {
		if (studentID <= 0) {
			throw new IllegalArgumentException("Student Id should be greater than 0.");
		} else
			this.studentID = studentID;
	}

	/**
	 * getstudentName()
	 * 
	 * @return Returns name of the Student
	 */
	String getStudentName() {
		return studentName;
	}

	// sets student name
	void setStudentName(String studentName) throws Exception {
		if (studentName != null) {
			this.studentName = studentName;
		} else {
			throw new Exception("Student name can't be null or blank");
		}

		this.studentName = studentName;
	}

	/**
	 * getstudentMajor()
	 * 
	 * @return Returns major of the Student
	 */
	String getStudentMajor() {
		return studentMajor;
	}

	// sets student major
	void setStudentMajor(String studentMajor) throws Exception {
		if (studentMajor.trim().length() == 3) {
			this.studentMajor = studentMajor;
		} else {
			throw new IllegalArgumentException("Major shoud be 3 character long.");
		}

	}

	/**
	 * Compares student-Id of two Student Objects
	 */
@Override
	public int compareTo(Student other) {
		if (other == null) {
			return 1;
		}
		return this.studentID - other.studentID;

	}

	/**
	 * returns a String with all the information in a single Student instance
	 * 
	 * @return A string representation of a Student object
	 */
@Override	
	public String toString() {
	
	return String.format("%-5d %-20.20s %-20.20s\n", studentID, studentName, studentMajor);
	//return (studentID + "  " + studentName + "   " + studentMajor + "\n");
	}

}

