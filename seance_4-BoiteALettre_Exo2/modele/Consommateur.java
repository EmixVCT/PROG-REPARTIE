package modele;



public class Consommateur implements Runnable{

	private BAL boite_a_lettre;
	
	public Consommateur(BAL chBAL) {
		boite_a_lettre = chBAL;
	}

	public void run(){
		
		try {
			while (true) {
				Thread.sleep(1000) ;
				String txt = boite_a_lettre.retirer() ;
				if (txt != null) {
					System.out.println("[" + Thread.currentThread().getName() +  "]" + "[" + txt + "]") ;
				}  else {
					System.out.println("[" + Thread.currentThread().getName() +  "]" + "[ Boite vide ]") ;
		        }
			}
		
		}  catch (InterruptedException e) {
		     System.out.println("[" + Thread.currentThread().getName() +  "] je m'arrête") ;
		  }
	}
}
