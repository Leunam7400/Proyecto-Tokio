package Visual;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class PanelLista extends JPanel {

	private JList<Personajes> lista;
	private DefaultListModel<Personajes> modeloLista;
	private JButton btSubir;
	private JButton btBajar;
	private JButton btEliminar;
	private JButton btbatalla;

	private Ejercito ejercito;

	public PanelLista(String titulo, Ejercito ejercito) {
		this.ejercito = ejercito;
		lista = new JList<Personajes>();
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modeloLista = new DefaultListModel<Personajes>();
		lista.setModel(modeloLista);
		btSubir = new JButton("Subir");
		btSubir.addActionListener(new AccionSubirBajar(-1));
		btBajar = new JButton("Bajar");
		btBajar.addActionListener(new AccionSubirBajar(1));
		btEliminar = new JButton("Eliminar");
		
		btbatalla = new JButton("Batalla");
		setLayout(new BorderLayout());
		JScrollPane scrollLista = new JScrollPane();
		scrollLista.setViewportView(lista);
		scrollLista.setBorder(BorderFactory.createTitledBorder(null, titulo));
		add(scrollLista, BorderLayout.CENTER);

		JPanel pnBotones = new JPanel();
		pnBotones.add(btSubir);
		pnBotones.add(btBajar);
		pnBotones.add(btbatalla);
		pnBotones.add(btEliminar);
		add(pnBotones, BorderLayout.SOUTH);
	}

	public void actualizarLista() {
		modeloLista.clear();
		for (Personajes ejer : ejercito.personaje) // Ejercito nos proporciona el ArrayList de Ejercito
			modeloLista.addElement(ejer);

		lista.setModel(modeloLista);
	}

	private class AccionSubirBajar implements ActionListener {

		private int desplazamiento; //-1 para subir, +1 para bajar
		
		public AccionSubirBajar(int desplazamiento) {
			this.desplazamiento = desplazamiento;
		}
		
		private class AccionEliminar implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				Personajes seleccionado = lista.getSelectedValue();
				if (seleccionado == null)
					JOptionPane.showMessageDialog(null, "Ha de seleccionar un Soldado");
				else {
					ejercito.personaje.remove(seleccionado);//Eliminamos del ArrayList
					actualizarLista();
				}
			}
		}
		
		public void actionPerformed(ActionEvent e) {
			//Soldado seleccionado en JList
			Personajes seleccionado = lista.getSelectedValue();
			if (seleccionado == null)
				JOptionPane.showMessageDialog(null, "Ha de seleccionar un Soldado");
			else {
				//Indice de soldado seleccionado, es igual en ambas listas
				int indiceSeleccionado = lista.getSelectedIndex();
				//Indice del soldado para intercambiar, puede que sea uno anterior o uno posterior
				int indiceIntercambiar = indiceSeleccionado + desplazamiento;
				//Buscamos en el ArrayList, el soldado para intercambiar
				Personajes intercambiar = ejercito.getPersonaje(indiceIntercambiar);
				
				//Si intercambiar fuese null, es que el soldado seleccionado no se puede intercambiar
				//Por ejemplo, si intentamos subir el soldado que ya está arriba del todo.
				if (intercambiar != null) {
					//Seteamos los soldados, intercambiando los indices
					ejercito.personaje.set(indiceSeleccionado, intercambiar);
					ejercito.personaje.set(indiceIntercambiar, seleccionado);
					actualizarLista();
				}
			}
		}
		
	}
	
	
}