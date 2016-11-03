import java.util.GregorianCalendar;

public class Document 
{
	String strTitre;
	int intNumeroDocument;
	GregorianCalendar calendar;
	static boolean boolRetourner;
	
	public Document(int intNumeroDocument, String strTitre, GregorianCalendar calendar, boolean boolRetourner)
	{
		this.strTitre = strTitre;
		this.intNumeroDocument = intNumeroDocument;
		this.calendar = calendar;
		this.boolRetourner = boolRetourner;
	}
	

}
