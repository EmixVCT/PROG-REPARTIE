package modele;

import java.util.Scanner;

public class Consommateur extends Thread{

	private BAL boite_a_lettre;
	
	public Consommateur(BAL chBAL) {
		boite_a_lettre = chBAL;
	}

	public void run(){
		
		boolean fini = false;

        while (!fini){
        	fini = boite_a_lettre.retirer();
        }
		boite_a_lettre.retirer();
	}
}
