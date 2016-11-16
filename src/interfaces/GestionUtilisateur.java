package interfaces;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

import données.Adherent;
import données.LectureFichier;
import données.ListeUtilisateur;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GestionUtilisateur extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Container c = getContentPane();
	
	//declarations d'instances
	private int intCompteurInscription = 0;
	private String strTelephone;
	
	private String strPrenom;
	private String strNomDeFamille;

	private LectureFichier lf;
	private ListeUtilisateur lu;

	private String[] strCombo = {"Ajouter un utilisateur","Ajouter un prepose", "Modifier un utilisateur", "Supprimer un utilisateur" };

	private JComboBox<?> jcb = new JComboBox<Object>(strCombo);

	private JPanel jpMain = new JPanel();
	private JPanel jpTxt = new JPanel();

	private JLabel jLabelNumDoc = new JLabel("Prenom de l'utilisateur : "); 
	private JLabel jLabelTitre = new JLabel("Nom famille de l'utilisateur: ");
	private JLabel jLabelAuteur = new JLabel("Numero telephone: ");
	
	private JLabel jLabelRealisateur = new JLabel("Nom du réalisateur : ");
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

	private JLabel[] tabLivre = { jLabelNumDoc, jLabelTitre, jLabelAuteur};
	private JLabel[] tabDVD = { jLabelNumDoc, jLabelTitre, jLabelRealisateur, jLabelDisques};
	private JLabel[] tabPeriodique = { jLabelNumDoc, jLabelTitre, jLabelNoPer, jLabelNoVolume};
	private JLabel[] tabSupprimer = { jLabelNumDoc };
	
	private JTextField[] tabTfLivre = { jtfPrenom, jtfNomFamille, jtfTelephone, jtf4 };
	private JTextField[] tabTfDVD = { jtfPrenom, jtfNomFamille, jtfTelephone, jtf4, jtf5 };
	private JTextField[] tabTfPeriodique = { jtfPrenom, jtfNomFamille, jtfTelephone, jtf4, jtf5 };
	private JTextField[] tabTfSupprimer = { jtfPrenom };

	public GestionUtilisateur(ListeUtilisateur lu) 
	{
		super("Gérer les usagers");
		setSize(350, 300);
		setLocationRelativeTo(null);
		
		this.lu = lu;

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
		jpMain.add(jpTxt);
		jpMain.add(jBtnAjouter, BorderLayout.SOUTH);

		GestionTextField("Livre");

		add(jcb, BorderLayout.NORTH);
		add(jpMain);
		setVisible(true);
	}

	//ajout des listeners
	private void AjoutListeners() {
		jcb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				jpMain.removeAll();

				if (jcb.getSelectedItem().equals(strCombo[0])) {

					jpMain.add(jpTxt);
					jpMain.add(jBtnAjouter, BorderLayout.SOUTH);

				} else if (jcb.getSelectedItem().equals(strCombo[1])) {

					jpMain.add(jpTxt);
					jpMain.add(jBtnModifier, BorderLayout.SOUTH);

					GestionTextField("Supprimer");
				} 
				
				
				else 
				{
					jpMain.add(jpTxt);
					jpMain.add(jBtnSupprimer);
					GestionTextField("Supprimer");
				}

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
					strTelephone = jtfTelephone.getText();
					strPrenom = jtfPrenom.getText();
					strNomDeFamille = jtfNomFamille.getText();
					
					Adherent adherent = new Adherent(intCompteurInscription,strTelephone,strPrenom,strNomDeFamille,"adresse");
					
					ListeUtilisateur.getAlAdherent().add(adherent);
					
					try
					{
						FileWriter fw = new FileWriter("Adherent.txt",true);
						BufferedWriter bw = new BufferedWriter(fw);
						PrintWriter pw = new PrintWriter(bw);
						
						pw.println("adhérent,"+strTelephone+","+strPrenom+" " +strNomDeFamille);
						pw.close();
					}
					
					catch(IOException a)
					{
						a.printStackTrace();
					}
					
					 JOptionPane.showMessageDialog(null,"L'utilisateur a ete ajouter","", JOptionPane.INFORMATION_MESSAGE);
					 
				}
			}
		});
		
		//supprimer lutilisateur
		jBtnSupprimer.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						
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
