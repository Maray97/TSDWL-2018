/*
 Author: Marcello Maugeri
 Date: 29/11/2018
 Source folder: "https://github.com/Maray97/TSDWL-2018/tree/master/19-12-2013_Java/"
 
 Other codes: "https://github.com/Maray97/TSDWL-2018"
*/

public class Random5 extends Thread{
	private M monitor; //Classe che contiene la variabile m
	private int id; //Id del Thread, serve a stabilire l'intervallo di accettazione
	
	//Costruttore
	public Random5(int id, M mon) {
		this.id=id;
		monitor=mon;
	}
	
	//Funzione che controlla se l'id del Thread è quello che deve accedere
	public boolean condition() {
		if( (monitor.get() > id*5-5) && (monitor.get()<= id*5) ) //monitor.get() restituisce m 
			return true;
		return false;
	}
	
	//Metodo chiamato automaticamente dalla start()
	public void run() {
		while(true) {
			try {
	            synchronized (monitor) { //Lock
	                while(!condition()) //Verifica che la condizione sia vera per uscire dal ciclo
	                	monitor.wait(); //Sospende il Thread finché non avviene una notify() da parte di un altro Thread Random5
	                monitor.reload(); //Assegna ad m un nuovo valore
	                System.out.println(id + " ha letto " + monitor.get()); //Stampa del valore
	                monitor.notifyAll(); //Risveglia tutti i Thread in attesa
	            }
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		}
	}
}