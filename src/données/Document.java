package données;

import java.util.Date;

public class Document {
	String strNumeroDocument;

	public String getStrNumeroDocument() {
		return strNumeroDocument;
	}

	public String getStrTitre() {
		return strTitre;
	}

	public Date getDate() {
		return date;
	}

	String strTitre;
	Date date;

	static boolean boolRetourner;

	public Document(String strNumeroDocument, String strTitre, Date date, boolean boolRetourner) {
		this.strTitre = strTitre;
		this.strNumeroDocument = strNumeroDocument;
		this.date = date;
		Document.boolRetourner = boolRetourner;
	}
	

}
