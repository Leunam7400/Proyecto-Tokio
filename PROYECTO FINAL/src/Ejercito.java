
import java.util.ArrayList;

public class Ejercito {
	
	public ArrayList<Personajes> personaje;
	
	public Ejercito() {
		 personaje= new ArrayList<Personajes>();
	}
	
	public void reclutarPersonaje(Personajes personajes ) {
		personaje.add(personajes);
	}
	
	public Personajes getPersonaje(int pos) {
		try {
			return personaje.get(pos);
		}
		catch(Exception e) {
			return null; //No hay soldado en esa posici�n
		}
	}
	
	public void comprobarEjercito() {
		int soldadoMuerto = -1; //Posicion de posible soldado muerto
		//Comprobamos si hay alguna baja
		for (int pos = 0; pos < personaje.size(); pos++)
			if (personaje.get(pos).estaMuerto()) //Baja confirmada
				soldadoMuerto = pos; //Guardamos posicion
		/*
		 * Para evitar inconsistencias, hay que eliminar al soldado
		 * muerto DESPU�S del bucle for.
		 * Si lo eliminasemos DENTRO del bucle for, mientras a�n se est�
		 * recorriendo, se podr�a producir una excepcion porque el indice
		 * que usa el bucle FOR podr�a ser inconsistente con el nuevo
		 * tama�o del ArrayList tras eliminar al soldado.
		 */
		if (soldadoMuerto != -1) //Se encontr� una baja, hay que eliminar
			personaje.remove(soldadoMuerto);
		//Al eliminar del ArrayList, autom�ticamente suben una posici�n los soldados posteriores
	}

	public boolean esDerrotado() {
		//Si ya no quedan soldado, el ejercito ha sido derrotado
		return personaje.size() == 0;
	}


}