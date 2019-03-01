import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class UneFenetre extends JFrame
{
    UnMobile sesMobile [];
    private final int LARG=600, HAUT=600, nb_cube=30;
    JPanel main,panel;
    Thread ths [];
    
    public UneFenetre()
    {
    	
    	super();
    	this.setTitle("Prog Répartie");
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setSize(LARG, HAUT);
    	this.setLocation(100,100);
    	panel = new JPanel();
        panel.setLayout(new GridLayout(nb_cube,2));

    	sesMobile = new UnMobile[nb_cube];
    	ths = new Thread[nb_cube];
    	
    	for(int i=0;i<nb_cube;i++)
    	{
    		sesMobile[i] = new UnMobile((LARG-38),HAUT/nb_cube);
        	panel.add(sesMobile[i]);
        	
       
        	ths[i] = new Thread(sesMobile[i]);
        	ths[i].start();
    	}
    	this.add(panel);
    	this.setVisible(true);
    }
}
