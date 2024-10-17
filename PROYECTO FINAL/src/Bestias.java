import java.util.Random;

public class Bestias extends Personajes {

	public Bestias(String nombre, int puntosVida, int nivelResistencia) {
		super(nombre, puntosVida, nivelResistencia);
	}

	   public void atacar(Personajes enemigo) {
	      //Único lanzamiento de un dado entre 0 y 90
	      Random dado = new Random();
	      int tirada = dado.nextInt(91);
	      System.out.println("Resultado del dado es: " + tirada);
	      enemigo.recibirAtaque(tirada);
	   }
}
