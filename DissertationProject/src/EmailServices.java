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
			ServerSocket server = new ServerSocket(port);																	
			Socket sock = server.accept();																					
			
			System.out.println("Waiting");
			
			InputStream inputStream = sock.getInputStream();																
	        DataInputStream dataInputStream = new DataInputStream(inputStream);												

	        String message = dataInputStream.readUTF();																		
	        System.out.println("The message recieved: \n" + message + "\n");
			
			DataOutputStream network = new DataOutputStream(sock.getOutputStream());										

			confirmEmail(message);																								
			
			network.writeUTF("Email sent.  Date: " + new Date() + "\n");													
			
			dataInputStream.close();																						
			network.close();																							
			sock.close();																									
			server.close();																									
			
			return message;
			
		}
		catch (IOException ioe)
		{
			System.err.println("Error in I/O");
			System.err.println(ioe.getMessage());

		}
		return null;
	}
	 

	
	public static void confirmEmail(String confirmEmail){
		
		try
		{
			System.out.println("Client Program");
			String ip = "192.168.0.16";
			String port_string = "3";
			int port = Integer.parseInt(port_string);
			sock = new Socket(ip, port);																						
		
	        OutputStream outputStream = sock.getOutputStream();																
	        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);											
			
	        dataOutputStream.writeUTF(confirmEmail);																		
	        dataOutputStream.flush();																						

			DataInputStream network = new DataInputStream(sock.getInputStream());										
	
			String line;
			
			while ((line = network.readUTF()) != null)																		
			{
				System.out.println(line);
			}
			
			dataOutputStream.close(); 																						
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
