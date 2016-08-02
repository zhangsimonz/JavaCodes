import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Lab 3 & 4 question 3 client side
 * By Hua Zhang 1447636
 */
public class TimeClient {
	public static void main (String[] args) throws Exception{
		Socket client = new Socket("localhost", 5000);
		DataInputStream dis = new DataInputStream(client.getInputStream());
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		
		dos.writeUTF("Time request");
		
		// accepting the long type value from server then converting it to a format below
		long tempDate = dis.readLong();
		Date serverDate = new Date(tempDate);
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY HH:mm a");
		String formattedDate = dateFormat.format(serverDate);
		
		System.out.println("System time: " + formattedDate.toString());
		client.close();
	}
}
