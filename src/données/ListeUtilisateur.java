package données;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JFrame;

import interfaces.Interface;

public class ListeUtilisateur 
{
	private static ArrayList<Prepose> alPrepose = new ArrayList<Prepose>();
	private static ArrayList<Adherent> alAdherent = new ArrayList<Adherent>();
	private BufferedReader bf;
	
	public ListeUtilisateur()
	{
		BufferedReader br = null;
		StringTokenizer st = null;
		
		try 
		{
			
			String strLigne;
		{
		br = new BufferedReader(new FileReader("Usagers.txt"));

		while ((strLigne = br.readLine()) != null) 
		{
			st = new StringTokenizer(strLigne, ",");

			while (st.hasMoreTokens()) 
			{
				// verifie si l'usager est dans le bon compte
				// verifie si l'usager existe
				// verifie si c'est le meme mot de passe
				
				if (st.nextToken().compareToIgnoreCase("Adhérent") == 0)
				{
					
				}
				
				else
				{
					Prepose prepose = new Prepose("a","a", "ok","514-465-1111", 0, strLigne);
				}
			}
			}
			}
		}
		
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		public ArrayList<Prepose> getAlPrepose()
		{
			return alPrepose;
		}
		
		public ArrayList<Adherent> getAlAdherent()
		{
			return alAdherent;
		}
		
		public void addAdherent(Adherent adherent)
		{
			alAdherent.add(adherent);
		}
		
	
}
