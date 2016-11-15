package interfaces;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

import données.Adherent;
import données.LectureFichier;
import données.Prepose;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GestionUtilisateur extends JFrame
{
	Container c = getContentPane();
	
	private int intCompteurInscription = 0;
	private int intNumeroTelephone;
	
	private String strPrenom;
	private String strNomDeFamille;
	private String strAdresse;
	
	private LectureFichier lf;

	private String[] strCombo = { "Ajouter un document", "Modifier un document", "Supprimer un document" };
	private String[] strType = { "Livre", "DVD", "Périodique" };

	private JComboBox<?> jcb = new JComboBox<Object>(strCombo);
	private JComboBox<?> jcbType = new JComboBox<Object>(strType);

	private JPanel jpMain = new JPanel();
	private JPanel jpTxt = new JPanel();

	private JLabel jLabelNumDoc = new JLabel("Prenom de l'utilisateur : ");
	private JLabel jLabelTitre = new JLabel("Nom famille de l'utilisateur: ");
	private JLabel jLabelAuteur = new JLabel("Numero telephone: ");
	
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

	private JTextField jtfPrenom = new JTextField();
	private JTextField jtfNomFamille = new JTextField();
	private JTextField jtfTelephone = new JTextField();
	private JTextField jtf4 = new JTextField();
	private JTextField jtf5 = new JTextField();

	private JLabel[] tabLivre = { jLabelNumDoc, jLabelTitre, jLabelAuteur, jLabelDate };
	private JLabel[] tabDVD = { jLabelNumDoc, jLabelTitre, jLabelRealisateur, jLabelDisques, jLabelDate };
	private JLabel[] tabPeriodique = { jLabelNumDoc, jLabelTitre, jLabelNoPer, jLabelNoVolume, jLabelDate };
	private JLabel[] tabSupprimer = { jLabelNumDoc };
	
	private JTextField[] tabTfLivre = { jtfPrenom, jtfNomFamille, jtfTelephone, jtf4 };
	private JTextField[] tabTfDVD = { jtfPrenom, jtfNomFamille, jtfTelephone, jtf4, jtf5 };
	private JTextField[] tabTfPeriodique = { jtfPrenom, jtfNomFamille, jtfTelephone, jtf4, jtf5 };
	private JTextField[] tabTfSupprimer = { jtfPrenom };

	private ArrayList<Prepose> alPrepose = new ArrayList<Prepose>();
	private ArrayList<Adherent> alAdherent = new ArrayList<Adherent>();
	
	public GestionUtilisateur(LectureFichier lf) 
	{
		super("Gérer les usagers");
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
		
		//ajouter adherents
		jBtnAjouter.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(jtfPrenom.getText().equals("") || jtfNomFamille.getText().equals("") || jtfPrenom.getText().equals("")  )
				{
					 JOptionPane.showMessageDialog(null,"Le nom complet et le numero de telephone doivent etre remplis! ","Erreur", JOptionPane.INFORMATION_MESSAGE);
				}
				
				else
				{
					intCompteurInscription++;
					//intNumeroTelephone = Integer.parseInt(jtfTelephone.getText());
					strPrenom = jtfPrenom.getText();
					strNomDeFamille = jtfNomFamille.getText();
					
					Adherent adherent = new Adherent(intCompteurInscription,1,strPrenom,strNomDeFamille,"adresse");
					
					alAdherent.add(adherent);
					
					try
					{
						FileWriter fw = new FileWriter("Adherent.txt",true);
						BufferedWriter bw = new BufferedWriter(fw);
						PrintWriter pw = new PrintWriter(bw);
						
						pw.println("adhérent,a,a");
						pw.close();
						
					}
					
					catch(IOException a)
					{
						a.printStackTrace();
					}
					
					 JOptionPane.showMessageDialog(null,"L'utilisateur a ete ajouter","Erreur", JOptionPane.INFORMATION_MESSAGE);
					 
				}
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
