import java.io.*;
import java.net.*;


public class Multiserver extends Thread{
	ServerSocket socket;
	int port;
	
	public Multiserver(int port) {
		this.port=port;
		try {
			socket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.start();
	}
	
	public void run() {
		try {
			while(true) {
				Socket client = socket.accept();
				Connection c = new Connection(client);
			}
		} catch(Throwable t) {
			t.printStackTrace(System.out);
		}
	}
}
