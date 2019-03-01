package client;

import modele.BAL;
import modele.Consommateur;
import modele.Producteur;

public class TestBAL {

	private int nbConsommateur = 5;
	private int nbProducteur = 5;

	
	public static void main(String[] args) {
		BAL boite_a_lettre = new BAL();
		

		Consommateur consommateur = new Consommateur(boite_a_lettre);
		Producteur producteur = new Producteur(boite_a_lettre,"coucou !");
		
		consommateur.start();
		producteur.start();
		
		producteur.interrupt();
		consommateur.interrupt();
		
	}

}
