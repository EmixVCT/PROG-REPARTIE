package client;

import modele.BAL;
import modele.Consommateur;
import modele.Producteur;

public class TestBAL {
	
	public static void main(String[] args) {
		BAL boite_a_lettre = new BAL();
		
		Consommateur Prod = new Consommateur(boite_a_lettre);;
		Producteur Conso = new Producteur(boite_a_lettre,"msg");
		
		Conso.start();
		Prod.start();
		
		/*
		Conso.interrupt();
		Prod.interrupt();
		
		try {
			Conso.join();
			Prod.join();
		} catch (InterruptedException e) {}
		*/
	}

}
