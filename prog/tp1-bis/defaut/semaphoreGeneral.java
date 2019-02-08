package defaut;

public final class semaphoreGeneral extends semaphoreBis {
	private int  valeurInitiale ;
	public semaphoreGeneral(int valeurInitiale){
		super(valeurInitiale);
		System.out.print(valeurInitiale);
		this.valeurInitiale = valeurInitiale;
	}
	public final synchronized void syncSignal(){
		super.syncSignal();
		System.out.print(valeur);
		if (valeur>valeurInitiale) valeur = valeurInitiale;
	}
}

