package modele;

public class Producteur extends Thread{

	private String lettre;
	private BAL boite_a_lettre;

	public Producteur(BAL chBAL,String message) {
		boite_a_lettre = chBAL;
		lettre = message;
	}

	public void run(){
		boite_a_lettre.deposer(lettre);

	}
}
