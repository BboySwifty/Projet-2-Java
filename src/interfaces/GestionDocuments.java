package interfaces;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

import données.LectureFichier;

public class GestionDocuments extends JFrame {
	
	private LectureFichier lf;

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

	private Hashtable hash1 = new Hashtable(4);
	private Hashtable hash2 = new Hashtable(4);

	private JTextField jtf1 = new JTextField();
	private JTextField jtf2 = new JTextField();
	private JTextField jtf3 = new JTextField();
	private JTextField jtf4 = new JTextField();
	private JTextField jtf5 = new JTextField();

	private JLabel[] tabLivre = { jLabelNumDoc, jLabelTitre, jLabelAuteur, jLabelDate };
	private JLabel[] tabDVD = { jLabelNumDoc, jLabelTitre, jLabelRealisateur, jLabelDisques, jLabelDate };
	private JLabel[] tabPeriodique = { jLabelNumDoc, jLabelTitre, jLabelNoPer, jLabelNoVolume, jLabelDate };
	private JLabel[] tabSupprimer = { jLabelNumDoc };
	
	private JTextField[] tabTfLivre = { jtf1, jtf2, jtf3, jtf4 };
	private JTextField[] tabTfDVD = { jtf1, jtf2, jtf3, jtf4, jtf5 };
	private JTextField[] tabTfPeriodique = { jtf1, jtf2, jtf3, jtf4, jtf5 };
	private JTextField[] tabTfSupprimer = { jtf1 };

	public GestionDocuments(LectureFichier lf) {
		super("Gérer les documents");
		setSize(350, 300);
		setLocationRelativeTo(null);
		
		this.lf = lf;

		AjoutListeners();
		
		hash1.put("Livre", tabLivre);
		hash1.put("DVD", tabDVD);
		hash1.put("Périodique", tabPeriodique);
		hash1.put("Supprimer", tabSupprimer);

		hash2.put("Livre", tabTfLivre);
		hash2.put("DVD", tabTfDVD);
		hash2.put("Périodique", tabTfPeriodique);
		hash2.put("Supprimer", tabTfSupprimer);

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
		
		jBtnAjouter.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				/*if(jcbType.getSelectedItem().equals("Livre")){
					Date date = new Date();
					Livre l = new Livre(jtf1.getText(), jtf2.getText(),  date Date.valueOf(jtf3.getText()), jtf4.getText());
					lf.alLivres.add(l);
					lf.alCollection.add(l);
				}*/
			}
		});
	}

	private void GestionTextField(String key) {
		JLabel[] tab1;
		JTextField[] tab2;
		
		tab1 = (JLabel[]) hash1.get(key);
		tab2 = (JTextField[]) hash2.get(key);
		
		jpTxt.removeAll();
		jpTxt.setLayout(new GridLayout(tab1.length, 2));

		for (int i = 0; i < tab1.length; i++) {
			tab2[i].setText("");
			jpTxt.add(tab1[i]);
			jpTxt.add(tab2[i]);
		}

		jpMain.validate();
		jpMain.repaint();
	}
}
