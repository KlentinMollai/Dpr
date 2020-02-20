/**
 * Finds the total distance the worker travels to set the chairs, drill the
 * holes and set the umbrellas.
 * 
 * @param ChairSet     distance traveled to set 4 chairs
 * @param BChairSet    distance between two chair sets
 * @param UmbrellaSet  distance traveled to set 4 umbrellas
 * @param BUmbrellaSet distance between two umbrella sets
 * @param V1           distance between chair and storage area
 * @param V2           distance between umbrellas and storage area
 * @author Klentin Mollai
 *@version 10/16/2019
 */
public class BeachChair {

	static final int ChairSet = 11;
	static final double UmbrellaSet = 22.5;
	static final int BChairSet = 4;
	static final double BUmbrellaSet = 7.5;
	static final int V1 = 60;
	static final int V2 = 59;
/** Main method calculates distance traveled to set chairs, drill and set umbrellas
 * and displays the total distance the worker traveled.
 * @param tripofChairs  number of trips made to set chairs.
 * @param tripsOfUmbrellas number of trips made to set umbrellas.
 * @param chairRectBase half the distance between the first and last chair.
 * @param umbrellaRectBase half the distance between the first and last umbrella.
 * @param TotalTripOfChairs total distance traveled to set chairs.
 * @param TotalTripOfDrill total distance traveled to drill holes.
 * @param TotalTripOfUmbrellas total distance traveled to set umbrellas.
 * @param TotalTrip total distance to set chairs, umbrellas and drill holes together.
 */

	public static void main(String[] args) 
	{

		int tripsOfChairs = 10;
		int tripsOfUmbrellas = 5;
		int chairRectBase = 146 /2;
		double umbrellaRectBase = 142.5/2;
		System.out.println("Distance the worker traveled by trip to set chairs is: \n");
		double TotalTripOfChairs = chairTrip(tripsOfChairs, chairRectBase);
		System.out.printf("Total = %.2f feet.\n", TotalTripOfChairs);
		double TotalTripOfDrill = drillTrip(umbrellaRectBase);
		System.out.printf("\nDistance of drilling is: %.2f feet\n", TotalTripOfDrill);
		System.out.println("\nDistance the worker traveled by trip to set umbrellas is: ");
		double TotalTripOfUmbrellas = umbrellaDistance(tripsOfUmbrellas, umbrellaRectBase) ;
		System.out.printf("Total = %.2f feet.\n", TotalTripOfUmbrellas);
		double TotalTrip = TotalTripOfChairs + TotalTripOfDrill + TotalTripOfUmbrellas;
		System.out.printf("\nTotal distance of worker is: %.2f Miles", TotalTrip / 5280);

	}

	/**
	 * Calculates distance traveled setting up just chairs
	 * @param trip   number of trip it takes for worker to set the chairs
	 * @param rectBase half of rectangle length
	 * @return total chair setting distance traveled
	 */

	private static double chairTrip(int trip, int rectBase) 
	{

		if (trip <= 0)
			return 0;  
		
			double firstTrip = Math.hypot(rectBase, V1) + Math.hypot(rectBase - ChairSet, V1) + ChairSet;
			double chairDistance = firstTrip + chairTrip(trip - 1, rectBase - ChairSet - BChairSet);
			System.out.printf("Trip[%-1d] %.2f feet\n ", trip, firstTrip);
			return chairDistance;


	}

	/**
	 * Calculates distance traveled to set up 4 chairs at times
	 * 
	 * @param base half of total length of all chairs
	 * @return total chair setting distance traveled
	 */

	private static double drillTrip(double base) 
	{

		return (base + Math.hypot(base, V2)) * 2;

	}

	/**
	 * Calculates distance traveled setting up just half of umbrellas
	 * 
	 * @param base half of total length of umbrellas
	 * @return total umbrella setting distance traveled
	 */
	private static double umbrellaDistance(int trip, double rectBase) 
	{  	
		
		if (trip <= 0)
			return 0;  
		
			double firstTrip = Math.hypot(rectBase, V2) + 
					Math.hypot(rectBase - UmbrellaSet, V2) + UmbrellaSet;
			double umbrellaTrip = firstTrip + umbrellaDistance
					(trip - 1, rectBase - UmbrellaSet - BUmbrellaSet);
			System.out.printf("Trip[%-1d] %.2f feet\n ", trip, firstTrip);
			
			return umbrellaTrip;

		
	}

}
