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
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import données.DVD;
import données.Livre;
import données.Periodique;
 
public class Interface extends JFrame
{
	private Container c = getContentPane();

	JFrame jframe = new JFrame();
	JTabbedPane jtab = new JTabbedPane();
	
	JButton jbtnQuitter = new JButton("Quitter");
	
	JTable jtable = new JTable();
	
	JPanel jpanel1 = new JPanel();
	JPanel jpanel2 = new JPanel();
	 
	JPanel jpanelCollection = new JPanel();
	JPanel jpanelLivres = new JPanel();
	JPanel jpanelPeriodiques = new JPanel();
	JPanel jpanelDVDs = new JPanel();
	JPanel jpanelRecherche = new JPanel();
	JPanel jpanelOptions = new JPanel();
	JPanel jpanelQuitter = new JPanel();
	
	String[] strAdmin= {"Collection","Livres","Periodiques","DVDs","Recherche","Options","Quitter"};
	String[] strAdherent = {"Collection","Livres","Periodiques","DVDs","Recherche","Quitter"};
	String[] strPrepose = {"Collection","Livres","Periodiques","DVDs","Recherche","Quitter"};
	
	JPanel[] jpanelAdmin ={jpanelCollection,jpanelLivres, jpanelPeriodiques, jpanelDVDs, jpanelRecherche, jpanelOptions, jpanelQuitter};
	JPanel[] jpanelAdherent ={jpanelCollection,jpanelLivres, jpanelPeriodiques, jpanelDVDs, jpanelRecherche, jpanelOptions, jpanelQuitter};
	JPanel[] jpanelPrepose ={jpanelCollection,jpanelLivres, jpanelPeriodiques, jpanelDVDs, jpanelRecherche, jpanelOptions, jpanelQuitter};
	
	ArrayList<DVD> alDVDs = new ArrayList<DVD>();
	ArrayList<Livre> alLivres= new ArrayList<Livre>();
	ArrayList<Periodique> alPeriodiques = new ArrayList<Periodique>();
	
	int intRef;
	int intNombreDisques;
	int intNumeroVolume;
	int intNumeroPeriodique;
	
	String strLigne;
	String strMot;
	String strTitre;
	String strDate;
	String strAuteur;
	
	Interface(String strUsager)
	{
		super("La mediatheque de GG");
		
		CreeTab(strUsager);
		
		add(jtab);
		
		setVisible(true);
		setSize(1000,700);
		setLocationRelativeTo(null);
		
		lireFichier("dvd.txt");
		
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
	
	public void lireFichier(String strFichier)
	{
		BufferedReader br = null;

		try
		{
			StringTokenizer st = null;
			br = new BufferedReader(new FileReader(strFichier));
			
			while((strLigne=br.readLine()) != null)
			{
				st = new StringTokenizer(strLigne,",");
				
				if(strFichier.equalsIgnoreCase("livres.txt"))
				{
					while(st.hasMoreTokens())
					{
						//int Ref du livre
						strMot = st.nextToken();
						intRef =Integer.parseInt(strMot.substring(3));
						
						//Titre du livre
						strTitre= st.nextToken().trim();
						
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
						
						//Nom de l'auteur
						strAuteur = st.nextToken().trim();
						Livre livre = new Livre(intRef,strTitre,strDate,strAuteur);
						
						alLivres.add(livre);
					}
				}
				
				else if(strFichier.equalsIgnoreCase("dvd.txt"))
				{
					while(st.hasMoreTokens())
					{
						strMot = st.nextToken();
						intRef = Integer.parseInt(strMot.substring(3));
						
						strTitre = st.nextToken();
						strDate = st.nextToken().trim();
						
						intNombreDisques = Integer.parseInt(st.nextToken());
						strAuteur = st.nextToken();
						
						DVD dvd = new DVD(intRef, strTitre, strDate, intNombreDisques, strAuteur);
						
						alDVDs.add(dvd);
					}
				}
				
				else if(strFichier.compareTo("Periodiques.txt".toLowerCase())==0)
				{
					while(st.hasMoreTokens())
					{
						strMot = st.nextToken();
						intRef = Integer.parseInt(strMot.substring(3));
						
						strTitre = st.nextToken().trim();;
						strDate = st.nextToken().trim();
						intNumeroVolume = Integer.parseInt(st.nextToken());
						intNumeroPeriodique = Integer.parseInt(st.nextToken());
						
						Periodique periodique = new Periodique(intRef, strTitre, strDate, intNumeroVolume, intNumeroPeriodique);
						
						alPeriodiques.add(periodique);
					}
				}
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
				jtab.addTab(strAdmin[i],jpanelAdmin[i]);
				jpanelQuitter.add(jbtnQuitter,BorderLayout.CENTER);
			}
		}
		
		else if(strUsager == "Adhérent")
		{
			for(int i =0; i<strAdherent.length; i++)
			{
				jtab.addTab(strAdherent[i],jpanelAdherent[i]);
				jpanelQuitter.add(jbtnQuitter,BorderLayout.CENTER);
			}
		}
		
		else
		{
			for(int i =0; i<strPrepose.length; i++)
			{
				jtab.addTab(strPrepose[i],jpanelPrepose[i]);
				jpanelQuitter.add(jbtnQuitter,BorderLayout.CENTER);
			}
		}
	}

	//getters
	public String getStrDate() {
		return strDate;
	}

	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}

	public String getStrAuteur() {
		return strAuteur;
	}

	public void setStrAuteur(String strAuteur) {
		this.strAuteur = strAuteur;
	}

	public String[] getStrPrepose() {
		return strPrepose;
	}

	public int getIntRef() {
		return intRef;
	}

	public int getIntNombreDisques() {
		return intNombreDisques;
	}

	public int getIntNumeroVolume() {
		return intNumeroVolume;
	}

	public int getIntNumeroPeriodique() {
		return intNumeroPeriodique;
	}

	public String getStrLigne() {
		return strLigne;
	}

	public String getStrMot() {
		return strMot;
	}

	public String getStrTitre() {
		return strTitre;
	}
}
