import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Interface extends JFrame
{
	private Container c = getContentPane();
	
	JFrame jframe = new JFrame();
	JTabbedPane jtab = new JTabbedPane();
	
	ArrayList<DVD> alDVD = new ArrayList<DVD>();
	ArrayList<Livre> alLvres= new ArrayList<Livre>();
	ArrayList<Periodique> alPeriodiques = new ArrayList<Periodique>();
	
	String[] strAdmin= {"Admin","Livre","Periodiques","DVDs","Recherche","Quitter"};
	String[] strAdherent = {"Adherent","Livre","Periodiques","DVDs","Recherche","Quitter"};
	String[] strPrepose = {"Prepose","Livre","Periodiques","DVDs","Recherche","Quitter"};
	
	Interface(String strUsager)
	{
		super("La mediatheque de GG");
		
		CreeTab(strUsager);
		
		add(jtab);
		
		setVisible(true);
		setSize(1000,700);
		setLocationRelativeTo(null);
		
		lireFichier("Livres.txt");
		
		/*//quitter
		jmenuquitter.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getSource() == jmenuquitter)
				{
					System.exit(0);
				}
			}
		});
		*/
		
		/*
		jtab.addChangeListener(new ChangeListener()
				{
					public void stateChanged(ChangeEvent e)
					{
						if(e.getSource().equals(jtab.getTitleAt(strArray.length-1)))
						{
							System.exit(0);
						}
					}
				});
				*/
	}
	
	public void lireFichier(String strFichier)
	{
		BufferedReader br = null;
		
		try
		{
			String strLigne;
			
			br = new BufferedReader(new FileReader(strFichier));
		
			StringTokenizer st = null;
			
			String strMot;
			int intRefLivre;
			String strLivre;
			String strDate;
			String strAuteur;
			
			while((strLigne=br.readLine()) != null)
			{
				st = new StringTokenizer(strLigne,",");
				
				if(strFichier.compareTo("Livres.txt")==0)
				{
					while(st.hasMoreTokens())
					{
						strMot = st.nextToken();
						intRefLivre =Integer.parseInt(strMot.substring(3));
						
						strLivre = st.nextToken();
						strDate = st.nextToken();
						
						Calendar cal = null;
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
						
						strAuteur = st.nextToken();
						
						Livre livre = new Livre(intRefLivre,strLivre,cal,strAuteur);
						
						//Livre livre = new Livre(strMot.substring(3));
						/*
						if(strFichier.compareTo("Livres.Txt".toLowerCase()) == 0)
						{
						}
						
						else if(strFichier.compareTo("DVD.txt".toLowerCase())==0)
						{
							
						}
						
						else if(strFichier.compareTo("Periodiques.txt".toLowerCase())==0)
						{
							
						}
						*/
					}
				}
				
			//System.out.println(strLigne);
			}
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void CreeTab(String strUsager)
	{
		if(strUsager == "Administration")
		{
			for(int i =0; i<strAdmin.length; i++)
			{
				jtab.addTab(strAdmin[i],null);
			}
		}
		
		else if(strUsager == "Adhérent")
		{
			for(int i =0; i<strAdherent.length; i++)
			{
				jtab.addTab(strAdherent[i],null);
			}
		}
		
		else
		{
			for(int i =0; i<strPrepose.length; i++)
			{
				jtab.addTab(strPrepose[i],null);
			}
		}
	}
}
