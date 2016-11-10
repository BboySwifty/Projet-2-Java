package données;

public class Livre extends Document
{

	String strNomAuteur;
	
	public Livre(int intNumeroDocument, String strTitre,  String strDate,String strNomAuteur) 
	{
		super(intNumeroDocument, strTitre, strDate, boolRetourner);
		
		this.strNomAuteur = strNomAuteur;
		
	}

	public String getStrNomAuteur() {
		return strNomAuteur;
	}
	

}
