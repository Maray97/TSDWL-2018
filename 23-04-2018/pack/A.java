/*
 Author: Marcello Maugeri
 Date: 06/11/2018
 Source folder: "https://github.com/Maray97/TSDWL-2018/blob/master/23-04-2018/"
 
 Other codes: "https://github.com/Maray97/TSDWL-2018"
*/


package pack;
import java.io.*;
import java.net.*;

public class A {
	protected ServerSocket serverSocket; //Server socket
	protected Socket clientSocket; //Client socket
	protected InputStreamReader inputStream;
	protected BufferedReader input;
	protected String buffer; //Messages buffer
	
	public A(int port) {
		try {
			serverSocket=new ServerSocket(port); //Opening a stream socket
		} catch(IOException e) {
			System.out.println("Error " + e); //Printing possible error
		}
	}
	public void run(){
		try {
			while((clientSocket = serverSocket.accept()) != null) { //Waiting for a request
				inputStream = new InputStreamReader(clientSocket.getInputStream()); //Preparing to receive a message
				input = new BufferedReader(inputStream);
				buffer=input.readLine(); //Reading client message
				System.out.println(buffer); //Printing client message
				clientSocket.close(); //Closing the channel
			}
		} catch(IOException e) {
			System.out.println("Error " + e); //Printing possible error
		}
	}
}