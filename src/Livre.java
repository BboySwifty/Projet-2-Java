import java.util.GregorianCalendar;

public class Livre extends Document
{

	String strNomAuteur;
	
	public Livre(int intNumeroDocument, String strTitre,  GregorianCalendar calendar,String strNomAuteur) 
	{
		super(intNumeroDocument, strTitre, calendar, boolRetourner);
		
		this.strNomAuteur = strNomAuteur;
		
	}
	

}
