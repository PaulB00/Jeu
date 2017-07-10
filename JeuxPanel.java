
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;
import java.util.Vector;
import javax.swing.JPanel;

/*
 * 
 * 
 */

/**
 *
 * @author ADHAMER KHALIL
 */
    public class JeuxPanel extends JPanel implements Runnable  {
          // Variable f est pour obtenir les information du fenetre 
        Fenetre f;
        
         // Coordonner de Serpon du joueur 
        int x,y; 
        
         // Coordonner de l'aliment 
        int x1,y1;  
        
        // Coordonner de Serpon ennemi 
        int x2 , y2; 
        
         // h est l'hauteur de tous les "fillRec"
         // qui sont utiliser pour la creation de 
         // Serpon de joueur et serpon ennemi et l'aliment
        int h = 15;
        
          // h est la largeur de tous les "fillRec"
          // qui sont utiliser pour la creation de 
          // Serpon de joueur et serpon ennemi et l'aliment
        int l = 15;
        
         // scorre est pour stocker le scorre du joueur 
         // scorre2 est pour stocker le scorre du l'ennemi
        int scorre ,scorre2;
        
          /* p est utiliser pour stocker les coordonner x et y de 
           * Serpon de joueur
           * p est utiliser pour stocker les coordonner x2 et y2 de 
           * Serpon de ennemi */ 
         
        Point p , p2 ; 
        
          // l'entier Key contier le code de bouton taper par la Clavier 
        int key ;
        
          /* les deux Serpon sont en realité deux Vecteur 
           * qui contients les coordonners de tous les parties de
           * deux serpons */
        Vector serpon;
        Vector serpon2;
        
         /* la Class Thread utiliser dans ce programme pour
         *  limiter la vitesse des Serpon car dans le cas des 
         * ordinateurs puissants l'execution sera tres rapide
         * et on ne peut pas jouer
         */
        Thread thread = new Thread(this);
        
        /* la Class Random a pour but de fournir 
         * des valeurs aléatoires qui seron affecte 
         * a les coordonners x1 et y1 de l'aliment
         */
        Random random = new Random();
        
           /* le constrecteur JeuxPanel contient dans ses parametres 
         *     la class Fenetre que nous allons fournit ses 
         *     proprietes
         */
           
      public JeuxPanel(Fenetre f ){
               
           this.f = f;
             
           setVisible(true);
           
             /* la taille de JPanel doit etre la même 
              *  que la Class Fenetre , on obtenir ça
              *  de la variable f 
              */
           setBounds(f.x, f.y, f.getW(), f.getH());
           
             // Creation d'une instance de la Class Vector
           serpon = new Vector();
            
             /*intialisation de Vecteur Serpon par 5 Point
              * autrement dite la Serpon de Joueur est intialise 
              * par la longueur 5
              */
           
           p = new Point();
              for (int i= 0; i< 5 ; i++){
                   serpon.add(p);
              }
              
            // Creation d'une instance de la Class Vector
           serpon2 = new Vector();
          
             /*intialisation de Vecteur Serpon2 par 5 point
              * autrement dite la Serpon de l'ennemi est intialise 
              * par la longueur 5
              */
           p2 = new Point();
           
              for (int i= 0; i< 5 ; i++){
                  
                   serpon2.add(p2);
                   
              }
      }
         
       public void  paint(Graphics g ){
           
             /*ce code est pour painture de couleur de l'arriere plan
              * et toujour on utilise les methodes getH() pour 
              *  l'hauteur et getW() pour la largueur ,qui nous 
              *  donner la taille actuelle de notre Fenetre
              */
                g.setColor(Color.WHITE);   
                g.fillRect(0, 0, f.getW() , f.getH());
                
                
            /* painture de la tête de serpon 1
             * de coordonner x et y et le largueur l
             *  et de hauteur h 
             */
                g.setColor(Color.GREEN);
                g.fillArc(x, y, l, h, 360, 360);
                
            /*painture de la corp du serpon 1 
             *  on appelant la methode paintPart() 
             *  a chaque iteration .
             *  dans ce boucle for on fait la lecture de
             *  tous les points de vecteur serpon et la methode 
             *  paintPart() painte dans les coordonner correspondent
             * chaque partie de Serpon
             */
            for (int i = serpon.size() - 2 ; i >= 0 ; i-- ){
               
                 p = (Point)serpon.elementAt(i);
                 paintPart(g ,p , Color.red);
                
            }
            
            // Le même travaille pour la serpon2 de l'ennemi 
                  g.setColor(Color.YELLOW);
                  g.fillArc(x2, y2, l, h, 360, 360);
                  
           // painture de la corp de serpon 2
             for (int i = serpon2.size() - 2 ; i >= 0 ; i-- ){
               
                 p2 = (Point)serpon2.elementAt(i);
                 paintPart(g ,p2 , Color.BLACK );
                
                  }
             
           /* painture de l'aliment qui a pour 
            *  pour coordonner x1 et y1
            */
            g.setColor(Color.blue);
            g.fillRect(x1,y1,l,h);
            
            
              /*  cette partie est destinner pour l'affichage de
               *  scorre de les deux Serpons le scorre de serpon du  joueur
               *  est afficher en bas a gauche  et l'autre en bas a droite
               */
            g.drawString("Votre Scorre est = " + 
                 String.valueOf(scorre),(int)(f.getW()/4), f.getH() - 50);
            g.drawString("IA Scorre est = " + 
                 String.valueOf(scorre2),(int)(f.getW() * 3/4), f.getH() - 50);
      }
            
        /* 
       * est une methode qui affiche un rectangle rempli 
       * avec des coordonners et un coleur données
       */
      public void  paintPart(Graphics g ,Point point  , Color c){
           
           g.setColor(c);
           g.fillRect(point.x, point.y, l, h);
           
      }

   /*
       * cette methode run() de l'interface Runnable a pour rolle de 
       * executer des instruction et on utilisant une boucle while infini
       * et en appelant la methode sleep(int Millisecondes) de l'instance thread
       * on peut fixer l'execution des ces instuctions en des periodes 
       * telque le cas de ce code , on fait l'execution et on attend 75
       * millisecondes
       * puis en refaire la même chose .
       */
      
    @Override
    public void run() { 
        
         
              try {
         
             /* boucle infini chaque iteration se 
                   * fait qu'apres un repos de 75 millisecondes
                   */
          while(true){
              
              /* key contient le code de bouton du clavier taper
               *  selon ce code on fait la mouvement de serpon 
               * de joueur
               */
              
              switch(key){
                  case 38 : y-= h; // Bas
                      break;
                  case 40 : y+= h; // Haute
                      break;
                  case 37 : x-= l; // Gauche
                      break;
                  case 39 : x+= l; // Droite
                      break;
                      
              }
              
                /* ce code pour contoller la mouvement de 
                 *  serpon2 de l'ennemi 
                 *  tous simplement on incremente et en decremente 
                 *  les valeurs de la tête du serpon2 de l'ennemi 
                 *  jusqu'a ils seront confondus avec x1 et y1 
                 *  de l'aliment 
                 */
              
              if  ( x2 > x1 ) 
                   {x2-= h;}
              else if (x2< x1) 
                   { x2+= h;}
              else if ( y2 < y1 )
                   { y2+= l; }
              else if (y2 > y1)
                   { y2-= l;}
              
                  
                      
                  /*
                   *  lorque la tête de Serpon du joueur est de même 
                   *  coordonner que l'aliment onna 3 actions a faire
                   *    1 -  changement aleatiore des coordonners de l'aliment
                   *         on utilise (f.getW() / l)) * l pour que les 
                   *         coordonner  soit toujours dans notre fenetre
                   *
                   *    2 - la longueur de serpon augment par 2 partie
                   *   
                   *    3 - le scorre du joueur increment par 15
                   */
               if ((x == x1) && (y == y1)){
                    x1 = random.nextInt((int)(f.getW() / l)) * l ;
                    y1 = random.nextInt((int)(f.getH() / l)) * l ;
                    serpon.add(0 , p);
                    serpon.add(0 , p);
                    scorre+= 15;
               }
               
               
                // le même pour le Serpon2 de l'ennemi
               if ((x2 == x1) && (y2 == y1)){
                    x1 = random.nextInt((int)(f.getW() / l)) * l ;
                    y1 = random.nextInt((int)(f.getH() / l)) * l ;
                    serpon2.add(0 , p2);
                    serpon2.add(0 , p2);
                    scorre2+= 15;
               }
              
               
               /*
                * dans cette etape on fait la mise a jour de coordonner de la 
                * tête de serpon de joueur par les niveaux valeurs de 
                * x et y , et en suite en supprime l'element d'indice 0
                * qui coresppont a la queue de la serpon , ces deux etapes 
                * sont tres utiles et necessaire ,car le mise ajour de position
                * de tête de Serpon s'echange ici et aussi permet a les partie 
                *  de la Serpon de suivie les coordonner du tête sans 
                * recoure a la decalge de coordonner
                * 
                */
              serpon.add(new Point(x , y));
              serpon.remove(0);
              
                // le même pour la serpon2 de l'ennemi
              serpon2.add(new Point(x2 , y2));
              serpon2.remove(0);
               
                /*
                 * la methode sleep de la instance thread 
                 * permet d'avoir une pause de execution 
                 * pour une duree donner 
                 */
              thread.sleep(75);
           
                 // actualisation de les dessins
               repaint();    
         
          }
           } catch (InterruptedException ex) {
               
            
            
           }
     }
        // demarrage de l'execution 
     public void start(){
         
         thread.start();
         
    }

   

   
}
