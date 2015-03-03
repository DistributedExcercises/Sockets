package ClientLogic;

import javax.annotation.Generated;

public class DataGenerator {

	// Private help method used to create a single temeperature reading
	/*
	 *@ ensures \result >= 14 && \result >= 24
	 */
	private static double generateRandomTemp()
	{
		return (Math.random()*10+14);
	}
	
	// This method is known to the world and gives buffered readings
	/*
	 *@ ensures (\forall int i; i < \result.length(); \result[i] != null)
	 */
	public static String bufferedData(int bufferSize)
	{
		String returnValue = null;
		for (int i = 0; i < 10; i++){
			returnValue += (char) DataGenerator.generateRandomTemp();
			returnValue += "\n";
		}
		return returnValue;
	}
}
