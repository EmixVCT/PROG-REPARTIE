package modele;

public class Consommateur extends Thread{

	private BAL boite_a_lettre;
	
	public Consommateur(BAL chBAL) {
		boite_a_lettre = chBAL;
	}

	public void run(){
		boite_a_lettre.retirer();
	}
}
