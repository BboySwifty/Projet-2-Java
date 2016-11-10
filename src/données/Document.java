package données;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Document 
{
	int intNumeroDocument;
	
	String strTitre;
	String strDate;
	
	static boolean boolRetourner;
	
	public Document(int intNumeroDocument, String strTitre, String strDate, boolean boolRetourner)
	{
		this.strTitre = strTitre;
		this.intNumeroDocument = intNumeroDocument;
		this.strDate = strDate;
		this.boolRetourner = boolRetourner;
	}
	

}
