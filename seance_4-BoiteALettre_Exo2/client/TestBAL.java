package client;

import modele.BAL;
import modele.Consommateur;
import modele.Producteur;

public class TestBAL {
	
	public static void main(String[] args) {
		BAL boite_a_lettre = new BAL(2);
		
		Consommateur Prod = new Consommateur(boite_a_lettre);;
		Producteur Conso = new Producteur(boite_a_lettre,"msg");
		
	    Thread producteur =  new Thread(Prod) ;
	    Thread consomateur =  new Thread(Conso) ;
	    producteur.start();
	    consomateur.start();
		
	    
	    
	}

}

