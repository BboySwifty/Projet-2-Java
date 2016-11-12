package interfaces;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import données.LectureFichier;
import données.TableModelCollection;

public class Interface extends JFrame {
	LectureFichier lf = new LectureFichier();

	JFrame jframe = new JFrame();
	JTabbedPane jtab = new JTabbedPane();

	public static JTextField jtAuteur = new JTextField();
	public static JTextField jtMotDePasse = new JTextField();

	private JButton jbtnQuitter = new JButton("Quitter");
	private JButton jbtnAjouterPrepose = new JButton("Ajouter Prepose");
	private JButton jbtnRecherche = new JButton("Recherche de la requete: ");
	private JButton jbtnModifierDocument = new JButton("Modifier document");
	private JButton jbtnListerDocument = new JButton("Lister document");
	private JButton jbtnAjouterDocument = new JButton("Ajouter document");
	private JButton jbtnEmprunterDocument = new JButton("Emprunter document");
	private JButton jbtnRetournerDocument = new JButton("Retourner document");
	private JButton jbtnChangerEtat = new JButton("Changer etat");
	private JButton jbtnVerifierDispo = new JButton("Verifier disponibilite");

	private JLabel jlabelParAuteur = new JLabel("Par Auteur: ");
	private JLabel jlabelParMotCles = new JLabel("Par Mot cles: ");

	private JPanel jpanelSousRecherche1 = new JPanel();
	private JPanel jpanelSousRecherche2 = new JPanel();
	private JPanel jpanelSousRecherche3 = new JPanel();
	private JPanel jpanelSousRechercheParAuteur = new JPanel();
	private JPanel jpanelSousRechercheResultat = new JPanel();
	private JPanel jpanelSousRechercheInformation = new JPanel();

	private JPanel jpanela = new JPanel();
	private JPanel jpanelb = new JPanel();
	private JPanel jpanelc = new JPanel();

	private JPanel jpanelCollection = new JPanel();
	private JPanel jpanelLivres = new JPanel();
	private JPanel jpanelPeriodiques = new JPanel();
	private JPanel jpanelDVDs = new JPanel();
	private JPanel jpanelRecherche = new JPanel();
	private JPanel jpanelOptions = new JPanel();

	private JLabel jlabelmario = new JLabel(new ImageIcon("mario.png"));
	private JLabel jlabelboo = new JLabel(new ImageIcon("boo.png"));
	private JLabel jlabelluigi = new JLabel(new ImageIcon("luigi.png"));

	private JPanel[] jpanelAdmin = { jpanelCollection, jpanelLivres, jpanelPeriodiques, jpanelDVDs, jpanelRecherche,
			jpanelOptions };
	private JPanel[] jpanelAdherent = { jpanelCollection, jpanelLivres, jpanelPeriodiques, jpanelDVDs, jpanelRecherche,
			jpanelOptions };
	private JPanel[] jpanelPrepose = { jpanelCollection, jpanelLivres, jpanelPeriodiques, jpanelDVDs, jpanelRecherche,
			jpanelOptions };

	private String[] strAdmin = { "Collection", "Livres", "Periodiques", "DVDs", "Recherche", "Options" };
	private String[] strAdherent = { "Collection", "Livres", "Periodiques", "DVDs", "Recherche", "Options" };
	private String[] strPrepose = { "Collection", "Livres", "Periodiques", "DVDs", "Recherche", "Options" };

	private TitledBorder tbRecherche = new TitledBorder("Recherche");
	private TitledBorder tbResultat = new TitledBorder("Résultats");
	private TitledBorder tbInformation = new TitledBorder("Information");
	private TitledBorder tbRechercheParAuteur = new TitledBorder("Recherche par auteur ou mot clé");
	private TitledBorder tbSousResultat = new TitledBorder("Résultats");
	private TitledBorder tbSousInformation = new TitledBorder("Information");

	private TableModelCollection tmLivre = new TableModelCollection(lf, "Livre");
	private TableModelCollection tmDVD = new TableModelCollection(lf, "DVD");
	private TableModelCollection tmPer = new TableModelCollection(lf, "Periodique");
	private TableModelCollection tmColl = new TableModelCollection(lf, "Collection");

	private JTable jtLiv = new JTable(tmLivre);
	private JTable jtDVD = new JTable(tmDVD);
	private JTable jtPer = new JTable(tmPer);
	private JTable jtColl = new JTable(tmColl);

	private JScrollPane jspLiv = new JScrollPane(jtLiv);
	private JScrollPane jspDVD = new JScrollPane(jtDVD);
	private JScrollPane jspPer = new JScrollPane(jtPer);
	private JScrollPane jspColl = new JScrollPane(jtColl);

	private TableRowSorter<TableModel> sorterLiv = new TableRowSorter<TableModel>(jtLiv.getModel());
	private TableRowSorter<TableModel> sorterDVD = new TableRowSorter<TableModel>(jtDVD.getModel());
	private TableRowSorter<TableModel> sorterPer = new TableRowSorter<TableModel>(jtPer.getModel());
	private TableRowSorter<TableModel> sorterColl = new TableRowSorter<TableModel>(jtColl.getModel());

	Interface(String strUsager) {
		super("La mediatheque de GG");

		CreeFunctionsButtons();
		CreeTabRecherche(strUsager);
		CreeTabOption(strUsager);

		setVisible(true);
		setSize(1000, 700);
		setLocationRelativeTo(null);

		jpanelCollection.setLayout(new GridLayout(1, 1));
		jpanelLivres.setLayout(new GridLayout(1, 1));
		jpanelDVDs.setLayout(new GridLayout(1, 1));
		jpanelPeriodiques.setLayout(new GridLayout(1, 1));

		jtLiv.setOpaque(true);
		jtDVD.setOpaque(true);
		jtPer.setOpaque(true);
		jtColl.setOpaque(true);

		jtLiv.setRowSorter(sorterLiv);
		jtDVD.setRowSorter(sorterDVD);
		jtPer.setRowSorter(sorterPer);
		jtColl.setRowSorter(sorterColl);

		jpanelLivres.add(jspLiv);
		jpanelDVDs.add(jspDVD);
		jpanelPeriodiques.add(jspPer);
		jpanelCollection.add(jspColl);

		add(jtab);
	}

	public void CreeTabRecherche(String strUsager) {
		for (int i = 0; i < strAdmin.length; i++) {
			jtab.addTab(strAdmin[i], jpanelAdmin[i]);
		}

		jpanelSousRecherche1.setLayout(new GridLayout(1, 2));
		jpanelSousRecherche2.setLayout(new GridLayout(1, 2));
		jpanelSousRecherche3.setLayout(new GridLayout(1, 2));
		jpanelRecherche.setLayout(new GridLayout(3, 1));
		
		jtAuteur.setPreferredSize(new Dimension(200, 25));

		jpanelSousRechercheParAuteur.setLayout(new GridLayout(3, 1));

		jpanelSousRechercheParAuteur.setBorder(tbRechercheParAuteur);
		jpanelSousRechercheResultat.setBorder(tbSousResultat);
		jpanelSousRechercheInformation.setBorder(tbSousInformation);
		
		jtAuteur.setPreferredSize(new Dimension(100,20));
		jtMotDePasse.setPreferredSize(new Dimension(100,20));
		
		jpanela.add(jlabelParAuteur);
		jpanela.add(jtAuteur);
		jpanelSousRechercheParAuteur.add(jpanela);

		jpanelb.add(jlabelParMotCles);
		jpanelb.add(jtMotDePasse);
		jpanelSousRechercheParAuteur.add(jpanelb);

		jpanelc.add(jbtnRecherche);
		jpanelSousRechercheParAuteur.add(jpanelc);

		jpanelSousRecherche1.setBorder(tbRecherche);
		jpanelSousRecherche2.setBorder(tbResultat);
		jpanelSousRecherche3.setBorder(tbInformation);

		jpanelSousRecherche1.add(jlabelmario);
		jpanelSousRecherche2.add(jlabelboo);
		jpanelSousRecherche3.add(jlabelluigi);

		jpanelSousRecherche1.add(jpanelSousRechercheParAuteur);
		jpanelSousRecherche2.add(jpanelSousRechercheResultat);
		jpanelSousRecherche3.add(jpanelSousRechercheInformation);

		jpanelRecherche.add(jpanelSousRecherche1);
		jpanelRecherche.add(jpanelSousRecherche2);
		jpanelRecherche.add(jpanelSousRecherche3);
	}

	// ajouter les buttons dans le tab d'option
	public void CreeTabOption(String strUsager) {
		if (strUsager == "Administration") {
			jpanelOptions.add(jbtnAjouterPrepose);
		}

		else if (strUsager == "Adhérent") {
			jpanelOptions.add(jbtnRetournerDocument);
			jpanelOptions.add(jbtnListerDocument);
		}

		else {
			jpanelOptions.add(jbtnModifierDocument);
			jpanelOptions.add(jbtnAjouterDocument);
			jpanelOptions.add(jbtnEmprunterDocument);
			jpanelOptions.add(jbtnRetournerDocument);
			jpanelOptions.add(jbtnChangerEtat);
			jpanelOptions.add(jbtnVerifierDispo);
		}

		jpanelOptions.add(jbtnQuitter);
	}

	// creer les fonctions des buttons
	public void CreeFunctionsButtons() {
		jbtnAjouterPrepose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == jbtnAjouterPrepose) {
					String strNomEntree = JOptionPane.showInputDialog("Entree le nom de l'usage: ");
					System.out.println(strNomEntree);

					String strMotDePasseEntree = JOptionPane.showInputDialog("Entree le mot de passe: ");
					System.out.println(strMotDePasseEntree);

					/*
					 * try { FileWriter file = new
					 * FileWriter("Usagers.txt",false); file.write("123");
					 * file.close();
					 * 
					 * }
					 * 
					 * catch(IOException o) {
					 * 
					 * }
					 */
				}
			}
		});
		
		jbtnRecherche.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						if(e.getSource() == jbtnRecherche)
						{
							TableModelCollection tmRecherche = new TableModelCollection(lf, "Recherche");
							JTable jtRecherche = new JTable(tmRecherche);
							JScrollPane jspRecherche = new JScrollPane(jtRecherche);
							TableRowSorter<TableModel> sorterRecherche = new TableRowSorter<TableModel>(jtRecherche.getModel());

							jtRecherche.setOpaque(true);
							jtRecherche.setRowSorter(sorterRecherche);
							jpanelSousRechercheResultat.removeAll();
							jpanelSousRechercheResultat.add(jspRecherche);
							jpanelSousRechercheResultat.validate();
							jpanelSousRechercheResultat.repaint();
						}
					}
			
				});
		
		jbtnVerifierDispo.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						//JOptionPane.showMessageDialog(null, "", "Disponibilite du document", JOptionPane.INFORMATION_MESSAGE);
					}
			
				});
		
		//button Quitter
		jbtnQuitter.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						if(e.getSource() == jbtnQuitter)
						{
							System.exit(0);
						}
					}
				});
	}
}
