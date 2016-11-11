package données;

public class Document 
{
	String strNumeroDocument;
	
	public String getStrNumeroDocument() {
		return strNumeroDocument;
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
	
	public Document(String strNumeroDocument, String strTitre, String strDate, boolean boolRetourner)
	{
		this.strTitre = strTitre;
		this.strNumeroDocument = strNumeroDocument;
		this.strDate = strDate;
		this.boolRetourner = boolRetourner;
	}
	
}
