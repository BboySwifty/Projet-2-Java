package données;

import java.util.Date;

public class Livre extends Document {

	String strNomAuteur;

	public Livre(String strIntDocument, String strTitre, Date date, String strNomAuteur) {
		super(strIntDocument, strTitre, date, boolRetourner);

		this.strNomAuteur = strNomAuteur;

	}

	public String getStrNomAuteur() {
		return strNomAuteur;
	}

}
