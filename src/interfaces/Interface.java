package interfaces;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import données.LectureFichier;
import données.TableModelCollection;

public class Interface extends JFrame implements TableModelListener {
	LectureFichier lf = new LectureFichier();

	JFrame jframe = new JFrame();
	JTabbedPane jtab = new JTabbedPane();

	public static JTextField jtAuteur = new JTextField();
	public static JTextField jtMotDePasse = new JTextField();

	private JButton jbtnQuitter = new JButton("Quitter");
	private JButton jbtnAjouterPrepose = new JButton("Ajouter Prepose");
	private JButton jbtnRecherche = new JButton("Recherche de la requete");
	private JButton jbtnModifierDocument = new JButton("Modifier document");
	private JButton jbtnListerDocument = new JButton("Lister document");
	private JButton jbtnAjouterDocument = new JButton("Ajouter document");
	private JButton jbtnEmprunterDocument = new JButton("Emprunter document");
	private JButton jbtnRetournerDocument = new JButton("Retourner document");
	private JButton jbtnGestionUsagers = new JButton("Gérer les usagers");

	private JLabel jlabelParAuteur = new JLabel("Par Auteur: ");
	private JLabel jlabelParMotCles = new JLabel("Par Mot cles: ");

	private JPanel jpanelSousRecherche1 = new JPanel();
	private JPanel jpanelSousRecherche2 = new JPanel();
	private JPanel jpanelSousRechercheParAuteur = new JPanel();
	private JPanel jpanelSousRechercheResultat = new JPanel();
	private JPanel jpanelImageMario = new JPanel();
	private JPanel jpanelImageLuigi = new JPanel();

	private JPanel jpanela = new JPanel();
	private JPanel jpanelb = new JPanel();
	private JPanel jpanelc = new JPanel();

	private JPanel jpanelCollection = new JPanel();
	private JPanel jpanelLivres = new JPanel();
	private JPanel jpanelPeriodiques = new JPanel();
	private JPanel jpanelDVDs = new JPanel();
	private JPanel jpanelRecherche = new JPanel();
	private JPanel jpanelOptions = new JPanel();

	private JPanel jpanelActions = new JPanel();
	private JPanel jpanelSousLivres = new JPanel();
	private JPanel jpanelSousPeriodiques = new JPanel();
	private JPanel jpanelSousDVDs = new JPanel();

	private JLabel jlabelmario = new JLabel(new ImageIcon("mario.png"));
	//private JLabel jlabelboo = new JLabel(new ImageIcon("boo.png"));
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
	private TitledBorder tbActions = new TitledBorder("Actions");
	private TitledBorder tbRechercheParAuteur = new TitledBorder("Recherche par auteur ou mot clé");
	private TitledBorder tbSousResultat = new TitledBorder("Résultats");

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
		CreeTabRecherche();
		CreeTabOption(strUsager);

		setVisible(true);
		setSize(1000, 700);
		setLocationRelativeTo(null);

		jtab.setPreferredSize(new Dimension(980, 435));

		jspLiv.setPreferredSize(new Dimension(975, 400));
		jspDVD.setPreferredSize(new Dimension(975, 400));
		jspPer.setPreferredSize(new Dimension(975, 400));
		jspColl.setPreferredSize(new Dimension(975, 400));

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

		jpanelActions.add(jbtnAjouterDocument);
		jpanelActions.add(jbtnModifierDocument);
		jpanelActions.add(jbtnEmprunterDocument);
		jpanelActions.add(jbtnRetournerDocument);
		jpanelActions.add(jbtnGestionUsagers);
		jpanelActions.add(jbtnQuitter);
		jpanelActions.setBorder(tbActions);
		add(jtab, BorderLayout.NORTH);
		add(jpanelActions, BorderLayout.SOUTH);
	}

	public void CreeTabRecherche() {
		for (int i = 0; i < strAdmin.length; i++) {
			jtab.addTab(strAdmin[i], jpanelAdmin[i]);
		}

		jpanelRecherche.setLayout(new GridLayout(2, 1));

		jtAuteur.setPreferredSize(new Dimension(200, 25));
		jtMotDePasse.setPreferredSize(new Dimension(200, 25));

		jpanelSousRechercheParAuteur.setLayout(new GridLayout(3, 1));

		jpanelSousRechercheParAuteur.setBorder(tbRechercheParAuteur);
		jpanelSousRechercheResultat.setBorder(tbSousResultat);
		
		jpanelSousRechercheParAuteur.setPreferredSize(new Dimension(600, 155));
		jpanelSousRechercheResultat.setPreferredSize(new Dimension(600, 155));

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
		
		jpanelImageMario.add(jlabelmario);
		jpanelImageLuigi.add(jlabelluigi);
		
		jpanelImageMario.setPreferredSize(new Dimension(300, 155));
		jpanelImageLuigi.setPreferredSize(new Dimension(300, 155));
		
		jpanelSousRecherche1.add(jpanelImageMario);
		jpanelSousRecherche2.add(jpanelImageLuigi);

		jpanelSousRecherche1.add(jpanelSousRechercheParAuteur);
		jpanelSousRecherche2.add(jpanelSousRechercheResultat);
		//jpanelSousRecherche3.add(jpanelSousRechercheInformation);

		jpanelRecherche.add(jpanelSousRecherche1);
		jpanelRecherche.add(jpanelSousRecherche2);
		//jpanelRecherche.add(jpanelSousRecherche3);
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
		}

		jpanelOptions.add(jbtnQuitter);
	}

	// creer les fonctions des buttons
	public void CreeFunctionsButtons() {

		// ajouter prepose
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

		jbtnRecherche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == jbtnRecherche) {
					TableModelCollection tmRecherche = new TableModelCollection(lf, "Recherche");
					JTable jtRecherche = new JTable(tmRecherche);

					if(tmRecherche.getRowCount() != 0)
					{
						JScrollPane jspRecherche = new JScrollPane(jtRecherche);
						TableRowSorter<TableModel> sorterRecherche = new TableRowSorter<TableModel>(
								jtRecherche.getModel());
						jspRecherche.setPreferredSize(new Dimension(565, 120));

						jtRecherche.setOpaque(true);
						jtRecherche.setRowSorter(sorterRecherche);
						jpanelSousRechercheResultat.removeAll();
						jpanelSousRechercheResultat.add(jspRecherche);
						jpanelSousRechercheResultat.validate();
						jpanelSousRechercheResultat.repaint();
						
					}
				}
			}

		});

		// button Quitter
		jbtnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == jbtnQuitter) {
					dispose();
				}
			}
		});
	}

	@Override
	public void tableChanged(TableModelEvent e) {

	}
}
