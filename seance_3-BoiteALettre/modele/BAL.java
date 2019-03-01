package modele;

import java.util.ArrayList;
import java.util.List;


public class BAL {
	
	private String buffer;
	
	private boolean plein;
	private boolean fini = false;
	 
	public BAL() {
		buffer = "";
		plein = false;
	}

	
	public synchronized boolean retirer(){
		//TQ la boite a lettre est vide attend
		if (fini) return true;
		
		while(!plein){
			try{
				wait();
			}catch(InterruptedException e){};
		}
		
		System.out.println("Le consommateur a lu :" + buffer);

		buffer = "";
		
		plein = false;
		notifyAll();
		
		return false;
	}
	
	
	public synchronized boolean deposer(String lettre){
		
		if (fini) return true;
		
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
		

        if (buffer.equals("q") || buffer.equals("Q") )
        	fini = true;

        return fini;
	}
}
