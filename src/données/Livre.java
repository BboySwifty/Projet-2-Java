package données;

public class Livre extends Document
{

	String strNomAuteur;
	
	public Livre(String strIntDocument, String strTitre,  String strDate,String strNomAuteur) 
	{
		super(strIntDocument, strTitre, strDate, boolRetourner);
		
		this.strNomAuteur = strNomAuteur;
		
	}

	public String getStrNomAuteur() {
		return strNomAuteur;
	}
	

}
