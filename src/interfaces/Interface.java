package interfaces;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import données.DVD;
import données.LectureFichier;
import données.Livre;
import données.Periodique;
import données.TableModelCollection;
 
public class Interface extends JFrame
{
	private Container c = getContentPane();

	JFrame jframe = new JFrame();
	JTabbedPane jtab = new JTabbedPane();
	
	JButton jbtnQuitter = new JButton("Quitter");
	JButton jbtnAjouterPrepose = new JButton("Ajouter Prepose");
	
	JTable jtable = new JTable();
	
	JPanel jpanel1 = new JPanel();
	JPanel jpanel2 = new JPanel();
	 
	JPanel jpanelCollection = new JPanel();
	JPanel jpanelLivres = new JPanel();
	JPanel jpanelPeriodiques = new JPanel();
	JPanel jpanelDVDs = new JPanel();
	JPanel jpanelRecherche = new JPanel();
	JPanel jpanelOptions = new JPanel();
	
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
		
		LectureFichier lf = new LectureFichier("livres.txt");
		TableModelCollection tm = new TableModelCollection(lf.alLivres);
		JTable jt = new JTable(tm);
		JScrollPane jsp = new JScrollPane(jt);
		
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
							Scanner scanner = new Scanner(System.in);
							
							strAjoutNom = scanner.nextLine();
							
							strAjoutMotDePasse = scanner.nextLine();
						}
					}
				});
		jpanelCollection.add(jsp);

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
