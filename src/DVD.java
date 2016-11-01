import java.util.GregorianCalendar;

public class DVD extends Document 
{
	String strNomRealisateur;
	int intNombreDisques;
	
	public DVD(int intNumeroDocument, String strTitre, int intNombrePret, GregorianCalendar calendar, String strNomRealisateur, int intNombreDisques) 
	{
		super(intNumeroDocument, strTitre, intNombrePret, calendar);
		
		this.strNomRealisateur = strNomRealisateur;
		this.intNombreDisques = intNombreDisques;
		
	}

}
