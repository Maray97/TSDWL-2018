/*
 Author: Marcello Maugeri
 Date: 29/11/2018
 Source folder: "https://github.com/Maray97/TSDWL-2018/tree/master/19-12-2013_Java/"
 
 Other codes: "https://github.com/Maray97/TSDWL-2018"
*/

public class Main {
	public static void main(String[] args) {
		//Classe monitor che contiene la variabile m. Il parametro in ingresso stabilisce il numero di Thread che verranno creati (Nel testo sono solo 2)
		M monitor = new M(2); 
		Random5 P1 = new Random5(1,monitor); //Thread 1
		Random5 P2 = new Random5(2,monitor); //Thread 2
		P1.start();
		P2.start();
	}
}