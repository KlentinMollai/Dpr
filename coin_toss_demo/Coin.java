package coin_toss_demo;


/**
 * Class Coin flips the coin and randomly 
 * returns heads or tails and checks if is heads .
 *
 * @author (Klentin Mollai)
 * @version (Coin 9/20/2019)
 */
import java.util.Random;

public class Coin {
	
	private boolean face;
	Random gen = new Random();
	
	//No-arg Constructor method:
	   public Coin()
	   {
	      face = false;
	      
	   }	
	   
	 //Flip the coin
	   public void flip()
	   {
	      face = gen.nextBoolean();
	   }
	 //checks and returns boolean value of face  
	   public boolean isHead() 
	   {
		   return(face);
	   }
	   
	 //returns string based on value of face
	   public  String toString()
	   {
	      if(face)
	         return "Heads";
	      return "Tails";
	   }

}