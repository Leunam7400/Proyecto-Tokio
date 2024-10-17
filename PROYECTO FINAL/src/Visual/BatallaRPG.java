package Visual;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class BatallaRPG extends JFrame {
	   
	   //Modelo
	   private Ejercito bestias;
	   private Ejercito heroes;
	   
	   //Vista
	   private PanelCrearSoldado crearHeroes;
	   private PanelCrearSoldado crearBestias;
	   
	   public BatallaRPG() {
	      bestias = new Ejercito();
	      heroes = new Ejercito();
	      //Este panel referenciará los Heroes
	      crearHeroes = new PanelCrearSoldado("Heroes", new String[] {"Legolas", "Aragorn", "Boromir","Gandalf", "Frodo"}, heroes);
	      //Este refenciará a la Bestias
	      crearBestias = new PanelCrearSoldado("Bestias", new String[] {"Lurtz", "Shagrat","Ugluk", "Mauhur"}, bestias);
	      JPanel pnSuperior = new JPanel();
	      pnSuperior.add(crearHeroes);
	      pnSuperior.add(crearBestias);
	      
	      setContentPane(pnSuperior);
	      
	      setTitle("Batalla RPG");
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      pack();
	      setLocationRelativeTo(null);
	      setVisible(true);
	   }

	   public static void main(String[] args) {
	      SwingUtilities.invokeLater(new Runnable() {
	         @Override
	         public void run() {
	            new BatallaRPG();   
	         }
	      });
	   }
	}