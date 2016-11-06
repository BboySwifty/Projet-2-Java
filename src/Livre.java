import java.util.Calendar;

public class Livre extends Document
{

	String strNomAuteur;
	
	public Livre(int intNumeroDocument, String strTitre,  Calendar calendar,String strNomAuteur) 
	{
		super(intNumeroDocument, strTitre, calendar, boolRetourner);
		
		this.strNomAuteur = strNomAuteur;
		
	}
	

}
