package modele;

import java.util.Scanner;

public class Producteur implements Runnable{

	private String lettre;
	private BAL boite_a_lettre;

	public Producteur(BAL chBAL,String message) {
		boite_a_lettre = chBAL;
		lettre = message;
	}

	public void run(){
		
		try {
	          while (true) {

	             // toutes les secondes un boulanger produit un pain
	        	 Thread.sleep(1000) ;
	             boite_a_lettre.deposer(lettre) ;

	               System.out.println("[" + Thread.currentThread().getName() +  "]" + "[ lettre déposer ]") ;
	            }
	         

	      }  catch (InterruptedException e) {
	         System.out.println("[" + Thread.currentThread().getName() +  "] je m'arrête") ;
	      }
	}
}
