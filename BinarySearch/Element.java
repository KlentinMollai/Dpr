
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Element extends ArrayUtil  {
	
	static int insertSorted(int arr[], int n, int key, int capacity) 
    { 
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
	
	 static int deleteElement(int arr[], int n, int pos) 
	    { 	  
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

	public static void main(String[] args) {

		int currentSize = 10;
		@SuppressWarnings("unused")
		Random gen = new Random();
		Scanner in = new Scanner(System.in);
		Element myElement = new Element();
		int[] array = new int[15];
		for (int i = 0; i < currentSize; i++) {
			array[i] = (int) (Math.random() * 100);
		}
		System.out.println(Arrays.toString(array));

		myElement.partSort(array, 15, 0, currentSize - 1);

		System.out.println(Arrays.toString(array));

		boolean done = false;
		while (!done) {
			System.out.print("Enter number to search for, -1 to quit: ");
			int input = in.nextInt();
			if (input == -1)
				done = true;
			else {
				int pos = ArrayUtil.search(array, 0, currentSize, input);
				if (pos >= 0 && array[pos] == input) {
					System.out.println("Found in position " + (pos + 1));
					System.out.println("Would you like to remove it? ");
					if (in.next().toUpperCase().charAt(0) == 'y')
						currentSize = deleteElement(array, currentSize, pos);
					    currentSize--;
					for (int i = 0; i < currentSize; i++)
						System.out.print(array[i] + " ");
				}
				if (pos >= 0 && array[pos] != input) {
					System.out.println("Not found!");
					System.out.println("Would you like to add it at position " + pos);
					if (in.next().toUpperCase().charAt(0) == 'y')
						currentSize = insertSorted(array, pos, input, currentSize);
					for (int i = 0; i < currentSize; i++)
						System.out.print(array[i] + " ");
				} 
				

				System.out.println("\n\tEnd Binary Search Demo\n");

			} 			
		}in.close();
	}
}


	
	
	


