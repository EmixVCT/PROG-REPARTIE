package defaut;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

class UneFenetreBis extends JFrame{
	
	int NB_THREAD = 20;
    int NB_COL = 1;

    Thread threads []= new Thread[NB_THREAD];
    JButton boutons []= new JButton[NB_THREAD];
    
    private final int LARG=700, HAUT=800;
    
    public UneFenetreBis(){
		super("fenetre");
		int i;
		//conteneur
		Container leConteneur = getContentPane();
		leConteneur.setLayout (new GridLayout(NB_THREAD, NB_COL));
		
		for (i=0;i < NB_THREAD;i++){
			UnMobileBis mobile = new UnMobileBis(LARG/NB_COL,HAUT/NB_THREAD);
			leConteneur.add(mobile);
			
			threads[i] = new Thread(mobile);
		}
		
		for (i=0;i < NB_THREAD;i++){
			threads[i].start();
		}

		
		this.setSize(new Dimension(LARG, HAUT));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		
	}
}
