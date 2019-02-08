package defaut;
/**
 * 
 */
import java.io.*;
import java.lang.String;

public class Affichage extends Thread{
	String texte;
	static semaphoreBinaire semaphore = new semaphoreBinaire(1);
	
	public Affichage (String txt){
		texte=txt;
		}
	
	public void run(){
		
		semaphore.syncWait();
		
		for (int i=0; i<texte.length(); i++){
		    System.out.print(texte.charAt(i));
		    try {
		    	sleep(100);
		    } catch(InterruptedException e){};
		}
		
		semaphore.syncSignal();
	}
}
