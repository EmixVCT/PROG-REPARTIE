
public final class semaphoreOriginale extends semaphore {
	
	private int nb_pass;
	
	public semaphoreOriginale(int valeurInitiale,int nb_pass){
		super(valeurInitiale);
		this.nb_pass = nb_pass;
	}
	public final synchronized void syncSignal(){
		super.syncSignal();
		if (valeur>nb_pass) valeur = nb_pass;
	}
}

