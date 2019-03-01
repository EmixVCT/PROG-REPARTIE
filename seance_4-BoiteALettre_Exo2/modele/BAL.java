package modele;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class BAL {
	
    private BlockingQueue<String> queue;
		 
	public BAL(int taille) {
		queue =  new ArrayBlockingQueue<String>(taille) ;
	}

	
	public String retirer() throws InterruptedException{
		return queue.take();
	}
	
	
	public void deposer(String lettre) throws InterruptedException {
		queue.put(lettre);
	}
}
