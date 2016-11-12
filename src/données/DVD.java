package données;

import java.util.Date;

public class DVD extends Document 
{
	private int intNombreDisques;
	private String strNomRealisateur;

	public DVD(String strIntDocument, String strTitre, Date date, int intNombreDisques,
			String strNomRealisateur) 
	{
		super(strIntDocument, strTitre, date, boolRetourner);

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
