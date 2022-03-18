import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Random;

public class EmailServices {
	
	private static Socket sock;
	
	
	 public static String recievedMessage() {
			
		 try
		 {
			
			System.out.println("Email Server");
			int port = Integer.parseInt("3");
			ServerSocket server = new ServerSocket(port);																	// Create server socket
			Socket sock = server.accept();																					// Accept 'client' connection and open server
			
			System.out.println("Waiting");
			
			InputStream inputStream = sock.getInputStream();																// Create input stream
	        DataInputStream dataInputStream = new DataInputStream(inputStream);												// Create data input stream

	        String message = dataInputStream.readUTF();																		// Set variable to message from 'client'
	        System.out.println("The message recieved: \n" + message + "\n");
			
			DataOutputStream network = new DataOutputStream(sock.getOutputStream());										// Create output data stream

			confirmEmail(message);																								// Call method to send email with parameter message
			
			network.writeUTF("Email sent.  Date: " + new Date() + "\n");													// Send message back to 'client'
			
			dataInputStream.close();																						// Close data input stream
			network.close();																								// Close output data stream
			sock.close();																									// Close socket
			server.close();																									// Close server
			
			return message;
			
		}
		catch (IOException ioe)
		{
			System.err.println("Error in I/O");
			System.err.println(ioe.getMessage());
			//System.exit(-1);
		}
		return null;
	}
	 
	// Method for setting up connection between 'client' and Email 'server' and allowing them to communicate through messages.
	
	public static void confirmEmail(String confirmCode){
		
		try
		{
			System.out.println("Client Program");
			String ip = "192.168.0.16";
			String port_string = "3";
			int port = Integer.parseInt(port_string);
			sock = new Socket(ip, port);																					// Create socket using ip address and port number variables to establish 'server'	
		
	        OutputStream outputStream = sock.getOutputStream();																// Create an output stream to the socket location
	        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);											// Create an output data stream	
			
	        dataOutputStream.writeUTF(confirmCode);																		// Create message to be sent to 'server'
	        dataOutputStream.flush();																						// Send message 	

			DataInputStream network = new DataInputStream(sock.getInputStream());											// Create input stream to receive message from 'server'
	
			String line;
			
			while ((line = network.readUTF()) != null)																		// Read every line of the received message
			{
				System.out.println(line);
			}
			
			dataOutputStream.close(); 																						// Close data output stream
		}
		
		catch (IOException ioe)
		{
			System.err.println("Error in I/O");
			System.err.println(ioe.getMessage());
		}
	}
	
	public static String randomConfirmCode() {
	  
		int randomNumber;
		String randomCode;
		
	        Random random = new Random();
	        randomNumber = random.nextInt(100000);
	        randomCode = String.format("%05d", randomNumber);
	       
	        
	       
	        
	        
	        
	        return randomCode;
	     
	    
	}

}
