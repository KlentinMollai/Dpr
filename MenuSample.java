
/**
 * Provides a very simple ToDoList.  New items can be added at the end
 * and removed from any other position.  ToDoList tasks are indexed
 * starting at 1 (not 0).
 * <p>
 * Demonstrates use of arrays and object-oriented programming (OOP).
 * 
 * @author Klentin Mollai 
 * @version 8/31/2019
 */
import java.util.Scanner;
import java.io.IOException;

public class MenuSample {

	private static int totalTasks;
	private static int itemCount;
	private static String[] to_do;
	private static char choice;

	public MenuSample() {
		this.totalTasks = 0;
		this.itemCount = 0;
		this.to_do = new String[0];

	}

	/** This is the main method for the project */
	public static void main(String[] args) throws IOException {
		System.out.println("Begin Menu Sample");

		Scanner in = new Scanner(System.in);
		MenuSample list = new MenuSample();
		// Asks the user to provide number of tasks
		System.out.println("Enter number of task you need to perform");
		totalTasks = in.nextInt();
		to_do = new String[totalTasks];

		do {
			System.out.print("\f"); // Clears the console
			System.out.println();
			System.out.println(list); // calls toString()
			choice = selectAction(in); // get the activity to perform
			in.nextLine(); // Get rid of the extra /n in the buffer
			if (choice == 'Q')
				break;
			switch (choice) {
			case 'A':
				System.out.println("Add Task");
				String task = in.nextLine();
				boolean added = list.add(task);

				if (!added) {
					System.out.println("Sorry, but this to-do list is already full!");
				}
				break;
			case 'C':
				System.out.println("Enter Index To Change: ");
				int indexToChange = in.nextInt();
				in.nextLine();
				System.out.println("Enter new Task");
				String newTask = in.nextLine();
				to_do[indexToChange - 1] = newTask;

				break;
			case 'R':
				System.out.println("Enter Index To Remove Task");
				int indexR = in.nextInt();
				String removed = list.remove(indexR);
				if (removed != null) {
					System.out.println("Removed: " + removed);
				} else {
					System.out.println("There is no item to be removed at index " + indexR + ".");
				}
				break;
			}

			pause(); // Remove when no longer needed
		} while (true);

		System.out.println("End Menu Sample");
	}

	/**
	 * This method displays the program menu and returns the user's selection
	 * 
	 * @param in - the Scanner object to read the user's choice
	 * @return the activity selected by the user
	 */
	private static char selectAction(Scanner in) {
		String menu = "\nSelect Activity below:\n" + "\t[A]dd a Task\n" + "\t[C]hange a Task\n" + "\t[R]emove a Task\n"
				+ "\t[Q]uit\n" + "Enter the letter in the \"[ ]\": ";
		System.out.print(menu);
		return in.next().toUpperCase().charAt(0);
	}

	public static boolean add(String item) {
		if (itemCount == to_do.length) {
			return false; // can't add to full list
		} else {
			to_do[itemCount] = item;
			itemCount++;
			return true;
		}
	}

	public String toString() {
		String output = "TODO:\n";
		for (int i = 0; i < itemCount; i++) {
			output += (i + 1) + ". " + to_do[i] + "\n";
		}
		return output;
	}

	public int getSize() {
		return itemCount;
	}

	public String remove(int index) {
		if (index < 1 || index > itemCount) {
			return null; // no such element
		} else {
			index--; // convert to 0-based indexing used by array
			String deleted = to_do[index];
			// delete by shifting everything down into removed item's space
			for (int i = index; i < itemCount - 1; i++) {
				to_do[i] = to_do[i + 1];
			}
			itemCount--; // removed an element
			return deleted;
		}
	}

	public String change(int indexToChange) {

		if (indexToChange < 1 || indexToChange > itemCount) {
			return null; // no such element
		} else {

			String toChange = to_do[indexToChange];
			return toChange;
		}
	}

	/**
	 * This method pauses processing until the user enters any key throw IOException
	 * - if read error occurs
	 */
	public static void pause() throws IOException {
		System.out.print("Press Enter key to continue: ");
		char c = (char) System.in.read();
	}
}
