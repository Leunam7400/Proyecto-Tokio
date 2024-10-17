
public class Main {

	public static void main(String args[]) {

		Ejercito heroes = new Ejercito();
		Ejercito bestias = new Ejercito();
		// -------------------------HEROES--------------------------//
		heroes.reclutarPersonaje(new Aragorn("Aragorn", 150, 50));
		heroes.reclutarPersonaje(new Legolas("Légolas", 150, 30));
		heroes.reclutarPersonaje(new Boromir("Boromir", 100, 60));
		heroes.reclutarPersonaje(new Gandalf("Gandalf", 300, 30));
		heroes.reclutarPersonaje(new Frodo("Frodo", 20, 10));
		// -------------------------BESTIAS-------------------------//
		bestias.reclutarPersonaje(new Lurtz("Lurtz", 200, 60));
		bestias.reclutarPersonaje(new Shagrat("Shagrat", 220, 50));
		bestias.reclutarPersonaje(new Ugluk("Uglúk", 120, 30));
		bestias.reclutarPersonaje(new Mauhur("Mauhúr", 100, 30));

		Batalla.batallar(heroes, bestias);

	}
}
