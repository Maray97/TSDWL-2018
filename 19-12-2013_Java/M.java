/*
 Author: Marcello Maugeri
 Date: 29/11/2018
 Source folder: "https://github.com/Maray97/TSDWL-2018/tree/master/19-12-2013_Java/"
 
 Other codes: "https://github.com/Maray97/TSDWL-2018"
*/
import java.util.*;

public class M {
	private int m; //Variabile m
	private int numeroThread; //Numero di Thread da gestire
	private Random r; //Oggetto Random
	
	//Costruttore
	public M(int i) {
		numeroThread=i; 
		r = new Random();
		m = r.nextInt(numeroThread*5)+1;
	}
	
	//Metodo che assegna un nuovo valore casuale ad m
	public void reload() {
		m = r.nextInt(numeroThread*5)+1;
	}
	
	//Metodo che restituisce la variabile m
	public int get() {
		return m;
	}
}