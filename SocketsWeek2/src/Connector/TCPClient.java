package Connector;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {
	
	/*
	 *  Class to create a connection to server and be able to send data to server
	 *  ! one way connection
	 */
	
	private final static short CONNECTION_ATTEMPTS = 10;
	private final static short CONNECT_INTERVAL_MS = 1000;

	private Socket clientSocket;
	private BufferedReader inFromServer;
	private DataOutputStream outToServer;
	
	/*
	 *@ requires clientSocket == null;
	 *@ ensures clientSocket != null || triedAttempts >= 9
	 */
	public void createConnection(String serverAddress, short serverPort) throws Exception
	{
		short triedAttempts = 0;
		while(clientSocket == null && triedAttempts < 10){
			try {
				clientSocket = new Socket(resolveIP(serverAddress), serverPort);	
				triedAttempts++;
				Thread.sleep(CONNECT_INTERVAL_MS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	/*
	 *@ requires serverAddress 
	 * TODO check validity of serverAddress string
	 */
	private InetAddress resolveIP(String serverAddress)
	   {
		try {
			   return InetAddress.getByName(serverAddress);
		   } catch (UnknownHostException e) {
			   e.printStackTrace();
		   }
		   return null;
	   }
	
	/*
	 *@ requires data.length() != null;
	 * TODO vi ved ikke hvordan vi bekræfter message sent
	 */
	public void sendLine(String data)
	{
		try {
			outToServer = new DataOutputStream(clientSocket.getOutputStream());
			outToServer.writeBytes(data);
			outToServer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 *@ requires clientSocket != null;
	 *@ ensures clientSocket == null;
	 */
	public void closeConnection() throws Exception
	{
		try {
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
