import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Lab 3 & 4 question 3 server side
 * By Hua Zhang 1447636
 */
public class TimeServer {
	public static void main (String[] args) throws Exception{
		ServerSocket serverSocket = new ServerSocket(5000);
		Socket socket = serverSocket.accept();
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		
		// writing the data output stream value to long type
		if (dis.readUTF() != null){
			dos.writeLong(System.currentTimeMillis());
		}
		serverSocket.close();
		socket.close();
	}

}
