import java.util.Calendar;

public class DVD extends Document 
{
	String strNomRealisateur;
	int intNombreDisques;
	
	public DVD(int intNumeroDocument, String strTitre, int intNombrePret, Calendar calendar, String strNomRealisateur, int intNombreDisques) 
	{
		super(intNumeroDocument, strTitre, calendar, boolRetourner);
		
		this.strNomRealisateur = strNomRealisateur;
		this.intNombreDisques = intNombreDisques;
		
	}

}
