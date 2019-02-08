package defaut;
/**
 * 
 */
import java.io.*;
import java.lang.String;

public class Affichage extends Thread{
	String texte;
	static Object excluMut = new Object();
	
	public Affichage (String txt){
		texte=txt;
		}
	
	public void run(){
		//semaphoreBinaire semaphore = new semaphoreBinaire(this.);
		//semaphore.syncWait();
		
		synchronized(excluMut){ 
			for (int i=0; i<texte.length(); i++){
			    System.out.print(texte.charAt(i));
			    try {
			    	sleep(100);
			    } catch(InterruptedException e){};
			}
		}
		//semaphore.syncSignal();
	}
}
