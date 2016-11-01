import java.util.GregorianCalendar;

public class Periodique extends Document 
{

	int intNumeroVolume;
	int intNumeroPeriodique;
	
	
	public Periodique(int intNumeroDocument, String strTitre, int intNombrePret,GregorianCalendar calendar,int intNumeroVolume, int intNumeroPeriodique) 
	{
		super(intNumeroDocument, strTitre, intNombrePret, calendar);
		
		this.intNumeroVolume = intNumeroVolume;
		this.intNumeroPeriodique = intNumeroPeriodique;
	}

}
