import java.awt.*;

import javax.swing.*;

class UnMobile extends JPanel implements Runnable
{
    int saLargeur, saHauteur, sonDebDessin;
    int sonPas;
    final int sonTemps=50, sonCote=40;
    static semaphoreOriginale sem = new semaphoreOriginale(2,2);
    
    boolean aller;
    boolean critique;
    
    UnMobile(int telleLargeur, int telleHauteur)
    {
		super();
		saLargeur = telleLargeur;
		saHauteur = telleHauteur;
		setSize(telleLargeur, telleHauteur);
		aller = true;
		sonPas = (int) ((Math.random()*50)+1);
    }

    public void run()
    {
    	  	
    	while(true){
    		for (sonDebDessin=0; sonDebDessin < (saLargeur - sonPas)/3; sonDebDessin+= sonPas)
    		{
    			repaint();
    			try{Thread.sleep(sonTemps);}
    			catch (InterruptedException telleExcp)
    			    {telleExcp.printStackTrace();}
    		}
    		
    		sem.syncWait();
    		critique = true;
    		for (sonDebDessin=sonDebDessin; sonDebDessin < ((saLargeur - sonPas)/3)*2; sonDebDessin+= sonPas)
    		{
    			repaint();
    			try{Thread.sleep(sonTemps);}
    			catch (InterruptedException telleExcp)
    			    {telleExcp.printStackTrace();}
    		}
    		sem.syncSignal();
    		critique = false;
    
  
    		for (sonDebDessin=sonDebDessin; sonDebDessin < ((saLargeur - sonPas)/3)*3; sonDebDessin+= sonPas)
    		{
    			repaint();
    			try{Thread.sleep(sonTemps);}
    			catch (InterruptedException telleExcp)
    			    {telleExcp.printStackTrace();}
    		}
    		
    		//===================================================================================================
    		
    		for (sonDebDessin=sonDebDessin; sonDebDessin > ((saLargeur - sonPas)/3)*2; sonDebDessin-= sonPas)
    		{
    			repaint();
    			try{Thread.sleep(sonTemps);}
    			catch (InterruptedException telleExcp)
    			    {telleExcp.printStackTrace();}
    		}
    		
    		sem.syncWait();
    		critique = true;
    		for (sonDebDessin=sonDebDessin; sonDebDessin > ((saLargeur - sonPas)/3); sonDebDessin-= sonPas)
    		{
    			repaint();
    			try{Thread.sleep(sonTemps);}
    			catch (InterruptedException telleExcp)
    			    {telleExcp.printStackTrace();}
    		}
    		sem.syncSignal();
    		critique = false;
    		
    		for (sonDebDessin=sonDebDessin; sonDebDessin >0; sonDebDessin-=sonPas)
    		{
    			repaint();
    			try{Thread.sleep(sonTemps);}
    			catch (InterruptedException telleExcp)
    			    {telleExcp.printStackTrace();}
    		}
    	}
    		
    }

    public void paintComponent(Graphics telCG)
    {
    	if(critique)
    		telCG.setColor(Color.RED);
    	else
    		telCG.setColor(Color.BLACK);
		super.paintComponent(telCG);
		telCG.fillRect(sonDebDessin, saHauteur/2, sonCote, sonCote);
    }
}