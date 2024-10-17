package Visual;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Visual.bestias.Lurtz;
import Visual.bestias.Mauhur;
import Visual.bestias.Shagrat;
import Visual.bestias.Ugluk;
import Visual.herores.Aragorn;
import Visual.herores.Boromir;
import Visual.herores.Frodo;
import Visual.herores.Gandalf;
import Visual.herores.Legolas;

public class PanelCrearSoldado extends JPanel {

	private JTextField jtNombre;
	private JComboBox<String> jcTipo;
	private JTextField jtVida;
	private JTextField jtArmadura;
	private JButton btAnadir;

	// Atributo para referenciar alguno de los ejercitos de la clase main
	private Ejercito ejercito;

	// Panel con la lista de soldados
	private PanelLista lista;

	public PanelCrearSoldado(String titulo, String[] tipos, Ejercito ejercito) {
		// Inicializamos componentes
		jtNombre = new JTextField();
		jcTipo = new JComboBox<String>(tipos);
		jtVida = new JTextField();
		jtArmadura = new JTextField();
		btAnadir = new JButton("Añadir");

		btAnadir.addActionListener(new AccionCrearSoldado());

		this.ejercito = ejercito; // Ejercito referenciado

		lista = new PanelLista(titulo, ejercito); // Pasamos titulo de borde y referencia a ejercito

		// Layout de "cajas" verticales
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		// Cada "caja" apilada verticalmente será un panel de clase PanelConLabel

		add(new PanelConLabel("Nombre:", jtNombre));
		add(new PanelConLabel("Tipo:", jcTipo));
		add(new PanelConLabel("Vida:", jtVida));
		add(new PanelConLabel("Armadura:", jtArmadura));

		// Boton añadir, le damos un panel propio para que quede mejor centrado
		JPanel pnAnadir = new JPanel();
		pnAnadir.add(btAnadir);
		add(pnAnadir);

		// Colocamos el panel lista debajo de todo
		add(lista);

		// Combinamos dos bordes, uno titulado y otro vacío para crear algo de relleno
		setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15),
				BorderFactory.createTitledBorder(titulo)));

	}

	private class PanelConLabel extends JPanel {

		public PanelConLabel(String texto, JComponent componente) {
			// Layout tipo grilla, será una fila con dos columnas
			setLayout(new GridLayout(1, 2));
			// En la primera columna, la etiqueta
			add(new JLabel(texto));
			// En la segunda columna, el componente que acompaña la etiqueta
			add(componente);
			// "Inflamos" el panel con algo de borde vacío
			setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		}
	}

	private class AccionCrearSoldado implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// Recogemos datos
			String nombre = jtNombre.getText();
			String tipo = (String) jcTipo.getSelectedItem();
			int vida = Integer.parseInt(jtVida.getText());
			int armadura = Integer.parseInt(jtArmadura.getText());

			// Creamos nuevo soldado según tipo
			switch (tipo) {
			case "Aragorn":
				ejercito.reclutarPersonaje(new Aragorn(nombre, vida, armadura));
				break;
			case "Frodo":
				ejercito.reclutarPersonaje(new Frodo(nombre, vida, armadura));
				break;
			case "Boromir":
				ejercito.reclutarPersonaje(new Boromir(nombre, vida, armadura));
				break;
			case "Lurtz":
				ejercito.reclutarPersonaje(new Lurtz(nombre, vida, armadura));
				break;
			case "Legolas":
				ejercito.reclutarPersonaje(new Legolas(nombre, vida, armadura));
				break;
			case "Gandalf":
				ejercito.reclutarPersonaje(new Gandalf(nombre, vida, armadura));
				break;

			case "Shagrat":
				ejercito.reclutarPersonaje(new Shagrat(nombre, vida, armadura));
				break;
			case "Ugluk":
				ejercito.reclutarPersonaje(new Ugluk(nombre, vida, armadura));
				break;
			case "Mauhur":
				ejercito.reclutarPersonaje(new Mauhur(nombre, vida, armadura));
				break;

			}

			// Limpiamos campos
			jtNombre.setText(null);
			jcTipo.setSelectedIndex(0);
			jtVida.setText(null);
			jtArmadura.setText(null);

			// Actualizamos lista
			lista.actualizarLista();
		}
	}

}