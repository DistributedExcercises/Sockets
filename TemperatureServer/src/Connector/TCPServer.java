package Connector;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPServer {
	
	/*
	 *  Class to receive data from a single sensor
	 */
	
	private final static short PORT_NUMBER = 2342;

	private ServerSocket serverSocket;
	
	public TCPServer() {
		try {
			serverSocket = new ServerSocket(PORT_NUMBER);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 *@ requires data.length() != null;
	 * TODO vi ved ikke hvordan vi bekræfter message sent
	 */
	public BufferedReader listenToClient()
	{
		BufferedReader dataFromClient = null;
		try {
			Socket clientConnection = serverSocket.accept();
			dataFromClient = new BufferedReader(new InputStreamReader(clientConnection.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dataFromClient;
	}
	
	/*
	 *@ requires clientSocket != null;
	 *@ ensures clientSocket == null;
	 */
	public void closeConnection() throws Exception
	{
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
