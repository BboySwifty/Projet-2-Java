package interfaces;

import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class GestionDocuments extends JFrame {
	
	private String[] strCombo = {"Ajouter un document", "Modifier un document", "Supprimer un document"};
	private String[] strType = {"Livre", "DVD", "Périodique"}
	
	private JComboBox jcb = new JComboBox(strCombo);
	
	public GestionDocuments(){
		super("Gérer les documents");
		setSize(300, 300);
		setLocationRelativeTo(null);
		add(jcb, BorderLayout.NORTH);
		setVisible(true);
	}
}
