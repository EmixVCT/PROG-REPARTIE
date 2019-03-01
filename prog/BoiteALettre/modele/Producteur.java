package modele;

import java.util.Scanner;

public class Producteur extends Thread{

	private String lettre;
	private BAL boite_a_lettre;

	public Producteur(BAL chBAL,String message) {
		boite_a_lettre = chBAL;
		lettre = message;
	}

	public void run(){
		
    	boolean fini = false;
		System.out.println("Entrez votre texte :");
        Scanner scanner = new Scanner(System.in);

        while (!fini){
        	fini = boite_a_lettre.deposer(scanner.next());
        }
	}
}
