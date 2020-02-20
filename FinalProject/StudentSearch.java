/**
 * StudentSearch class allows user to search,add,remove student object using BibarySearchTree
 * with selectionAction method provided 
 * It also allows user to list student objects by Major.
 * 
 * @author Klentin Mollai
 * @version 12/05/2019
 */
package FinalProject;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.lang.Exception;

public class StudentSearch {

	public static void main(String[] arg) throws Exception {
		System.out.println("\tBegin StudentSearch program\n");

		System.out.println("Welcome to Student Database.\n");
		System.out.println("Id    Name                 Major");
		System.out.println("__________________________________");
		Student student = new Student();
		Scanner in = new Scanner(System.in);
		char choice;
		boolean done = false;

		try {

			/**
			 * Initializes an empty tree and fills it with five objects
			 */
			BinarySearchTree tree = new BinarySearchTree();
			tree.add(new Student(3, "John Smith", "MAT"));
			tree.add(new Student(2, "Adam Yong", "DPR"));
			tree.add(new Student(5, "Ben Douglas", "PHY"));
			tree.add(new Student(1, "Eli Bakingoff", "DPR"));
			tree.add(new Student(4, "Zed Ink", "DPR"));
			tree.print();

			do {
				try {
					System.out.print("\f"); // Clears the console
					choice = selectAction(in); // get the activity to perform
					in.nextLine(); // Get rid of the extra /n in the buffer

					switch (choice) {

					case 'Q':
						done = true;
						System.out.print("\f");
						tree.print();
						break;
					default:
						throw new Exception("Invalid Selection");

						/**
						 * Prompts user to enter id to search for student add it if not found and remove
						 * if found.
						 */
					case 'S':
						System.out.print("\nEnter Id number to search Student database");
						int id = in.nextInt();
						student.setStudentID(id);
						Comparable<Student> searchStudent = tree.find(new Student(id));
						if (searchStudent == null) {

							System.out.println("Student not found");
							System.out.println("Would you like to add it to DataBase [Y]es or [N]o");
							if (YorN(in)) {
								tree.add(new Student(student.getStudentID(), "Klentin Mollai", "DPR"));
								tree.print();
							}

						} else {
							System.out.println(searchStudent);
							System.out.println("Student found! Remove? [Y]es or [N]o ");
							if (YorN(in)) {
								tree.remove(new Student(id));
								tree.print();
							}
						}
						break;
					/**
					 * Lists all students of the same major.
					 */
					case 'L':
						System.out.println("Enter a major to list all students in that major");
						String major = in.next().toUpperCase();
						student.setStudentMajor(major);
						ArrayList<Object> list = new ArrayList<Object>();
						list = tree.getList();
						for (Object obj : list) {
							Student st = (Student) obj;
							if (st.getStudentMajor().equals(major)) {
								System.out.println(st.toString());
							}
						}
						break;

					}
				} catch (Exception e) {
					System.out.println(e.getMessage());

				}
			} while (!done);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {

			in.close();
		}

		System.out.println("End Student Search");

	}

	/**
	 * This method displays the program menu and returns the user's selection
	 * 
	 * @param in - the Scanner object to read the user's choice
	 * @return the activity selected by the user
	 */
	private static char selectAction(Scanner in) {
		String menu = "\nSelect Activity below:\n" + "\t[S]earch a Student\n" + "\t[Q]uit\n"
				+ "\t[L]ist Students by  Major\n" + "Enter the letter in the \"[ ]\": ";
		System.out.print(menu);
		return in.next().toUpperCase().charAt(0);
	}

	/**
	 * This method requests a Y or N response from the user It does not accept any
	 * value other than Y or N (upper or lower case)
	 * 
	 * @param in - Scanner object for user input
	 * @return true if user enters a y, false if not
	 */
	private static boolean YorN(Scanner in) {
		char answer = in.next().toUpperCase().charAt(0);
		while (answer != 'Y' && answer != 'N') {
			System.out.print("Please resopnd only Y or N?: ");
			answer = in.next().toUpperCase().charAt(0);
		}
		return (answer == 'Y');
	}

	/**
	 * This method pauses processing until the user enters any key
	 * 
	 * @throw IOException, if read error occurs
	 */
	private static void pause() throws IOException {
		System.out.print("Press Enter key to continue: ");
		char c = (char) System.in.read();
	}

}