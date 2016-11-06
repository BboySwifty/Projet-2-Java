import java.util.Calendar;

public class Periodique extends Document 
{

	int intNumeroVolume;
	int intNumeroPeriodique;
	
	public Periodique(int intNumeroDocument, String strTitre, int intNombrePret, Calendar calendar,int intNumeroVolume, int intNumeroPeriodique) 
	{
		super(intNumeroDocument, strTitre, calendar, boolRetourner);
		
		this.intNumeroVolume = intNumeroVolume;
		this.intNumeroPeriodique = intNumeroPeriodique;
	}

}
