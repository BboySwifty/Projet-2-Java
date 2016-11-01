import java.util.GregorianCalendar;

public class Document 
{
	String strTitre;
	int intNumeroDocument;
	int intNombrePret;
	GregorianCalendar calendar;
	static boolean boolRetourner;
	
	public Document(int intNumeroDocument, String strTitre, int intNombrePret, GregorianCalendar calendar, boolean boolRetourner)
	{
		this.strTitre = strTitre;
		this.intNombrePret = intNombrePret;
		this.intNumeroDocument = intNumeroDocument;
		this.calendar = calendar;
		this.boolRetourner = boolRetourner;
	}
	

}
