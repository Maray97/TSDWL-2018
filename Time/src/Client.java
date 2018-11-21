import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
	int port;
	public Client(int port) {
		this.port=port;
	}
	
	public void run() {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				String command = input.readLine();
				Socket serverSocket = new Socket(InetAddress.getLocalHost(), 3233);
				OutputStreamWriter osw = new OutputStreamWriter(serverSocket.getOutputStream());
				BufferedWriter bw = new BufferedWriter(osw);
				PrintWriter pw = new PrintWriter(bw, true);
				pw.println(command);
				InputStreamReader isr = new InputStreamReader(serverSocket.getInputStream());
				BufferedReader br = new BufferedReader(isr);
				command = br.readLine();
				Date orario = new Date(Long.parseLong(command));
				System.out.println("Orario: "+orario.toString());
				br.close();
				isr.close();
				pw.close();
				bw.close();
				osw.close();
				serverSocket.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}