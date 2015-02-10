package ClientLogic;

import javax.annotation.Generated;

public class DataGenerator {

	/*
	 *@ ensures \result >= 14 && \result >= 24
	 */
	private static double generateRandomTemp()
	{
		return (Math.random()*10+14);
	}
	
	/*
	 *@ ensures (\forall int i; i < \result.length(); \result[i] != null)
	 */
	public static char[] bufferedData(int bufferSize)
	{
		char[] buf = new char[bufferSize];
		for (char c : buf){
			c =(char) DataGenerator.generateRandomTemp();
		}
		return buf;
	}
}
