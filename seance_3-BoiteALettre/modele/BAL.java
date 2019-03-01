package modele;

import java.util.ArrayList;
import java.util.List;


public class BAL {
	
	private String buffer;
	
	private boolean plein;
	
	public BAL() {
		buffer = "";
		plein = false;
	}

	
	public synchronized void retirer(){
		//TQ la boite a lettre est vide attend
		while(!plein){
			try{
				wait();
			}catch(InterruptedException e){};
		}
		
		System.out.println("Le consommateur a lu :" + buffer);

		buffer = "";
		
		plein = false;
		notifyAll();
		
	}
	
	
	public synchronized void deposer(String lettre){
		//TQ la boite a lettre est pleine attend
		while(plein){
			try{
				wait();
			}catch(InterruptedException e){};
		}
		
		System.out.println("Prod a ecrie : "+lettre);

		buffer = lettre; //rempli la boite a lettre

		plein = true; //
		notifyAll(); //envoie un signal 
	}
}
