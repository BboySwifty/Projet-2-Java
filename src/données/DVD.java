package données;
import java.util.Calendar;

public class DVD extends Document 
{
	String strNomRealisateur;
	int intNombreDisques;
	
	public DVD(int intNumeroDocument, String strTitre, String strDate,int intNombreDisques, String strNomRealisateur) 
	{
		super(intNumeroDocument, strTitre, strDate, boolRetourner);
		
		this.strNomRealisateur = strNomRealisateur;
		this.intNombreDisques = intNombreDisques;
		
	}

}
