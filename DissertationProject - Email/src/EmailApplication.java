import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailApplication {

	
	 public static void sendEmailFromCustomer(String confirmEmail) {    

	      String to = confirmEmail.substring(5);															
	      String from = "Elenco.com";													
	      String host = "localhost";																		
	      
	      Properties properties = System.getProperties();												
	      properties.setProperty("mail.smtp.host", host);												

	      Session session = Session.getDefaultInstance(properties);											

	      try 
	      {
	
	         MimeMessage message = new MimeMessage(session);												

	         message.setFrom(new InternetAddress(from));													
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));						

	         message.setSubject("Welcome To Elenco");															
	         message.setText("Here is your code to confirm your email for your new Elenco account: " + confirmEmail.substring(0,5));														

	         Transport.send(message);																		
	         
	         System.out.println("Successfully Sent message");
	         
	      } 
	      catch (MessagingException mex) 
	      {
	         mex.printStackTrace();
	      }
	   }

	 

	 
	 public static String recievedMessageFromCustomer() {
		
		 try
		 {
			
			System.out.println("Elenco Email Server");
			int port = Integer.parseInt("3");
			ServerSocket server = new ServerSocket(port);																	
			Socket sock = server.accept();																					
			
			System.out.println("Waiting For Connection");
			
			InputStream inputStream = sock.getInputStream();																
	        DataInputStream dataInputStream = new DataInputStream(inputStream);												

	        String message = dataInputStream.readUTF();																		
	        System.out.println("The message recieved: \n" + message + "\n");
			
			DataOutputStream network = new DataOutputStream(sock.getOutputStream());										

			sendEmailFromCustomer(message);																								
			
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
	 
	 public static String recievedMessageFromAdmin() {
			
		 try
		 {
			
			System.out.println("Elenco Email Server");
			int port = Integer.parseInt("4");
			ServerSocket server = new ServerSocket(port);																	
			Socket sock = server.accept();																					
			
			System.out.println("Waiting For Connection");
			
			InputStream inputStream = sock.getInputStream();																
	        DataInputStream dataInputStream = new DataInputStream(inputStream);												

	        String message = dataInputStream.readUTF();																		
	        System.out.println("The message recieved: \n" + message + "\n");
			
			DataOutputStream network = new DataOutputStream(sock.getOutputStream());										

			sendEmailFromAdmin(message);																								
			
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
	 
	 public static void sendEmailFromAdmin(String email) {    

	      String to = "customer@email.co.uk";															
	      String from = "Elenco.com";													
	      String host = "localhost";																		
	      
	      Properties properties = System.getProperties();												
	      properties.setProperty("mail.smtp.host", host);												

	      Session session = Session.getDefaultInstance(properties);											

	      try 
	      {
	
	         MimeMessage message = new MimeMessage(session);												

	         message.setFrom(new InternetAddress(from));													
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));						

	         message.setSubject("Welcome To Elenco");															
	         message.setText(email);														

	         Transport.send(message);																		
	         
	         System.out.println("Successfully Sent message");
	         
	      } 
	      catch (MessagingException mex) 
	      {
	         mex.printStackTrace();
	      }
	   }
	
	
	
}
