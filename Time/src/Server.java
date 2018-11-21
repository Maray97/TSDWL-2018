import java.util.*;
import java.io.*;
import java.net.*;

public class Server {
	ServerSocket socket;
	Socket clientSocket;
	int port;
	InetAddress last;
	LinkedList<InetAddress> bannedList;
	
	public Server(int port) {
		this.port=port;
		try {
			socket = new ServerSocket(port);
			bannedList = new LinkedList<InetAddress>();
			last=InetAddress.getLoopbackAddress();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		try {
			while((clientSocket = socket.accept()) != null) {
				System.out.println("Connessione instaurata");
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
				output.close();
				bw.close();
				os.close();
				br.close();
				is.close();
				clientSocket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}