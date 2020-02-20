package coin_toss_demo;


/**
 * Program stimulates fliping of 7 coins with value 
 * randomly provided from an array of values in cents
 * displays the sum of just heads.
 *
 * @author (Klentin Mollai)
 * @version (CoinToss 9/20/2019)
 */

import java.util.Random;

public class CoinToss 
{

	public static void main(String[] args) 
	{

		AlCoin[] arrCoin = new AlCoin[7];
		int[] coinValue = { 1, 2, 5, 10, 20, 50, 100 };
		int sum = 0;
		Random gen = new Random();

		for (int i = 0; i < arrCoin.length; i++) 
		{
			AlCoin coin = new AlCoin(coinValue[gen.nextInt(7)]);
			arrCoin[i] = coin;
			coin.flip();
			if (coin.isHead()) 
			{
				sum = sum + coin.getValue();
			}
			System.out.println(coin.toString());

		}

		System.out.println("Total value of heads is: " + sum);

	}

}

