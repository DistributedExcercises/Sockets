package ServerLogic;

import java.io.BufferedReader;
import java.io.IOException;

import ServerConnector.TCPServer;

public class DataController {


	private int numberOfReadings = 0;
	private double mean;
	
	public void readLine() throws IOException{
		TCPServer server = new TCPServer();
		BufferedReader inFromSensor = null;
		
		while (inFromSensor == null) {
			inFromSensor = server.listenToClient();
		}
		while (inFromSensor != null){
			String currentTemps = inFromSensor.readLine();
			String[] lines = currentTemps.split(System.getProperty("line.separator"));
			
			int lineCount = 0;
			int tempSum = 0;
			for (String str : lines) {
				System.out.println(str);
				lineCount++;
				tempSum += Double.valueOf(str);
			}
			// Update mean temperature
			updateMean(tempSum, lineCount);
		}
		
	}
	
	private void updateMean(double tempSum, int lineCount) {
		double newMean = ((mean*numberOfReadings)+(tempSum)) / (numberOfReadings+lineCount);
		numberOfReadings += lineCount;
		mean = newMean;
	}
}
