package coin_toss_demo;


/**
 * AlCoin class inherites from Coin class 
 * and provides value to the coin.
 *
 * @author (Klentin Mollai)
 * @version (AlCoin 9/20/2019)
 */

public class AlCoin extends Coin 
{
    public int value;

    public AlCoin(int val) // constructor that takes an integer parameter
    {
        super();       //calls calls superclass costructor
        value = val;
    }
    //return the value
    public int getValue() {
        return value;
    }
    //sets the value
    public int setValue(int value) {
        return value;

    }
    //return superclass toString and the value
    public String toString()
    {

        return super.toString() + "\t"+ value + "\n";
    }


}
