package defaut;
import java.awt.*;
import javax.swing.*;

class UnMobile extends JPanel implements Runnable{
	
    int saLargeur, saHauteur, sonDebDessin;
    final int sonTemps=40, sonCote=40;
    int sonPas = 10;
    boolean marche = true; 
    		
    public UnMobile(int telleLargeur, int telleHauteur){
		super();
		saLargeur = telleLargeur;
		saHauteur = telleHauteur;
		setSize(telleLargeur, telleHauteur);
		
    }

    public void run(){
    	/*
		for (sonDebDessin=0; sonDebDessin < saLargeur - sonPas; sonDebDessin += sonPas){
			repaint();
			try{Thread.sleep(sonTemps);}
			catch (InterruptedException telleExcp)
			    {telleExcp.printStackTrace();}
		}
		
		for (sonDebDessin= saLargeur - sonPas ; sonDebDessin > 0; sonDebDessin -= sonPas){
			repaint();
			try{Thread.sleep(sonTemps);}
			catch (InterruptedException telleExcp)
			    {telleExcp.printStackTrace();}
		}*/
		
		while(marche){
			if(sonDebDessin > saLargeur - sonCote || sonDebDessin < 0){
				sonPas = -sonPas;
			}
			sonDebDessin += sonPas;
			repaint();
			try{Thread.sleep(sonTemps);}
			catch (InterruptedException telleExcp)
			    {telleExcp.printStackTrace();}
		}
    }

    public void paintComponent(Graphics telCG){
		super.paintComponent(telCG);
		telCG.fillRect(sonDebDessin, saHauteur/2, sonCote, sonCote);
    }
    
    public void statusChange(){
    	if (marche){
    		marche = false;
    	}else{
    		marche = true;
    	}
    }
}
