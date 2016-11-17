package données;

import java.util.Date;

public class Livre extends Document {

	private String strNomAuteur;

	public Livre(String strIntDocument, String strTitre, Date date, String strNomAuteur) 
	{
		super(strIntDocument, strTitre, date, boolRetourner);
		this.strNomAuteur = strNomAuteur;

	}

	//getters et setters
	public String getStrNomAuteur() 
	{
		return strNomAuteur;
	}

}
