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

/**
 * <h1> Class </h1>
 * 
 * <p>
 * Utility Layer of the Tiered architecture structure.
 * </p>
 * 
 * <p>
 * EmailServices
 * </p>
 * 
 * <p>
 * A class for housing methods involved in creating a socket connection with the Elenco Email server. 
 * <br> This is so confirm code Emails can be sent to users during account creation to verify the email is valid and legitimate.
 * <br> The final function is to randomly generate the confirm codes that are sent in the email.
 * </p>
 * 
 */
public class EmailServices {
	
	// Variables
	
	private static Socket sock;

	/**
	 * <h1> Method </h1>
	 * <p>
	 * To 'listen' on determined port for response from email server.
	 * <br> When a response is detect, accept the response and unpack the <code>String</code> sent from server. 
	 * <br> This response then can be used in a meaningful way.
	 * </p>
	 * 
	 * @see String
	 * @see EmailServices
	 */
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
	 

		/**
		 * <h1> Method </h1>
		 * <p>
		 * To send parameter(email) to email server so it can be sent to new account.
		 * </p>
		 * <p>
		 * Parameter is the email address, message and confirm code. A <code>String</code> object is used to store the data.
		 * </p>
		 * 
		 * @param confirmEmail					<code>String</code> object to store email info.
		 * 
		 * @see String
		 * @see EmailServices
		 */
	
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
	
	/**
	 * <h1> Method </h1>
	 * <p>
	 * To randomly generate a 5 digit String. Used as the confirm code on an email
	 * </p>
	 * 
	 *
	 * @see String
	 * @see EmailServices
	 */
	
	public static String randomConfirmCode() {
	  
		int randomNumber;
		String randomCode;
		
	    Random random = new Random();
	    randomNumber = random.nextInt(100000);
	    randomCode = String.format("%05d", randomNumber);

	    return randomCode;
	        
	}

}
