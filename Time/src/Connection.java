import java.io.*;
import java.net.*;
import java.util.LinkedList;

public class Connection extends Thread{
	static InetAddress last = InetAddress.getLoopbackAddress();
	static LinkedList<InetAddress> bannedList = new LinkedList<InetAddress>();
	Socket clientSocket;
	
	public Connection(Socket socket) {
		clientSocket = socket;
		this.start();
	}
	
	public void run() {
		try {
			while(true) {
				InputStreamReader is = new InputStreamReader(clientSocket.getInputStream());
				BufferedReader br = new BufferedReader(is);
				String buf = br.readLine();
				System.out.println("Ricevuto comando: "+buf);
				if(last.equals(clientSocket.getInetAddress()))
					bannedList.add(clientSocket.getInetAddress());
				if(bannedList.contains(clientSocket.getInetAddress())){
					buf = "BANNED";
				} else if(buf.equals("TIME")) {
						buf=String.valueOf(System.currentTimeMillis());
				} else {
					buf="N/A";
				}
				last=clientSocket.getInetAddress();
				OutputStreamWriter os = new OutputStreamWriter(clientSocket.getOutputStream());
				BufferedWriter bw = new BufferedWriter(os);
				PrintWriter output = new PrintWriter(bw,true);
				System.out.println("Sto inviando "+buf);
				output.println(buf);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
