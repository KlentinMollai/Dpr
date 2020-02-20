import java.util.Arrays;

public class ArrayUtil {

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
			ArrayUtil.swap(a, minPos, i);
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
	
	

	 void partSort(int[] arr, int N, int a, int b) {
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

}
