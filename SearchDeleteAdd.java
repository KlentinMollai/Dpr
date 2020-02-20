
/**
 * This program sorts, binary searches, adds and deletes array element
 * 
 * @author Klentin Mollai 
 * @version 10/8/2019
 */
import java.util.Arrays;
import java.util.Scanner;

public class SearchDeleteAdd {
	/**
	 * Initializes an array of 15 and randomly fills first 10 elements partially
	 * sorts it and prompts the user to search for an element add it or delete it
	 */

	public static void main(String[] args) {

		int currentSize = 10;
		Scanner in = new Scanner(System.in);
		int[] array = new int[15];
		int capacity = array.length;
		for (int i = 0; i < currentSize; i++) 
		{
			array[i] = (int) (Math.random() * 100);
		}
		System.out.println(Arrays.toString(array));
		partSort(array, 15, 0, currentSize - 1);
		System.out.println(Arrays.toString(array));

		boolean done = false;
		while (!done) {
			System.out.print("\nEnter number to search for, -1 to quit: ");
			int key = in.nextInt();
			if (key == -1)
				done = true;
			int pos = Arrays.binarySearch(array, 0, currentSize, key);
			if (pos >= 0 && array[pos] == key) 
			{
				System.out.println("Found in position " + pos);
				System.out.println("Would you like to remove it? ");

				if (YorN(in)) 
				{
					currentSize = deleteElement(array, currentSize, key);
					for (int i = 0; i < currentSize; i++)
						System.out.print(array[i] + " ");
				}
			}
			
	
		          if (pos >= 0 )//&& array[pos] != key) 
			{
				    System.out.println("Not found!");
				    System.out.println("Would you like to add it at position " + (pos+1));

				if (YorN(in)) 
				{
					currentSize = insertSorted(array, currentSize, key, capacity);
					for (int i = 0; i < currentSize; i++)
						System.out.print(array[i] + " ");
				}
			}
				else 
				System.out.println("End of SearchDeleteAdd Demo. ");
		}
	}
	
	/**
	 * Deletes a value in a range of a sorted array, using the binary search
	 * algorithm. *
	 * 
	 * @param arr     the array in which to search
	 * @param n    current array size
	 * @param user input
	 * @param capacity array.length  
	 * @return size of array after inserting element
	 */

	static int insertSorted(int arr[], int n, int key, int capacity) {
		// Cannot insert more elements if n is already
		// more than or equal to capacity
		if (n >= capacity)
			return n;

		int i;
		for (i = n - 1; (i >= 0 && arr[i] > key); i--)
			arr[i + 1] = arr[i];

		arr[i + 1] = key;

		return (n + 1);
	}
	/**
	 * Deletes a value in a range of a sorted array, using the binary search
	 * algorithm. *
	 * 
	 * @param arr     the array in which to search
	 * @param n    current array size
	 * @param user input  
	 * @return size of array after deleting element
	 */

	static int deleteElement(int arr[], int n, int key) {
		// Find position of element to be deleted
		int pos = search(arr, 0, n - 1, key);

		if (pos == -1) {
			System.out.println("Element not found");
			return n;
		}

		// Deleting element
		int i;
		for (i = pos; i < n - 1; i++)
			arr[i] = arr[i + 1];

		return n - 1;
	}
	 
	/**
	 * Finds a value in a range of a sorted array, using the binary search
	 * algorithm. *
	 * 
	 * @param a     the array in which to search
	 * @param low   the low index of the range
	 * @param high  the high index of the range
	 * @param value the value to find
	 * @return the index at which the value occurs, or -1 if it does not occur in
	 *         the array
	 */
	public static int search(int[] a, int low, int high, int value) {
		int pos = -1;
		if (low <= high) {
			int mid = (low + high) / 2;
			if (a[mid] == value)
				return mid;
			if (a[mid] < value)
				return search(a, mid + 1, high, value);
			else
				return search(a, low, mid - 1, value);
		}

		if (pos == -1) { // the target is not in, find the position
			// to insert
			pos = low;
			while (pos < high && a[pos] < value)
				pos++;
			pos--; // insert after the position
		}

		return pos;
	}

	/**
	 * This method sorts an array, using selection sort.
	 * 
	 * @param a - reference to the array to sort
	 */
	public static void sort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int minPos = minimumPosition(a, i);
			swap(a, minPos, i);
		}
	}

	/**
	 * Finds the smallest element in a tail range of the array. *
	 * 
	 * @param a    - reference to the array being sorted
	 * @param from the first position in a to compare
	 * @return the position of the smallest element in the range a[from] . . .
	 *         a[a.length - 1]
	 */
	private static int minimumPosition(int[] a, int from) {
		int minPos = from;
		for (int i = from + 1; i < a.length; i++)
			if (a[i] < a[minPos])
				minPos = i;
		return minPos;
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	/**
	 * Partially sorts the array
	 * @param arr    the array in which to search
	 * @param a   the low index of the range
	 * @param b  the high index of the range
	
	 */        
	static void partSort(int[] arr, int N, int a, int b) {
		// Variables to store start and end of the index range
		int l = Math.min(a, b);
		int r = Math.max(a, b);

		// Temporary array
		int[] temp = new int[r - l + 1];
		int j = 0;
		for (int i = l; i <= r; i++) {
			temp[j] = arr[i];
			j++;
		}

		// Sort the temporary array
		Arrays.sort(temp);

		// Modifying original array with temporary array elements
		j = 0;
		for (int i = l; i <= r; i++) {
			arr[i] = temp[j];
			j++;
		}

	}
	
	/**
	* This method requests a Y or N response from the user
	* It does not accept any value other than Y or N (upper or lower case)
	* @param in - Scanner object for user input
	* @return true if user enters a y, false if not
	*/
	private static boolean YorN(Scanner in)
	{
	char answer = in.next().toUpperCase().charAt(0);
	while (answer != 'Y' && answer != 'N')
	{
	System.out.print("Please resopnd only Y or N?: ");
	answer = in.next().toUpperCase().charAt(0);
	}
	return (answer == 'Y');
	}

}

