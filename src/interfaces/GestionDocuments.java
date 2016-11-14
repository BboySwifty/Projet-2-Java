package interfaces;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

public class GestionDocuments extends JFrame {

	private String[] strCombo = { "Ajouter un document", "Modifier un document", "Supprimer un document" };
	private String[] strType = { "Livre", "DVD", "Périodique" };

	private JComboBox<?> jcb = new JComboBox<Object>(strCombo);
	private JComboBox<?> jcbType = new JComboBox<Object>(strType);

	private JPanel jpMain = new JPanel();
	private JPanel jpTxt = new JPanel();

	private JLabel jLabelNumDoc = new JLabel("Numéro du document : ");
	private JLabel jLabelTitre = new JLabel("Titre : ");
	private JLabel jLabelAuteur = new JLabel("Nom de l'auteur : ");
	private JLabel jLabelRealisateur = new JLabel("Nom du réalisateur : ");
	private JLabel jLabelDate = new JLabel("Date de parution : ");
	private JLabel jLabelDisques = new JLabel("Nombre de disques : ");
	private JLabel jLabelNoPer = new JLabel("Numéro du périodique : ");
	private JLabel jLabelNoVolume = new JLabel("Numéro du volume : ");

	private JButton jBtnAjouter = new JButton("Ajouter");
	private JButton jBtnModifier = new JButton("Modifier");
	private JButton jBtnSupprimer = new JButton("Supprimer");

	private Hashtable hash = new Hashtable(5);

	private JTextField jtf1 = new JTextField();
	private JTextField jtf2 = new JTextField();
	private JTextField jtf3 = new JTextField();
	private JTextField jtf4 = new JTextField();
	private JTextField jtf5 = new JTextField();

	private Component[] tabLivre = { jLabelNumDoc, jtf1, jLabelTitre, jtf2, jLabelAuteur, jtf3, jLabelDate, jtf4 };
	private Component[] tabDVD = { jLabelNumDoc, jtf1, jLabelTitre, jtf2, jLabelRealisateur, jtf3, jLabelDisques, jtf4,
			jLabelDate, jtf5 };
	private Component[] tabPeriodique = { jLabelNumDoc, jtf1, jLabelTitre, jtf2, jLabelNoPer, jtf3, jLabelNoVolume,
			jtf5 };
	private Component[] tabSupprimer = { jLabelNumDoc, jtf1 };

	public GestionDocuments() {
		super("Gérer les documents");
		setSize(350, 300);
		setLocationRelativeTo(null);

		AjoutListeners();
		hash.put("Livre", tabLivre);
		hash.put("DVD", tabDVD);
		hash.put("Périodique", tabPeriodique);
		hash.put("Supprimer", tabSupprimer);

		jpTxt.setLayout(new GridLayout(4, 2));
		jpMain.add(jcbType);
		jpMain.add(jpTxt);
		jpMain.add(jBtnAjouter, BorderLayout.SOUTH);

		GestionTextField("Livre");

		add(jcb, BorderLayout.NORTH);
		add(jpMain);
		setVisible(true);
	}

	private void AjoutListeners() {
		jcb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				jpMain.removeAll();

				if (jcb.getSelectedItem().equals(strCombo[0])) {

					jpMain.add(jcbType);
					jpMain.add(jpTxt);
					jpMain.add(jBtnAjouter, BorderLayout.SOUTH);

					GestionTextField(jcbType.getSelectedItem().toString());
				} else if (jcb.getSelectedItem().equals(strCombo[1])) {

					jpMain.add(jpTxt);
					jpMain.add(jBtnModifier, BorderLayout.SOUTH);

					GestionTextField("Supprimer");
				} else {

					jpMain.add(jpTxt);
					jpMain.add(jBtnSupprimer, BorderLayout.SOUTH);

					GestionTextField("Supprimer");
				}
			}
		});

		jcbType.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GestionTextField(jcbType.getSelectedItem().toString());
			}
		});
	}

	private void GestionTextField(String key) {
		Component[] tab;
		tab = (Component[]) hash.get(key);
		jpTxt.removeAll();
		jpTxt.setLayout(new GridLayout(tab.length / 2, 2));

		for (int i = 0; i < tab.length; i++) {
			jpTxt.add(tab[i]);
		}

		jpMain.validate();
		jpMain.repaint();
	}
}
