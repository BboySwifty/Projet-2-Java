package données;

import java.util.Date;

public class DVD extends Document 
{
	//declaration d'instance
	private int intNombreDisques;
	private String strNomRealisateur;

	public DVD(String strIntDocument, String strTitre,Date date, int intNombreDisques,
			String strNomRealisateur) 
	{
		super(strIntDocument, strTitre, date, boolRetourner);

		this.strNomRealisateur = strNomRealisateur;
		this.intNombreDisques = intNombreDisques;

	}

	//getters et setters
	public String getStrNomRealisateur() {
		return strNomRealisateur;
	}

	public int getIntNombreDisques() {
		return intNombreDisques;
	}

}
