import java.io.*;

public class Main {

	public static void main(String[] args) {
		int choice=0,port=3233;
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Digita:\n0 per Client\n1 per Server singolo\n2 per Multiserver");
		try {
			choice = Integer.parseInt(input.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(choice==0) {
			Client C = new Client(port);
			C.run();
		} else if(choice==1) {
			Server S = new Server(port);
			S.run();
		} else if(choice==2) {
			Multiserver M = new Multiserver(port);
		} else {
			System.out.println("Scelta non valida, chiusura in corso...");
		}
	}
}