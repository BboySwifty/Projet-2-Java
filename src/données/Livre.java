package données;
import java.util.Calendar;

public class Livre extends Document
{

	String strNomAuteur;
	
	public Livre(int intNumeroDocument, String strTitre,  String strDate,String strNomAuteur) 
	{
		super(intNumeroDocument, strTitre, strDate, boolRetourner);
		
		this.strNomAuteur = strNomAuteur;
		
	}
	

}
