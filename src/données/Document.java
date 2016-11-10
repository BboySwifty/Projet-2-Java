package données;

public class Document 
{
	int intNumeroDocument;
	
	public int getIntNumeroDocument() {
		return intNumeroDocument;
	}

	public String getStrTitre() {
		return strTitre;
	}

	public String getStrDate() {
		return strDate;
	}

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
