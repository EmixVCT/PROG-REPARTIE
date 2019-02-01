package defaut;
import java.awt.*;

import javax.swing.*;

class UneFenetre extends JFrame {
    UnMobile sonMobile;
    private final int LARG=400, HAUT=250;
    
    public UneFenetre(){
		super("fenetre");
		
		Container leConteneur = getContentPane();
		
		sonMobile = new UnMobile(LARG,HAUT);
		leConteneur.add(sonMobile);
		
		Thread laThread = new Thread(sonMobile);
		laThread.start();
		
    	this.setResizable(false);
    	this.setSize(new Dimension(LARG, HAUT));
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setVisible(true);

		
    }
}
