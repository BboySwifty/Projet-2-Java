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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	
	JLabel jlabel = new JLabel();
	
	ArrayList<DVD> alDVDs = new ArrayList<DVD>();
	ArrayList<Livre> alLivres= new ArrayList<Livre>();
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
			StringTokenizer st = null;
			br = new BufferedReader(new FileReader(strFichier));

			int intRefLivre;
			
			String strLigne;
			String strMot;
			String strNomLivre;
			String strDate;
			String strAuteur;
			
			while((strLigne=br.readLine()) != null)
			{
				st = new StringTokenizer(strLigne,",");
				
				if(strFichier.compareTo("Livres.txt")==0)
				{
					while(st.hasMoreTokens())
					{
						//int Ref du livre
						strMot = st.nextToken();
						intRefLivre =Integer.parseInt(strMot.substring(3));
						
						//nom du livre
						strNomLivre = st.nextToken();
						
						//Date publication
						strDate = st.nextToken().trim();
						
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
						Calendar cal = Calendar.getInstance();
						
						try
						{
							cal.setTime(sdf.parse(strDate));
						} 
						
						catch (ParseException e) 
						{
							e.printStackTrace();
						}
						
						//System.out.println(sdf.format(cal.getTime()));
						
						//Nom de l'auteur
						strAuteur = st.nextToken();
						
						Livre livre = new Livre(intRefLivre,strNomLivre,cal,strAuteur);
						
						alLivres.add(livre);
					}
				}
				
				else if(strFichier.compareTo("Livres.Txt".toLowerCase()) == 0)
				{
					while(st.hasMoreTokens())
					{
						
					}
				}
				
				else if(strFichier.compareTo("Periodiques.txt".toLowerCase())==0)
				{
					while(st.hasMoreTokens())
					{
						
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
