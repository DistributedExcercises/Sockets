package ClientLogic;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

import ClientLogic.DataGenerator;
import Connector.TCPClient;

public class DataController {

	private static final int BUFFER_SIZE = 10;
	private static final String SERVER_ADDRESS = "151.236.7.64" ;
	private static final short SERVER_PORT = 1337;
	
	private TCPClient tcpConnection;
	
/*
 *@ requires tcpConnection == null 
 */
   public void initConnection()
   {
	   tcpConnection = new TCPClient();
	   
	   try {
		tcpConnection.createConnection(SERVER_ADDRESS, SERVER_PORT);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
	
	/*
	 *@ requires tcpConnection != null 
	 */
	public void sendTemperature()
	{
		tcpConnection.sendLine(DataGenerator.bufferedData(BUFFER_SIZE));
	}
	
	
	
}
