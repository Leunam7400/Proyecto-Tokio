import java.util.Random;

public class Heroes extends Personajes {

	public Heroes(String nombre, int puntosVida, int nivelResistencia) {
		super(nombre, puntosVida, nivelResistencia);
	}

	public void atacar(Personajes enemigo) {
		// El ataque será el mejor lanzamiento entre dos dados de 0 a 100
		Random dado = new Random();
		int tirada1 = dado.nextInt(101);
		int tirada2 = dado.nextInt(101);
		System.out.println("Primer dado: " + tirada1);
		System.out.println("Segundo dado: " + tirada2);
		int maximo = Math.max(tirada1, tirada2);
		enemigo.recibirAtaque(maximo);
	}

}
