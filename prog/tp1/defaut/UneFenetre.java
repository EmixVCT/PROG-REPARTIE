package defaut;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

class UneFenetre extends JFrame implements ActionListener{
	
	int NB_THREAD = 100;
    int NB_COL = 2;

    Thread threads []= new Thread[NB_THREAD];
    JButton boutons []= new JButton[NB_THREAD];
    boolean status[] = new boolean[NB_THREAD];
    
    private final int LARG=700, HAUT=400;
    
    public UneFenetre(){
		super("fenetre");
		int i;
		//conteneur
		Container leConteneur = getContentPane();
		leConteneur.setLayout (new GridLayout(NB_THREAD, NB_COL));
		
		for (i=0;i < NB_THREAD;i++){
			UnMobile mobile = new UnMobile(LARG/NB_COL,HAUT/NB_THREAD);
			leConteneur.add(mobile);
			
			JButton sonBouton = new JButton("Start/Stop");
			sonBouton.addActionListener(this);	
			boutons[i] = sonBouton;
			leConteneur.add(sonBouton);
			
			status[i] = true;
			threads[i] = new Thread(mobile);
		}
		
		for (i=0;i < NB_THREAD;i++){
			threads[i].start();
		}

		
		this.setSize(new Dimension(LARG, HAUT));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

    }

	@Override
	public void actionPerformed(ActionEvent evt) {
		System.out.println(evt.getSource());
		
		Object obj = evt.getSource();
		
		int i;
		for (i = 0;i < NB_THREAD;i++){
			if (obj == boutons[i]){
				if (status[i] == true){
					threads[i].suspend();
					status[i] = false;
				}else{
					threads[i].resume();
					status[i] = true;
				}
			}
		}
		
		
	}
}
