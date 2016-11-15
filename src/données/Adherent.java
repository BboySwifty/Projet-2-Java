package données;
public class Adherent extends Personne 
{
	private int intNumeroInscription;

	public Adherent(int intNumeroInscription, String strTelephone , String strNom, String strPrenom, String strAdresse) 
	{
		super(strNom, strPrenom, strAdresse, strTelephone );
		this.intNumeroInscription = intNumeroInscription;
	}

	public int getIntNumeroInscription() {
		return intNumeroInscription;
	}
}