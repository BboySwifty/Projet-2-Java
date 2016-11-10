package données;

public class Periodique extends Document 
{

	int intNumeroVolume;
	int intNumeroPeriodique;
	
	public Periodique(int intNumeroDocument, String strTitre, String strDate,int intNumeroVolume, int intNumeroPeriodique) 
	{
		super(intNumeroDocument, strTitre, strDate, boolRetourner);
		
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
