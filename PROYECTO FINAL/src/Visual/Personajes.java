package Visual;

public abstract class Personajes {

	private String nombre;
	private int puntosVida;
	private int nivelResistencia;

	public Personajes(String nombre, int puntosVida, int nivelResistencia) {
		this.nombre = nombre;
		this.puntosVida = puntosVida;
		this.nivelResistencia = nivelResistencia;
	}

	public String getNombre() {
		return nombre;
	}

	public boolean estaMuerto() {
		return puntosVida <= 0;
	}

	public int getNivelResistencia() {
		return nivelResistencia;
	}

	public void recibirAtaque(int ataque) {
		if (ataque > nivelResistencia)
			puntosVida -= ataque - nivelResistencia;

		if (puntosVida < 0)
			puntosVida = 0;
		// Evitarvalores negativos
	}

	public String toString() {
		return String.format("%s (Vida=%d Armadura=%d)", nombre, puntosVida, nivelResistencia);
	}
	public boolean equals(Object obj) {
		if (obj instanceof Personajes) {
		Personajes otroSoldado = (Personajes) obj;
			return nombre.equals(otroSoldado.getNombre());//Si los nombres coinciden, retorna true
		}
		else
			return false;
	}
	// Este método lo han de sobreescribir Heroes y Bestias, porque será distinto para
	// cada uno
	public abstract void atacar(Personajes enemigo);

}