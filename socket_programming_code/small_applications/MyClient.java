/**
 * Lab 3 & 4 question 2 MyClient.java
 * By Hua Zhang 1447636
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class MyClient {
	public static void main(String[] args) throws Exception {
		Socket s = new Socket("localhost", 5000);
		DataInputStream dinput = new DataInputStream(s.getInputStream());
		DataOutputStream doutput = new DataOutputStream(s.getOutputStream());

		doutput.writeUTF("Hello"); 
		String str2 = dinput.readUTF(); /// assume that the server will return a message
		System.out.println("Message received from Server: " + str2);
		
		doutput.close();
		s.close();
	}
}
/// for some reasons it doesn't work, and keep telling me that the connection is refused, I think there are some setting not right on my computer