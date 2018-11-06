/*
 Author: Marcello Maugeri
 Date: 06/11/2018
 Source folder: "https://github.com/Maray97/TSDWL-2018/tree/master/23-04-2018/"
 
 Other codes: "https://github.com/Maray97/TSDWL-2018"
*/


package pack;
import java.io.*;

public class Main {

	public static void main(String[] args){
		A server;
		int choice=1;
		int port=3333; //Listening port
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Digit:\n1 - A class\n2 - B class\n3 - C class\n4 - D class");
		try {
			choice = Integer.parseInt(input.readLine());
		} catch(IOException e) {
			System.out.println("Error "+e); //Printing possible error
		}
		switch(choice) {
		case 1:
			server = new A(port);
			break;
		case 2:
			server = new B(port);
			break;
		case 3:
			server = new C(port);
			break;
		case 4:
			server = new D(port);
			break;
		default:
			System.out.println("Default A class");
			server = new A(port);
		break;
		}
		server.run(); //Starting server
	}
}