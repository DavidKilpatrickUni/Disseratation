import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class AdminEmailServices {
	
	private static Socket sock;
	
	public static String recievedMessage() {
			
		try
		{
		
			System.out.println("Email Server");
			int port = Integer.parseInt("4");
			ServerSocket server = new ServerSocket(port);																	
			Socket sock = server.accept();																					
			
			System.out.println("Waiting");
			
			InputStream inputStream = sock.getInputStream();																
			DataInputStream dataInputStream = new DataInputStream(inputStream);												

			String message = dataInputStream.readUTF();																		
			System.out.println("The message recieved: \n" + message + "\n");
	    
			DataOutputStream network = new DataOutputStream(sock.getOutputStream());										

			sendEmail(message);																								
			
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
	 

	
	public static void sendEmail(String sendEmail){
		
		try
		{
			System.out.println("Client Program");
			String ip = "192.168.0.16";
			String port_string = "4";
			int port = Integer.parseInt(port_string);
			sock = new Socket(ip, port);																						
		
	        OutputStream outputStream = sock.getOutputStream();																
	        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);											
			
	        dataOutputStream.writeUTF(sendEmail);																		
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

}
