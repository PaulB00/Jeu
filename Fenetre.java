
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/*
 *  cette class permet d'afficher la fenetre qui contient 
 *  la Panel de la Class jeuxPanel et de capter les 
 *  bouton de clavies tapées par le joueur a l'aide de l'interface 
 * implementé KeyListener
 */

/**
 *
 * @author ADHAMER KHALIL
 */
public class Fenetre extends JFrame implements KeyListener {
     int x = 0;
     int y = 0;
    JeuxPanel jeux;
      public Fenetre (){
          
            // visibilite et titre et taille inisial de Fenetre
           setVisible(true);
           setTitle("Jeux Serpon ISIMG ");
           setBounds(x,y,500,500);
           
              // instance jeux de Class JeuxPanel  
           jeux = new JeuxPanel(this);
           
              // affichage de notre JPanel dans notre Fenetre
           add(jeux);
               
              //  execution de jeux 
           jeux.start();
           
             /* 
            * cette methode nous permet d'activer la dectection 
            * des bouton taper . 
            */
           
           addKeyListener(this);
           
           
      }
      
       @Override
    public void keyTyped(KeyEvent e) {
      
    }

       /*
        * cet une methode abstact de l'interface
        * KeyListener a pour rôle de detecté les bouton tappées
        * en suite en affecte le code de bouton taper a l'instance jeux de 
        * la Class jeuxPanel
        */
    @Override
    public void keyPressed(KeyEvent e) {
           jeux.key = e.getKeyCode();
        
      }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }
    
    // retourne la largueur actuelle de la fenetre 
  public int getW(){
      return getWidth();
  }
  
        // retourne l'hauteur actuelle de la fenetre 
  public int getH(){
      return getHeight();
  }
 
    
}
