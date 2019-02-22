package client;

import modele.BAL;
import modele.Consommateur;
import modele.Producteur;

public class TestBAL {
	
	public static void main(String[] args) {
		BAL boite_a_lettre = new BAL();
		
		Consommateur tabConso[] = new Consommateur[5];
		Producteur tabProd[] = new Producteur[5];
		
		String listMessage[] = {"Premier message","renlance premier message","Message divers","dernier message"};
		
		for(int i = 0;i<listMessage.length;i++){
			tabConso[i] = new Consommateur(boite_a_lettre);
			tabProd[i] = new Producteur(boite_a_lettre,listMessage[i]);
		}
		
		for(int i = 0;i<listMessage.length;i++){
			tabConso[i].start();
			tabProd[i].start();
		}
		
		for(int i = 0;i<listMessage.length;i++){
			tabConso[i].interrupt();
			tabProd[i].interrupt();
			
			try {
				tabConso[i].join();
				tabProd[i].join();
			} catch (InterruptedException e) {}
		}
	}

}
