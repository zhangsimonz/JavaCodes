/**
 * Lab 3 & 4 question 2 MyServer.java
 * By Hua Zhang 1447636
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
	public static void main(String args[]) throws Exception {
		ServerSocket ss = null;
		ss = new ServerSocket(5000);
		Socket s = ss.accept();
		DataInputStream dinput = new DataInputStream(s.getInputStream());
		DataOutputStream doutput = new DataOutputStream(s.getOutputStream());

		if (dinput.readUTF().equals("Hello")){
			doutput.writeUTF("Hi there, got your message!");
		} else {
			System.out.println("Got message, but incorrect - not Hello.");
		}
		s.close();
		ss.close();
	}
}
