import java.util.GregorianCalendar;

public class Livre extends Document
{

	String strNomAuteur;
	
	public Livre(int intNumeroDocument, String strTitre, int intNombrePret, GregorianCalendar calendar,String strNomAuteur) 
	{
		super(intNumeroDocument, strTitre, intNombrePret, calendar, boolRetourner);
		
		this.strNomAuteur = strNomAuteur;
		
	}
	

}
