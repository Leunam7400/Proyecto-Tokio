
import java.util.Scanner;

public class Batalla {

	private static Scanner sc = new Scanner(System.in);
	   
	   public static void batallar(Ejercito heroes, Ejercito bestias) {
	      
	      //Mientras ningun ejército haya sido derrotado....
	      while(!heroes.esDerrotado() && !bestias.esDerrotado()) {

	         //Calculamos el total de turnos, según el ejército más grande
	         int turnosTotal;
	         if (heroes.personaje.size() >= bestias.personaje.size())
	            turnosTotal = heroes.personaje.size();
	         else
	            turnosTotal = bestias.personaje.size();
	         
	         //Comienza una ronda de turnos
	         for (int turno = 0; turno < turnosTotal; turno++) {
	            //Seleccionamos combatientes
	            Heroes heroe = (Heroes) heroes.getPersonaje(turno);
	            Bestias bestia = (Bestias) bestias.getPersonaje(turno);
	            //Comprobamos que ninguno sea null
	            if (heroe == null && bestia == null)
	               //¿Ambos son null?Entonces esta ronda de turnos ha terminado
	               break;
	            else if (heroe == null)
	               //No hay Heroe, Bestia queda en guardia
	               System.out.println(bestia.getNombre() + " queda en guardia");
	            else if (bestia == null)
	               //No hay Bestia, Heroe queda en guardia
	               System.out.println(heroe.getNombre() + " queda en guardia");
	            else {
	               //Ninguno es null, comienza el combate
	               System.out.println("Lucha entre " + heroe + " y " + bestia);
	               //Turno heroe
	               System.out.println("Turno de " + heroe.getNombre());
	               heroe.atacar(bestia);
	               System.out.println("Datos Actualizados de " + bestia);
	               if (bestia.estaMuerto())
	                  System.out.println(bestia.getNombre() + " ha muerto.");
	               else {
	                  //Turno bestia
	                  System.out.println("Turno de " + bestia.getNombre());
	                  bestia.atacar(heroe);
	                  System.out.println("Datos Actualizados de " + heroe);
	                  if (heroe.estaMuerto())
	                     System.out.println(heroe.getNombre() + " ha muerto.");
	               }
	            }
	            //Turno combate finalizado, ejercitos actualizan sus filas
	            heroes.comprobarEjercito();
	            bestias.comprobarEjercito();
	            pausa();
	            //Y se inicia el siguiente turno
	         }
	      }
	      
	      //Las rondas de turnos han finalizado porque algún ejército ha sido derrotado. Comprobamos
	      if (heroes.esDerrotado())
	         System.out.println("Han ganado las Bestias. Soldados restantes: " + bestias.personaje.size());
	      else
	         System.out.println("Han ganado los Heroes. Soldados restantes: " + heroes.personaje.size());
	   }

	   private static void pausa() {
	      System.out.println("\n\t\tPulse INTRO para continuar...\n");
	      sc.nextLine();
	   }
	   
	}
