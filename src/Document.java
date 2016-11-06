import java.util.Calendar;
import java.util.GregorianCalendar;

public class Document 
{
	String strTitre;
	int intNumeroDocument;
	Calendar calendar;
	static boolean boolRetourner;
	
	public Document(int intNumeroDocument, String strTitre, Calendar calendar, boolean boolRetourner)
	{
		this.strTitre = strTitre;
		this.intNumeroDocument = intNumeroDocument;
		this.calendar = calendar;
		this.boolRetourner = boolRetourner;
	}
	

}
