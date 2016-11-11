package données;
import java.util.Calendar;

public class DVD extends Document 
{
	String strNomRealisateur;
	int intNombreDisques;
	
	public DVD(String strIntDocument, String strTitre, String strDate,int intNombreDisques, String strNomRealisateur) 
	{
		super(strIntDocument, strTitre, strDate, boolRetourner);
		
		this.strNomRealisateur = strNomRealisateur;
		this.intNombreDisques = intNombreDisques;
		
	}

	public String getStrNomRealisateur() {
		return strNomRealisateur;
	}

	public int getIntNombreDisques() {
		return intNombreDisques;
	}

}
