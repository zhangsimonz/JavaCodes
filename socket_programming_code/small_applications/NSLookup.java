/**
 * Lab 3 & 4 question 1
 * By Hua Zhang 1447636
 */
import java.net.InetAddress;
import java.net.UnknownHostException;

public class NSLookup {
	public static void main(String[] args) {
		try {
			if (args.length != 0) {
				InetAddress address = InetAddress.getByName(args[0]);
				System.out.println("Hose name: " + address.getHostName());
				System.out.println("IP address: " + address.getHostAddress());
			} else {
				System.out.println("Please give a host name");
			}
		} catch (UnknownHostException e) {
			System.out.println("Could not find " + String.valueOf(args[0]));
		}
	}
}
