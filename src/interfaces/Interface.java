package interfaces;
import java.awt.Container;
import java.awt.Font;
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
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import données.LectureFichier;
import données.TableModelCollection;
 
public class Interface extends JFrame
{
	private Container c = getContentPane();

	JFrame jframe = new JFrame();
	JTabbedPane jtab = new JTabbedPane();
	
	JButton jbtnQuitter = new JButton("Quitter");
	JButton jbtnAjouterPrepose = new JButton("Ajouter Prepose");
	JButton jbtnRecherche = new JButton("Chercher: ");
	
	JTable jtable = new JTable();
	
	JPanel jpanelSousRecherche1 = new JPanel();
	JPanel jpanelSousRecherche2 = new JPanel();
	JPanel jpanelSousRecherche3 = new JPanel();
	
	JPanel jpanelSousRechercheParAuteur = new JPanel();
	JPanel jpanelSousRechercheInformation = new JPanel();
	
	JPanel jpanelCollection = new JPanel();
	JPanel jpanelLivres = new JPanel();
	JPanel jpanelPeriodiques = new JPanel();
	JPanel jpanelDVDs = new JPanel();
	JPanel jpanelRecherche = new JPanel();
	JPanel jpanelOptions = new JPanel();
	
	TitledBorder tbRechercheParAuteur = new TitledBorder("Recherche par auteur ou mot clé");
	TitledBorder tbRecherche = new TitledBorder("Recherche");
	TitledBorder tbResultat = new TitledBorder("Résultats");
	TitledBorder tbInformation = new TitledBorder("Information");
	TitledBorder tbSousInformation = new TitledBorder("Information");
	
	JTextArea jtAuteur = new JTextArea();
	JTextArea jtMotCle = new JTextArea();
	
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
	
	
	
	Interface(String strUsager)
	{
		super("La mediatheque de GG");
		
		CreeTab(strUsager);
		
		
		setVisible(true);
		setSize(1000,700);
		setLocationRelativeTo(null);
		
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
		
		
		jbtnAjouterPrepose.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						String strAjoutNom;
						String strAjoutMotDePasse;
						
						if(e.getSource() == jbtnAjouterPrepose)
						{
							String strNomEntree = JOptionPane.showInputDialog("Entree le nom de l'usagee: ");
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
		LectureFichier lf = new LectureFichier();
		
		TableModelCollection tmLivre = new TableModelCollection(lf, "Livre");
		TableModelCollection tmColl = new TableModelCollection(lf, "Collection");
		
		JTable jtColl = new JTable(tmColl);
		JTable jtLiv = new JTable(tmLivre);
		
		JScrollPane jspColl = new JScrollPane(jtColl);
		JScrollPane jspLiv = new JScrollPane(jtLiv);
		
		jtColl.setOpaque(true);
		jtLiv.setOpaque(true);
		
		jpanelCollection.setLayout(new GridLayout(1,1));
		jpanelLivres.setLayout(new GridLayout(1,1));
		
		jpanelCollection.add(jspColl);
		jpanelLivres.add(jspLiv);

		add(jtab);
	}
	
	public void CreeTab(String strUsager)
	{
		if(strUsager == "Administration")
		{
			for(int i =0; i<strAdmin.length; i++)
			{
				jtab.addTab(strAdmin[i],jpanelAdmin[i]);
				jpanelOptions.add(jbtnAjouterPrepose);
			}
			
			jpanelOptions.add(jbtnAjouterPrepose);
			
			jpanelSousRecherche1.setLayout( new GridLayout(1,2));
			jpanelSousRecherche3.setLayout( new GridLayout(1,2));
			jpanelRecherche.setLayout(new GridLayout(3,1));
			
			jpanelSousRechercheParAuteur.setBorder(tbRechercheParAuteur);
			
			jpanelSousRechercheInformation.setBorder(tbSousInformation);
			
			jpanelSousRechercheParAuteur.add(jbtnRecherche);
			jpanelSousRechercheParAuteur.add(jtAuteur);
			
			jpanelSousRecherche1.setBorder(tbRecherche);
			jpanelSousRecherche2.setBorder(tbResultat);
			jpanelSousRecherche3.setBorder(tbInformation);
			
			jpanelSousRecherche1.add(jlabelmario);
			jpanelSousRecherche1.add(jpanelSousRechercheParAuteur);
			jpanelSousRecherche2.add(jlabelboo);
			jpanelSousRecherche3.add(jlabelluigi);
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
		
		jpanelOptions.add(jbtnQuitter);
	}
}
