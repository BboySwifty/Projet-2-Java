package données;

import java.util.ArrayList;

public class ListeUtilisateur 
{
	private ArrayList<Prepose> alPrepose = new ArrayList<Prepose>();
	private ArrayList<Adherent> alAdherent = new ArrayList<Adherent>();
	
	public ArrayList<Prepose> getAlPrepose()
	{
		return alPrepose;
	}
	
	public ArrayList<Adherent> getAlAdherent()
	{
		return alAdherent;
	}
}
