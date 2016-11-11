package données;

import java.util.Date;

public class Periodique extends Document 
{

	int intNumeroVolume;
	int intNumeroPeriodique;
	
	public Periodique(String strIntDocument, String strTitre, Date date, int intNumeroVolume, int intNumeroPeriodique) 
	{
		super(strIntDocument, strTitre, date, boolRetourner);
		
		this.intNumeroVolume = intNumeroVolume;
		this.intNumeroPeriodique = intNumeroPeriodique;
	}

	public int getIntNumeroVolume() {
		return intNumeroVolume;
	}

	public int getIntNumeroPeriodique() {
		return intNumeroPeriodique;
	}

}
