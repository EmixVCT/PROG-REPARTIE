package defaut;
//programme d'un mobile se deplacant de la gauche vers la droite de la fenetre-ecran
import java.awt.*;
import javax.swing.*;

public class TpMobile{
    public static void main(String[] telsArgs){
    	
    	JFrame fenetre = new UneFenetre();
    	
    	fenetre.setResizable(false);
    	fenetre.setSize(new Dimension(1200, 650));
    	fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	fenetre.setVisible(true);
 	
    }
}
