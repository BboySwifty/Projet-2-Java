package interfaces;
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
 
public class Interface extends JFrame
{
	JFrame jframe = new JFrame();
	JTabbedPane jtab = new JTabbedPane();
	
	JButton jbtnQuitter = new JButton("Quitter");
	JButton jbtnAjouterPrepose = new JButton("Ajouter Prepose");
	JButton jbtnRecherche = new JButton("Recherche de la requete: ");
	JButton jbtnModifierDocument = new JButton("Modifier document");
	JButton jbtnListerDocument = new JButton("Lister document");
	JButton jbtnAjouterDocument = new JButton("Ajouter document");
	JButton jbtnEmprunterDocument = new JButton("Emprunter document");
	JButton jbtnRetournerDocument = new JButton("Retourner document");
	JButton jbtnChangerEtat = new JButton("Changer etat");
	JButton jbtnVerifierDispo = new JButton("Verifier disponibilite");
	
	JLabel jlabelParAuteur = new JLabel("Par Auteur: ");
	JLabel jlabelParMotCles = new JLabel("Par Mot cles: ");
	
	JPanel jpanelSousRecherche1 = new JPanel();
	JPanel jpanelSousRecherche2 = new JPanel();
	JPanel jpanelSousRecherche3 = new JPanel();
	
	JPanel jpanelSousRechercheParAuteur = new JPanel();
	JPanel jpanelSousRechercheResultat = new JPanel();
	JPanel jpanelSousRechercheInformation = new JPanel();
	
	JPanel jpanela= new JPanel();
	JPanel jpanelb= new JPanel();
	JPanel jpanelc= new JPanel();
	
	JPanel jpanelCollection = new JPanel();
	JPanel jpanelLivres = new JPanel();
	JPanel jpanelPeriodiques = new JPanel();
	JPanel jpanelDVDs = new JPanel();
	
	JPanel jpanelRecherche = new JPanel();
	JPanel jpanelOptions = new JPanel();
	
	TitledBorder tbRecherche = new TitledBorder("Recherche");
	TitledBorder tbResultat = new TitledBorder("Résultats");
	TitledBorder tbInformation = new TitledBorder("Information");
	TitledBorder tbRechercheParAuteur = new TitledBorder("Recherche par auteur ou mot clé");
	TitledBorder tbSousResultat = new TitledBorder("Résultats");
	TitledBorder tbSousInformation = new TitledBorder("Information");
	
	public static JTextField jtAuteur = new JTextField();
	public JTextField jtMotDePasse = new JTextField();
	
	JLabel jlabelmario = new JLabel( new ImageIcon("mario.png"));
	JLabel jlabelboo = new JLabel( new ImageIcon("boo.png"));
	JLabel jlabelluigi = new JLabel( new ImageIcon("luigi.png"));
	
	String[] strTable ={"Numéro de document","Titre","Date de parution","Disponibilité"};
	String[] strAdmin= {"Collection","Livres","Periodiques","DVDs","Recherche","Options"};
	String[] strAdherent = {"Collection","Livres","Periodiques","DVDs","Recherche","Options"};
	String[] strPrepose = {"Collection","Livres","Periodiques","DVDs","Recherche","Options"};
	
	JPanel[] jpanelAdmin ={jpanelCollection,jpanelLivres, jpanelPeriodiques, jpanelDVDs, jpanelRecherche, jpanelOptions};
	JPanel[] jpanelAdherent ={jpanelCollection,jpanelLivres, jpanelPeriodiques, jpanelDVDs, jpanelRecherche, jpanelOptions};
	JPanel[] jpanelPrepose ={jpanelCollection,jpanelLivres, jpanelPeriodiques, jpanelDVDs, jpanelRecherche, jpanelOptions};
	
	LectureFichier lf = new LectureFichier();
	
	TableModelCollection tmLivre = new TableModelCollection(lf, "Livre");
	TableModelCollection tmDVD = new TableModelCollection(lf, "DVD");
	TableModelCollection tmPer = new TableModelCollection(lf, "Periodique");
	TableModelCollection tmColl = new TableModelCollection(lf, "Collection");

	JTable jtLiv = new JTable(tmLivre);
	JTable jtDVD = new JTable(tmDVD);
	JTable jtPer = new JTable(tmPer);
	JTable jtColl = new JTable(tmColl);

	JScrollPane jspLiv = new JScrollPane(jtLiv);
	JScrollPane jspDVD = new JScrollPane(jtDVD);
	JScrollPane jspPer = new JScrollPane(jtPer);
	JScrollPane jspColl = new JScrollPane(jtColl);
	
	TableRowSorter<TableModel> sorterLiv = new TableRowSorter<TableModel>(jtLiv.getModel());
	TableRowSorter<TableModel> sorterDVD = new TableRowSorter<TableModel>(jtDVD.getModel());
	TableRowSorter<TableModel> sorterPer = new TableRowSorter<TableModel>(jtPer.getModel());
	TableRowSorter<TableModel> sorterColl = new TableRowSorter<TableModel>(jtColl.getModel());
	
	Interface(String strUsager)
	{
		super("La mediatheque de GG");
		
		CreeTabRecherche(strUsager);
		CreeTabOption(strUsager);
		
		setVisible(true);
		setSize(1000,700);
		setLocationRelativeTo(null);
		
		jtLiv.setOpaque(true);
		jtDVD.setOpaque(true);
		jtPer.setOpaque(true);
		jtColl.setOpaque(true);
		
		jtLiv.setRowSorter(sorterLiv);
		jtDVD.setRowSorter(sorterDVD);
		jtPer.setRowSorter(sorterPer);
		jtColl.setRowSorter(sorterColl);
		
		jpanelCollection.setLayout(new GridLayout(1,1));
		jpanelLivres.setLayout(new GridLayout(1,1));
		jpanelDVDs.setLayout(new GridLayout(1,1));
		jpanelPeriodiques.setLayout(new GridLayout(1,1));
		
		jpanelLivres.add(jspLiv);
		jpanelDVDs.add(jspDVD);
		jpanelPeriodiques.add(jspPer);
		jpanelCollection.add(jspColl);

		add(jtab);
		
		jbtnAjouterPrepose.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getSource() == jbtnAjouterPrepose)
				{
					String strNomEntree = JOptionPane.showInputDialog("Entree le nom de l'usage: ");
					System.out.println(strNomEntree);
					
					String strMotDePasseEntree = JOptionPane.showInputDialog("Entree le mot de passe: ");
					System.out.println(strMotDePasseEntree);
					
					/*
					try
					{
						FileWriter file = new FileWriter("Usagers.txt",false);
						file.write("123");
						file.close();
						
					}
					
					catch(IOException o)
					{
						
					}
					*/
				}
			}
		});
		
		jbtnVerifierDispo.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						
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
	
	public void CreeTabRecherche(String strUsager)
	{
		if(strUsager == "Administration")
		{
			for(int i =0; i<strAdmin.length; i++)
			{
				jtab.addTab(strAdmin[i],jpanelAdmin[i]);
			}
			
			jpanelSousRecherche1.setLayout( new GridLayout(1,2));
			jpanelSousRecherche2.setLayout( new GridLayout(1,2));
			jpanelSousRecherche3.setLayout( new GridLayout(1,2));
			jpanelRecherche.setLayout(new GridLayout(3,1));
			
			jpanelSousRechercheParAuteur.setLayout(new GridLayout(3,1));
			
			jpanelSousRechercheParAuteur.setBorder(tbRechercheParAuteur);
			jpanelSousRechercheResultat.setBorder(tbSousResultat);
			jpanelSousRechercheInformation.setBorder(tbSousInformation);
			
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
		
		else if(strUsager == "Adhérent")
		{
			for(int i =0; i<strAdherent.length; i++)
			{
				jtab.addTab(strAdherent[i],jpanelAdherent[i]);
			}
		}
		
		else
		{
			for(int i =0; i<strPrepose.length; i++)
			{
				jtab.addTab(strPrepose[i],jpanelPrepose[i]);
			}
		}
	}
	
	//cree les buttons dans le tab d'option
	public void CreeTabOption(String strUsager)
	{
		if(strUsager == "Administration")
		{
			jpanelOptions.add(jbtnAjouterPrepose);
		}

		else if(strUsager == "Adhérent")
		{
			jpanelOptions.add(jbtnRetournerDocument);
			jpanelOptions.add(jbtnListerDocument);
		}
		
		else
		{
			jpanelOptions.add(jbtnModifierDocument);
			jpanelOptions.add(jbtnAjouterDocument);
			jpanelOptions.add(jbtnEmprunterDocument);
			jpanelOptions.add(jbtnRetournerDocument);
			jpanelOptions.add(jbtnChangerEtat);
			jpanelOptions.add(jbtnVerifierDispo);
		}
		
		jpanelOptions.add(jbtnQuitter);
	}
}
