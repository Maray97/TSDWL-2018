/*
 Author: Marcello Maugeri
 Date: 06/11/2018
 Source folder: "https://github.com/Maray97/TSDWL-2018/tree/master/23-04-2018/"
 
 Other codes: "https://github.com/Maray97/TSDWL-2018"
*/


package pack;
import java.io.*;

public class C extends B{
	protected int requestNumber;
	public C(int port){
		super(port); //Calling B constructor
		requestNumber=0;
	}
	
	public void run(){
		try {
			while((clientSocket = serverSocket.accept()) != null) { //Waiting for a request
				inputStream = new InputStreamReader(clientSocket.getInputStream()); //Preparing to receive a message
				input = new BufferedReader(inputStream);
				buffer=input.readLine(); //Reading client message
				System.out.println(buffer); //Printing client message
				outputStream = new OutputStreamWriter(clientSocket.getOutputStream()); //Preparing to send back a message
				bufferWriter = new BufferedWriter(outputStream);
				output = new PrintWriter(bufferWriter, true);
				buffer=(++requestNumber)+","+sommacifre(buffer); //Creating the message: request number and sommacifre() result
				output.println(buffer); //Sending back the message
				clientSocket.close(); //Closing the channel
			}
		} catch(IOException e) {
			System.out.println("Error " + e); //Printing possible error
		}
	}

	protected int sommacifre(String s) { //Function that returns 0
		return 0;
	}
}